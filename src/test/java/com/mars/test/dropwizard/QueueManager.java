package com.mars.test.dropwizard;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueManager {
    private final Queue queue;

    private final Counter pendingJobs;
    private final Timer responsesTimer;

    public QueueManager(MetricRegistry metrics, String name) {
        this.queue = new ConcurrentLinkedQueue();
        this.pendingJobs = metrics.counter(MetricRegistry.name(QueueManager.class, "pending-jobs"));
        this.responsesTimer = metrics.timer(MetricRegistry.name(QueueManager.class, "responses"));
        metrics.register(MetricRegistry.name(QueueManager.class, name, "size"),
                new Gauge<Integer>() {
                    @Override
                    public Integer getValue() {
                        return queue.size();
                    }
                });
    }

    public void addJob(String job) {
        final Timer.Context context = responsesTimer.time();
        pendingJobs.inc();
        queue.add(job);
        context.stop();
    }

    public Object takeJob() {
        pendingJobs.dec();
        return queue.poll();
    }

    public Long getCount() {
        return pendingJobs.getCount();
    }

}
