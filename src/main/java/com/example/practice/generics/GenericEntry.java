package com.example.practice.generics;

/**
 * @author Incheol Jung
 */
public class GenericEntry<K,V>{

    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key){
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        GenericEntry<String, Integer> genericEntry = new GenericEntry<>();
        genericEntry.setKey("incheol");
        genericEntry.setValue(1000);
    }
}
