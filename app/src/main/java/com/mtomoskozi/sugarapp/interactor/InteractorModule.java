package com.mtomoskozi.sugarapp.interactor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Máté on 27/04/2016.
 */
@Module
public class InteractorModule {

    @Provides
    public PeopleDbInteractor providePeopleDbInteractor() {
        return new PeopleDbInteractor();
    }
}
