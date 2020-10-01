package com.example.practice.threadDump;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Incheol Jung
 */
public class HoldMemoryOOM {
    private final static Map<String, String> leakMap = new HashMap<>();
    private final static String STORE_DATA = "STORE DATA";

    private StringBuffer sb = new StringBuffer();

    public void addObject(int objectCount){
        int mapSize = leakMap.size();
        int maxCount = mapSize + objectCount;
        for (int loop = mapSize; loop < maxCount; loop++){
            leakMap.put(STORE_DATA + loop, STORE_DATA + loop * 5);
            sb.append(STORE_DATA);
        }
    }

    public static void main(String[] args) {
        HoldMemoryOOM holdMemoryOOM = new HoldMemoryOOM();
        holdMemoryOOM.addObject(5000000);
    }
}
