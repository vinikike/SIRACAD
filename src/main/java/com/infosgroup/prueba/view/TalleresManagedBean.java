/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Docente;
import com.infosgroup.prueba.model.entities.Talleres;
import com.infosgroup.prueba.model.entities.TalleresPK;
import com.infosgroup.prueba.model.facades.DocenteFacade;
import com.infosgroup.prueba.model.facades.TalleresFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "nuevoTaller")
@ViewScoped
public class TalleresManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient TalleresFacade talleresFacade;
    @EJB
    private transient DocenteFacade docenteFacade;
    //-----------------------------------------------------------------------    
    private List<Docente> listaDocentes;
    private List<Talleres> listaTalleres;
    //-----------------------------------------------------------------------
    private Integer talleres$periodoEscolar;
    private Integer talleres$idTaller;
    private String talleres$nombreTaller;
    private String talleres$descripcionTaller;
    private String talleres$responsableTaller;

//-----------sets y Gets--------------------------------------------------------
    public Integer getTalleres$periodoEscolar() {
        return talleres$periodoEscolar;
    }

    public void setTalleres$periodoEscolar(Integer talleres$periodoEscolar) {
        this.talleres$periodoEscolar = talleres$periodoEscolar;
    }

    public Integer getTalleres$idTaller() {
        return talleres$idTaller;
    }

    public void setTalleres$idTaller(Integer talleres$idTaller) {
        this.talleres$idTaller = talleres$idTaller;
    }

    public String getTalleres$nombreTaller() {
        return talleres$nombreTaller;
    }

    public void setTalleres$nombreTaller(String talleres$nombreTaller) {
        this.talleres$nombreTaller = talleres$nombreTaller;
    }

    public String getTalleres$descripcionTaller() {
        return talleres$descripcionTaller;
    }

    public void setTalleres$descripcionTaller(String talleres$descripcionTaller) {
        this.talleres$descripcionTaller = talleres$descripcionTaller;
    }

    public String getTalleres$responsableTaller() {
        return talleres$responsableTaller;
    }

    public void setTalleres$responsableTaller(String talleres$responsableTaller) {
        this.talleres$responsableTaller = talleres$responsableTaller;
    }

    public List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    public List<Talleres> getListaTalleres() {
        return listaTalleres;
    }

    public void setListaTalleres(List<Talleres> listaTalleres) {
        this.listaTalleres = listaTalleres;
    }

//-------------------------------------------------------------------------------------------
    @PostConstruct
    @Override
    public void _init() {
        super._init();
        
        listaDocentes = docenteFacade.findAll();
        listaTalleres = talleresFacade.findAll();
        
        talleres$periodoEscolar = 2013;
        talleres$nombreTaller = "";
        talleres$descripcionTaller = "";
        talleres$responsableTaller = "";
    }

    public String guardarTaller$action() {

        Talleres talleresBuscar = talleresFacade.find(new TalleresPK(2013, talleres$idTaller));
        if (talleresBuscar != null) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Ya existe un registro de este taller");
            return null;
        }

        TalleresPK talleresPK = new TalleresPK();
        talleresPK.setIdPeriodoEscolar(2013);
        //talleresPK.setCodigoTaller(1);

        Talleres talleres = new Talleres();
        talleres.setTalleresPK(talleresPK);

        talleres.setNombre(talleres$nombreTaller);
        talleres.setDescripcion(talleres$descripcionTaller);
        talleres.setResponsable(talleres$responsableTaller);
        talleresFacade.create(talleres);
        
        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Taller registrado exitosamente");
        
        talleres$nombreTaller = "";
        talleres$descripcionTaller = "";
        talleres$responsableTaller = "Seleccione un Docente";
        listaTalleres = talleresFacade.findAll();

        return null;
    }
}
