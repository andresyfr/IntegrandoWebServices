package com.anncode.aplicacioncontactos.restApi;

import com.anncode.aplicacioncontactos.restApi.ConstantesRestApi;
import com.anncode.aplicacioncontactos.restApi.model.ContactoResponse;
import com.anncode.aplicacioncontactos.restApi.model.DataUserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by andres caicedo on 18/07/17.
 */
public interface PerfilEndpointsApi {

    @GET
    Call<DataUserResponse> getRecentMedia(@Url String url);

}
