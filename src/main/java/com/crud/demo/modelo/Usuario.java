package com.crud.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * Se encarga de almacenar todos los datos que posee un usuario.
 */
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int edad;

    public Usuario() {

    }
/**
 * Constructor de la clase usuario donde se obtienen los valores de
 * sus atributos.
 * @param id Funciona como clave primaria del usuario.
 * @param Nombres Es el nombre o nombres que posee el usuario registrado.
 * @param ApellidoPaterno Es el apellido paterno que posee
 * el usuario registrado.
 * @param ApellidoMaterno Es el apellido materno que posee
 * el usuario registrado.
 * @param Edad Es la edad que posee el usuario registrado.
 */
    public Usuario(int id, String Nombres, String ApellidoPaterno, String ApellidoMaterno, int Edad) {
        super();
        this.id = id;
        this.nombres = Nombres;
        this.apellidoPaterno = ApellidoPaterno;
        this.apellidoMaterno = ApellidoMaterno;
        this.edad = Edad;
    }
    
    public int getID() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public int getEdad() {
        return edad;
    }

    public void setID(int entradaID) {
        id = entradaID;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
