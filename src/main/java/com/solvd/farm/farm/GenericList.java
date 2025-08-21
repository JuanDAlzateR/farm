package com.solvd.farm.farm;

import com.solvd.farm.abstracts.AbstractList;
import com.solvd.farm.abstracts.Countable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class GenericList <T extends Countable> extends AbstractList {
    public static final Logger LOGGER = LogManager.getLogger(GenericList.class);
    private ArrayList<T> list = new ArrayList<>();

    public ArrayList<T> getList() {
        return this.list;
    }

    /* Looks in the array for the index of item with that name
        If it doesn't find it, it returns -1  */
    @Override
    public int indexOfName(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void add(T item) {
        int index = indexOfName(item.getName());
        if (index > -1) {
            list.get(index).addQuantity(item.getQuantity());
        } else {
            list.add(item);
        }
    }

    public void display() {
        for (T item : list) {
            LOGGER.info(item);
        }
    }

}