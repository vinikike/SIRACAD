/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "estadistica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadistica.findAll", query = "SELECT e FROM Estadistica e"),
    @NamedQuery(name = "Estadistica.findByIdPeriodoEscolar", query = "SELECT e FROM Estadistica e WHERE e.estadisticaPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Estadistica.findByNivel", query = "SELECT e FROM Estadistica e WHERE e.estadisticaPK.nivel = :nivel"),
    @NamedQuery(name = "Estadistica.findByGrado", query = "SELECT e FROM Estadistica e WHERE e.estadisticaPK.grado = :grado"),
    @NamedQuery(name = "Estadistica.findByOpcion", query = "SELECT e FROM Estadistica e WHERE e.estadisticaPK.opcion = :opcion"),
    @NamedQuery(name = "Estadistica.findBySeccion", query = "SELECT e FROM Estadistica e WHERE e.estadisticaPK.seccion = :seccion"),
    @NamedQuery(name = "Estadistica.findByMatriculaInicialMasculino", query = "SELECT e FROM Estadistica e WHERE e.matriculaInicialMasculino = :matriculaInicialMasculino"),
    @NamedQuery(name = "Estadistica.findByMatriculaInicialFemenino", query = "SELECT e FROM Estadistica e WHERE e.matriculaInicialFemenino = :matriculaInicialFemenino"),
    @NamedQuery(name = "Estadistica.findByIngresosDelMesMasculino", query = "SELECT e FROM Estadistica e WHERE e.ingresosDelMesMasculino = :ingresosDelMesMasculino"),
    @NamedQuery(name = "Estadistica.findByIngresosDelMesFemenino", query = "SELECT e FROM Estadistica e WHERE e.ingresosDelMesFemenino = :ingresosDelMesFemenino"),
    @NamedQuery(name = "Estadistica.findByEgresosDelMesMasculino", query = "SELECT e FROM Estadistica e WHERE e.egresosDelMesMasculino = :egresosDelMesMasculino"),
    @NamedQuery(name = "Estadistica.findByEgresosDelMesFemenino", query = "SELECT e FROM Estadistica e WHERE e.egresosDelMesFemenino = :egresosDelMesFemenino"),
    @NamedQuery(name = "Estadistica.findByMatriculaEfectivaDelMesMasculino", query = "SELECT e FROM Estadistica e WHERE e.matriculaEfectivaDelMesMasculino = :matriculaEfectivaDelMesMasculino"),
    @NamedQuery(name = "Estadistica.findByMatriculaEfectivaDelMesFemenino", query = "SELECT e FROM Estadistica e WHERE e.matriculaEfectivaDelMesFemenino = :matriculaEfectivaDelMesFemenino"),
    @NamedQuery(name = "Estadistica.findByAsistenciaMediaMasculino", query = "SELECT e FROM Estadistica e WHERE e.asistenciaMediaMasculino = :asistenciaMediaMasculino"),
    @NamedQuery(name = "Estadistica.findByAsistenciaMediaFemenino", query = "SELECT e FROM Estadistica e WHERE e.asistenciaMediaFemenino = :asistenciaMediaFemenino"),
    @NamedQuery(name = "Estadistica.findByInasistenciaMediaMasculino", query = "SELECT e FROM Estadistica e WHERE e.inasistenciaMediaMasculino = :inasistenciaMediaMasculino"),
    @NamedQuery(name = "Estadistica.findByInasistenciaMediaFemenino", query = "SELECT e FROM Estadistica e WHERE e.inasistenciaMediaFemenino = :inasistenciaMediaFemenino"),
    @NamedQuery(name = "Estadistica.findBySobreEdadMasculino", query = "SELECT e FROM Estadistica e WHERE e.sobreEdadMasculino = :sobreEdadMasculino"),
    @NamedQuery(name = "Estadistica.findBySobreEdadFemenino", query = "SELECT e FROM Estadistica e WHERE e.sobreEdadFemenino = :sobreEdadFemenino"),
    @NamedQuery(name = "Estadistica.findByRepitenciaMasculino", query = "SELECT e FROM Estadistica e WHERE e.repitenciaMasculino = :repitenciaMasculino"),
    @NamedQuery(name = "Estadistica.findByRepitenciaFemenino", query = "SELECT e FROM Estadistica e WHERE e.repitenciaFemenino = :repitenciaFemenino"),
    @NamedQuery(name = "Estadistica.findByDocenteDui", query = "SELECT e FROM Estadistica e WHERE e.docenteDui = :docenteDui"),
    @NamedQuery(name = "Estadistica.findByMes", query = "SELECT e FROM Estadistica e WHERE e.mes = :mes")})
