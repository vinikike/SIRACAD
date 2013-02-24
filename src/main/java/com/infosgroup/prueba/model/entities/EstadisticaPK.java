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
public class EstadisticaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo_escolar", nullable = false)
    private int idPeriodoEscolar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nivel", nullable = false, length = 2147483647)
    private String nivel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "grado", nullable = false, length = 2147483647)
    private String grado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "opcion", nullable = false, length = 2147483647)
    private String opcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "seccion", nullable = false, length = 2147483647)
    private String seccion;

    public EstadisticaPK() {
    }

    public EstadisticaPK(int idPeriodoEscolar, String nivel, String grado, String opcion, String seccion) {
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.nivel = nivel;
        this.grado = grado;
        this.opcion = opcion;
        this.seccion = seccion;
    }

    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPeriodoEscolar;
        hash += (nivel != null ? nivel.hashCode() : 0);
        hash += (grado != null ? grado.hashCode() : 0);
        hash += (opcion != null ? opcion.hashCode() : 0);
        hash += (seccion != null ? seccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadisticaPK)) {
            return false;
        }
        EstadisticaPK other = (EstadisticaPK) object;
        if (this.idPeriodoEscolar != other.idPeriodoEscolar) {
            return false;
        }
        if ((this.nivel == null && other.nivel != null) || (this.nivel != null && !this.nivel.equals(other.nivel))) {
            return false;
        }
        if ((this.grado == null && other.grado != null) || (this.grado != null && !this.grado.equals(other.grado))) {
            return false;
        }
        if ((this.opcion == null && other.opcion != null) || (this.opcion != null && !this.opcion.equals(other.opcion))) {
            return false;
        }
        if ((this.seccion == null && other.seccion != null) || (this.seccion != null && !this.seccion.equals(other.seccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.EstadisticaPK[ idPeriodoEscolar=" + idPeriodoEscolar + ", nivel=" + nivel + ", grado=" + grado + ", opcion=" + opcion + ", seccion=" + seccion + " ]";
    }
    
}
