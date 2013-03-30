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
import javax.persistence.ManyToOne;
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
@Table(name = "talleres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Talleres.findAll", query = "SELECT t FROM Talleres t"),
    @NamedQuery(name = "Talleres.findByIdPeriodoEscolar", query = "SELECT t FROM Talleres t WHERE t.talleresPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Talleres.findByNombre", query = "SELECT t FROM Talleres t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "Talleres.findByDescripcion", query = "SELECT t FROM Talleres t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "Talleres.findByResponsable", query = "SELECT t FROM Talleres t WHERE t.responsable = :responsable"),
    @NamedQuery(name = "Talleres.findByCodigoTaller", query = "SELECT t FROM Talleres t WHERE t.talleresPK.codigoTaller = :codigoTaller")})
public class Talleres implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TalleresPK talleresPK;
    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;
    @Size(max = 100)
    @Column(name = "descripcion", length = 100)
    private String descripcion;
    @Size(max = 50)
    @Column(name = "responsable", length = 50)
    private String responsable;
    @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PeriodoEscolar periodoEscolar;

    public Talleres() {
    }

    public Talleres(TalleresPK talleresPK) {
        this.talleresPK = talleresPK;
    }

    public Talleres(int idPeriodoEscolar, int codigoTaller) {
        this.talleresPK = new TalleresPK(idPeriodoEscolar, codigoTaller);
    }

    public TalleresPK getTalleresPK() {
        return talleresPK;
    }

    public void setTalleresPK(TalleresPK talleresPK) {
        this.talleresPK = talleresPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public PeriodoEscolar getPeriodoEscolar() {
        return periodoEscolar;
    }

    public void setPeriodoEscolar(PeriodoEscolar periodoEscolar) {
        this.periodoEscolar = periodoEscolar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (talleresPK != null ? talleresPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talleres)) {
            return false;
        }
        Talleres other = (Talleres) object;
        if ((this.talleresPK == null && other.talleresPK != null) || (this.talleresPK != null && !this.talleresPK.equals(other.talleresPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Talleres[ talleresPK=" + talleresPK + " ]";
    }
    
}
