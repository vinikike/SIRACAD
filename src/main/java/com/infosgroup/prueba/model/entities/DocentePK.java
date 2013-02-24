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
public class DocentePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo_escolar", nullable = false)
    private int idPeriodoEscolar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "docente_dui", nullable = false, length = 2147483647)
    private String docenteDui;

    public DocentePK() {
    }

    public DocentePK(int idPeriodoEscolar, String docenteDui) {
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.docenteDui = docenteDui;
    }

    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
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
        hash += (int) idPeriodoEscolar;
        hash += (docenteDui != null ? docenteDui.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocentePK)) {
            return false;
        }
        DocentePK other = (DocentePK) object;
        if (this.idPeriodoEscolar != other.idPeriodoEscolar) {
            return false;
        }
        if ((this.docenteDui == null && other.docenteDui != null) || (this.docenteDui != null && !this.docenteDui.equals(other.docenteDui))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.DocentePK[ idPeriodoEscolar=" + idPeriodoEscolar + ", docenteDui=" + docenteDui + " ]";
    }
    
}
