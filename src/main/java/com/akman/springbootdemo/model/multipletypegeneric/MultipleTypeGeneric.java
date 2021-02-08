package com.akman.springbootdemo.model.multipletypegeneric;

public interface MultipleTypeGeneric<K, V> {

    K getKey();

    V getValue();
}