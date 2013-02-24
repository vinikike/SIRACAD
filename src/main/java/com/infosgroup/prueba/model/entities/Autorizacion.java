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
@Table(name = "autorizacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autorizacion.findAll", query = "SELECT a FROM Autorizacion a"),
    @NamedQuery(name = "Autorizacion.findByIdPeriodoEscolar", query = "SELECT a FROM Autorizacion a WHERE a.autorizacionPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Autorizacion.findByNie", query = "SELECT a FROM Autorizacion a WHERE a.autorizacionPK.nie = :nie"),
    @NamedQuery(name = "Autorizacion.findByAutorizacionsolo", query = "SELECT a FROM Autorizacion a WHERE a.autorizacionsolo = :autorizacionsolo"),
    @NamedQuery(name = "Autorizacion.findByPersonarecogernombre", query = "SELECT a FROM Autorizacion a WHERE a.personarecogernombre = :personarecogernombre"),
    @NamedQuery(name = "Autorizacion.findByPersonarecogertelefono", query = "SELECT a FROM Autorizacion a WHERE a.personarecogertelefono = :personarecogertelefono"),
    @NamedQuery(name = "Autorizacion.findByPersonarecogerdui", query = "SELECT a FROM Autorizacion a WHERE a.personarecogerdui = :personarecogerdui")})
public class Autorizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AutorizacionPK autorizacionPK;
    @Size(max = 50)
    @Column(name = "autorizacionsolo", length = 50)
    private String autorizacionsolo;
    @Size(max = 100)
    @Column(name = "personarecogernombre", length = 100)
    private String personarecogernombre;
    @Size(max = 50)
    @Column(name = "personarecogertelefono", length = 50)
    private String personarecogertelefono;
    @Size(max = 50)
    @Column(name = "personarecogerdui", length = 50)
    private String personarecogerdui;
    @JoinColumns({
        @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id_periodo_escolar", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "nie", referencedColumnName = "nie", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Alumno alumno;

    public Autorizacion() {
    }

    public Autorizacion(AutorizacionPK autorizacionPK) {
        this.autorizacionPK = autorizacionPK;
    }

    public Autorizacion(int idPeriodoEscolar, String nie) {
        this.autorizacionPK = new AutorizacionPK(idPeriodoEscolar, nie);
    }

    public AutorizacionPK getAutorizacionPK() {
        return autorizacionPK;
    }

    public void setAutorizacionPK(AutorizacionPK autorizacionPK) {
        this.autorizacionPK = autorizacionPK;
    }

    public String getAutorizacionsolo() {
        return autorizacionsolo;
    }

    public void setAutorizacionsolo(String autorizacionsolo) {
        this.autorizacionsolo = autorizacionsolo;
    }

    public String getPersonarecogernombre() {
        return personarecogernombre;
    }

    public void setPersonarecogernombre(String personarecogernombre) {
        this.personarecogernombre = personarecogernombre;
    }

    public String getPersonarecogertelefono() {
        return personarecogertelefono;
    }

    public void setPersonarecogertelefono(String personarecogertelefono) {
        this.personarecogertelefono = personarecogertelefono;
    }

    public String getPersonarecogerdui() {
        return personarecogerdui;
    }

    public void setPersonarecogerdui(String personarecogerdui) {
        this.personarecogerdui = personarecogerdui;
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
        hash += (autorizacionPK != null ? autorizacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autorizacion)) {
            return false;
        }
        Autorizacion other = (Autorizacion) object;
        if ((this.autorizacionPK == null && other.autorizacionPK != null) || (this.autorizacionPK != null && !this.autorizacionPK.equals(other.autorizacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Autorizacion[ autorizacionPK=" + autorizacionPK + " ]";
    }
    
}
