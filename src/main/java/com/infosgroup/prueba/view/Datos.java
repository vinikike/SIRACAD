/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import java.io.Serializable;

/**
 *
 * @author Guille
 */
public class Datos implements Serializable
{
    
    private String nombre;
    private String descripcion;
    private String docente;

    public Datos(String nombre, String descripcion, String docente) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.docente = docente;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }
    
}
