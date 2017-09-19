package com.anncode.aplicacioncontactos.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.anncode.aplicacioncontactos.db.ConstructorContactos;
import com.anncode.aplicacioncontactos.pojo.Contacto;
import com.anncode.aplicacioncontactos.pojo.DataUser;
import com.anncode.aplicacioncontactos.restApi.ConstantesRestApi;
import com.anncode.aplicacioncontactos.restApi.ContactoEndpointsApi;
import com.anncode.aplicacioncontactos.restApi.PerfilEndpointsApi;
import com.anncode.aplicacioncontactos.restApi.adapter.ContactoRestApiAdapter;
import com.anncode.aplicacioncontactos.restApi.adapter.PerfilRestApiAdapter;
import com.anncode.aplicacioncontactos.restApi.model.ContactoResponse;
import com.anncode.aplicacioncontactos.restApi.model.DataUserResponse;
import com.anncode.aplicacioncontactos.vista.fragment.IPerfilFragmentView;
import com.anncode.aplicacioncontactos.vista.fragment.IRecyclerViewFragmentView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by andres caicedo on 22/08/17.
 */
public class PerfilRecyclerViewFragmentPresenter implements IRecylerViewFragmentPresenter {
//usuario
    private IPerfilFragmentView iPerfilFragmentView;
    private Context context;
    private ArrayList<DataUser> dataUsers=new ArrayList<DataUser>();
//fotos de usuario
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public PerfilRecyclerViewFragmentPresenter(IPerfilFragmentView iPerfilFragmentView, Context context) {
        this.iPerfilFragmentView = iPerfilFragmentView;
        this.context = context;
        //obtenerContactosBaseDatos();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerContactosBaseDatos() {
//        constructorContactos = new ConstructorContactos(context);
//        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void obtenerMediosRecientes() {
        PerfilRestApiAdapter perfilRestApiAdapter = new PerfilRestApiAdapter();
        Gson gsonMediaRecent = perfilRestApiAdapter.perfilConstruyeGsonDeserializadorMediaRecent();
        PerfilEndpointsApi perfilEndpointsApi = perfilRestApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);

        String url=(ConstantesRestApi.URL_GET_DATA_USER);

        Call<DataUserResponse> perfilResponseCall = perfilEndpointsApi.getRecentMedia(url.replace("{name_user}",ConstantesRestApi.getName_user()));

        perfilResponseCall.enqueue(new Callback<DataUserResponse>() {
            @Override
            public void onResponse(Call<DataUserResponse> call, Response<DataUserResponse> response) {
                DataUserResponse perfilResponse = response.body();
                dataUsers = perfilResponse.getDataUser();
//                mostrarContactosRV();
                if(dataUsers.size()>0) {
                    obtenerFotosdelIDContacto(dataUsers.get(0).getId());
                }
                mostrarDataPerfil();
            }

            @Override
            public void onFailure(Call<DataUserResponse> call, Throwable t) {
                Toast.makeText(context, "¡Algo pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });


    }

    private void obtenerFotosdelIDContacto(String id){
        ContactoRestApiAdapter contactoRestApiAdapter = new ContactoRestApiAdapter();
        Gson gsonMediaRecent2 = contactoRestApiAdapter.construyeGsonDeserializadorMediaRecent();
        ContactoEndpointsApi contactoEndpointsApi = contactoRestApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent2);

        String url=ConstantesRestApi.URL_GET_MEDIA_RECENT_BY_ID;
        Call<ContactoResponse> contactoResponseCall = contactoEndpointsApi.getRecentMediaSearchIdUser(url.replace("{id_user}",id));

        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoResponse = response.body();
                contactos = contactoResponse.getContactos();
                mostrarContactosRV();
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión 2! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION 2", t.toString());
            }
        });
    }

    public void mostrarDataPerfil(){
        iPerfilFragmentView.inicializarPerfil(dataUsers);
    }

    @Override
    public void mostrarContactosRV() {
        iPerfilFragmentView.inicializarAdaptadorRV(iPerfilFragmentView.crearAdaptador(contactos));
        iPerfilFragmentView.generarGridLayout();
    }
}
