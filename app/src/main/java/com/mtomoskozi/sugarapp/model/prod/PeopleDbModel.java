package com.mtomoskozi.sugarapp.model.prod;

import com.mtomoskozi.sugarapp.model.Person;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Máté on 27/04/2016.
 */
public class PeopleDbModel {

    public PeopleDbModel() {

    }

    public List<Person> fetchPeople() {
        List<Person> values = Person.listAll(Person.class);
        return values;
    }

    public void insertPerson(Person toInsert) {
        toInsert.save();
    }
}


