package com.solvd.farm.interfaces;

import com.solvd.farm.exceptions.InvalidOptionException;

@FunctionalInterface
public interface IMenuAction {
    Object[] run(Object...arg) throws InvalidOptionException;
}