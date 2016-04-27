package com.mtomoskozi.sugarapp.model.mock;

import com.mtomoskozi.sugarapp.model.prod.PeopleDbModel;
import com.mtomoskozi.sugarapp.model.Person;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Máté on 27/04/2016.
 */
public class MockPeopleDbModel extends PeopleDbModel {

    LinkedList<Person> values = new LinkedList<>();

    public MockPeopleDbModel() {
        values.add(new Person("Mama"));
        values.add(new Person("Papa"));
    }

    @Override
    public List<Person> fetchPeople() {
        return values;
    }

    @Override
    public void insertPerson(Person toInsert) {
        values.add(toInsert);
    }
}
