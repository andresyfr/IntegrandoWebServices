package com.anncode.aplicacioncontactos.restApi.model;

import com.anncode.aplicacioncontactos.pojo.DataUser;

import java.util.ArrayList;

/**
 * Created by andres caicedo on 18/07/17.
 */
public class DataUserResponse {

    ArrayList<DataUser> dataUser;

    public ArrayList<DataUser> getDataUser() {
        return dataUser;
    }

    public void setDataUser(ArrayList<DataUser> dataUser) {
        this.dataUser = dataUser;
    }
}
