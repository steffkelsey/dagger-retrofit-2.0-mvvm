package com.thecodeviking.daggerretrofitmvvm.networking;

import com.thecodeviking.daggerretrofitmvvm.models.UserSearchResult;

import java.util.HashMap;
import java.util.Map;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Query;

/**
 * Rest Service for searching GitHub users
 */
public class GitHubUserService {
    private IGitHubUserApi mApi;
    private Map<String, Call<UserSearchResult>> mGetUserCallMap = new HashMap<>();

    public GitHubUserService(RestClient restClient) {
        mApi = restClient.create(IGitHubUserApi.class);
    }

    public void getUsers(final String searchTerm, final MyCallBack<UserSearchResult> callBack) {
        getUsers(searchTerm, callBack, false);
    }

    public void getUsers(final String searchTerm, final MyCallBack<UserSearchResult> callBack, boolean isCancelable) {
        Call<UserSearchResult> call = mApi.getUsers(searchTerm);
        if (isCancelable) {
            if (mGetUserCallMap.containsKey(searchTerm)) return; // call already exists, abort
            mGetUserCallMap.put(searchTerm, call);
        }
        call.enqueue(new Callback<UserSearchResult>() {
            @Override
            public void onResponse(Response<UserSearchResult> response, Retrofit retrofit) {
                mGetUserCallMap.remove(searchTerm);
                if (response.isSuccess()) {
                    callBack.onSuccess(response.body());
                } else {
                    callBack.onError("Server Error", response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Throwable t) {
                mGetUserCallMap.remove(searchTerm);
                callBack.onError("Android Application Error", t.getMessage());
            }
        });
    }

    public void cancel(String searchTerm) {
        if (mGetUserCallMap.containsKey(searchTerm)) {
            mGetUserCallMap.get(searchTerm).cancel();
            mGetUserCallMap.remove(searchTerm);
        }
    }

    public void cancelAll() {
        for (String key : mGetUserCallMap.keySet()) {
            mGetUserCallMap.get(key).cancel();
        }
        mGetUserCallMap.clear();
    }

    public interface IGitHubUserApi {
        @Headers("User-Agent: DaggerAndRetrofit2.0Example-App")
        @GET("search/users")
        Call<UserSearchResult> getUsers(@Query("q") String name);
    }
}
