package com.mtomoskozi.sugarapp.presenter;

import com.mtomoskozi.sugarapp.android.SugarAppApplication;
import com.mtomoskozi.sugarapp.interactor.PeopleInteractor;
import com.mtomoskozi.sugarapp.model.Person;
import com.mtomoskozi.sugarapp.view.MainView;

import javax.inject.Inject;

/**
 * Created by Máté on 27/04/2016.
 */
public class MainPresenter extends Presenter<MainView> {

    @Inject
    public PeopleInteractor interactor;

    public MainPresenter() {
        SugarAppApplication.injector.inject(this);
    }

    public void addPerson(Person toAdd)  {
        try {
            interactor.addPersonToNetwork(toAdd);
        } catch (Exception e) {
            interactor.addPersonToDb(toAdd);
            view.showMessage(e.getMessage());
        }

    }

    public void refreshPeople() {
        try {
            view.showPeople(interactor.getPeopleFromNetwork());
        } catch (Exception e) {
            view.showPeople(interactor.getPeopleFromDb());
            view.showMessage(e.getMessage());
        }
    }
}