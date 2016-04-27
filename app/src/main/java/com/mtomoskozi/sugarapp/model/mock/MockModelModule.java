package com.mtomoskozi.sugarapp.model.mock;

import com.mtomoskozi.sugarapp.model.prod.PeopleDbModel;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Máté on 27/04/2016.
 */
@Module
public class MockModelModule {

    @Provides
    public PeopleDbModel provideMockPeopleDbModel() {
        return new MockPeopleDbModel();
    }
}
