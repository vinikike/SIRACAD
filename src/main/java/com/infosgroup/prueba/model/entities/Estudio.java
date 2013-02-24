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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "estudio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudio.findAll", query = "SELECT e FROM Estudio e"),
    @NamedQuery(name = "Estudio.findByGradoestudio", query = "SELECT e FROM Estudio e WHERE e.gradoestudio = :gradoestudio"),
    @NamedQuery(name = "Estudio.findByOpcionestudio", query = "SELECT e FROM Estudio e WHERE e.opcionestudio = :opcionestudio"),
    @NamedQuery(name = "Estudio.findBySeccionestudio", query = "SELECT e FROM Estudio e WHERE e.seccionestudio = :seccionestudio"),
    @NamedQuery(name = "Estudio.findByRepitegrado", query = "SELECT e FROM Estudio e WHERE e.repitegrado = :repitegrado"),
    @NamedQuery(name = "Estudio.findByEstudioparvularia", query = "SELECT e FROM Estudio e WHERE e.estudioparvularia = :estudioparvularia"),
    @NamedQuery(name = "Estudio.findByIdPeriodoEscolar", query = "SELECT e FROM Estudio e WHERE e.estudioPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Estudio.findByNie", query = "SELECT e FROM Estudio e WHERE e.estudioPK.nie = :nie"),
    @NamedQuery(name = "Estudio.findByNivel", query = "SELECT e FROM Estudio e WHERE e.nivel = :nivel")})
public class Estudio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudioPK estudioPK;
    @Size(max = 50)
    @Column(name = "gradoestudio", length = 50)
    private String gradoestudio;
    @Size(max = 50)
    @Column(name = "opcionestudio", length = 50)
    private String opcionestudio;
    @Size(max = 50)
    @Column(name = "seccionestudio", length = 50)
    private String seccionestudio;
    @Size(max = 50)
    @Column(name = "repitegrado", length = 50)
    private String repitegrado;
    @Size(max = 50)
    @Column(name = "estudioparvularia", length = 50)
    private String estudioparvularia;
    @Size(max = 10)
    @Column(name = "nivel", length = 10)
    private String nivel;
    @JoinColumns({
        @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id_periodo_escolar", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "nie", referencedColumnName = "nie", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Alumno alumno;

    public Estudio() {
    }

    public Estudio(EstudioPK estudioPK) {
        this.estudioPK = estudioPK;
    }

    public Estudio(int idPeriodoEscolar, String nie) {
        this.estudioPK = new EstudioPK(idPeriodoEscolar, nie);
    }

    public EstudioPK getEstudioPK() {
        return estudioPK;
    }

    public void setEstudioPK(EstudioPK estudioPK) {
        this.estudioPK = estudioPK;
    }

    public String getGradoestudio() {
        return gradoestudio;
    }

    public void setGradoestudio(String gradoestudio) {
        this.gradoestudio = gradoestudio;
    }

    public String getOpcionestudio() {
        return opcionestudio;
    }

    public void setOpcionestudio(String opcionestudio) {
        this.opcionestudio = opcionestudio;
    }

    public String getSeccionestudio() {
        return seccionestudio;
    }

    public void setSeccionestudio(String seccionestudio) {
        this.seccionestudio = seccionestudio;
    }

    public String getRepitegrado() {
        return repitegrado;
    }

    public void setRepitegrado(String repitegrado) {
        this.repitegrado = repitegrado;
    }

    public String getEstudioparvularia() {
        return estudioparvularia;
    }

    public void setEstudioparvularia(String estudioparvularia) {
        this.estudioparvularia = estudioparvularia;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
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
        hash += (estudioPK != null ? estudioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudio)) {
            return false;
        }
        Estudio other = (Estudio) object;
        if ((this.estudioPK == null && other.estudioPK != null) || (this.estudioPK != null && !this.estudioPK.equals(other.estudioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Estudio[ estudioPK=" + estudioPK + " ]";
    }
    
}
