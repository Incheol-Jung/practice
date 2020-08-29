package com.example.practice.heapOutOfMemory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Incheol Jung
 */
public class Example {

    public static class Adder {

        public long addIncremental(long l) {
            Long sum = 0L;
            sum = sum + l;
            return sum;
        }
    }

    public static class Cache {

        private Map<String, String> map = new HashMap<String, String>();

        public void initCache() {
            map.put("Anil", "Work as Engineer");
            map.put("Shamik", "Work as Java Engineer");
            map.put("Ram", "Work as Doctor");
        }

        public Map<String, String> getCache() {
            return map;
        }

        public void forEachDisplay() {
            for (String key : map.keySet()) {
                String val = map.get(key);
                System.out.println(key + " :: " + val);
            }
        }

        public static void main(String[] args) {

        }
    }

    public static class Person {

        private String name;

        public Person(String name) {
            this.name = name;
        }
    }

    public static class MutableCustomKey {
        public MutableCustomKey(String name)
        {
            this.name=name;
        }
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            MutableCustomKey other = (MutableCustomKey) obj;
            if (name == null) {
                if (other.name != null)
                    return  false;
            } else if (!name.equals(other.name))
            return false;
            return true;
        }

        public static class Stack {
            private int maxSize;
            private int[] stackArray;
            private int pointer;
            public Stack(int s) {
                maxSize = s;
                stackArray = new int[maxSize];
                pointer = -1;
            }
            public void push(int j) {
                stackArray[++pointer] = j;
            }
            public int pop() {
                return stackArray[pointer--]; // 위치만 전달할 뿐, Stack의 사이즈는 줄어들지 않음. 메모리 누수발생
            }

            // 메모리 누수를 방지 하기 위한 개선된 메소
//            public int pop() {
//                int size = pointer--
//                int element= stackArray[size];
//                stackArray[size];
//                return element;
//            }

            public int peek() {
                return stackArray[pointer];
            }
            public boolean isEmpty() {
                return (pointer == -1);
            }
            public boolean isFull() {
                return (pointer == maxSize - 1);
            }

        }
    }

    public static void main(String[] args) {

        // Example 1: Autoboxing
        // 무분별한 오토박싱은 메모리 누수의 원인이 된다.
        Adder adder = new Adder();
        for (long i = 0; i < 1000; i++) {
            adder.addIncremental(i);
        }

        // Example 2: Using Cache
        // 내부의 Map 데이터 구조 때문에 메모리 누수가 발생한다.
        Cache cache = new Cache();
        cache.initCache();
        cache.forEachDisplay();

        // Example 3: Closing Connections
        // File 또는 db connection을 열기만 하고 닫지 않았을 경우(예제에서는 exception이 발생할 경우 닫히지 않고 종료됨)
        try {
            Connection con = DriverManager.getConnection(null);
            con.close();
        } catch (Exception ex) {
            //
        }

        // Example 4: Using CustomKey
        // Person equals() and hashcode() 을 재정의 하지 않았다.
        // 하지만 map에 entrySet 안에서 Key로 사용되어 메모리 누수의 원인이 될 수 있다.
        HashMap<Person, String> map = new HashMap<>();
        map.put(new Person("incheol"), "incheol");
        map.get(new Person("incheol"));
        System.out.println(map.size());

        // Example 5: Mutable Custom Key
        // equals와 hashCode는 override 하였지만 mutable 하다.
        // 이렇게 되면, map의 key는 변경되었지만 외부에서는 해당 키를 알지 못하여 메모리 누수가 발생할 수 있다.
        MutableCustomKey key = new MutableCustomKey("incheol");
        Map<MutableCustomKey,String> mutableMap = new HashMap<MutableCustomKey,String>();
        mutableMap.put(key, "incheol jung");
        MutableCustomKey refKey = new MutableCustomKey("incheol");
        String val = mutableMap.get(refKey);
        System.out.println("Value Found " + val);
        key.setName("tomas");
        String val1 = mutableMap.get(refKey);
        System.out.println("Due to MutableKey value not found " + val1);

        // Example 6: 잘못된 자료 구조
        // 보통 pop을 했을 경우 stack의 정보가 사라져야한다.
        // 즉, 정보의 위치 또한 비워져야 한다는 것이다.
        // 하지만, 위의 경우 pop은 해당 위치의 값만 전달해 줄 뿐 사용하지 않는 데이터인지 GC가 판별 할 수가없다.
        MutableCustomKey.Stack stack = new MutableCustomKey.Stack(1000);
        for(int i = 0; i<1000; i++)
        {
            stack.push(i);
        }
        for(int i = 0; i<1000; i++)
        {
            int element = stack.pop();
            System.out.println("Poped element is "+ element);
        }


    }
}
