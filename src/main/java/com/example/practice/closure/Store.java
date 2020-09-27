package com.example.practice.closure;

import java.util.function.Function;

/**
 * @author Incheol Jung
 */
public class Store {
    private String storeNo = "9000";

    public void anonymousClosure() {
        String anonymousNo = "1000";
        Function<String, Integer> anonymousFunction = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                System.out.println(Store.this.storeNo);
                Store.this.storeNo = "test";
//                anonymousNo = "test";
                return Integer.parseInt(anonymousNo);
            }
        };
    }

//    void anonymousClassClosure() {
//        Server server = new HttpServer();
//        waitFor(new RewriteCond.Condition() {
//            @Override
//            public Boolean isSatisfied() {
//                return !server.isRunning();
//            }
//        });
//    }

    public void lambdaClosure() {
        String anonymousNo = "1000";
        Function<String,Integer> lambdaFunction = i -> {
            System.out.println(this.storeNo);
            this.storeNo = "222";
//            anonymousNo = "test";
            return null;
        };
    }


    //    public static void main(String[] args) {
//        Closure2 c = new Closure2();
//        c.lambdaClosure();
//        c.anonymousClosure();
//    }
}
