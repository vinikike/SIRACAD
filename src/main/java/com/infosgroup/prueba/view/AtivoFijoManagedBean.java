/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Catalogoactivo;
import com.infosgroup.prueba.model.facades.CaltalogoActivosFacade;
import com.infosgroup.prueba.model.entities.Activofijo;
import com.infosgroup.prueba.model.entities.ActivofijoPK;
import com.infosgroup.prueba.model.facades.ActivoFijoFacade;
import com.infosgroup.prueba.view.beans.SessionBean;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "ativoFijoManagedBean")
@ViewScoped
public class AtivoFijoManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient CaltalogoActivosFacade caltalogoActivosFacade;
    @EJB
    private transient ActivoFijoFacade activoFijoFacade;
    //========================================================================
    @Inject
    private SessionBean sessionBean;
    //========================================================================
    private String activo$codCatalogo;
    private String activo$codigoActivo;
    private String activo$tipoCargo;
    private String activo$actCaracteristicas;
    private Integer activo$cantidad;
    private Date activo$fechaAdquisicion;
    private String activo$estadoFisico;
    private String activo$clave;
    private Double activo$preciounitario;
    private Double activo$precioTotal;
    private Integer activo$inicio;
    private Integer activo$fin;
    //========================================================================
    private List<Catalogoactivo> listaCatalogoActivos;

    //=======================================================================
    public SessionBean getSessionBean() {
        return sessionBean;
    }

    public void setSessionBean(SessionBean sessionBean) {
        this.sessionBean = sessionBean;
    }

    public String getActivo$codCatalogo() {
        return activo$codCatalogo;
    }

    public void setActivo$codCatalogo(String activo$codCatalogo) {
        this.activo$codCatalogo = activo$codCatalogo;
    }

    public String getActivo$clave() {
        return activo$clave;
    }

    public void setActivo$clave(String activo$clave) {
        this.activo$clave = activo$clave;
    }

    public String getActivo$codigoActivo() {
        return activo$codigoActivo;
    }

    public void setActivo$codigoActivo(String activo$codigoActivo) {
        this.activo$codigoActivo = activo$codigoActivo;
    }

    public String getActivo$tipoCargo() {
        return activo$tipoCargo;
    }

    public void setActivo$tipoCargo(String activo$tipoCargo) {
        this.activo$tipoCargo = activo$tipoCargo;
    }

    public String getActivo$actCaracteristicas() {
        return activo$actCaracteristicas;
    }

    public void setActivo$actCaracteristicas(String activo$actCaracteristicas) {
        this.activo$actCaracteristicas = activo$actCaracteristicas;
    }

    public Date getActivo$fechaAdquisicion() {
        return activo$fechaAdquisicion;
    }

    public Integer getActivo$cantidad() {
        return activo$cantidad;
    }

    public void setActivo$cantidad(Integer activo$cantidad) {
        this.activo$cantidad = activo$cantidad;
    }

    public void setActivo$fechaAdquisicion(Date activo$fechaAdquisicion) {
        this.activo$fechaAdquisicion = activo$fechaAdquisicion;
    }

    public String getActivo$estadoFisico() {
        return activo$estadoFisico;
    }

    public void setActivo$estadoFisico(String activo$estadoFisico) {
        this.activo$estadoFisico = activo$estadoFisico;
    }

    public Double getActivo$preciounitario() {
        return activo$preciounitario;
    }

    public void setActivo$preciounitario(Double activo$preciounitario) {
        this.activo$preciounitario = activo$preciounitario;
    }

    public List<Catalogoactivo> getListaCatalogoActivos() {
        return listaCatalogoActivos;
    }

    public void setListaCatalogoActivos(List<Catalogoactivo> listaCatalogoActivos) {
        this.listaCatalogoActivos = listaCatalogoActivos;
    }

    public Double getActivo$precioTotal() {
        return activo$precioTotal;
    }

    public void setActivo$precioTotal(Double activo$precioTotal) {
        this.activo$precioTotal = activo$precioTotal;
    }

    public Integer getActivo$inicio() {
        return activo$inicio;
    }

    public void setActivo$inicio(Integer activo$inicio) {
        this.activo$inicio = activo$inicio;
    }

    public Integer getActivo$fin() {
        return activo$fin;
    }

    public void setActivo$fin(Integer activo$fin) {
        this.activo$fin = activo$fin;
    }

    //------------------------------------------------------------------------
    @PostConstruct
    @Override
    public void _init() {
        super._init();
        activo$tipoCargo = "1-1";
        activo$estadoFisico = "Bueno";
        activo$fechaAdquisicion = Calendar.getInstance().getTime();
        activo$preciounitario = 0.0;
        activo$cantidad = 1;
        activo$clave = "R";
        activo$precioTotal = activo$preciounitario * activo$cantidad;
        listaCatalogoActivos = caltalogoActivosFacade.findAll();
    }

    public String guardarActivo$action() {

//        Activofijo activoBuscar = activoFijoFacade.find(new ActivofijoPK(activo$codigoActivo, sessionBean.getPeriodoEscolar(), activo$codCatalogo, activo$clave) );
//        if (activoBuscar != null) {
//            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Ya existe registro del alumno en el periodo escolar");
//            return null;
//        }

        ActivofijoPK activofijoPK = new ActivofijoPK();
        activofijoPK.setCodigocatalogo(activo$codCatalogo);
        activofijoPK.setCodigocorrelativo(activo$codigoActivo);
        activofijoPK.setCodigoinstitucion(sessionBean.getCompania().getCodigo());
        activofijoPK.setIdperiodoescolar(sessionBean.getPeriodoEscolar().getId());

        Activofijo activofijo = new Activofijo();
        activofijo.setActivofijoPK(activofijoPK);
        activofijo.setCantidad(activo$cantidad);
        activofijo.setCaracteristicas(activo$actCaracteristicas);
        activofijo.setClave(activo$clave);
        activofijo.setEstadofisico(activo$estadoFisico);
        activofijo.setFechaaquision(activo$fechaAdquisicion);
        activofijo.setTipocargo(activo$tipoCargo);
        activofijo.setValorunitario(activo$preciounitario);
        activoFijoFacade.create(activofijo);

        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Registro realizado con exito");
        return null;
    }
    
//        public void categoria$valueChangeListener(ValueChangeEvent evt) {
//        Catalogoactivo c = (Catalogoactivo) evt.getNewValue();
//        activo$inicio = ((c == null) ? 0 : activoFijoFacade.cantidadLibros(sessionBean.getPeriodoEscolar(), sessionBean.getCompania(), c)) + 1;
//    }
}
