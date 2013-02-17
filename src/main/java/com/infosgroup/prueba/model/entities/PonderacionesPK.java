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

/**
 *
 * @author Guille
 */
@Embeddable
public class PonderacionesPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo_escolar")
    private int idPeriodoEscolar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel")
    private int idNivel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_periodo")
    private int idPeriodo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ponderacion")
    private int idPonderacion;

    public PonderacionesPK() {
    }

    public PonderacionesPK(int idPeriodoEscolar, int idNivel, int idPeriodo, int idPonderacion) {
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.idNivel = idNivel;
        this.idPeriodo = idPeriodo;
        this.idPonderacion = idPonderacion;
    }

    public int getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(int idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public int getIdPonderacion() {
        return idPonderacion;
    }

    public void setIdPonderacion(int idPonderacion) {
        this.idPonderacion = idPonderacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPeriodoEscolar;
        hash += (int) idNivel;
        hash += (int) idPeriodo;
        hash += (int) idPonderacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PonderacionesPK)) {
            return false;
        }
        PonderacionesPK other = (PonderacionesPK) object;
        if (this.idPeriodoEscolar != other.idPeriodoEscolar) {
            return false;
        }
        if (this.idNivel != other.idNivel) {
            return false;
        }
        if (this.idPeriodo != other.idPeriodo) {
            return false;
        }
        if (this.idPonderacion != other.idPonderacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.PonderacionesPK[ idPeriodoEscolar=" + idPeriodoEscolar + ", idNivel=" + idNivel + ", idPeriodo=" + idPeriodo + ", idPonderacion=" + idPonderacion + " ]";
    }
    
}
