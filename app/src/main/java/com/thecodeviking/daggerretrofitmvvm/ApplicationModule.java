package com.thecodeviking.daggerretrofitmvvm;

import com.thecodeviking.daggerretrofitmvvm.constants.RestApi;
import com.thecodeviking.daggerretrofitmvvm.networking.GitHubUserService;
import com.thecodeviking.daggerretrofitmvvm.networking.RestClient;
import com.thecodeviking.daggerretrofitmvvm.viewmodels.MainViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Things that live for the duration of the application and will be injected into whatever the
 * component defines
 */
@Module
public class ApplicationModule {
    public ApplicationModule() {
    }

    @Provides
    @Singleton
    MainViewModel provideMainViewModel(GitHubUserService gitHubUserService) {
        return new MainViewModel(gitHubUserService);
    }

    @Provides
    @Singleton
    RestClient provideRestService() {
        return new RestClient(RestApi.BASE_URL);
    }

    @Provides
    @Singleton
    GitHubUserService provideGitHubUserService(RestClient restClient) {
        return new GitHubUserService(restClient);
    }
}