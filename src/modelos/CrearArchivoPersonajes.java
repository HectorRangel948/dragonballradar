package modelos;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CrearArchivoPersonajes {
    public void crearArchivo(List<Personaje> listaPersonajes, Gson gson){
        try{
            FileWriter archivo = new FileWriter("Personajes.txt");
            archivo.write(gson.toJson(listaPersonajes));
            archivo.close();
            System.out.println("Se creó el archivo exitosamente");
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
