package com.example.practice.stream;

import java.util.stream.LongStream;

/**
 * @author Incheol Jung
 */
public class AccumulatorExample {
    public static class Accumulator {
        public long total = 0;
        public void add(long value) { total += value; }

        public static long sideEffectSum(long n) {
            Accumulator accumulator = new Accumulator();
            LongStream.rangeClosed(1, n).forEach(accumulator::add);
            return accumulator.total;
        }
    }
    public static void main(String[] args) {
        Accumulator.sideEffectSum(100000);
    }
}
