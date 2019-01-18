package com.example.shoucang;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface MyService {
//    https://gank.io/api/data/1
    String url = "https://gank.io/api/data/福利/10/";
    @GET
    Observable<Welfare>welfarecall(@Url String page);
}
