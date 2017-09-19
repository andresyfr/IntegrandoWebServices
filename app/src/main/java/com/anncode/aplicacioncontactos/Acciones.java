package com.anncode.aplicacioncontactos;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.anncode.aplicacioncontactos.pojo.Contacto;
import com.anncode.aplicacioncontactos.vista.fragment.PerfilFragment;
import com.anncode.recyclerviewfragments.R;

import java.util.ArrayList;

/**
 * Created by andres on 18/02/17.
 */

public class Acciones implements View.OnClickListener{

    /**objeto Singleton*/
    private static Acciones singlenAcciones=null;
    private ArrayList<Contacto> mascotas;
    private String nombreCuentaConfigurado="Petyfr";

    private PerfilFragment perfilFragment= new PerfilFragment();


    private Acciones(){
        this.mascotas=new ArrayList<Contacto>();
        mascotas.add(new Contacto("","Conejo Pancho","","", 5));
        mascotas.add(new Contacto("","Gato Pancho", "","", 4));
        mascotas.add(new Contacto("","Pato Donald", "","", 3));
        mascotas.add(new Contacto("","Tortuga Nija", "","", 2));
        mascotas.add(new Contacto("","Perro Dalmata", "","", 4));
        mascotas.add(new Contacto("","Perra lika", "","", 5));
        mascotas.add(new Contacto("","Perro Lufi", "","", 5));
    }

    public static Acciones getInstance() {
        if (singlenAcciones == null) {
            synchronized (Acciones.class) {
                if (singlenAcciones == null) {
                    singlenAcciones = new Acciones();
                }
            }
        }
        return singlenAcciones;
    }

    @Override
    public void onClick(View v) {

    }

    public boolean accionesMune(MenuItem item, boolean superOption, Activity activity){
        switch (item.getItemId()) {
            case R.id.actionConfigurarCuenta:
                Intent intent=new Intent(activity, ConfigurarCuenta.class);
                activity.startActivity(intent);
                //Log.i("ActionBar", "actionFavoritos!");
                return true;
            case R.id.actionAcercaDe:
                Toast.makeText(activity.getApplicationContext(),"Aplicación realizada por ANDRES FELIPE RAMIREZ CAICEDO: andresyfr@gmail.com", Toast.LENGTH_LONG).show();
                //Log.i("ActionBar", "acerca de!");;
                return true;
            case R.id.actionContacto:
                Toast.makeText(activity.getApplicationContext(),"Esta opción se deshabilito para no ejecutar mucho código", Toast.LENGTH_SHORT).show();
                //Log.i("ActionBar", "acerca de!");;
                return true;
            default:
                return superOption;
        }
    }

    public boolean cambiarDatosMascotas(Contacto mascotaOriginal, Contacto mascotaCambiada){
        int i=0;
        while (i<mascotas.size()){
            if(mascotas.get(i).getLikes()==mascotaOriginal.getLikes() && mascotas.get(i).getNombreCompleto().equals(mascotaOriginal.getNombreCompleto()) && mascotas.get(i).getUrlFoto() == mascotaOriginal.getUrlFoto()){
                mascotas.set(i,mascotaCambiada);
                return true;
            }
            i++;
        }return false;
    }

    public ArrayList<Contacto> getMascotas() {
        return mascotas;
    }

    public String getNombreCuentaConfigurado() {
        return nombreCuentaConfigurado;
    }

    public void setNombreCuentaConfigurado(String nombreCuentaConfigurado) {
        this.nombreCuentaConfigurado = nombreCuentaConfigurado;
    }

    public PerfilFragment getPerfilFragment() {
        return perfilFragment;
    }
}
