package com.solvd.farm.abstracts;

import com.solvd.farm.interfaces.SearchName;

public abstract class AbstractList implements SearchName {

    public AbstractList(){}

    public abstract int indexOfName(String name);

}