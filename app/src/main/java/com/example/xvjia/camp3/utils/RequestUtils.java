package com.example.xvjia.camp3.utils;

import com.example.xvjia.camp3.decode.UnicodeDecode;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by xjl on 2017/1/16.
 */

public class RequestUtils {
    private OkHttpClient client;
    private Map<String, String> params;
    private String url;

    public RequestUtils() {
        client = new OkHttpClient();
    }

    public Observable<String> request(Map<String, String> map, String requestUrl) {
        params = map;
        url = requestUrl;
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(final Subscriber<? super String> subscriber) {
                if (!subscriber.isUnsubscribed()) {
                    FormBody.Builder builder = new FormBody.Builder();
                    if (params != null && !params.isEmpty()) {
                        for (Map.Entry<String, String> entry : params.entrySet()) {
//                            Logger.d(entry.getKey() + ":" + entry.getValue());
                            builder.add(entry.getKey(), entry.getValue());
                        }
                    }
                    RequestBody requestBody = builder.build();
                    Request request = new Request.Builder()
                            .url(url)
                            .post(requestBody)
                            .build();
                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            subscriber.onError(e);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            if (response.isSuccessful()) {
                                subscriber.onNext(UnicodeDecode.decode(response.body().string()));
                            }
                            subscriber.onCompleted();
                        }
                    });
                }
            }
        });
    }
}
