package cowapps.js_cmd.splashimage;

import java.io.Serializable;

/**
 * Created by js_cmd on 16/1/17.
 */

public class Jugador implements Serializable {
    //Declaracion de propiedades del objeto
    private String nombre="nadie";
    private String nick="nadie";
    private int edad=0;
    private int id=0;
    private int puntos=0;

    //Constructor por defecto
    public Jugador() {

    }

    //Constructor con argumentos
    public Jugador(String nombre,String nick,int edad,int id, int puntos) {
        this.nombre = nombre;
        this.nick = nick;
        this.edad = edad;
        this.id = id;
        this.puntos = puntos;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return the nick
     */
    public String getNick() {
        return nick;
    }
    /**
     * @param nick the nick to set
     */
    public void setNick(String nick) {
        this.nick = nick;
    }
    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }
    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the puntos
     */
    public int getPuntos() {
        return puntos;
    }
    /**
     * @param puntos the puntos to set
     */
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

}

