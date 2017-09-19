package com.anncode.aplicacioncontactos.restApi;

import com.anncode.aplicacioncontactos.restApi.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by anahisalgado on 25/05/16.
 */
public interface ContactoEndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia();

    @GET
    Call<ContactoResponse> getRecentMediaSearchIdUser(@Url String url);

//    @GET(ConstantesRestApi.URL_GET_DATA_USER)
//    Call<ContactoResponse> getRecentMediaSearchIdUser(@Query("{id}") String id);
}
