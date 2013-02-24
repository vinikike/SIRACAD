/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "grado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Grado.findAll", query = "SELECT g FROM Grado g"),
    @NamedQuery(name = "Grado.findByIdPeriodoEscolar", query = "SELECT g FROM Grado g WHERE g.gradoPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Grado.findByNivel", query = "SELECT g FROM Grado g WHERE g.gradoPK.nivel = :nivel"),
    @NamedQuery(name = "Grado.findByGrado", query = "SELECT g FROM Grado g WHERE g.gradoPK.grado = :grado"),
    @NamedQuery(name = "Grado.findByOpcion", query = "SELECT g FROM Grado g WHERE g.gradoPK.opcion = :opcion"),
    @NamedQuery(name = "Grado.findBySeccion", query = "SELECT g FROM Grado g WHERE g.gradoPK.seccion = :seccion"),
    @NamedQuery(name = "Grado.findByTurno", query = "SELECT g FROM Grado g WHERE g.turno = :turno"),
    @NamedQuery(name = "Grado.findByNombreGrado", query = "SELECT g FROM Grado g WHERE g.nombreGrado = :nombreGrado"),
    @NamedQuery(name = "Grado.findByDocenteDui", query = "SELECT g FROM Grado g WHERE g.docenteDui = :docenteDui")})
public class Grado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GradoPK gradoPK;
    @Size(max = 50)
    @Column(name = "turno", length = 50)
    private String turno;
    @Size(max = 50)
    @Column(name = "nombre_grado", length = 50)
    private String nombreGrado;
    @Size(max = 50)
    @Column(name = "docente_dui", length = 50)
    private String docenteDui;

    public Grado() {
    }

    public Grado(GradoPK gradoPK) {
        this.gradoPK = gradoPK;
    }

    public Grado(int idPeriodoEscolar, String nivel, String grado, String opcion, String seccion) {
        this.gradoPK = new GradoPK(idPeriodoEscolar, nivel, grado, opcion, seccion);
    }

    public GradoPK getGradoPK() {
        return gradoPK;
    }

    public void setGradoPK(GradoPK gradoPK) {
        this.gradoPK = gradoPK;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNombreGrado() {
        return nombreGrado;
    }

    public void setNombreGrado(String nombreGrado) {
        this.nombreGrado = nombreGrado;
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
        hash += (gradoPK != null ? gradoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grado)) {
            return false;
        }
        Grado other = (Grado) object;
        if ((this.gradoPK == null && other.gradoPK != null) || (this.gradoPK != null && !this.gradoPK.equals(other.gradoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Grado[ gradoPK=" + gradoPK + " ]";
    }
    
}
