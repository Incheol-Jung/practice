package com.example.practice.threadDump;

/**
 * @author Incheol Jung
 */
public class MultiLockingThreads {

    public static void main(String[] args) {
        for(int loop = 0; loop < 10; loop++){
            LockThread thread = new LockThread();
            thread.start();
        }
    }
}
class LockThread extends Thread {

    @Override
    public void run() {
        while (true) {
            IncreaseNumber.increase();
        }
    }
}
class IncreaseNumber {
    private static long count = 0;
    public static synchronized void increase() {
        count++;
    }
}
