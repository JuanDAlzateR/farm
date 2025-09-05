package com.solvd.farm.input;

@FunctionalInterface
public interface IConstructor<T> {
    T construct(String string) throws Exception;
}
