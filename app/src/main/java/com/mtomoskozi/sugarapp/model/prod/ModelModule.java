package com.mtomoskozi.sugarapp.model.prod;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Máté on 27/04/2016.
 */
@Module
public class ModelModule {
    @Provides
    public PeopleDbModel providePeopleDbModel() {
        return new PeopleDbModel();
    }
}
