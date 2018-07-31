package com.example.ioc;

public interface ViewInjector<T> {
    void inject(T t, Object source);
}