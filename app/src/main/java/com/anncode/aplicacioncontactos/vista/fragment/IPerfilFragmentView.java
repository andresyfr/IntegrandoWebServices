package com.anncode.aplicacioncontactos.vista.fragment;

import com.anncode.aplicacioncontactos.adapter.ContactoAdaptador;
import com.anncode.aplicacioncontactos.adapter.PerfilAdaptador;
import com.anncode.aplicacioncontactos.pojo.Contacto;
import com.anncode.aplicacioncontactos.pojo.DataUser;

import java.util.ArrayList;

/**
 * Created by andres caicedo on 18/07/17.
 */
public interface IPerfilFragmentView {

    public void generarLinearLayoutVertical();
    public void generarGridLayout();

    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> dataUser);

    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);

    public void inicializarPerfil(ArrayList<DataUser> dataUsers);
}
