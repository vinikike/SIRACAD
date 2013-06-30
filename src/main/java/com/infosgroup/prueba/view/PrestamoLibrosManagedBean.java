/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Biblioteca;
import com.infosgroup.prueba.model.entities.Prestamolibros;
import com.infosgroup.prueba.model.facades.PrestamoLibroFacade;
import com.infosgroup.prueba.view.beans.SessionBean;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Guille
 */
//@Named(value = "prestamoLibrosManagedBean")
@ManagedBean(name = "prestamoLibrosManagedBean")
@ViewScoped
public class PrestamoLibrosManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient PrestamoLibroFacade prestamoLibroFacade;
    //-----------------------------------------------------------------
    @Inject
    private SessionBean sessionBean;
    //-----------------------------------------------------------------
    private Biblioteca biblioteca;
    //-----------------------------------------------------------------
    private Integer prestamo$correlativo;
    private String prestamo$nombreLibro;
    private Integer prestamo$cantidadLibro;
    private String prestamo$nombrePrestamista;
    private String prestamo$tipoPrestamista;
    private String prestamo$gradoPrestamista;
    private Date prestamo$fechaPrestamo;
    private Date prestamo$fechaDevolucion;
    private String prestamo$estadoPrestamo;
    private String prestamo$codigo;

    //-----------------------------------------------------------------
    public Integer getPrestamo$correlativo() {
        return prestamo$correlativo;
    }

    public void setPrestamo$correlativo(Integer prestamo$correlativo) {
        this.prestamo$correlativo = prestamo$correlativo;
    }

    public String getPrestamo$nombreLibro() {
        return prestamo$nombreLibro;
    }

    public void setPrestamo$nombreLibro(String prestamo$nombreLibro) {
        this.prestamo$nombreLibro = prestamo$nombreLibro;
    }

    public Integer getPrestamo$cantidadLibro() {
        return prestamo$cantidadLibro;
    }

    public void setPrestamo$cantidadLibro(Integer prestamo$cantidadLibro) {
        this.prestamo$cantidadLibro = prestamo$cantidadLibro;
    }

    public String getPrestamo$nombrePrestamista() {
        return prestamo$nombrePrestamista;
    }

    public void setPrestamo$nombrePrestamista(String prestamo$nombrePrestamista) {
        this.prestamo$nombrePrestamista = prestamo$nombrePrestamista;
    }

    public String getPrestamo$tipoPrestamista() {
        return prestamo$tipoPrestamista;
    }

    public void setPrestamo$tipoPrestamista(String prestamo$tipoPrestamista) {
        this.prestamo$tipoPrestamista = prestamo$tipoPrestamista;
    }

    public String getPrestamo$gradoPrestamista() {
        return prestamo$gradoPrestamista;
    }

    public void setPrestamo$gradoPrestamista(String prestamo$gradoPrestamista) {
        this.prestamo$gradoPrestamista = prestamo$gradoPrestamista;
    }

    public Date getPrestamo$fechaPrestamo() {
        return prestamo$fechaPrestamo;
    }

    public void setPrestamo$fechaPrestamo(Date prestamo$fechaPrestamo) {
        this.prestamo$fechaPrestamo = prestamo$fechaPrestamo;
    }

    public Date getPrestamo$fechaDevolucion() {
        return prestamo$fechaDevolucion;
    }

    public void setPrestamo$fechaDevolucion(Date prestamo$fechaDevolucion) {
        this.prestamo$fechaDevolucion = prestamo$fechaDevolucion;
    }

    public String getPrestamo$estadoPrestamo() {
        return prestamo$estadoPrestamo;
    }

    public void setPrestamo$estadoPrestamo(String prestamo$estadoPrestamo) {
        this.prestamo$estadoPrestamo = prestamo$estadoPrestamo;
    }

    public String getPrestamo$codigo() {
        return prestamo$codigo;
    }

    public void setPrestamo$codigo(String prestamo$codigo) {
        this.prestamo$codigo = prestamo$codigo;
    }

    @PostConstruct
    @Override
    public void _init() {
        super._init();
        biblioteca = sessionBean.getBibliotecaSeleccionada();
        if (biblioteca != null) {
            prestamo$nombreLibro = biblioteca.getTitulo();
        }

        prestamo$tipoPrestamista = "Estudiante";
        prestamo$cantidadLibro = 1;
        prestamo$fechaPrestamo = Calendar.getInstance().getTime();
        prestamo$fechaDevolucion = Calendar.getInstance().getTime();
    }

    public String prestarLibro$action() {
        Prestamolibros prestamolibros = new Prestamolibros();
        prestamolibros.setCodprestamo(prestamoLibroFacade.max() + 1);
        prestamolibros.setNombrelibro(prestamo$nombreLibro);
        prestamolibros.setCantidad(prestamo$cantidadLibro);
        prestamolibros.setEstado("Prestado");
        prestamolibros.setGrado(prestamo$gradoPrestamista);
        prestamolibros.setTipopresona(prestamo$tipoPrestamista);
        prestamolibros.setNombre(prestamo$nombrePrestamista);
        prestamolibros.setFechaprestamo(prestamo$fechaPrestamo);
        prestamolibros.setFechadevolucion(prestamo$fechaDevolucion);
        prestamolibros.setCodigo(prestamo$codigo);

        prestamoLibroFacade.create(prestamolibros);
        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Prestamo Realizado");

        prestamo$cantidadLibro = 1;
        prestamo$codigo = "";
        prestamo$gradoPrestamista = "Seleccione un grado";
        prestamo$nombreLibro = "";
        prestamo$nombrePrestamista = "";
        prestamo$tipoPrestamista = "Estudiante";
        prestamo$fechaPrestamo = Calendar.getInstance().getTime();
        prestamo$fechaDevolucion = Calendar.getInstance().getTime();
        return null;
    }
}
