package com.anncode.aplicacioncontactos.restApi.adapter;

import com.anncode.aplicacioncontactos.restApi.ConstantesRestApi;
import com.anncode.aplicacioncontactos.restApi.ContactoEndpointsApi;
import com.anncode.aplicacioncontactos.restApi.PerfilEndpointsApi;
import com.anncode.aplicacioncontactos.restApi.deserializador.ContactoDeserializador;
import com.anncode.aplicacioncontactos.restApi.deserializador.PerfilDeserializador;
import com.anncode.aplicacioncontactos.restApi.model.ContactoResponse;
import com.anncode.aplicacioncontactos.restApi.model.DataUserResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by andres caicedo on 18/07/17.
 */
public class PerfilRestApiAdapter {

    public PerfilEndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(PerfilEndpointsApi.class);
    }

    public Gson perfilConstruyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DataUserResponse.class, new PerfilDeserializador());
        return gsonBuilder.create();
    }
}
