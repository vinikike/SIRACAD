/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Docente;
import com.infosgroup.prueba.model.facades.DocenteFacade;
import com.infosgroup.prueba.view.beans.SessionBean;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "ingresarDocente")
@ViewScoped
public class IngresarDocenteManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient DocenteFacade docenteFacade;
    //-------------------------------------------------
    private List<Docente> listaDocentes;
//    private Docente docente;
    //-----------------------------------------------------------------
    @ManagedProperty(value = "#{SessionBean}")
    private SessionBean sessionBean;

    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }
    //-----------------------------------------------------------------
    //-----------------------------------------------------------------
    private Integer periodo$escolar;
    private String docente$DUI;
    private String docente$NIP;
    private String docente$nombre;
    private String docente$nivelEscalafon;
    private String docente$especialidad;
    private String[] docente$jornada;
    private String docente$direccion;
    private String docente$telefono;
    private String docente$telefonoMovil;
//---------set y get---------------------------------

    public Integer getPeriodo$escolar() {
        return periodo$escolar;
    }

    public void setPeriodo$escolar(Integer periodo$escolar) {
        this.periodo$escolar = periodo$escolar;
    }

    public String getDocente$DUI() {
        return docente$DUI;
    }

    public void setDocente$DUI(String docente$DUI) {
        this.docente$DUI = docente$DUI;
    }

    public String getDocente$NIP() {
        return docente$NIP;
    }

    public void setDocente$NIP(String docente$NIP) {
        this.docente$NIP = docente$NIP;
    }

    public String getDocente$nombre() {
        return docente$nombre;
    }

    public void setDocente$nombre(String docente$nombre) {
        this.docente$nombre = docente$nombre;
    }

    public String getDocente$nivelEscalafon() {
        return docente$nivelEscalafon;
    }

    public void setDocente$nivelEscalafon(String docente$nivelEscalafon) {
        this.docente$nivelEscalafon = docente$nivelEscalafon;
    }

    public String getDocente$especialidad() {
        return docente$especialidad;
    }

    public void setDocente$especialidad(String docente$especialidad) {
        this.docente$especialidad = docente$especialidad;
    }

    public String[] getDocente$jornada() {
        return docente$jornada;
    }

    public void setDocente$jornada(String[] docente$jornada) {
        this.docente$jornada = docente$jornada;
    }

    public String getDocente$direccion() {
        return docente$direccion;
    }

    public void setDocente$direccion(String docente$direccion) {
        this.docente$direccion = docente$direccion;
    }

    public String getDocente$telefono() {
        return docente$telefono;
    }

    public void setDocente$telefono(String docente$telefono) {
        this.docente$telefono = docente$telefono;
    }

    public String getDocente$telefonoMovil() {
        return docente$telefonoMovil;
    }

    public void setDocente$telefonoMovil(String docente$telefonoMovil) {
        this.docente$telefonoMovil = docente$telefonoMovil;
    }

    //--------------------------------------------------------------
    public List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    //-------------------------------------------------------------------
    @PostConstruct
    @Override
    public void _init() {
        super._init();
        docente$nivelEscalafon = "N1";
        docente$jornada = null;
        listaDocentes = docenteFacade.findAll();
    }

    public String guardarDocente$action() {

        Docente docenteBuscar = docenteFacade.find(docente$DUI);
        if (docenteBuscar != null) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Ya existe registro del Docente");
            return null;
        }


//        DocentePK docentePK = new DocentePK();
//        docentePK.setIdPeriodoEscolar(2013);
//        docentePK.set(docente$DUI);

        Docente docente = new Docente();
        docente.setId(docente$DUI);
        docente.setUsuario(null);
//        docente.setDocentePK(docentePK);

        docente.setIdPeriodoEscolar(getSessionBean().getPeriodoEscolar());
        docente.setDocenteNip(docente$NIP);
        docente.setNombre(docente$nombre);
        docente.setDireccion(docente$direccion);
        docente.setEspecialidad(docente$especialidad);

        for (String v : docente$jornada) {
            switch (v) {
                case "M":
                    docente.setJornadamatutino("M");
                    break;
                case "T":
                    docente.setJornadavespertino("T");
                    break;
                case "N":
                    docente.setJornadanocturno("N");
                    break;
            }
        }

        docente.setNivelEscalafon(docente$nivelEscalafon);
        docente.setTelefono(docente$telefono);
        docente.setCelular(docente$telefonoMovil);
        docenteFacade.create(docente);

        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Docente registrado exitosamente");

        docente$DUI = "";
        docente$NIP = "";
        docente$nombre = "";
        docente$nivelEscalafon = "N1";
        docente$especialidad = "";
        docente$jornada = null;
        docente$direccion = "";
        docente$telefono = "";
        docente$telefonoMovil = "";
        listaDocentes = docenteFacade.findAll();

        return null;
    }
}
