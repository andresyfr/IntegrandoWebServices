package com.anncode.aplicacioncontactos.restApi.deserializador;

import com.anncode.aplicacioncontactos.pojo.Contacto;
import com.anncode.aplicacioncontactos.pojo.DataUser;
import com.anncode.aplicacioncontactos.restApi.PerfilJsonKeys;
import com.anncode.aplicacioncontactos.restApi.model.DataUserResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by andres caicedo on 18/07/17.
 */
public class PerfilDeserializador implements JsonDeserializer<DataUserResponse> {
    @Override
    public DataUserResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        DataUserResponse dataUserResponse = gson.fromJson(json, DataUserResponse.class);
        JsonArray dataUserResponseData = json.getAsJsonObject().getAsJsonArray(PerfilJsonKeys.MEDIA_RESPONSE_ARRAY);

        dataUserResponse.setDataUser(deserializarContactoDeJson(dataUserResponseData));
        return dataUserResponse;
    }

    private ArrayList<DataUser> deserializarContactoDeJson(JsonArray dataUserResponseData){
        ArrayList<DataUser> dataUser = new ArrayList<>();
//        String id               = dataUserResponseData.get(PerfilJsonKeys.ID).getAsString();
//        String userName         = dataUserResponseData.get(PerfilJsonKeys.USERNAME).getAsString();
//        String urlFoto          = dataUserResponseData.get(PerfilJsonKeys.PROFILE_PICTURE).getAsString();
//        String fullName         = dataUserResponseData.get(PerfilJsonKeys.USER_FULLNAME).getAsString();

//        dataUser.add(new DataUser(id,userName,urlFoto,fullName));
//        dataUser.add(new DataUser("1","andres","https://scontent.cdninstagram.com/t51.2885-19/s150x150/19984862_152460615326975_2310083563569020928_a.jpg","andres"));
        for (int i = 0; i < dataUserResponseData.size() ; i++) {
            JsonObject dataUserResponseDataObject = dataUserResponseData.get(i).getAsJsonObject();

            String id               = dataUserResponseDataObject.get(PerfilJsonKeys.ID).getAsString();
            String userName         = dataUserResponseDataObject.get(PerfilJsonKeys.USERNAME).getAsString();
            String urlFoto          = dataUserResponseDataObject.get(PerfilJsonKeys.PROFILE_PICTURE).getAsString();
            String fullName         = dataUserResponseDataObject.get(PerfilJsonKeys.USER_FULLNAME).getAsString();
            dataUser.add(new DataUser(id,userName,urlFoto,fullName,0));

//        System.out.println("aaaaaaaaaaaaannnnnnnnnnnnnnndddddddddddddddrrrrrrrrrrrr "+id + " "+ userName+" "+urlFoto+" "+fullName);

//            JsonObject userJson     = dataUserResponseDataObject.getAsJsonObject(PerfilJsonKeys.USER);
//            String id               = userJson.get(PerfilJsonKeys.USER_ID).getAsString();
//            String nombreCompleto   = userJson.get(PerfilJsonKeys.USER_FULLNAME).getAsString();
//
//            JsonObject imageJson            = dataUserResponseDataObject.getAsJsonObject(PerfilJsonKeys.MEDIA_IMAGES);
//            JsonObject stdResolutionJson    = imageJson.getAsJsonObject(PerfilJsonKeys.MEDIA_STANDARD_RESOLUTION);
//            String urlFoto                  = stdResolutionJson.get(PerfilJsonKeys.MEDIA_URL).getAsString();
//
//            JsonObject likesJson = dataUserResponseDataObject.getAsJsonObject(PerfilJsonKeys.MEDIA_LIKES);
//            int likes = likesJson.get(PerfilJsonKeys.MEDIA_LIKES_COUNT).getAsInt();
//
//            Contacto contactoActual = new Contacto();
//            contactoActual.setId(id);
//            contactoActual.setNombreCompleto(nombreCompleto);
//            contactoActual.setUrlFoto(urlFoto);
//            contactoActual.setLikes(likes);
//
//            dataUser.add(contactoActual);
//
        }

        return dataUser;
    }
}
