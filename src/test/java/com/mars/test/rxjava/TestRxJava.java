package com.mars.test.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.reactivestreams.Subscription;

import java.util.concurrent.TimeUnit;

/**
 * "FRP is programming with asynchronous data streams."
 * <p>
 * https://dzone.com/articles/only-introduction-reactive
 * https://praveer09.github.io/technology/2016/02/13/rxjava-part-1-a-quick-introduction/
 *
 * example source
 * https://github.com/politrons/reactive/blob/master/src/test/java/rx/observables/connectable/HotObservable.java
 *
 */
@Slf4j
public class TestRxJava {

    @Test
    public void test1() {
        Observable.range(1, 5).subscribe(
                number -> System.out.println(number),
                error -> System.out.println("error"),
                () -> System.out.println("completed")
        );
    }

    @Test
    public void test2() {
        // defining the source
        Observable<Integer> source = Observable.range(1, 5);

        // defining the consumer
        Consumer<Integer> consumer = new Consumer<Integer>() {

            @Override
            public void accept(Integer integer) throws Exception {
                log.info("accept" + integer);
            }

        };
        source.subscribe(consumer);

    }

    /**
            * This example we can see how a third observer subscribe to hot Observable once this one has start emitting items,
            * Since the hot observable was created with publish he miss the items already emitted
     *
             * @throws InterruptedException
     */
    @Test
    public void testHotObservablesMissingItems() throws InterruptedException {
        Observable<Long> interval = Observable.interval(100L, TimeUnit.MILLISECONDS);
        ConnectableObservable<Long> published = interval.publish();
        subscribeToObservable(published, "First");
        subscribeToObservable(published, "Second");
        published.connect();
        subscribeToObservableWithDelay(published);

    }

    /**
     * This example we can see how a third observer subscribe to hot Observable once start emitting items, and because the hot
     * observable was created with replay, it replay to the third observer all missed items.
     *
     * @throws InterruptedException
     */
    @Test
    public void testHotObservablesReplayingMissItems() throws InterruptedException {
        Observable<Long> interval = Observable.interval(100L, TimeUnit.MILLISECONDS);
        ConnectableObservable<Long> published = interval.replay();
        subscribeToObservable(published, "First");
        subscribeToObservable(published, "Second");
        published.connect();
        subscribeToObservableWithDelay(published);
    }

    /**
     * In this example we see how using hot observables PublishSubject we can emit an item on broadcast to all the observers(subscribers).
     *
     * @throws InterruptedException
     */
    @Test
    public void testHotObservableUsingPublishSubject() throws InterruptedException {
        Observable<Long> interval = Observable.interval(100L, TimeUnit.MILLISECONDS);
        Subject<Long> publishSubject = PublishSubject.create();
        interval.subscribe(publishSubject);
        subscribeToObservable(publishSubject, "First");
        subscribeToObservable(publishSubject, "Second");
        try {
            Thread.sleep(300L);
            publishSubject.onNext(555L);
            subscribeToObservable(publishSubject, "Third");
            Thread.sleep(500L);
        } catch (InterruptedException e) {
        }
    }

    /**
     * In this example we see how using hot observables ConnectableObservables we can start emitting items not when we subscribe, but when we connect.
     *
     * @throws InterruptedException
     */
    @Test
    public void testHotObservableConnectableObservables() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        Observable<String> observable = Observable.just("Hot observable");
        ConnectableObservable<String> published = observable.publish();
        published.subscribe(s -> System.out.println(String.format("Item %s Emitted after: %s seconds", s, (System.currentTimeMillis() - startTime) / 1000)),
                e -> System.out.println(e.getMessage()));
        Thread.sleep(1000);
        published.connect();
    }

    /**
     * In this example we see how using hot observables PublishSubject we can start emitting items not when we subscribe,
     * but when we subscribe the observer to the observable.
     *
     * @throws InterruptedException
     */
    @Test
    public void testHotObservablePublishSubject() throws InterruptedException {
        Long startTime = System.currentTimeMillis();
        Observable<String> observable = Observable.just("Hot observable");
        PublishSubject<String> publishSubject = PublishSubject.create();
        publishSubject.subscribe(s -> System.out.println(
                String.format("Item %s Emitted in publish subject after: %s seconds", s, (System.currentTimeMillis() - startTime) / 1000)));
        Thread.sleep(1000);
        observable.subscribe(publishSubject);

    }

    /**
     * In this example we see how using hot observables ReplaySubject we can emit an item on broadcast to all the observers(subscribers).
     *
     * @throws InterruptedException
     */
    @Test
    public void testHotObservableUsingAsyncSubject() throws InterruptedException {
        Observable<Long> interval = Observable.interval(100L, TimeUnit.MILLISECONDS);
        Subject<Long> publishSubject = AsyncSubject.create();
        interval.subscribe(publishSubject);
        Thread.sleep(1000L);
        subscribeToObservable(publishSubject, "First");
        subscribeToObservable(publishSubject, "Second");
        subscribeToObservable(publishSubject, "Third");
    }


    /**
     * In this example we see how using hot observables ReplaySubject we can emit an item on broadcast to all the observers(subscribers).
     *
     * @throws InterruptedException
     */
    @Test
    public void testHotObservableUsingReplaySubject() throws InterruptedException {
        Observable<Long> interval = Observable.interval(100L, TimeUnit.MILLISECONDS);
        Subject<Long> publishSubject = ReplaySubject.create(1);
        interval.subscribe(publishSubject);
        Thread.sleep(1000L);
        subscribeToObservable(publishSubject, "First");
        subscribeToObservable(publishSubject, "Second");
        subscribeToObservable(publishSubject, "Third");
    }

    /**
     * In this example we see how using hot observables ReplaySubject we can emit an item on broadcast to all the observers(subscribers).
     *
     * @throws InterruptedException
     */
    @Test
    public void testHotObservableUsingReplaySubject2() throws InterruptedException {
        Observable<Long> interval = Observable.interval(100L, TimeUnit.MILLISECONDS);
        Subject<Long> publishSubject = ReplaySubject.create(1);
        interval.subscribe(publishSubject);
        Thread.sleep(1000L);
        publishSubject.subscribe(System.out::println, (e) -> System.err.println(e.getMessage()), System.out::println);
    }

    private Subscription subscribeToObservableWithDelay(ConnectableObservable<Long> published) {
        Subscription sub3 = null;
        try {
            Thread.sleep(500L);
            sub3 = subscribeToObservable(published, "Third");
            Thread.sleep(500L);
        } catch (InterruptedException e) {
        }
        return sub3;
    }


    Subscription subscribeToObservable(Observable<Long> observable, String name) {
        return (Subscription) observable.subscribe((v) -> System.out.println(name + " : " + v), (e) -> {
            System.err.println("Error from " + name + ":");
            System.err.println(e.getMessage());
        }, () -> System.out.println(name + " ended!"));
    }


    /**
     * In this example we see how using hot observables ReplaySubject we can emit an item on broadcast to all the observers(subscribers).
     *
     * @throws InterruptedException
     */
    @Test
    public void chainObservables() throws InterruptedException {
        Observable<Long> interval = Observable.just(1l);
        Subject<Long> publishSubject = ReplaySubject.create(1);
        Subject<Long> publishSubject2 = ReplaySubject.create(1);
        interval.subscribe(publishSubject);
        publishSubject.subscribe(publishSubject2);
        publishSubject2.subscribe(System.out::println, (e) -> System.err.println(e.getMessage()), System.out::println);
    }
}
