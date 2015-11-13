package com.thecodeviking.daggerretrofitmvvm;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Defines injections at the application level
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    void inject(MainActivity activity);
}