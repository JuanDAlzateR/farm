package com.solvd.farm.input;

@FunctionalInterface
public interface IInputClass <T>{
    T input(String message); //throws exception ??
}
