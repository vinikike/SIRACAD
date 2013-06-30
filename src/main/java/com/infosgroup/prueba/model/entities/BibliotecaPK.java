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
public class BibliotecaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo_escolar")
    private int idPeriodoEscolar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_correlativo")
    private int codigoCorrelativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo_catalogo")
    private String codigoCatalogo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "codigo_institucion")
    private String codigoInstitucion;

    public BibliotecaPK() {
    }

    public BibliotecaPK(int idPeriodoEscolar, int codigoCorrelativo, String codigoCatalogo, String codigoInstitucion) {
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.codigoCorrelativo = codigoCorrelativo;
        this.codigoCatalogo = codigoCatalogo;
        this.codigoInstitucion = codigoInstitucion;
    }

    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public int getCodigoCorrelativo() {
        return codigoCorrelativo;
    }

    public void setCodigoCorrelativo(int codigoCorrelativo) {
        this.codigoCorrelativo = codigoCorrelativo;
    }

    public String getCodigoCatalogo() {
        return codigoCatalogo;
    }

    public void setCodigoCatalogo(String codigoCatalogo) {
        this.codigoCatalogo = codigoCatalogo;
    }

    public String getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(String codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPeriodoEscolar;
        hash += (int) codigoCorrelativo;
        hash += (codigoCatalogo != null ? codigoCatalogo.hashCode() : 0);
        hash += (codigoInstitucion != null ? codigoInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BibliotecaPK)) {
            return false;
        }
        BibliotecaPK other = (BibliotecaPK) object;
        if (this.idPeriodoEscolar != other.idPeriodoEscolar) {
            return false;
        }
        if (this.codigoCorrelativo != other.codigoCorrelativo) {
            return false;
        }
        if ((this.codigoCatalogo == null && other.codigoCatalogo != null) || (this.codigoCatalogo != null && !this.codigoCatalogo.equals(other.codigoCatalogo))) {
            return false;
        }
        if ((this.codigoInstitucion == null && other.codigoInstitucion != null) || (this.codigoInstitucion != null && !this.codigoInstitucion.equals(other.codigoInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.BibliotecaPK[ idPeriodoEscolar=" + idPeriodoEscolar + ", codigoCorrelativo=" + codigoCorrelativo + ", codigoCatalogo=" + codigoCatalogo + ", codigoInstitucion=" + codigoInstitucion + " ]";
    }
    
}
