package com.mtomoskozi.sugarapp.network.prod;

import com.mtomoskozi.sugarapp.network.PeopleApi;
import com.mtomoskozi.sugarapp.network.GsonHelper;
import com.mtomoskozi.sugarapp.network.NetworkConfig;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Created by Máté on 01/05/2016.
 */

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        OkHttpClient.Builder clientBuilder = null;
        try {
            clientBuilder = UnsafeClientFactory.getUnsafeClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (clientBuilder == null) {
            throw new RuntimeException("HttpClient cannot be initialized!");
        }

        return clientBuilder;
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }

    @Provides
    @Singleton
    public PeopleApi provideDefaultApi(Retrofit retrofit) {
        return retrofit.create(PeopleApi.class);
    }

}


