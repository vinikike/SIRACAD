/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Grado;
import com.infosgroup.prueba.model.entities.GradoPK;
import com.infosgroup.prueba.model.entities.ListaGrados;
import com.infosgroup.prueba.model.entities.Nivel;
import com.infosgroup.prueba.model.facades.GradoFacade;
import com.infosgroup.prueba.model.facades.ListaGradosFacade;
import com.infosgroup.prueba.model.facades.NivelFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "ingresarGradoSeccion")
@ViewScoped
public class IngresarGradoSeccionManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient GradoFacade gradoFacade;
    @EJB
    private transient NivelFacade nivelFacade;
    @EJB
    private transient ListaGradosFacade listaGradosFacade;
    //---------------------------------------------------
    private String grado$periodo_Escolar;
    private Nivel grado$nivel;
    private ListaGrados grado$grado;
    private String grado$opcion;
    private String grado$seccion;
    private String grado$nombre;
    private String grado$turno;
    //
    private List<Nivel> listaNiveles;
    private List<ListaGrados> listaGrados;

//--------------------------------------------------------------------
    public String getGrado$periodo_Escolar() {
        return grado$periodo_Escolar;
    }

    public void setGrado$periodo_Escolar(String grado$periodo_Escolar) {
        this.grado$periodo_Escolar = grado$periodo_Escolar;
    }

    public Nivel getGrado$nivel() {
        return grado$nivel;
    }

    public void setGrado$nivel(Nivel grado$nivel) {
        this.grado$nivel = grado$nivel;
    }

    public List<Nivel> getListaNiveles() {
        return listaNiveles;
    }

    public void setListaNiveles(List<Nivel> listaNiveles) {
        this.listaNiveles = listaNiveles;
    }

    public ListaGrados getGrado$grado() {
        return grado$grado;
    }

    public void setGrado$grado(ListaGrados grado$grado) {
        this.grado$grado = grado$grado;
    }

    public String getGrado$opcion() {
        return grado$opcion;
    }

    public void setGrado$opcion(String grado$opcion) {
        this.grado$opcion = grado$opcion;
    }

    public String getGrado$seccion() {
        return grado$seccion;
    }

    public void setGrado$seccion(String grado$seccion) {
        this.grado$seccion = grado$seccion;
    }

    public String getGrado$nombre() {
        return grado$nombre;
    }

    public void setGrado$nombre(String grado$nombre) {
        this.grado$nombre = grado$nombre;
    }

    public String getGrado$turno() {
        return grado$turno;
    }

    public void setGrado$turno(String grado$turno) {
        this.grado$turno = grado$turno;
    }

    public List<ListaGrados> getListaGrados() {
        return listaGrados;
    }

    public void setListaGrados(List<ListaGrados> listaGrados) {
        this.listaGrados = listaGrados;
    }

    //--------------------------------------------------------------------
    //========================
    @PostConstruct
    @Override
    public void _init() {
        super._init();

        
        grado$opcion = "G";
        grado$turno = "M";
        listaNiveles = nivelFacade.findAll();        
        grado$nivel = null; //nivelFacade.find(1);
        listaGrados = new ArrayList<ListaGrados>(); //listaGradosFacade.findByNivel(grado$nivel);
        grado$grado = null;
    }

    public String guardarGradoSeccion$action() {

//        Grado gradoBuscar = gradoFacade.find(new GradoPK(2013, grado$nivel, grado$grado, grado$opcion, grado$seccion));
//        if (gradoBuscar != null) {
//            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Ya existe el registro este grado en el periodo escolar");
//            return null;
//        }

        GradoPK gradoPK = new GradoPK();
        gradoPK.setIdPeriodoEscolar(2013);
//        gradoPK.setNivel(grado$nivel);
//        gradoPK.setGrado(grado$grado);
        gradoPK.setOpcion(grado$opcion);
        gradoPK.setSeccion(grado$seccion);

        Grado grado = new Grado();
        grado.setGradoPK(gradoPK);

        grado.setNombreGrado(grado$nombre);
        grado.setTurno(grado$turno);
        gradoFacade.create(grado);

        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Seccion registrada exitosamente");

//        grado$nivel = "P";
//        grado$grado = "5";
        grado$opcion = "G";
        grado$nombre = "";
        grado$seccion = "";
        grado$turno = "M";

        return null;

    }
    
    public void nivel$valueChangeListener(ValueChangeEvent evt)
    {
        Nivel n = (Nivel) evt.getNewValue();
        listaGrados = listaGradosFacade.findByNivel(n);
    }
}