public class Estadistica implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadisticaPK estadisticaPK;
    @Size(max = 2147483647)
    @Column(name = "matricula_inicial_masculino", length = 2147483647)
    private String matriculaInicialMasculino;
    @Size(max = 2147483647)
    @Column(name = "matricula_inicial_femenino", length = 2147483647)
    private String matriculaInicialFemenino;
    @Size(max = 2147483647)
    @Column(name = "ingresos_del_mes_masculino", length = 2147483647)
    private String ingresosDelMesMasculino;
    @Size(max = 2147483647)
    @Column(name = "ingresos_del_mes_femenino", length = 2147483647)
    private String ingresosDelMesFemenino;
    @Size(max = 2147483647)
    @Column(name = "egresos_del_mes_masculino", length = 2147483647)
    private String egresosDelMesMasculino;
    @Size(max = 2147483647)
    @Column(name = "egresos_del_mes_femenino", length = 2147483647)
    private String egresosDelMesFemenino;
    @Size(max = 2147483647)
    @Column(name = "matricula_efectiva del_mes_masculino", length = 2147483647)
    private String matriculaEfectivaDelMesMasculino;
    @Size(max = 2147483647)
    @Column(name = "matricula_efectiva del_mes_femenino", length = 2147483647)
    private String matriculaEfectivaDelMesFemenino;
    @Size(max = 2147483647)
    @Column(name = "asistencia_media_masculino", length = 2147483647)
    private String asistenciaMediaMasculino;
    @Size(max = 2147483647)
    @Column(name = "asistencia_media_femenino", length = 2147483647)
    private String asistenciaMediaFemenino;
    @Size(max = 2147483647)
    @Column(name = "inasistencia_media_masculino", length = 2147483647)
    private String inasistenciaMediaMasculino;
    @Size(max = 2147483647)
    @Column(name = "inasistencia_media_femenino", length = 2147483647)
    private String inasistenciaMediaFemenino;
    @Size(max = 2147483647)
    @Column(name = "sobre_edad_masculino", length = 2147483647)
    private String sobreEdadMasculino;
    @Size(max = 2147483647)
    @Column(name = "sobre_edad_femenino", length = 2147483647)
    private String sobreEdadFemenino;
    @Size(max = 2147483647)
    @Column(name = "repitencia_masculino", length = 2147483647)
    private String repitenciaMasculino;
    @Size(max = 2147483647)
    @Column(name = "repitencia_femenino", length = 2147483647)
    private String repitenciaFemenino;
    @Size(max = 2147483647)
    @Column(name = "docente_dui", length = 2147483647)
    private String docenteDui;
    @Size(max = 2147483647)
    @Column(name = "mes", length = 2147483647)
    private String mes;

    public Estadistica() {
    }

    public Estadistica(EstadisticaPK estadisticaPK) {
        this.estadisticaPK = estadisticaPK;
    }

    public Estadistica(int idPeriodoEscolar, String nivel, String grado, String opcion, String seccion) {
        this.estadisticaPK = new EstadisticaPK(idPeriodoEscolar, nivel, grado, opcion, seccion);
    }

    public EstadisticaPK getEstadisticaPK() {
        return estadisticaPK;
    }

    public void setEstadisticaPK(EstadisticaPK estadisticaPK) {
        this.estadisticaPK = estadisticaPK;
    }

    public String getMatriculaInicialMasculino() {
        return matriculaInicialMasculino;
    }

    public void setMatriculaInicialMasculino(String matriculaInicialMasculino) {
        this.matriculaInicialMasculino = matriculaInicialMasculino;
    }

    public String getMatriculaInicialFemenino() {
        return matriculaInicialFemenino;
    }

    public void setMatriculaInicialFemenino(String matriculaInicialFemenino) {
        this.matriculaInicialFemenino = matriculaInicialFemenino;
    }

    public String getIngresosDelMesMasculino() {
        return ingresosDelMesMasculino;
    }

    public void setIngresosDelMesMasculino(String ingresosDelMesMasculino) {
        this.ingresosDelMesMasculino = ingresosDelMesMasculino;
    }

    public String getIngresosDelMesFemenino() {
        return ingresosDelMesFemenino;
    }

    public void setIngresosDelMesFemenino(String ingresosDelMesFemenino) {
        this.ingresosDelMesFemenino = ingresosDelMesFemenino;
    }

    public String getEgresosDelMesMasculino() {
        return egresosDelMesMasculino;
    }

    public void setEgresosDelMesMasculino(String egresosDelMesMasculino) {
        this.egresosDelMesMasculino = egresosDelMesMasculino;
    }

    public String getEgresosDelMesFemenino() {
        return egresosDelMesFemenino;
    }

    public void setEgresosDelMesFemenino(String egresosDelMesFemenino) {
        this.egresosDelMesFemenino = egresosDelMesFemenino;
    }

    public String getMatriculaEfectivaDelMesMasculino() {
        return matriculaEfectivaDelMesMasculino;
    }

    public void setMatriculaEfectivaDelMesMasculino(String matriculaEfectivaDelMesMasculino) {
        this.matriculaEfectivaDelMesMasculino = matriculaEfectivaDelMesMasculino;
    }

    public String getMatriculaEfectivaDelMesFemenino() {
        return matriculaEfectivaDelMesFemenino;
    }

    public void setMatriculaEfectivaDelMesFemenino(String matriculaEfectivaDelMesFemenino) {
        this.matriculaEfectivaDelMesFemenino = matriculaEfectivaDelMesFemenino;
    }

    public String getAsistenciaMediaMasculino() {
        return asistenciaMediaMasculino;
    }

    public void setAsistenciaMediaMasculino(String asistenciaMediaMasculino) {
        this.asistenciaMediaMasculino = asistenciaMediaMasculino;
    }

    public String getAsistenciaMediaFemenino() {
        return asistenciaMediaFemenino;
    }

    public void setAsistenciaMediaFemenino(String asistenciaMediaFemenino) {
        this.asistenciaMediaFemenino = asistenciaMediaFemenino;
    }

    public String getInasistenciaMediaMasculino() {
        return inasistenciaMediaMasculino;
    }

    public void setInasistenciaMediaMasculino(String inasistenciaMediaMasculino) {
        this.inasistenciaMediaMasculino = inasistenciaMediaMasculino;
    }

    public String getInasistenciaMediaFemenino() {
        return inasistenciaMediaFemenino;
    }

    public void setInasistenciaMediaFemenino(String inasistenciaMediaFemenino) {
        this.inasistenciaMediaFemenino = inasistenciaMediaFemenino;
    }

    public String getSobreEdadMasculino() {
        return sobreEdadMasculino;
    }

    public void setSobreEdadMasculino(String sobreEdadMasculino) {
        this.sobreEdadMasculino = sobreEdadMasculino;
    }

    public String getSobreEdadFemenino() {
        return sobreEdadFemenino;
    }

    public void setSobreEdadFemenino(String sobreEdadFemenino) {
        this.sobreEdadFemenino = sobreEdadFemenino;
    }

    public String getRepitenciaMasculino() {
        return repitenciaMasculino;
    }

    public void setRepitenciaMasculino(String repitenciaMasculino) {
        this.repitenciaMasculino = repitenciaMasculino;
    }

    public String getRepitenciaFemenino() {
        return repitenciaFemenino;
    }

    public void setRepitenciaFemenino(String repitenciaFemenino) {
        this.repitenciaFemenino = repitenciaFemenino;
    }

    public String getDocenteDui() {
        return docenteDui;
    }

    public void setDocenteDui(String docenteDui) {
        this.docenteDui = docenteDui;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estadisticaPK != null ? estadisticaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadistica)) {
            return false;
        }
        Estadistica other = (Estadistica) object;
        if ((this.estadisticaPK == null && other.estadisticaPK != null) || (this.estadisticaPK != null && !this.estadisticaPK.equals(other.estadisticaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Estadistica[ estadisticaPK=" + estadisticaPK + " ]";
    }
    
}
