package com.thecodeviking.daggerretrofitmvvm.networking;

import com.thecodeviking.daggerretrofitmvvm.constants.RestApi;
import com.thecodeviking.daggerretrofitmvvm.models.UserSearchResult;

import junit.framework.Assert;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GitHubServiceTest {
    @Test
    public void testGitHubService_getUsersTestSuccess() {
        RestClient restClient = new RestClient(RestApi.BASE_URL);
        GitHubUserService gitHubUserService = new GitHubUserService(restClient);
        final CountDownLatch latch = new CountDownLatch(1);
        gitHubUserService.getUsers("steffkelsey", new MyCallBack<UserSearchResult>() {
            @Override
            public void onSuccess(UserSearchResult response) {
                Assert.assertTrue(response.getTotalCount() == 1);
                latch.countDown();
            }

            @Override
            public void onError(String header, String message) {
                Assert.assertTrue(false);
            }
        });

        try {
            latch.await(5000, TimeUnit.MILLISECONDS);
            Assert.assertEquals(latch.getCount(), 0);
        } catch (InterruptedException e) {
            System.out.println("exception: " + e.toString());
            Assert.assertTrue(false);
        }
    }

    @Test
    public void testGitHubService_getUsersTestFailure() {
        RestClient restClient = new RestClient("https://api.github34.com/");
        GitHubUserService gitHubUserService = new GitHubUserService(restClient);
        final CountDownLatch latch = new CountDownLatch(1);
        gitHubUserService.getUsers("kangaroo", new MyCallBack<UserSearchResult>() {
            @Override
            public void onSuccess(UserSearchResult response) {
                Assert.assertTrue(false);
            }

            @Override
            public void onError(String header, String message) {
                latch.countDown();
            }
        });

        try {
            latch.await(5000, TimeUnit.MILLISECONDS);
            Assert.assertEquals(latch.getCount(), 0);
        } catch (InterruptedException e) {
            System.out.println("exception: " + e.toString());
            Assert.assertTrue(false);
        }
    }
}
