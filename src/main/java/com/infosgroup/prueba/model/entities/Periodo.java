/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "periodo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p"),
    @NamedQuery(name = "Periodo.findByIdPeriodoEscolar", query = "SELECT p FROM Periodo p WHERE p.periodoPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Periodo.findByIdNivel", query = "SELECT p FROM Periodo p WHERE p.periodoPK.idNivel = :idNivel"),
    @NamedQuery(name = "Periodo.findByIdPeriodo", query = "SELECT p FROM Periodo p WHERE p.periodoPK.idPeriodo = :idPeriodo")})
public class Periodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PeriodoPK periodoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<Ponderaciones> ponderacionesList;
    @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PeriodoEscolar periodoEscolar;
    @JoinColumn(name = "id_nivel", referencedColumnName = "id_nivel", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Nivel nivel;

    public Periodo() {
    }

    public Periodo(PeriodoPK periodoPK) {
        this.periodoPK = periodoPK;
    }

    public Periodo(int idPeriodoEscolar, int idNivel, int idPeriodo) {
        this.periodoPK = new PeriodoPK(idPeriodoEscolar, idNivel, idPeriodo);
    }

    public PeriodoPK getPeriodoPK() {
        return periodoPK;
    }

    public void setPeriodoPK(PeriodoPK periodoPK) {
        this.periodoPK = periodoPK;
    }

    @XmlTransient
    public List<Ponderaciones> getPonderacionesList() {
        return ponderacionesList;
    }

    public void setPonderacionesList(List<Ponderaciones> ponderacionesList) {
        this.ponderacionesList = ponderacionesList;
    }

    public PeriodoEscolar getPeriodoEscolar() {
        return periodoEscolar;
    }

    public void setPeriodoEscolar(PeriodoEscolar periodoEscolar) {
        this.periodoEscolar = periodoEscolar;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodoPK != null ? periodoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.periodoPK == null && other.periodoPK != null) || (this.periodoPK != null && !this.periodoPK.equals(other.periodoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Periodo[ periodoPK=" + periodoPK + " ]";
    }
    
}
