package com.mtomoskozi.sugarapp.android;

import android.app.Application;

import com.mtomoskozi.sugarapp.BuildConfig;
import com.mtomoskozi.sugarapp.view.ViewModule;

/**
 * Created by Máté on 27/04/2016.
 */
public class SugarAppApplication  extends Application {

        public static SugarAppApplicationComponent injector;

        @Override
        public void onCreate() {
            super.onCreate();
            if (BuildConfig.FLAVOR.equals("mock")) {
                injector = DaggerMockSugarAppApplicationComponent.builder().viewModule(new ViewModule(this)).build();
            } else {
                injector = DaggerSugarAppApplicationComponent.builder().viewModule(new ViewModule(this)).build();
            }
        }
    }
