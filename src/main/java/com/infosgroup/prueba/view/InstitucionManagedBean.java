/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Compania;
import com.infosgroup.prueba.model.facades.CompaniaFacade;
import com.infosgroup.prueba.model.facades.PeriodoEscolarFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "datosDeInstitucion")
@ViewScoped
public class InstitucionManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient CompaniaFacade companiaFacade;
    @EJB
    private transient PeriodoEscolarFacade periodoEscolarFacade;
    //-----------------------------------------------------------------
    private String institucion$nombre;
    private String institucion$codigo;
    private String institucion$distrito;
    private String institucion$departamento;
    private String institucion$municipio;
    private String institucion$direccion;
    private String institucion$telefono;

    //-----------------------------------------------------------------
    public String getInstitucion$nombre() {
        return institucion$nombre;
    }

    public void setInstitucion$nombre(String institucion$nombre) {
        this.institucion$nombre = institucion$nombre;
    }

    public String getInstitucion$codigo() {
        return institucion$codigo;
    }

    public void setInstitucion$codigo(String institucion$codigo) {
        this.institucion$codigo = institucion$codigo;
    }

    public String getInstitucion$distrito() {
        return institucion$distrito;
    }

    public void setInstitucion$distrito(String institucion$distrito) {
        this.institucion$distrito = institucion$distrito;
    }

    public String getInstitucion$departamento() {
        return institucion$departamento;
    }

    public void setInstitucion$departamento(String institucion$departamento) {
        this.institucion$departamento = institucion$departamento;
    }

    public String getInstitucion$municipio() {
        return institucion$municipio;
    }

    public void setInstitucion$municipio(String institucion$municipio) {
        this.institucion$municipio = institucion$municipio;
    }

    public String getInstitucion$direccion() {
        return institucion$direccion;
    }

    public void setInstitucion$direccion(String institucion$direccion) {
        this.institucion$direccion = institucion$direccion;
    }

    public String getInstitucion$telefono() {
        return institucion$telefono;
    }

    public void setInstitucion$telefono(String institucion$telefono) {
        this.institucion$telefono = institucion$telefono;
    }

//-------------------------------------------------------------------
    @PostConstruct
    @Override
    public void _init() {
        super._init();

        Compania compania = companiaFacade.find(1);

        institucion$nombre = compania.getNombre();
        institucion$codigo = compania.getCodigo();
        institucion$direccion = compania.getDireccion();
        institucion$distrito = compania.getDistrito();
        institucion$departamento = compania.getDepartamento();
        institucion$municipio = compania.getMunicipio();
        institucion$telefono = compania.getTelefono();

    }

    public String guardarDatosInstitucion$action() {

        Compania compania = companiaFacade.find(1);

        compania.setCodigo(institucion$codigo);
        compania.setNombre(institucion$nombre);
        compania.setDistrito(institucion$distrito);
        compania.setDireccion(institucion$direccion);
        compania.setDepartamento(institucion$departamento);
        compania.setMunicipio(institucion$municipio);
        compania.setTelefono(institucion$telefono);
        companiaFacade.edit(compania);

        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Datos de la Institucion Guardados con Exito");

        institucion$nombre = compania.getNombre();
        institucion$codigo = compania.getCodigo();
        institucion$direccion = compania.getDireccion();
        institucion$distrito = compania.getDistrito();
        institucion$departamento = compania.getDepartamento();
        institucion$municipio = compania.getMunicipio();
        institucion$telefono = compania.getTelefono();
        
        return null;
    }
}
