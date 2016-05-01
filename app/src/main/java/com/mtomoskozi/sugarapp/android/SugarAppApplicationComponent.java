package com.mtomoskozi.sugarapp.android;

import com.mtomoskozi.sugarapp.interactor.InteractorModule;
import com.mtomoskozi.sugarapp.interactor.PeopleInteractor;
import com.mtomoskozi.sugarapp.model.prod.ModelModule;
import com.mtomoskozi.sugarapp.network.prod.NetworkModule;
import com.mtomoskozi.sugarapp.presenter.MainPresenter;
import com.mtomoskozi.sugarapp.view.ViewModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Máté on 27/04/2016.
 */
@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, ModelModule.class, NetworkModule.class})
public interface SugarAppApplicationComponent {
    void inject(MainActivity mainActivity);

    void inject(MainPresenter mainPresenter);

    void inject(PeopleInteractor interactor);
}

