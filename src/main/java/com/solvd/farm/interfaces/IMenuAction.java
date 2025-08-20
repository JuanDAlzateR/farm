package com.solvd.farm.interfaces;

import com.solvd.farm.exceptions.InvalidOptionException;

@FunctionalInterface
public interface IMenuAction {
    void run() throws InvalidOptionException;
}