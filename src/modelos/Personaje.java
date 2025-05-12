package modelos;

public class Personaje {
    private String nombre;
    private String ki;
    private String raza;

    public Personaje(PersonajeAPI personajeAPI){
        this.nombre=personajeAPI.name();
        this.ki= personajeAPI.ki();
        this.raza=personajeAPI.race();
    }

    @Override
    public String toString(){
        return """
                DRAGON BALL
                Nombre: %s
                Ki: %s
                Raza: %s
                """.formatted(this.nombre, this.ki, this.raza);
    }

}
