package com.example.demo.hello.util;


public class LinkedHashMapUtil extends HashMapUtil {

    static class Entry<K,V> extends HashMapUtil.Node<K,V> {
        Entry<K,V> before, after;
        Entry(int hash, K key, V value, HashMapUtil.Node<K,V> next) {
            super(hash, key, value, next);
        }
    }

}
