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
public class RepresentantePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo_escolar")
    private int idPeriodoEscolar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "dui")
    private String dui;

    public RepresentantePK() {
    }

    public RepresentantePK(int idPeriodoEscolar, String dui) {
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.dui = dui;
    }

    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPeriodoEscolar;
        hash += (dui != null ? dui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentantePK)) {
            return false;
        }
        RepresentantePK other = (RepresentantePK) object;
        if (this.idPeriodoEscolar != other.idPeriodoEscolar) {
            return false;
        }
        if ((this.dui == null && other.dui != null) || (this.dui != null && !this.dui.equals(other.dui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.RepresentantePK[ idPeriodoEscolar=" + idPeriodoEscolar + ", dui=" + dui + " ]";
    }
    
}
