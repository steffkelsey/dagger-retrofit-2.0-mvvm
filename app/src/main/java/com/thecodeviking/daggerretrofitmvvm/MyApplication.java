package com.thecodeviking.daggerretrofitmvvm;

import android.app.Application;

/**
 * Creates the Dagger graph
 */
public class MyApplication extends Application {
    private ApplicationComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return mComponent;
    }
}
