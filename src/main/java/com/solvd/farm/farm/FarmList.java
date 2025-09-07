package com.solvd.farm.farm;

import com.solvd.farm.Main;
import com.solvd.farm.abstracts.AbstractList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class FarmList extends AbstractList {

    public static final Logger LOGGER = LogManager.getLogger(FarmList.class);
    private final ArrayList<Farm> farms = new ArrayList<>();
    private int defaultFarmIndex = 0;

    public ArrayList<Farm> getList() {
        return this.farms;
    }

    public int getDefaultFarmIndex() {
        return defaultFarmIndex;
    }

    public Farm getDefaultFarm() {
        return this.farms.get(this.defaultFarmIndex);
    }

    public void setDefaultFarmIndex(int index) {
        if (0 <= index && index < this.farms.size()) {
            this.defaultFarmIndex = index;
        } else {
            //Posibility for another exception
            Main.LOGGER.error("FarmIndex Out Of Bounds");
        }
    }

    /* Looks in the array for the index of item with that name
        If it doesn't find it, it returns -1  */
    @Override
    public int indexOfName(String name) {
        return IntStream.range(0, farms.size())
                .filter(i -> farms.get(i).getFarmName().equals(name))
                .findFirst()
                .orElse(-1);

    }

    public void add(Farm farm) {
        int index = indexOfName(farm.getFarmName());
        if (index > -1) {
            LOGGER.info("Error: There is a farm with that name already");
        } else {
            farms.add(farm);
        }
    }

    public void display() {
        LOGGER.info("");
        LOGGER.info("list of all farms");

        IntStream.range(0, this.farms.size())
                .forEach(i -> {
                    String farmName = this.farms.get(i).getFarmName();
                    if (i == this.defaultFarmIndex) {
                        LOGGER.info("\t" + farmName + "(Default)");
                    } else {
                        LOGGER.info("\t" + farmName);
                    }
                });

    }

    public void displayWithIndex() {
        LOGGER.info("");
        LOGGER.info("list of all farms");
        IntStream.range(0, this.farms.size())
                .forEach(i -> {
                    String farmName = this.farms.get(i).getFarmName();
                    if (i == this.defaultFarmIndex) {
                        LOGGER.info("\t" + i + ") " + farmName + "(Default)");
                    } else {
                        LOGGER.info("\t" + i + ") " + farmName);
                    }
                });
    }

}