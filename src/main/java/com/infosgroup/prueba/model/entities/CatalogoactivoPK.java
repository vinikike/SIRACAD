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
public class CatalogoactivoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo_escolar")
    private int idPeriodoEscolar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigoactivo")
    private String codigoactivo;

    public CatalogoactivoPK() {
    }

    public CatalogoactivoPK(int idPeriodoEscolar, String codigoactivo) {
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.codigoactivo = codigoactivo;
    }

    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public String getCodigoactivo() {
        return codigoactivo;
    }

    public void setCodigoactivo(String codigoactivo) {
        this.codigoactivo = codigoactivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPeriodoEscolar;
        hash += (codigoactivo != null ? codigoactivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoactivoPK)) {
            return false;
        }
        CatalogoactivoPK other = (CatalogoactivoPK) object;
        if (this.idPeriodoEscolar != other.idPeriodoEscolar) {
            return false;
        }
        if ((this.codigoactivo == null && other.codigoactivo != null) || (this.codigoactivo != null && !this.codigoactivo.equals(other.codigoactivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.CatalogoactivoPK[ idPeriodoEscolar=" + idPeriodoEscolar + ", codigoactivo=" + codigoactivo + " ]";
    }
    
}
