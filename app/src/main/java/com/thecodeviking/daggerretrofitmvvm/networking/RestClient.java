package com.thecodeviking.daggerretrofitmvvm.networking;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * For REST over HTTP(S). Holds the client for other services to put interfaces against.
 */
public class RestClient {
    private static final String TAG = RestClient.class.toString();
    private final Retrofit mClient;

    public RestClient(String baseUrl) {
        OkHttpClient okClient = new OkHttpClient();
        okClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                // if we needed to refresh oAuth tokens, this is where it would happen
                Response response = chain.proceed(chain.request()); // currently does nothing
                return response;
            }
        });

        mClient = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    /**
     * Creates an implementation of the API defined by the ApiInterfaceClass
     * @param apiInterfaceClass
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> apiInterfaceClass) {
        return mClient.create(apiInterfaceClass);
    }
}
