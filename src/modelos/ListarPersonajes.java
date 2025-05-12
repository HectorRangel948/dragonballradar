package modelos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ListarPersonajes {
    private static List<Personaje> listaPersonajes = new ArrayList<>();

    public ListarPersonajes(){}

    public List<Personaje> getListaPersonajes(){
        return this.listaPersonajes;
    }

    public List<Personaje> listarPersonaje(Personaje personaje){
        this.listaPersonajes.add(personaje);
        return getListaPersonajes();
    }
}
