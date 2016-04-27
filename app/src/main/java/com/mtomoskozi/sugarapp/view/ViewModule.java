package com.mtomoskozi.sugarapp.view;

import android.content.Context;

import com.mtomoskozi.sugarapp.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Máté on 27/04/2016.
 */
@Module
public class ViewModule {
    private Context context;

    public ViewModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }
}

