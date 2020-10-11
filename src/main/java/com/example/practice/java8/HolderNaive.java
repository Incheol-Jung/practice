package com.example.practice.java8;

import com.example.practice.block.BlockService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

import lombok.SneakyThrows;

/**
 * @author Incheol Jung
 */
public class HolderNaive {
    private static Logger logger = LoggerFactory.getLogger(HolderNaive.class);

    class Heavy{

    }

    private Supplier<Heavy> heavy = () -> createAndCacheHeavy();
    private Heavy heavy2;

    public HolderNaive() {
        System.out.println("Holder created");
    }

    public Heavy getHeavy() {
        logger.info("getHeavy");
        return heavy.get();
    }

    @SneakyThrows
    public Heavy getHeavy2() {
        if(heavy2 == null) {
            Thread.sleep(5000);
            heavy2 = new Heavy();
        }
        return heavy2;
    }
    private synchronized Heavy createAndCacheHeavy() {
        class HeavyFactory implements Supplier<Heavy> {
            @SneakyThrows
            public HeavyFactory() {
                logger.info("HeavyFactory");
                Thread.sleep(5000);
            }

            private final Heavy heavyInstance = new Heavy();

            @SneakyThrows
            public Heavy get() {
                return heavyInstance;
            }
        }

        if(!HeavyFactory.class.isInstance(heavy)) {
            heavy = new HeavyFactory();
        }

        return heavy.get();
    }

    // 실행 함수
    @SneakyThrows
    public static boolean evaluate(final int value) {
        System.out.println("evaluating ..." + value);
        Thread.sleep(2000);
        return value > 100;
    }

    // 즉시 실행 함수
    public static void eagerEvaluator(
        final boolean input1, final boolean input2) {
        System.out.println("eagerEvaluator called...");
        System.out.println("accept?: " + (input1 && input2));
    }

    // 즉시 실행 함수 사용 예제
    public static void main(final String[] args) {
        System.out.println("//" + "START:EAGER_OUTPUT");
        System.out.println(evaluate(1) && evaluate(2));
        System.out.println("//" + "END:EAGER_OUTPUT");
    }
}
