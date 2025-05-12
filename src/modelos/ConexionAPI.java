package modelos;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionAPI {

    final String DIRECCIONAPI = "https://dragonball-api.com/api/characters/";

    public ConexionAPI(){};

    public String obtenerPersonaje(String idPersonaje){

        System.out.println("Obteniendo personaje...");

        String json="";

        try{
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(DIRECCIONAPI+idPersonaje))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            json=response.body();

        }catch(IllegalArgumentException e){
            System.out.println("Error, verifique la dirección.\n"+e);
        }catch(Exception e){
            System.out.println(e);
        }

        return json;
    }



}
