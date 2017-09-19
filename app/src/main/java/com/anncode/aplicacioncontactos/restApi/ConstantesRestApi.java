package com.anncode.aplicacioncontactos.restApi;

/**
 * Created by anahisalgado on 25/05/16.
 */
public final class ConstantesRestApi {

    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "5707055408.a62d289.101c474e40c3446d9fd1cee136e9b4a0";
//    public static final String ACCESS_TOKEN = "3259702353.aa0d0f4.e61865afc9144ecc8ffc8f6dc84aa17b";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN
    //===================================================================================================================
//para búscar los datos de un usuario por el nombre del mismo==============================================
    //    public static String PERFIL_SEARCHING="petyfr";
    public static final String URL_SET_USER_SEARCHING_NAME="{name_user}";
//    public static final String URL_SET_USER_SEARCHING="5707055408";
    public static final String KEY_ACCESS_TOKEN_SEARCH = "&access_token=";
    public static final String URL_GET_DATA_USER="users/search?q="+URL_SET_USER_SEARCHING_NAME+KEY_ACCESS_TOKEN_SEARCH+ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/search?q=petyfr&access_token=5707055408.a62d289.101c474e40c3446d9fd1cee136e9b4a0

    //para búscar las fotos de un usuario por el id del mismo==============================================
    public static final String URL_SET_USER_SEARCHING_ID="{id_user}";
    public static final String URL_GET_MEDIA_RECENT_BY_ID="users/"+URL_SET_USER_SEARCHING_ID+"/media/recent/"+KEY_ACCESS_TOKEN+ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/5707055408/media/recent/?access_token=5707055408.a62d289.101c474e40c3446d9fd1cee136e9b4a0

    //
    public static String name_user="petagramdoc";
    public static String id_user="5787786954";

    //public static String name_user="petyfr";
    //public static String id_user="5707055408";

    public static String getName_user() {
        return name_user;
    }

    public static void setName_user(String name_user) {
        ConstantesRestApi.name_user = name_user;
    }

    public static String getId_user() {
        return id_user;
    }

    public static void setId_user(String id_user) {
        ConstantesRestApi.id_user = id_user;
    }
}
