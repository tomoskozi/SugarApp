package com.mtomoskozi.sugarapp.network.mock;

import android.net.Uri;
import android.util.Log;

import com.mtomoskozi.sugarapp.network.NetworkConfig;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Máté on 01/05/2016.
 */

import static com.mtomoskozi.sugarapp.network.mock.MockHelper.makeResponse;

public class MockInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return process(chain.request());
    }

    public Response process(Request request) {

        Uri uri = Uri.parse(request.url().toString());

        Log.d("Test Http Client", "URL call: " + uri.toString());
        Headers headers = request.headers();

        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "people")) {
            return PeopleMock.process(request);
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "people/add")) {
            return PeopleMock.process(request);
        } else {
            return makeResponse(request, headers, 404, "Unknown");
        }
    }
}
