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
public class DescargoactivoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigoinstitucion")
    private String codigoinstitucion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperiodoescolar")
    private int idperiodoescolar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigocatalogo")
    private String codigocatalogo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "codigocorrelativo")
    private String codigocorrelativo;

    public DescargoactivoPK() {
    }

    public DescargoactivoPK(String codigoinstitucion, int idperiodoescolar, String codigocatalogo, String codigocorrelativo) {
        this.codigoinstitucion = codigoinstitucion;
        this.idperiodoescolar = idperiodoescolar;
        this.codigocatalogo = codigocatalogo;
        this.codigocorrelativo = codigocorrelativo;
    }

    public String getCodigoinstitucion() {
        return codigoinstitucion;
    }

    public void setCodigoinstitucion(String codigoinstitucion) {
        this.codigoinstitucion = codigoinstitucion;
    }

    public int getIdperiodoescolar() {
        return idperiodoescolar;
    }

    public void setIdperiodoescolar(int idperiodoescolar) {
        this.idperiodoescolar = idperiodoescolar;
    }

    public String getCodigocatalogo() {
        return codigocatalogo;
    }

    public void setCodigocatalogo(String codigocatalogo) {
        this.codigocatalogo = codigocatalogo;
    }

    public String getCodigocorrelativo() {
        return codigocorrelativo;
    }

    public void setCodigocorrelativo(String codigocorrelativo) {
        this.codigocorrelativo = codigocorrelativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoinstitucion != null ? codigoinstitucion.hashCode() : 0);
        hash += (int) idperiodoescolar;
        hash += (codigocatalogo != null ? codigocatalogo.hashCode() : 0);
        hash += (codigocorrelativo != null ? codigocorrelativo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescargoactivoPK)) {
            return false;
        }
        DescargoactivoPK other = (DescargoactivoPK) object;
        if ((this.codigoinstitucion == null && other.codigoinstitucion != null) || (this.codigoinstitucion != null && !this.codigoinstitucion.equals(other.codigoinstitucion))) {
            return false;
        }
        if (this.idperiodoescolar != other.idperiodoescolar) {
            return false;
        }
        if ((this.codigocatalogo == null && other.codigocatalogo != null) || (this.codigocatalogo != null && !this.codigocatalogo.equals(other.codigocatalogo))) {
            return false;
        }
        if ((this.codigocorrelativo == null && other.codigocorrelativo != null) || (this.codigocorrelativo != null && !this.codigocorrelativo.equals(other.codigocorrelativo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.DescargoactivoPK[ codigoinstitucion=" + codigoinstitucion + ", idperiodoescolar=" + idperiodoescolar + ", codigocatalogo=" + codigocatalogo + ", codigocorrelativo=" + codigocorrelativo + " ]";
    }
    
}
