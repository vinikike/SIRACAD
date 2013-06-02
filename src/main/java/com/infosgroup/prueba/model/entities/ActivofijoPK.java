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
public class ActivofijoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigo_institucion")
    private String codigoInstitucion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id_periodod_escolar")
    private String idPeriododEscolar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_catalogo")
    private int codigoCatalogo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_correlativo")
    private int codigoCorrelativo;

    public ActivofijoPK() {
    }

    public ActivofijoPK(String codigoInstitucion, String idPeriododEscolar, int codigoCatalogo, int codigoCorrelativo) {
        this.codigoInstitucion = codigoInstitucion;
        this.idPeriododEscolar = idPeriododEscolar;
        this.codigoCatalogo = codigoCatalogo;
        this.codigoCorrelativo = codigoCorrelativo;
    }

    public String getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(String codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    public String getIdPeriododEscolar() {
        return idPeriododEscolar;
    }

    public void setIdPeriododEscolar(String idPeriododEscolar) {
        this.idPeriododEscolar = idPeriododEscolar;
    }

    public int getCodigoCatalogo() {
        return codigoCatalogo;
    }

    public void setCodigoCatalogo(int codigoCatalogo) {
        this.codigoCatalogo = codigoCatalogo;
    }

    public int getCodigoCorrelativo() {
        return codigoCorrelativo;
    }

    public void setCodigoCorrelativo(int codigoCorrelativo) {
        this.codigoCorrelativo = codigoCorrelativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoInstitucion != null ? codigoInstitucion.hashCode() : 0);
        hash += (idPeriododEscolar != null ? idPeriododEscolar.hashCode() : 0);
        hash += (int) codigoCatalogo;
        hash += (int) codigoCorrelativo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivofijoPK)) {
            return false;
        }
        ActivofijoPK other = (ActivofijoPK) object;
        if ((this.codigoInstitucion == null && other.codigoInstitucion != null) || (this.codigoInstitucion != null && !this.codigoInstitucion.equals(other.codigoInstitucion))) {
            return false;
        }
        if ((this.idPeriododEscolar == null && other.idPeriododEscolar != null) || (this.idPeriododEscolar != null && !this.idPeriododEscolar.equals(other.idPeriododEscolar))) {
            return false;
        }
        if (this.codigoCatalogo != other.codigoCatalogo) {
            return false;
        }
        if (this.codigoCorrelativo != other.codigoCorrelativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.ActivofijoPK[ codigoInstitucion=" + codigoInstitucion + ", idPeriododEscolar=" + idPeriododEscolar + ", codigoCatalogo=" + codigoCatalogo + ", codigoCorrelativo=" + codigoCorrelativo + " ]";
    }
    
}
