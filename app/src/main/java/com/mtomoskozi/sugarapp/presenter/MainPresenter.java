package com.mtomoskozi.sugarapp.presenter;

import com.mtomoskozi.sugarapp.android.SugarAppApplication;
import com.mtomoskozi.sugarapp.interactor.PeopleDbInteractor;
import com.mtomoskozi.sugarapp.model.Person;
import com.mtomoskozi.sugarapp.view.MainView;

import javax.inject.Inject;

/**
 * Created by Máté on 27/04/2016.
 */
public class MainPresenter extends Presenter<MainView> {

    @Inject
    public PeopleDbInteractor interactor;

    public MainPresenter() {
        SugarAppApplication.injector.inject(this);
    }

    public void addPerson(Person toAdd) {
        interactor.addPerson(toAdd);
    }

    public void refreshPeople() {
        view.showPeople(interactor.getPeople());
    }
}