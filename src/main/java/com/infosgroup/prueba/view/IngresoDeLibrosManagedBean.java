/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Catalogolibros;
import com.infosgroup.prueba.model.entities.CatalogolibrosPK;
import com.infosgroup.prueba.model.entities.Libro;
import com.infosgroup.prueba.model.entities.LibroPK;
import com.infosgroup.prueba.model.facades.CaltalogoLibrosFacade;
import com.infosgroup.prueba.model.facades.LibroFacade;
import com.infosgroup.prueba.view.beans.SessionBean;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "ingresaLibros")
@ViewScoped
public class IngresoDeLibrosManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient CaltalogoLibrosFacade catalogoLibrosFacade;
    @EJB
    private transient LibroFacade libroFacade;
    //-----------------------------------------------------------------
    @Inject
    private SessionBean sessionBean;
    //-----------------------------------------------------------------
    private Integer grado$periodo_Escolar;
    private String libro$codigo;
    private Integer libro$cantidad;
    private String libro$titulo;
    private String libro$autor;
    private String libro$editorial;
    private String libro$edicion;
    private Catalogolibros libro$codigoCatalogo;
    private String libro$pais;
    private String libro$clave;
    private String libro$tipoAdquisicion;
    private Double libro$precio;
    private List<Catalogolibros> listaCatalogoLibros;
    private Integer libro$inicio;
    private Integer libro$fin;
//--gets y sets-----------------------------------------------------------------

    public Integer getGrado$periodo_Escolar() {
        return grado$periodo_Escolar;
    }

    public void setGrado$periodo_Escolar(Integer grado$periodo_Escolar) {
        this.grado$periodo_Escolar = grado$periodo_Escolar;
    }

    public String getLibro$codigo() {
        return libro$codigo;
    }

    public void setLibro$codigo(String libro$codigo) {
        this.libro$codigo = libro$codigo;
    }

    public Integer getLibro$cantidad() {
        return libro$cantidad;
    }

    public void setLibro$cantidad(Integer libro$cantidad) {
        this.libro$cantidad = libro$cantidad;
    }

    public String getLibro$titulo() {
        return libro$titulo;
    }

    public void setLibro$titulo(String libro$titulo) {
        this.libro$titulo = libro$titulo;
    }

    public String getLibro$autor() {
        return libro$autor;
    }

    public void setLibro$autor(String libro$autor) {
        this.libro$autor = libro$autor;
    }

    public String getLibro$editorial() {
        return libro$editorial;
    }

    public void setLibro$editorial(String libro$editorial) {
        this.libro$editorial = libro$editorial;
    }

    public String getLibro$edicion() {
        return libro$edicion;
    }

    public void setLibro$edicion(String libro$edicion) {
        this.libro$edicion = libro$edicion;
    }

    public Catalogolibros getLibro$codigoCatalogo() {
        return libro$codigoCatalogo;
    }

    public void setLibro$codigoCatalogo(Catalogolibros libro$codigoCatalogo) {
        this.libro$codigoCatalogo = libro$codigoCatalogo;
    }

    public String getLibro$pais() {
        return libro$pais;
    }

    public void setLibro$pais(String libro$pais) {
        this.libro$pais = libro$pais;
    }

    public String getLibro$clave() {
        return libro$clave;
    }

    public void setLibro$clave(String libro$clave) {
        this.libro$clave = libro$clave;
    }

    public String getLibro$tipoAdquisicion() {
        return libro$tipoAdquisicion;
    }

    public void setLibro$tipoAdquisicion(String libro$tipoAdquisicion) {
        this.libro$tipoAdquisicion = libro$tipoAdquisicion;
    }

    public Double getLibro$precio() {
        return libro$precio;
    }

    public void setLibro$precio(Double libro$precio) {
        this.libro$precio = libro$precio;
    }

    public List<Catalogolibros> getListaCatalogoLibros() {
        return listaCatalogoLibros;
    }

    public void setListaCatalogoLibros(List<Catalogolibros> listaCatalogoLibros) {
        this.listaCatalogoLibros = listaCatalogoLibros;
    }

    public Integer getLibro$inicio() {
        return libro$inicio;
    }

    public void setLibro$inicio(Integer libro$inicio) {
        this.libro$inicio = libro$inicio;
    }

    public Integer getLibro$fin() {
        return libro$fin;
    }

    public void setLibro$fin(Integer libro$fin) {
        this.libro$fin = libro$fin;
    }

//------------------------------------------------------------------------------
    @PostConstruct
    @Override
    public void _init() {
        super._init();
        libro$cantidad = 0;
        libro$inicio = 0;
        libro$tipoAdquisicion = "Donacion";
        libro$precio = 0.0;
        listaCatalogoLibros = catalogoLibrosFacade.findAll();
    }

    public String guardarLibro$action() {
//        Long ultimoLibro = libroFacade.cantidadLibros(libro$tipo);
//        Libro libroBuscar = new Libro(2013, "" + ultimoLibro, libro$tipo.getCatalogolibrosPK().getCodigolibro());
//        if (libroBuscar != null) {
//            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Ya existe registro del Libro");
//            return null;
//        }
        try {
            libro$codigo = new StringBuilder().append(libro$inicio).append("/").append(libro$fin).toString();

            LibroPK libroPK = new LibroPK();
            libroPK.setIdPeriodoEscolar(sessionBean.getPeriodoEscolar().getId());
            libroPK.setCodigoInstitucion(sessionBean.getCompania().getCodigo());
            libroPK.setCodigoCatalogo(libro$codigoCatalogo.getCatalogolibrosPK().getCodigolibro());
            libroPK.setCodigoCorrelativo(libro$codigo);

            Libro libro = new Libro();
            libro.setLibroPK(libroPK);
            libro.setTitulo(libro$titulo);
            libro.setAutor(libro$autor);
            libro.setEditorial(libro$editorial);
            libro.setPais(libro$pais);
            libro.setPrecio(libro$precio);
            libro.setCantidad(libro$cantidad);
            libro.setClave(libro$clave);
            libro.setCatalogolibros(libro$codigoCatalogo);
            libro.setInicio(libro$inicio);
            libro.setFin(libro$fin);

            libroFacade.create(libro);
            mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "");
        } catch (Exception excpt) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_ERROR, "");
            logger.log(Level.SEVERE, null, excpt);
        }
        return null;
    }
    
    public void categoria$valueChangeListener(ValueChangeEvent evt)
    {
        Catalogolibros c = (Catalogolibros) evt.getNewValue();
        libro$inicio = (c == null) ? 0 : libroFacade.cantidadLibros(sessionBean.getPeriodoEscolar(), sessionBean.getCompania(), c);
    }
    
    public void cantidad$valueChangeListener(ValueChangeEvent evt)
    {
        Integer n = (Integer) evt.getNewValue();
        libro$fin = libro$inicio + n;
    }
}
