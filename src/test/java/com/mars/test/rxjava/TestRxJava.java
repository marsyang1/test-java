package com.mars.test.rxjava;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * "FRP is programming with asynchronous data streams."
 * <p>
 * https://dzone.com/articles/only-introduction-reactive
 * https://praveer09.github.io/technology/2016/02/13/rxjava-part-1-a-quick-introduction/
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
}
