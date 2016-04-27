package com.mtomoskozi.sugarapp.interactor;

import com.mtomoskozi.sugarapp.android.SugarAppApplication;
import com.mtomoskozi.sugarapp.model.prod.PeopleDbModel;
import com.mtomoskozi.sugarapp.model.Person;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Máté on 27/04/2016.
 */
public class PeopleDbInteractor {
        @Inject
        PeopleDbModel model;

        public PeopleDbInteractor() {
            SugarAppApplication.injector.inject(this);
        }

        public void addPerson(Person toAdd) {
            model.insertPerson(toAdd);
        }

        public List<Person> getPeople() {
            return model.fetchPeople();
        }
    }
