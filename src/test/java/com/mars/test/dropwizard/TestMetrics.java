package com.mars.test.dropwizard;


import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TestMetrics {

    static final MetricRegistry metrics = new MetricRegistry();


    @Test
    public void test1() {
        startReport();
        Meter requests = metrics.meter("requests");
        requests.mark();
        wait5Seconds();
    }

    @Test
    public void testGauge() {
        QueueManager manager = new QueueManager(metrics, "job1");
        startReport();
        manager.addJob("Hello");
        manager.addJob("Hello1");
        waitSeconds(2);
        manager.addJob("Hello2");
        manager.addJob("Hello3");
        manager.addJob("Hello4");
        manager.addJob("Hello5");
        wait5Seconds();
        manager.takeJob();
        manager.takeJob();
        manager.takeJob();
        waitSeconds(1);
        manager.takeJob();
        manager.takeJob();
    }

    void startReport() {
        ConsoleReporter reporter = ConsoleReporter.forRegistry(metrics)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.SECONDS);
    }

    void wait5Seconds() {
        waitSeconds(5);
    }

    private void waitSeconds(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
        }
    }

}
