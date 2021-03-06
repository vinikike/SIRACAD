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
public class NinosvivePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo_escolar", nullable = false)
    private int idPeriodoEscolar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nie", nullable = false, length = 50)
    private String nie;

    public NinosvivePK() {
    }

    public NinosvivePK(int idPeriodoEscolar, String nie) {
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.nie = nie;
    }

    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
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
        hash += (int) idPeriodoEscolar;
        hash += (nie != null ? nie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NinosvivePK)) {
            return false;
        }
        NinosvivePK other = (NinosvivePK) object;
        if (this.idPeriodoEscolar != other.idPeriodoEscolar) {
            return false;
        }
        if ((this.nie == null && other.nie != null) || (this.nie != null && !this.nie.equals(other.nie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.NinosvivePK[ idPeriodoEscolar=" + idPeriodoEscolar + ", nie=" + nie + " ]";
    }
    
}
