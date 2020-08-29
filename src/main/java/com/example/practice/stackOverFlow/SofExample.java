package com.example.practice.stackOverFlow;

/**
 * @author Incheol Jung
 */
public class SofExample {

    public static class ClassOne {
        private int oneValue;
        private ClassTwo clsTwoInstance = null;

        public ClassOne() {
            oneValue = 0;
            clsTwoInstance = new ClassTwo();
        }

        public ClassOne(int oneValue, ClassTwo clsTwoInstance) {
            this.oneValue = oneValue;
            this.clsTwoInstance = clsTwoInstance;
        }
    }

    public static class ClassTwo {
        private int twoValue;
        private ClassOne clsOneInstance = null;

        public ClassTwo() {
            twoValue = 10;
            clsOneInstance = new ClassOne();
        }

        public ClassTwo(int twoValue, ClassOne clsOneInstance) {
            this.twoValue = twoValue;
            this.clsOneInstance = clsOneInstance;
        }
    }

    public static class AccountHolder {
        private String firstName;
        private String lastName;

        AccountHolder jointAccountHolder = new AccountHolder();
    }


    public long calculateFactorial(long number) {
        return number == 0 ? 1 : number * calculateFactorial(number - 1);
    }

    public static void main(String[] args) {
        SofExample example = new SofExample();

        // case 1. 재귀함수
//        long result = example.calculateFactorial(100);
//        System.out.println(result);

        // case 2. 상호 참조 생성
//        ClassOne one = new ClassOne();

        // case 3. 본인 참조 생성
//        AccountHolder holder = new AccountHolder();

        // case 4. 정적 배열 사이즈 크게 잡기
        int[] arr = new int[1000000000];
    }
}
