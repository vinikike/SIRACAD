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
@Table(name = "salud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salud.findAll", query = "SELECT s FROM Salud s"),
    @NamedQuery(name = "Salud.findByIdPeriodoescolar", query = "SELECT s FROM Salud s WHERE s.saludPK.idPeriodoescolar = :idPeriodoescolar"),
    @NamedQuery(name = "Salud.findByNie", query = "SELECT s FROM Salud s WHERE s.saludPK.nie = :nie"),
    @NamedQuery(name = "Salud.findByPoseediscapacidad", query = "SELECT s FROM Salud s WHERE s.poseediscapacidad = :poseediscapacidad"),
    @NamedQuery(name = "Salud.findByTipodediscapacidad", query = "SELECT s FROM Salud s WHERE s.tipodediscapacidad = :tipodediscapacidad"),
    @NamedQuery(name = "Salud.findByVacunascompletas", query = "SELECT s FROM Salud s WHERE s.vacunascompletas = :vacunascompletas"),
    @NamedQuery(name = "Salud.findByProblemadesalud", query = "SELECT s FROM Salud s WHERE s.problemadesalud = :problemadesalud")})
public class Salud implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SaludPK saludPK;
    @Size(max = 50)
    @Column(name = "poseediscapacidad", length = 50)
    private String poseediscapacidad;
    @Size(max = 100)
    @Column(name = "tipodediscapacidad", length = 100)
    private String tipodediscapacidad;
    @Size(max = 50)
    @Column(name = "vacunascompletas", length = 50)
    private String vacunascompletas;
    @Size(max = 100)
    @Column(name = "problemadesalud", length = 100)
    private String problemadesalud;
    @JoinColumns({
        @JoinColumn(name = "id_periodoescolar", referencedColumnName = "id_periodo_escolar", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "nie", referencedColumnName = "nie", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Alumno alumno;

    public Salud() {
    }

    public Salud(SaludPK saludPK) {
        this.saludPK = saludPK;
    }

    public Salud(int idPeriodoescolar, String nie) {
        this.saludPK = new SaludPK(idPeriodoescolar, nie);
    }

    public SaludPK getSaludPK() {
        return saludPK;
    }

    public void setSaludPK(SaludPK saludPK) {
        this.saludPK = saludPK;
    }

    public String getPoseediscapacidad() {
        return poseediscapacidad;
    }

    public void setPoseediscapacidad(String poseediscapacidad) {
        this.poseediscapacidad = poseediscapacidad;
    }

    public String getTipodediscapacidad() {
        return tipodediscapacidad;
    }

    public void setTipodediscapacidad(String tipodediscapacidad) {
        this.tipodediscapacidad = tipodediscapacidad;
    }

    public String getVacunascompletas() {
        return vacunascompletas;
    }

    public void setVacunascompletas(String vacunascompletas) {
        this.vacunascompletas = vacunascompletas;
    }

    public String getProblemadesalud() {
        return problemadesalud;
    }

    public void setProblemadesalud(String problemadesalud) {
        this.problemadesalud = problemadesalud;
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
        hash += (saludPK != null ? saludPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salud)) {
            return false;
        }
        Salud other = (Salud) object;
        if ((this.saludPK == null && other.saludPK != null) || (this.saludPK != null && !this.saludPK.equals(other.saludPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Salud[ saludPK=" + saludPK + " ]";
    }
    
}
