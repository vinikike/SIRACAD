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
public class CatalogolibrosPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo_escolar", nullable = false)
    private int idPeriodoEscolar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigolibro", nullable = false, length = 2147483647)
    private String codigolibro;

    public CatalogolibrosPK() {
    }

    public CatalogolibrosPK(int idPeriodoEscolar, String codigolibro) {
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.codigolibro = codigolibro;
    }

    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public String getCodigolibro() {
        return codigolibro;
    }

    public void setCodigolibro(String codigolibro) {
        this.codigolibro = codigolibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPeriodoEscolar;
        hash += (codigolibro != null ? codigolibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogolibrosPK)) {
            return false;
        }
        CatalogolibrosPK other = (CatalogolibrosPK) object;
        if (this.idPeriodoEscolar != other.idPeriodoEscolar) {
            return false;
        }
        if ((this.codigolibro == null && other.codigolibro != null) || (this.codigolibro != null && !this.codigolibro.equals(other.codigolibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.CatalogolibrosPK[ idPeriodoEscolar=" + idPeriodoEscolar + ", codigolibro=" + codigolibro + " ]";
    }
    
}
