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
import javax.validation.constraints.Size;

/**
 *
 * @author Guille
 */
@Embeddable
public class SaludPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodoescolar", nullable = false)
    private int idPeriodoescolar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nie", nullable = false, length = 2147483647)
    private String nie;

    public SaludPK() {
    }

    public SaludPK(int idPeriodoescolar, String nie) {
        this.idPeriodoescolar = idPeriodoescolar;
        this.nie = nie;
    }

    public int getIdPeriodoescolar() {
        return idPeriodoescolar;
    }

    public void setIdPeriodoescolar(int idPeriodoescolar) {
        this.idPeriodoescolar = idPeriodoescolar;
    }

    public String getNie() {
        return nie;
    }

    public void setNie(String nie) {
        this.nie = nie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPeriodoescolar;
        hash += (nie != null ? nie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaludPK)) {
            return false;
        }
        SaludPK other = (SaludPK) object;
        if (this.idPeriodoescolar != other.idPeriodoescolar) {
            return false;
        }
        if ((this.nie == null && other.nie != null) || (this.nie != null && !this.nie.equals(other.nie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.SaludPK[ idPeriodoescolar=" + idPeriodoescolar + ", nie=" + nie + " ]";
    }
    
}
