/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Guille
 */
@Embeddable
public class PeriodoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo_escolar", nullable = false)
    private int idPeriodoEscolar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel", nullable = false)
    private int idNivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo", nullable = false)
    private int idPeriodo;

    public PeriodoPK() {
    }

    public PeriodoPK(int idPeriodoEscolar, int idNivel, int idPeriodo) {
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.idNivel = idNivel;
        this.idPeriodo = idPeriodo;
    }

    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPeriodoEscolar;
        hash += (int) idNivel;
        hash += (int) idPeriodo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodoPK)) {
            return false;
        }
        PeriodoPK other = (PeriodoPK) object;
        if (this.idPeriodoEscolar != other.idPeriodoEscolar) {
            return false;
        }
        if (this.idNivel != other.idNivel) {
            return false;
        }
        if (this.idPeriodo != other.idPeriodo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.PeriodoPK[ idPeriodoEscolar=" + idPeriodoEscolar + ", idNivel=" + idNivel + ", idPeriodo=" + idPeriodo + " ]";
    }
    
}
