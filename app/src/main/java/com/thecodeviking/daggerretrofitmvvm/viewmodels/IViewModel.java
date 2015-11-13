package com.thecodeviking.daggerretrofitmvvm.viewmodels;

import android.app.Activity;
import android.os.Handler;

/**
 * Interface for all the ViewModels in the app. Mostly concerned with View/Activity lifecycle
 * events
 */
public interface IViewModel {
    void onCreate(Handler handler);

    void onResume();

    void onPause();

    void onDestroy();

    void setCurrentActivity(Activity value);
}
