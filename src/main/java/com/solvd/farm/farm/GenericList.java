package com.solvd.farm.farm;

import com.solvd.farm.abstracts.AbstractList;
import com.solvd.farm.abstracts.Countable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class GenericList<T extends Countable> extends AbstractList {
    public static final Logger LOGGER = LogManager.getLogger(GenericList.class);
    private final ArrayList<T> list = new ArrayList<>();

    public ArrayList<T> getList() {
        return this.list;
    }

    /* Looks in the array for the index of item with that name
        If it doesn't find it, it returns -1  */
    @Override
    public int indexOfName(String name) {
        return IntStream.range(0, list.size())
                .filter(i -> list.get(i).getName().equals(name))
                .findFirst()
                .orElse(-1);
    }

    public void add(T item) {
        int index = indexOfName(item.getName());
        LOGGER.debug("item: " + item.getName() + "  index: " + index);
        if (index > -1) {
            list.get(index).addQuantity(item.getQuantity());
        } else {
            LOGGER.debug("list size: " + list.size());
            list.add(item);
            LOGGER.debug(item + " added");
            LOGGER.debug("new list size: " + list.size());
        }
    }

    public void display() {
        list.stream()
                .forEach(LOGGER::info);
    }

}