package com.example.practice.block;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Incheol Jung
 */
public class StopThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        AtomicLong;
        ConcurrentHashMap ha = new ConcurrentHashMap();
        ha.putIfAbsent()
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested)
                i++;
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
