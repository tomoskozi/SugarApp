package com.mtomoskozi.sugarapp.android;

import com.mtomoskozi.sugarapp.interactor.InteractorModule;
import com.mtomoskozi.sugarapp.model.mock.MockModelModule;
import com.mtomoskozi.sugarapp.view.ViewModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Máté on 27/04/2016.
 */
@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, MockModelModule.class})
public interface MockSugarAppApplicationComponent extends SugarAppApplicationComponent {

}
