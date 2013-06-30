/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import javax.ejb.EJB;
import com.infosgroup.prueba.model.entities.Biblioteca;
import com.infosgroup.prueba.model.entities.BibliotecaPK;
import com.infosgroup.prueba.model.facades.BibliotecaFacade;
//import com.infosgroup.prueba.model.facades.BuscarLibroFacade;
import com.infosgroup.prueba.view.beans.SessionBean;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Guille
 */
//@Named(value = "buscarLibroManagedBean")
@ManagedBean(name = "buscarLibroManagedBean")
@ViewScoped
public class BuscarLibroManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient BibliotecaFacade bibliotecaFacade;
    private List<Biblioteca> listaLibros;
    @Inject
    private SessionBean sessionBean;
    private String busqueda$libroAutor;
    private String busqueda$tipo;
//--------------------------------------------------------------------

    public List<Biblioteca> getListaLibros() {
        return listaLibros;
    }

    public void setListaLibros(List<Biblioteca> listaLibros) {
        this.listaLibros = listaLibros;
    }

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public String getBusqueda$libroAutor() {
        return busqueda$libroAutor;
    }

    public void setBusqueda$libroAutor(String busqueda$libroAutor) {
        this.busqueda$libroAutor = busqueda$libroAutor;
    }

    public String getBusqueda$tipo() {
        return busqueda$tipo;
    }

    public void setBusqueda$tipo(String busqueda$tipo) {
        this.busqueda$tipo = busqueda$tipo;
    }

    //-------------------------------------------------------------------
    @PostConstruct
    @Override
    public void _init() {
        super._init();
        busqueda$tipo = "Titulo";
        busqueda$libroAutor = "";
    }

    public String BuscarLibroAutor$action() {
        if ("Titulo".equals(busqueda$tipo)) {
            bibliotecaFacade.findByTitulo(busqueda$libroAutor);
            listaLibros = bibliotecaFacade.findByTitulo(busqueda$libroAutor);
        } else {
            bibliotecaFacade.findByAutor(busqueda$libroAutor);
            listaLibros = bibliotecaFacade.findByAutor(busqueda$libroAutor);
        }

        HashSet<Biblioteca> l = new HashSet<>();
        for (Biblioteca b : listaLibros) {
        }

//        busqueda$tipo = "Titulo";
        busqueda$libroAutor = "";

        return null;
    }
}
