package com.endava.pageObjects;

/**
 * Created by draicu on 8/1/2016.
 */
public enum Locations {
    BUCHAREST("Romania, Bucharest");

    String location;

    Locations(String location){
        this.location = location;
    }

    @Override
    public String toString(){
        return this.location;
    }

}
