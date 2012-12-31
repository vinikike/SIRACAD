/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;
 
  

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 

/**
 *
 * @author Guille
 */
@ManagedBean(name="datosTabla")
@ViewScoped
public class DatosTabla extends AbstractJSFBean
{
    private List<Datos> listadatos;

    public List<Datos> getListadatos() {
        return listadatos;
    }

    public void setListadatos(List<Datos> listadatos) {
        this.listadatos = listadatos;
    }
    
    
    @PostConstruct
    public void init()
    {
        listadatos = new ArrayList<Datos>();
        listadatos.add(new Datos("Guitarra", "Es un taller donde despiertan los estudiantes el artista que llevan en su interior", "Ulises Renderos"));
        listadatos.add(new Datos("Danza", "Los estudiantes aprenden el arte de la danza de nuestra cultura", "Veronica Guadalupe Rivas"));
        listadatos.add(new Datos("Cosmetologia", "Los jovenes demuestran su interes por aprender algo nuevo", "Cindy Osorio"));
        listadatos.add(new Datos("Pintura", "Los jovenes despiertan su interes por el arte demostrando su imaginacion en cada modelo", "Gerardo Mejia"));
    }

}
