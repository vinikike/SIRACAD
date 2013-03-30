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
    @NamedQuery(name = "Estadistica.findByMatriculainicialMasculino", query = "SELECT e FROM Estadistica e WHERE e.matriculainicialMasculino = :matriculainicialMasculino"),
    @NamedQuery(name = "Estadistica.findByMatriculainicialFemenino", query = "SELECT e FROM Estadistica e WHERE e.matriculainicialFemenino = :matriculainicialFemenino"),
    @NamedQuery(name = "Estadistica.findByIngresosMasculino", query = "SELECT e FROM Estadistica e WHERE e.ingresosMasculino = :ingresosMasculino"),
    @NamedQuery(name = "Estadistica.findByIngresosFemenino", query = "SELECT e FROM Estadistica e WHERE e.ingresosFemenino = :ingresosFemenino"),
    @NamedQuery(name = "Estadistica.findByEgresosMasculino", query = "SELECT e FROM Estadistica e WHERE e.egresosMasculino = :egresosMasculino"),
    @NamedQuery(name = "Estadistica.findByEgresosFemenino", query = "SELECT e FROM Estadistica e WHERE e.egresosFemenino = :egresosFemenino"),
    @NamedQuery(name = "Estadistica.findByMatriculaefectivaMasculino", query = "SELECT e FROM Estadistica e WHERE e.matriculaefectivaMasculino = :matriculaefectivaMasculino"),
    @NamedQuery(name = "Estadistica.findByMatriculaefectivaFemenino", query = "SELECT e FROM Estadistica e WHERE e.matriculaefectivaFemenino = :matriculaefectivaFemenino"),
    @NamedQuery(name = "Estadistica.findByAsistenciamediaMasculino", query = "SELECT e FROM Estadistica e WHERE e.asistenciamediaMasculino = :asistenciamediaMasculino"),
    @NamedQuery(name = "Estadistica.findByAsistenciamediaFemenino", query = "SELECT e FROM Estadistica e WHERE e.asistenciamediaFemenino = :asistenciamediaFemenino"),
    @NamedQuery(name = "Estadistica.findByInasistenciamediaMasculino", query = "SELECT e FROM Estadistica e WHERE e.inasistenciamediaMasculino = :inasistenciamediaMasculino"),
    @NamedQuery(name = "Estadistica.findByInasistenciamediaFemenino", query = "SELECT e FROM Estadistica e WHERE e.inasistenciamediaFemenino = :inasistenciamediaFemenino"),
    @NamedQuery(name = "Estadistica.findBySobreedadMasculino", query = "SELECT e FROM Estadistica e WHERE e.sobreedadMasculino = :sobreedadMasculino"),
    @NamedQuery(name = "Estadistica.findBySobreedadFemenino", query = "SELECT e FROM Estadistica e WHERE e.sobreedadFemenino = :sobreedadFemenino"),
    @NamedQuery(name = "Estadistica.findByRepitenciaMasculino", query = "SELECT e FROM Estadistica e WHERE e.repitenciaMasculino = :repitenciaMasculino"),
    @NamedQuery(name = "Estadistica.findByRepitenciaFemenino", query = "SELECT e FROM Estadistica e WHERE e.repitenciaFemenino = :repitenciaFemenino"),
    @NamedQuery(name = "Estadistica.findByMes", query = "SELECT e FROM Estadistica e WHERE e.mes = :mes"),
    @NamedQuery(name = "Estadistica.findByDocenteDui", query = "SELECT e FROM Estadistica e WHERE e.docenteDui = :docenteDui")})
