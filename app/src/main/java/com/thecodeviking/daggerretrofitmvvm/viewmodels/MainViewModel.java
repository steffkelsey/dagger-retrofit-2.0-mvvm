package com.thecodeviking.daggerretrofitmvvm.viewmodels;

import com.thecodeviking.daggerretrofitmvvm.listeners.BaseListener;
import com.thecodeviking.daggerretrofitmvvm.models.GitHubUser;
import com.thecodeviking.daggerretrofitmvvm.models.UserSearchResult;
import com.thecodeviking.daggerretrofitmvvm.networking.GitHubUserService;
import com.thecodeviking.daggerretrofitmvvm.networking.MyCallBack;

import android.app.Activity;

/**
 * ViewModel for the MainActivity class.
 */
public class MainViewModel extends BaseViewModel implements IViewModel {
    private static final String TAG = MainViewModel.class.toString();
    private Listener mListener;
    private GitHubUserService mGitHubUserService;

    public MainViewModel(GitHubUserService gitHubUserService) {
        mGitHubUserService = gitHubUserService;
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }

    public void clearListener() {
        mListener = null;
    }

    public void getUsersCommand(String searchTerm) {
        mGitHubUserService.getUsers(searchTerm, new MyCallBack<UserSearchResult>() {
            @Override
            public void onSuccess(UserSearchResult response) {
                if (mListener != null) {
                    String result = "Users(" + response.getTotalCount() + ")";
                    if (response.getItems().size() > 0) {
                        int cnt = 1;
                        result += ": Showing 1 - " + response.getItems().size();
                        for (GitHubUser user : response.getItems()) {
                            result += "\n";
                            result += (cnt++) + ") " + user.getLogin();
                        }
                    }
                    mListener.onTextChanged(result);
                }
            }

            @Override
            public void onError(String header, String message) {
                if (mListener != null) mListener.onError(header, message);
            }
        });
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void setCurrentActivity(Activity value) {

    }

    public interface Listener extends BaseListener {
        void onTextChanged(String text);
    }
}
