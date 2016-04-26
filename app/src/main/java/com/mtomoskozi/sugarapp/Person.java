package com.mtomoskozi.sugarapp;


import com.orm.SugarRecord;


/**
 * Created by mtomoskozi on 4/15/16.
 */
public class Person extends SugarRecord {
    String name;

    public Person() {
        name = "Default";
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
