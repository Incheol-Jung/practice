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
        }

        public void getClassTwo(ClassTwo classTwo) {
            this.clsTwoInstance = classTwo;
        }
    }

    public static class ClassTwo {

        private int twoValue;
        private ClassOne clsOneInstance = null;

        public ClassTwo() {
            twoValue = 10;
            clsOneInstance = new ClassOne();
        }

        public void getClassOne(ClassOne classOne) {
            this.clsOneInstance = classOne;
        }
    }

    public static class AccountHolder {

        private String firstName;
        private String lastName;

        AccountHolder jointAccountHolder = new AccountHolder();
    }

    public long calculateFactorial(long number) {
        return number == 1 ? 1 : number * calculateFactorial(number - 1);
    }

    public long calculateTailFactorial(long number, long sum) {
        return number == 1 ? sum : calculateTailFactorial(number - 1, number * sum);
    }

    public static void main(String[] args) {
        SofExample example = new SofExample();

        // case 1. 재귀함수
        //        long result = example.calculateFactorial(10600);
        // case 1. 재귀함수 해결방법
        //        long result2 = example.calculateTailFactorial(10600,1);

        // case 2. 상호 참조 생성
        //        ClassOne one = new ClassOne();

        // case 3. 본인 참조 생성
//        AccountHolder holder = new AccountHolder();

        // case 4. 정적 배열 사이즈 크게 잡기
        int[] arr = new int[1000000000];
    }
}
