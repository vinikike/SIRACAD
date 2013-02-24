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
public class FichaAlumnoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo_escolar", nullable = false)
    private int idPeriodoEscolar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private int id;

    public FichaAlumnoPK() {
    }

    public FichaAlumnoPK(int idPeriodoEscolar, int id) {
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.id = id;
    }

    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPeriodoEscolar;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaAlumnoPK)) {
            return false;
        }
        FichaAlumnoPK other = (FichaAlumnoPK) object;
        if (this.idPeriodoEscolar != other.idPeriodoEscolar) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.FichaAlumnoPK[ idPeriodoEscolar=" + idPeriodoEscolar + ", id=" + id + " ]";
    }
    
}
