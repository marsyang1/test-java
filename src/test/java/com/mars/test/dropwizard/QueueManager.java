package com.mars.test.dropwizard;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.MetricRegistry;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QueueManager {
    private final Queue queue;

    public QueueManager(MetricRegistry metrics, String name) {
        this.queue = new ConcurrentLinkedQueue();
        metrics.register(MetricRegistry.name(QueueManager.class, name, "size"),
                new Gauge<Integer>() {
                    @Override
                    public Integer getValue() {
                        return queue.size();
                    }
                });
    }

    public void addJob(String job) {
        queue.add(job);
    }

    public Object takeJob() {
        return queue.poll();
    }
}
