/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Grado;
import com.infosgroup.prueba.model.entities.GradoPK;
import com.infosgroup.prueba.model.entities.Estadistica;
import com.infosgroup.prueba.model.entities.EstadisticaPK;
import com.infosgroup.prueba.model.facades.EstadisticaFacade;
import com.infosgroup.prueba.view.beans.SessionBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "ingresarEstadistica")
@ViewScoped
public class IngresarEstadisticaManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient EstadisticaFacade estadisticaFacade;
    //-----------------------------------------------------------------
    //@ManagedProperty(value = "#{SessionBean}")
    @Inject
    private SessionBean sessionBean;

//    public SessionBean getSessionBean() {
//        return sessionBean;
//    }
//
//    public void setSessionBean(SessionBean sessionBean) {
//        this.sessionBean = sessionBean;
//    }
    //-----------------------------------------------------------------
    private Integer grado$periodo_Escolar;
    private String grado$nivel;
    private String grado$grado;
    private String grado$opcion;
    private String grado$seccion;
    //-----------------------------------------------------
    private Integer estadistica$mariculaInicial_Masculino;
    private Integer estadistica$mariculaInicial_Femenino;
    private Integer estadistica$ingresosDelMes_Masculino;
    private Integer estadistica$ingresosDelMes_Femenino;
    private Integer estadistica$egresosDelMes_Masculino;
    private Integer estadistica$egresosDelMes_Femenino;
    private Integer estadistica$matriculEfectivaDelMes_Masculino;
    private Integer estadistica$matriculEfectivaDelMes_Femenino;
    private Integer estadistica$asistenciaMedia_Masculino;
    private Integer estadistica$asistenciaMedia_Femenino;
    private Integer estadistica$inasistenciaMedia_Masculino;
    private Integer estadistica$inasistenciaMedia_Femenino;
    private Integer estadistica$sobreEdad_Masculino;
    private Integer estadistica$sobreEdad_Femenino;
    private Integer estadistica$repitencia_Masculino;
    private Integer estadistica$repitencia_Femenino;
    private String estadistica$mes;
    private String docente$DUI;
    private String docente$nombre;

    //=================Gets y Sets=================================
    public Integer getGrado$periodo_Escolar() {
        return grado$periodo_Escolar;
    }

    public void setGrado$periodo_Escolar(Integer grado$periodo_Escolar) {
        this.grado$periodo_Escolar = grado$periodo_Escolar;
    }

    public String getGrado$nivel() {
        return grado$nivel;
    }

    public void setGrado$nivel(String grado$nivel) {
        this.grado$nivel = grado$nivel;
    }

    public String getGrado$grado() {
        return grado$grado;
    }

    public void setGrado$grado(String grado$grado) {
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

    public Integer getEstadistica$mariculaInicial_Masculino() {
        return estadistica$mariculaInicial_Masculino;
    }

    public void setEstadistica$mariculaInicial_Masculino(Integer estadistica$mariculaInicial_Masculino) {
        this.estadistica$mariculaInicial_Masculino = estadistica$mariculaInicial_Masculino;
    }

    public Integer getEstadistica$mariculaInicial_Femenino() {
        return estadistica$mariculaInicial_Femenino;
    }

    public void setEstadistica$mariculaInicial_Femenino(Integer estadistica$mariculaInicial_Femenino) {
        this.estadistica$mariculaInicial_Femenino = estadistica$mariculaInicial_Femenino;
    }

    public Integer getEstadistica$ingresosDelMes_Masculino() {
        return estadistica$ingresosDelMes_Masculino;
    }

    public void setEstadistica$ingresosDelMes_Masculino(Integer estadistica$ingresosDelMes_Masculino) {
        this.estadistica$ingresosDelMes_Masculino = estadistica$ingresosDelMes_Masculino;
    }

    public Integer getEstadistica$ingresosDelMes_Femenino() {
        return estadistica$ingresosDelMes_Femenino;
    }

    public void setEstadistica$ingresosDelMes_Femenino(Integer estadistica$ingresosDelMes_Femenino) {
        this.estadistica$ingresosDelMes_Femenino = estadistica$ingresosDelMes_Femenino;
    }

    public Integer getEstadistica$egresosDelMes_Masculino() {
        return estadistica$egresosDelMes_Masculino;
    }

    public void setEstadistica$egresosDelMes_Masculino(Integer estadistica$egresosDelMes_Masculino) {
        this.estadistica$egresosDelMes_Masculino = estadistica$egresosDelMes_Masculino;
    }

    public Integer getEstadistica$egresosDelMes_Femenino() {
        return estadistica$egresosDelMes_Femenino;
    }

    public void setEstadistica$egresosDelMes_Femenino(Integer estadistica$egresosDelMes_Femenino) {
        this.estadistica$egresosDelMes_Femenino = estadistica$egresosDelMes_Femenino;
    }

    public Integer getEstadistica$matriculEfectivaDelMes_Masculino() {
        return estadistica$matriculEfectivaDelMes_Masculino;
    }

    public void setEstadistica$matriculEfectivaDelMes_Masculino(Integer estadistica$matriculEfectivaDelMes_Masculino) {
        this.estadistica$matriculEfectivaDelMes_Masculino = estadistica$matriculEfectivaDelMes_Masculino;
    }

    public Integer getEstadistica$matriculEfectivaDelMes_Femenino() {
        return estadistica$matriculEfectivaDelMes_Femenino;
    }

    public void setEstadistica$matriculEfectivaDelMes_Femenino(Integer estadistica$matriculEfectivaDelMes_Femenino) {
        this.estadistica$matriculEfectivaDelMes_Femenino = estadistica$matriculEfectivaDelMes_Femenino;
    }

    public Integer getEstadistica$asistenciaMedia_Masculino() {
        return estadistica$asistenciaMedia_Masculino;
    }

    public void setEstadistica$asistenciaMedia_Masculino(Integer estadistica$asistenciaMedia_Masculino) {
        this.estadistica$asistenciaMedia_Masculino = estadistica$asistenciaMedia_Masculino;
    }

    public Integer getEstadistica$asistenciaMedia_Femenino() {
        return estadistica$asistenciaMedia_Femenino;
    }

    public void setEstadistica$asistenciaMedia_Femenino(Integer estadistica$asistenciaMedia_Femenino) {
        this.estadistica$asistenciaMedia_Femenino = estadistica$asistenciaMedia_Femenino;
    }

    public Integer getEstadistica$inasistenciaMedia_Masculino() {
        return estadistica$inasistenciaMedia_Masculino;
    }

    public void setEstadistica$inasistenciaMedia_Masculino(Integer estadistica$inasistenciaMedia_Masculino) {
        this.estadistica$inasistenciaMedia_Masculino = estadistica$inasistenciaMedia_Masculino;
    }

    public Integer getEstadistica$inasistenciaMedia_Femenino() {
        return estadistica$inasistenciaMedia_Femenino;
    }

    public void setEstadistica$inasistenciaMedia_Femenino(Integer estadistica$inasistenciaMedia_Femenino) {
        this.estadistica$inasistenciaMedia_Femenino = estadistica$inasistenciaMedia_Femenino;
    }

    public Integer getEstadistica$sobreEdad_Masculino() {
        return estadistica$sobreEdad_Masculino;
    }

    public void setEstadistica$sobreEdad_Masculino(Integer estadistica$sobreEdad_Masculino) {
        this.estadistica$sobreEdad_Masculino = estadistica$sobreEdad_Masculino;
    }

    public Integer getEstadistica$sobreEdad_Femenino() {
        return estadistica$sobreEdad_Femenino;
    }

    public void setEstadistica$sobreEdad_Femenino(Integer estadistica$sobreEdad_Femenino) {
        this.estadistica$sobreEdad_Femenino = estadistica$sobreEdad_Femenino;
    }

    public Integer getEstadistica$repitencia_Masculino() {
        return estadistica$repitencia_Masculino;
    }

    public void setEstadistica$repitencia_Masculino(Integer estadistica$repitencia_Masculino) {
        this.estadistica$repitencia_Masculino = estadistica$repitencia_Masculino;
    }

    public Integer getEstadistica$repitencia_Femenino() {
        return estadistica$repitencia_Femenino;
    }

    public void setEstadistica$repitencia_Femenino(Integer estadistica$repitencia_Femenino) {
        this.estadistica$repitencia_Femenino = estadistica$repitencia_Femenino;
    }

    public String getEstadistica$mes() {
        return estadistica$mes;
    }

    public void setEstadistica$mes(String estadistica$mes) {
        this.estadistica$mes = estadistica$mes;
    }

    public String getDocente$DUI() {
        return docente$DUI;
    }

    public void setDocente$DUI(String docente$DUI) {
        this.docente$DUI = docente$DUI;
    }

    public String getDocente$nombre() {
        return docente$nombre;
    }

    public void setDocente$nombre(String docente$nombre) {
        this.docente$nombre = docente$nombre;
    }

    //===============================================================
    @PostConstruct
    @Override
    public void _init() {
        super._init();

        estadistica$mes = "0";
        //grado$periodo_Escolar = sessionBean.getPeriodoEscolar();
        docente$DUI = sessionBean.getUsuario().getId();
        docente$nombre = sessionBean.getUsuario().getDocente().getNombre();

        estadistica$mariculaInicial_Masculino = 0;
        estadistica$mariculaInicial_Femenino = 0;

        estadistica$ingresosDelMes_Masculino = 0;
        estadistica$ingresosDelMes_Femenino = 0;

        estadistica$egresosDelMes_Masculino = 0;
        estadistica$egresosDelMes_Femenino = 0;

        estadistica$matriculEfectivaDelMes_Masculino = 0;
        estadistica$matriculEfectivaDelMes_Femenino = 0;

        estadistica$asistenciaMedia_Masculino = 0;
        estadistica$asistenciaMedia_Femenino = 0;

        estadistica$inasistenciaMedia_Masculino = 0;
        estadistica$inasistenciaMedia_Femenino = 0;

        estadistica$sobreEdad_Masculino = 0;
        estadistica$sobreEdad_Femenino = 0;

        estadistica$repitencia_Masculino = 0;
        estadistica$repitencia_Femenino = 0;

    }

    public String guardarEstadistica$action() {
//revisarrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
        Estadistica estadisticaBuscar = new Estadistica(2013, grado$nivel, grado$nivel, grado$opcion, grado$seccion);
        if (estadisticaBuscar != null) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Ya existe registro estadistico de este mes");
            return null;
        }

        EstadisticaPK estadisticaPK = new EstadisticaPK();
        estadisticaPK.setIdPeriodoEscolar(2013);
        estadisticaPK.setNivel(grado$nivel);
        estadisticaPK.setGrado(grado$grado);
        estadisticaPK.setOpcion(grado$opcion);
        estadisticaPK.setSeccion(grado$seccion);

        Estadistica estadistica = new Estadistica();
        estadistica.setEstadisticaPK(estadisticaPK);

        estadistica.setMatriculainicialMasculino(estadistica$mariculaInicial_Masculino);
        estadistica.setMatriculainicialFemenino(estadistica$mariculaInicial_Femenino);

        estadistica.setIngresosMasculino(estadistica$ingresosDelMes_Masculino);
        estadistica.setIngresosFemenino(estadistica$ingresosDelMes_Femenino);

        estadistica.setEgresosMasculino(estadistica$egresosDelMes_Masculino);
        estadistica.setEgresosFemenino(estadistica$egresosDelMes_Femenino);

        estadistica.setMatriculaefectivaMasculino(estadistica$matriculEfectivaDelMes_Masculino);
        estadistica.setMatriculaefectivaFemenino(estadistica$matriculEfectivaDelMes_Femenino);

        estadistica.setAsistenciamediaMasculino(estadistica$asistenciaMedia_Masculino);
        estadistica.setAsistenciamediaFemenino(estadistica$asistenciaMedia_Femenino);

        estadistica.setInasistenciamediaMasculino(estadistica$inasistenciaMedia_Masculino);
        estadistica.setInasistenciamediaFemenino(estadistica$inasistenciaMedia_Femenino);

        estadistica.setSobreedadMasculino(estadistica$sobreEdad_Masculino);
        estadistica.setSobreedadFemenino(estadistica$sobreEdad_Femenino);

        estadistica.setRepitenciaMasculino(estadistica$repitencia_Masculino);
        estadistica.setRepitenciaFemenino(estadistica$repitencia_Femenino);

        //estadistica.setDocenteDui(docente$DUI);

        //estadistica.setMes(estadistica$mes);


        estadisticaFacade.create(estadistica);

        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Estadistica registrada con exito");

        return null;
    }
}
