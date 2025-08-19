package com.solvd.farm.crops;

import com.solvd.farm.Main;
import com.solvd.farm.abstracts.AbstractList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class GrainList extends AbstractList {
    public static final Logger LOGGER = LogManager.getLogger(GrainList.class);
    private ArrayList<Grain> grains = new ArrayList<>();

    /* Looks in the array for the index of item with that name
        If it doesn't find it, it returns -1  */
    @Override
    public int indexOfName(String name) {
        for (int i = 0; i < grains.size(); i++) {
            if (grains.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void add(Grain grain) {
        int index = indexOfName(grain.getName());
        if (index > -1) {
            grains.get(index).addQuantity(grain.getQuantity());
        } else {
            grains.add(grain);
        }
    }

    public void printAll() {
        for (Grain grain : grains) {
            LOGGER.info(grain);
        }
    }

    public ArrayList<Grain> getList() {
        return this.grains;
    }

}