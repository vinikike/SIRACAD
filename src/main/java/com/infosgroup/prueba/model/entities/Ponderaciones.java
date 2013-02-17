/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "ponderaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ponderaciones.findAll", query = "SELECT p FROM Ponderaciones p"),
    @NamedQuery(name = "Ponderaciones.findByIdPeriodoEscolar", query = "SELECT p FROM Ponderaciones p WHERE p.ponderacionesPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Ponderaciones.findByIdNivel", query = "SELECT p FROM Ponderaciones p WHERE p.ponderacionesPK.idNivel = :idNivel"),
    @NamedQuery(name = "Ponderaciones.findByIdPeriodo", query = "SELECT p FROM Ponderaciones p WHERE p.ponderacionesPK.idPeriodo = :idPeriodo"),
    @NamedQuery(name = "Ponderaciones.findByIdPonderacion", query = "SELECT p FROM Ponderaciones p WHERE p.ponderacionesPK.idPonderacion = :idPonderacion"),
    @NamedQuery(name = "Ponderaciones.findByPorcentaje", query = "SELECT p FROM Ponderaciones p WHERE p.porcentaje = :porcentaje")})
public class Ponderaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PonderacionesPK ponderacionesPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "porcentaje")
    private Double porcentaje;
    @JoinColumns({
        @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id_periodo_escolar", insertable = false, updatable = false),
        @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel", insertable = false, updatable = false),
        @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Periodo periodo;

    public Ponderaciones() {
    }

    public Ponderaciones(PonderacionesPK ponderacionesPK) {
        this.ponderacionesPK = ponderacionesPK;
    }

    public Ponderaciones(int idPeriodoEscolar, int idNivel, int idPeriodo, int idPonderacion) {
        this.ponderacionesPK = new PonderacionesPK(idPeriodoEscolar, idNivel, idPeriodo, idPonderacion);
    }

    public PonderacionesPK getPonderacionesPK() {
        return ponderacionesPK;
    }

    public void setPonderacionesPK(PonderacionesPK ponderacionesPK) {
        this.ponderacionesPK = ponderacionesPK;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ponderacionesPK != null ? ponderacionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ponderaciones)) {
            return false;
        }
        Ponderaciones other = (Ponderaciones) object;
        if ((this.ponderacionesPK == null && other.ponderacionesPK != null) || (this.ponderacionesPK != null && !this.ponderacionesPK.equals(other.ponderacionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Ponderaciones[ ponderacionesPK=" + ponderacionesPK + " ]";
    }
    
}
