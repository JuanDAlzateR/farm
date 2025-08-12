package com.solvd.farm.abstracts;

import com.solvd.farm.interfaces.ISearchName;

public abstract class AbstractList implements ISearchName {

    public AbstractList(){}

    public abstract int indexOfName(String name);

}