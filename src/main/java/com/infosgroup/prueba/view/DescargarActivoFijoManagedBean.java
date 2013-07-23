/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Catalogoactivo;
import com.infosgroup.prueba.model.facades.CaltalogoActivosFacade;
import com.infosgroup.prueba.model.entities.Activofijo;
import com.infosgroup.prueba.model.entities.ActivofijoPK;
import com.infosgroup.prueba.model.entities.Descargoactivo;
import com.infosgroup.prueba.model.entities.DescargoactivoPK;
import com.infosgroup.prueba.model.facades.DescargarActivoFijoFacade;
import com.infosgroup.prueba.view.beans.SessionBean;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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
@ManagedBean(name = "descargarAtivoFijoManagedBean")
@ViewScoped
public class DescargarActivoFijoManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient CaltalogoActivosFacade caltalogoActivosFacade;
    @EJB
    private transient DescargarActivoFijoFacade descargarActivoFijoFacade;
    //========================================================================
    @Inject
    private SessionBean sessionBean;
    //========================================================================
    private Catalogoactivo activo$codCatalogo;
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

    public Catalogoactivo getActivo$codCatalogo() {
        return activo$codCatalogo;
    }

    public void setActivo$codCatalogo(Catalogoactivo activo$codCatalogo) {
        this.activo$codCatalogo = activo$codCatalogo;
    }

    public String getActivo$clave() {
        return activo$clave;
    }

    public void setActivo$clave(String activo$clave) {
        this.activo$clave = activo$clave;
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

    public String getActivo$codigoActivo() {
        return activo$codigoActivo;
    }

    public void setActivo$codigoActivo(String activo$codigoActivo) {
        this.activo$codigoActivo = activo$codigoActivo;
    }

    //------------------------------------------------------------------------
    @PostConstruct
    @Override
    public void _init() {
        super._init();
        activo$tipoCargo = "2-1";
        activo$codigoActivo = "";
        //activo$estadoFisico = "Bueno";
        activo$fechaAdquisicion = Calendar.getInstance().getTime();
        activo$preciounitario = 0.0;
        activo$cantidad = 1;
        //activo$clave = "R";
        activo$precioTotal = activo$preciounitario * activo$cantidad;
        listaCatalogoActivos = descargarActivoFijoFacade.listaActivos();
        //activo$inicio = 0;
    }

    public String guardarActivo$action() {

        Descargoactivo descargoActivoBuscar = descargarActivoFijoFacade.find(new DescargoactivoPK(sessionBean.getCompania().getCodigo(), sessionBean.getPeriodoEscolar().getId(), activo$codCatalogo.getCatalogoactivoPK().getCodigoactivo(), activo$codigoActivo));
        if (descargoActivoBuscar != null) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Ya existe el descargo de esta activo");
            return null;
        }

//        activo$inicio = ((activo$codCatalogo == null) ? 0 : activoFijoFacade.cantidadActivos(sessionBean.getPeriodoEscolar(), sessionBean.getCompania(), activo$codCatalogo)) + 1;
//        activo$fin = ((activo$inicio == null) ? 0 : activo$inicio + activo$cantidad) - 1;

//        activo$codigoActivo = new StringBuilder().append(activo$inicio).append("/").append(activo$fin).toString();

        DescargoactivoPK descargoactivoPK = new DescargoactivoPK();
        descargoactivoPK.setCodigocatalogo(activo$codCatalogo.getCatalogoactivoPK().getCodigoactivo());
        descargoactivoPK.setCodigocorrelativo(activo$codigoActivo);
        descargoactivoPK.setCodigoinstitucion(sessionBean.getCompania().getCodigo());
        descargoactivoPK.setIdperiodoescolar(sessionBean.getPeriodoEscolar().getId());

        Descargoactivo descargoactivo = new Descargoactivo();
        descargoactivo.setDescargoactivoPK(descargoactivoPK);
        descargoactivo.setCantidad(activo$cantidad);
        descargoactivo.setCaracteristicas(activo$actCaracteristicas);
//        descargoactivo.setClave(activo$clave);
//        descargoactivo.setEstadofisico(activo$estadoFisico);
        descargoactivo.setFechaaquision(activo$fechaAdquisicion);
        descargoactivo.setTipocargo(activo$tipoCargo);
        descargoactivo.setValorunitario(activo$preciounitario);
        descargoactivo.setValortotal(activo$preciounitario * activo$cantidad);
//        descargoactivo.setInicio(activo$inicio);
//        descargoactivo.setFin(activo$fin);
        //activofijo.getCatalogoactivo().get
//        activoFijoFacade.create(activofijo);
        descargarActivoFijoFacade.create(descargoactivo);

        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Registro realizado con exito");

        activo$tipoCargo = "2-1";
        activo$codigoActivo = "";
        activo$actCaracteristicas = "";

        activo$fechaAdquisicion = Calendar.getInstance().getTime();
        activo$preciounitario = 0.0;
        activo$cantidad = 1;
        activo$codCatalogo = null;
        activo$precioTotal = activo$preciounitario * activo$cantidad;

        return null;
    }
}
