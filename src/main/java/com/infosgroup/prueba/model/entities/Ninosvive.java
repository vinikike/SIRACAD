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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "ninosvive")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ninosvive.findAll", query = "SELECT n FROM Ninosvive n"),
    @NamedQuery(name = "Ninosvive.findByIdPeriodoEscolar", query = "SELECT n FROM Ninosvive n WHERE n.ninosvivePK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Ninosvive.findByNie", query = "SELECT n FROM Ninosvive n WHERE n.ninosvivePK.nie = :nie"),
    @NamedQuery(name = "Ninosvive.findByCantidadninos", query = "SELECT n FROM Ninosvive n WHERE n.cantidadninos = :cantidadninos"),
    @NamedQuery(name = "Ninosvive.findByCantidadninas", query = "SELECT n FROM Ninosvive n WHERE n.cantidadninas = :cantidadninas")})
public class Ninosvive implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NinosvivePK ninosvivePK;
    @Column(name = "cantidadninos")
    private Integer cantidadninos;
    @Column(name = "cantidadninas")
    private Integer cantidadninas;
    @JoinColumns({
        @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id_periodo_escolar", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "nie", referencedColumnName = "nie", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Alumno alumno;

    public Ninosvive() {
    }

    public Ninosvive(NinosvivePK ninosvivePK) {
        this.ninosvivePK = ninosvivePK;
    }

    public Ninosvive(int idPeriodoEscolar, String nie) {
        this.ninosvivePK = new NinosvivePK(idPeriodoEscolar, nie);
    }

    public NinosvivePK getNinosvivePK() {
        return ninosvivePK;
    }

    public void setNinosvivePK(NinosvivePK ninosvivePK) {
        this.ninosvivePK = ninosvivePK;
    }

    public Integer getCantidadninos() {
        return cantidadninos;
    }

    public void setCantidadninos(Integer cantidadninos) {
        this.cantidadninos = cantidadninos;
    }

    public Integer getCantidadninas() {
        return cantidadninas;
    }

    public void setCantidadninas(Integer cantidadninas) {
        this.cantidadninas = cantidadninas;
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
        hash += (ninosvivePK != null ? ninosvivePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ninosvive)) {
            return false;
        }
        Ninosvive other = (Ninosvive) object;
        if ((this.ninosvivePK == null && other.ninosvivePK != null) || (this.ninosvivePK != null && !this.ninosvivePK.equals(other.ninosvivePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Ninosvive[ ninosvivePK=" + ninosvivePK + " ]";
    }
    
}
