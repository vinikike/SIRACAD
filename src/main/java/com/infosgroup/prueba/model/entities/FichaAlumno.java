/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "ficha_alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FichaAlumno.findAll", query = "SELECT f FROM FichaAlumno f"),
    @NamedQuery(name = "FichaAlumno.findByIdPeriodoEscolar", query = "SELECT f FROM FichaAlumno f WHERE f.fichaAlumnoPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "FichaAlumno.findById", query = "SELECT f FROM FichaAlumno f WHERE f.fichaAlumnoPK.id = :id"),
    @NamedQuery(name = "FichaAlumno.findByRepiteGrado", query = "SELECT f FROM FichaAlumno f WHERE f.repiteGrado = :repiteGrado"),
    @NamedQuery(name = "FichaAlumno.findByCantHnosGradoSup", query = "SELECT f FROM FichaAlumno f WHERE f.cantHnosGradoSup = :cantHnosGradoSup")})
public class FichaAlumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FichaAlumnoPK fichaAlumnoPK;
    @Column(name = "repite_grado")
    private Boolean repiteGrado;
    @Column(name = "cant_hnos_grado_sup")
    private Integer cantHnosGradoSup;
    @JoinColumns({
        @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id_periodo_escolar", insertable = false, updatable = false),
        @JoinColumn(name = "nie", referencedColumnName = "nie")})
    @ManyToOne(optional = false)
    private Alumno alumno;

    public FichaAlumno() {
    }

    public FichaAlumno(FichaAlumnoPK fichaAlumnoPK) {
        this.fichaAlumnoPK = fichaAlumnoPK;
    }

    public FichaAlumno(int idPeriodoEscolar, int id) {
        this.fichaAlumnoPK = new FichaAlumnoPK(idPeriodoEscolar, id);
    }

    public FichaAlumnoPK getFichaAlumnoPK() {
        return fichaAlumnoPK;
    }

    public void setFichaAlumnoPK(FichaAlumnoPK fichaAlumnoPK) {
        this.fichaAlumnoPK = fichaAlumnoPK;
    }

    public Boolean getRepiteGrado() {
        return repiteGrado;
    }

    public void setRepiteGrado(Boolean repiteGrado) {
        this.repiteGrado = repiteGrado;
    }

    public Integer getCantHnosGradoSup() {
        return cantHnosGradoSup;
    }

    public void setCantHnosGradoSup(Integer cantHnosGradoSup) {
        this.cantHnosGradoSup = cantHnosGradoSup;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fichaAlumnoPK != null ? fichaAlumnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FichaAlumno)) {
            return false;
        }
        FichaAlumno other = (FichaAlumno) object;
        if ((this.fichaAlumnoPK == null && other.fichaAlumnoPK != null) || (this.fichaAlumnoPK != null && !this.fichaAlumnoPK.equals(other.fichaAlumnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.FichaAlumno[ fichaAlumnoPK=" + fichaAlumnoPK + " ]";
    }
    
}