public class Estadistica implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadisticaPK estadisticaPK;
    @Column(name = "matriculainicial_masculino")
    private Integer matriculainicialMasculino;
    @Column(name = "matriculainicial_femenino")
    private Integer matriculainicialFemenino;
    @Column(name = "ingresos_masculino")
    private Integer ingresosMasculino;
    @Column(name = "ingresos_femenino")
    private Integer ingresosFemenino;
    @Column(name = "egresos_masculino")
    private Integer egresosMasculino;
    @Column(name = "egresos_femenino")
    private Integer egresosFemenino;
    @Column(name = "matriculaefectiva_masculino")
    private Integer matriculaefectivaMasculino;
    @Column(name = "matriculaefectiva_femenino")
    private Integer matriculaefectivaFemenino;
    @Column(name = "asistenciamedia_masculino")
    private Integer asistenciamediaMasculino;
    @Column(name = "asistenciamedia_femenino")
    private Integer asistenciamediaFemenino;
    @Column(name = "inasistenciamedia_masculino")
    private Integer inasistenciamediaMasculino;
    @Column(name = "inasistenciamedia_femenino")
    private Integer inasistenciamediaFemenino;
    @Column(name = "sobreedad_masculino")
    private Integer sobreedadMasculino;
    @Column(name = "sobreedad_femenino")
    private Integer sobreedadFemenino;
    @Column(name = "repitencia_masculino")
    private Integer repitenciaMasculino;
    @Column(name = "repitencia_femenino")
    private Integer repitenciaFemenino;
    @Size(max = 2147483647)
    @Column(name = "mes", length = 2147483647)
    private String mes;
    @Size(max = 2147483647)
    @Column(name = "docente_dui", length = 2147483647)
    private String docenteDui;

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

    public Integer getMatriculainicialMasculino() {
        return matriculainicialMasculino;
    }

    public void setMatriculainicialMasculino(Integer matriculainicialMasculino) {
        this.matriculainicialMasculino = matriculainicialMasculino;
    }

    public Integer getMatriculainicialFemenino() {
        return matriculainicialFemenino;
    }

    public void setMatriculainicialFemenino(Integer matriculainicialFemenino) {
        this.matriculainicialFemenino = matriculainicialFemenino;
    }

    public Integer getIngresosMasculino() {
        return ingresosMasculino;
    }

    public void setIngresosMasculino(Integer ingresosMasculino) {
        this.ingresosMasculino = ingresosMasculino;
    }

    public Integer getIngresosFemenino() {
        return ingresosFemenino;
    }

    public void setIngresosFemenino(Integer ingresosFemenino) {
        this.ingresosFemenino = ingresosFemenino;
    }

    public Integer getEgresosMasculino() {
        return egresosMasculino;
    }

    public void setEgresosMasculino(Integer egresosMasculino) {
        this.egresosMasculino = egresosMasculino;
    }

    public Integer getEgresosFemenino() {
        return egresosFemenino;
    }

    public void setEgresosFemenino(Integer egresosFemenino) {
        this.egresosFemenino = egresosFemenino;
    }

    public Integer getMatriculaefectivaMasculino() {
        return matriculaefectivaMasculino;
    }

    public void setMatriculaefectivaMasculino(Integer matriculaefectivaMasculino) {
        this.matriculaefectivaMasculino = matriculaefectivaMasculino;
    }

    public Integer getMatriculaefectivaFemenino() {
        return matriculaefectivaFemenino;
    }

    public void setMatriculaefectivaFemenino(Integer matriculaefectivaFemenino) {
        this.matriculaefectivaFemenino = matriculaefectivaFemenino;
    }

    public Integer getAsistenciamediaMasculino() {
        return asistenciamediaMasculino;
    }

    public void setAsistenciamediaMasculino(Integer asistenciamediaMasculino) {
        this.asistenciamediaMasculino = asistenciamediaMasculino;
    }

    public Integer getAsistenciamediaFemenino() {
        return asistenciamediaFemenino;
    }

    public void setAsistenciamediaFemenino(Integer asistenciamediaFemenino) {
        this.asistenciamediaFemenino = asistenciamediaFemenino;
    }

    public Integer getInasistenciamediaMasculino() {
        return inasistenciamediaMasculino;
    }

    public void setInasistenciamediaMasculino(Integer inasistenciamediaMasculino) {
        this.inasistenciamediaMasculino = inasistenciamediaMasculino;
    }

    public Integer getInasistenciamediaFemenino() {
        return inasistenciamediaFemenino;
    }

    public void setInasistenciamediaFemenino(Integer inasistenciamediaFemenino) {
        this.inasistenciamediaFemenino = inasistenciamediaFemenino;
    }

    public Integer getSobreedadMasculino() {
        return sobreedadMasculino;
    }

    public void setSobreedadMasculino(Integer sobreedadMasculino) {
        this.sobreedadMasculino = sobreedadMasculino;
    }

    public Integer getSobreedadFemenino() {
        return sobreedadFemenino;
    }

    public void setSobreedadFemenino(Integer sobreedadFemenino) {
        this.sobreedadFemenino = sobreedadFemenino;
    }

    public Integer getRepitenciaMasculino() {
        return repitenciaMasculino;
    }

    public void setRepitenciaMasculino(Integer repitenciaMasculino) {
        this.repitenciaMasculino = repitenciaMasculino;
    }

    public Integer getRepitenciaFemenino() {
        return repitenciaFemenino;
    }

    public void setRepitenciaFemenino(Integer repitenciaFemenino) {
        this.repitenciaFemenino = repitenciaFemenino;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDocenteDui() {
        return docenteDui;
    }

    public void setDocenteDui(String docenteDui) {
        this.docenteDui = docenteDui;
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
