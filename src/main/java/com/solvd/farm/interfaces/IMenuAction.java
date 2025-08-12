package com.solvd.farm.interfaces;

@FunctionalInterface
public interface IMenuAction {
    Object[] run(Object...arg);
}