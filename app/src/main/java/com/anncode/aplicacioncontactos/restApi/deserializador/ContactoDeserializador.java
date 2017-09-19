package com.anncode.aplicacioncontactos.restApi.deserializador;

import com.anncode.aplicacioncontactos.pojo.Contacto;
import com.anncode.aplicacioncontactos.restApi.ContactoJsonKeys;
import com.anncode.aplicacioncontactos.restApi.model.ContactoResponse;
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
 * Created by anahisalgado on 25/05/16.
 */
public class ContactoDeserializador implements JsonDeserializer<ContactoResponse> {
    @Override
    public ContactoResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        ContactoResponse contactoResponse = gson.fromJson(json, ContactoResponse.class);
        JsonArray contactoResponseData = json.getAsJsonObject().getAsJsonArray(ContactoJsonKeys.MEDIA_RESPONSE_ARRAY);

        contactoResponse.setContactos(deserializarContactoDeJson(contactoResponseData));
        return contactoResponse;
    }

    private ArrayList<Contacto> deserializarContactoDeJson(JsonArray contactoResponseData){
        ArrayList<Contacto> contactos = new ArrayList<>();
        for (int i = 0; i < contactoResponseData.size() ; i++) {
            JsonObject contactoResponseDataObject = contactoResponseData.get(i).getAsJsonObject();

            JsonObject userJson     = contactoResponseDataObject.getAsJsonObject(ContactoJsonKeys.USER);
            String id               = userJson.get(ContactoJsonKeys.USER_ID).getAsString();
            String nombreCompleto   = userJson.get(ContactoJsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson            = contactoResponseDataObject.getAsJsonObject(ContactoJsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson    = imageJson.getAsJsonObject(ContactoJsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto                  = stdResolutionJson.get(ContactoJsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = contactoResponseDataObject.getAsJsonObject(ContactoJsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(ContactoJsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Contacto contactoActual = new Contacto();
            contactoActual.setId(id);
            contactoActual.setNombreCompleto(nombreCompleto);
            contactoActual.setUrlFoto(urlFoto);
            contactoActual.setLikes(likes);

            contactos.add(contactoActual);

        }

        return contactos;
    }
}
