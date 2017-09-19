package com.anncode.aplicacioncontactos.pojo;

/**
 * Created by andres caicedo on 18/07/17.
 */
public class DataUser {

    private String id;
    private String userName;
    private String urlFoto;
    private String nombreCompleto;
    private int like;

    public DataUser(String id, String userName, String urlFoto, String nombreCompleto, int like) {
        this.id = id;
        this.userName = userName;
        this.urlFoto = urlFoto;
        this.nombreCompleto = nombreCompleto;
        this.like=like;
    }

    public DataUser() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "DataUser> "+getId()+" "+getUserName()+" "+getUrlFoto()+" "+getNombreCompleto()+" "+getLike();
    }
}
