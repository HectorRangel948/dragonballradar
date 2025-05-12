import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelos.*;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        String idPersonaje="0";
        ListarPersonajes listaDePersonajes = new ListarPersonajes();

        while(true){
            System.out.println("Ingrese el id del personaje: ");
            idPersonaje=console.nextLine();

            if(idPersonaje.contains("salir")){
                break;
            }
            else{
                ConexionAPI nuevaConexion = new ConexionAPI();
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();

                String personajeInfo = nuevaConexion.obtenerPersonaje(idPersonaje);

                PersonajeAPI miPersonajeAPI= gson.fromJson(personajeInfo, PersonajeAPI.class);

                try{
                    Personaje miPersonaje = new Personaje(miPersonajeAPI);
                    listaDePersonajes.listarPersonaje(miPersonaje);
                    System.out.println(listaDePersonajes.getListaPersonajes());

                    CrearArchivoPersonajes nuevoArchivo = new CrearArchivoPersonajes();
                    nuevoArchivo.crearArchivo(listaDePersonajes.getListaPersonajes(),gson);

                }catch(Exception e){
                    System.out.println(e);
                }
            }

        }
    }
}
