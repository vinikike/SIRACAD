/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "zona_residencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ZonaResidencia.findAll", query = "SELECT z FROM ZonaResidencia z"),
    @NamedQuery(name = "ZonaResidencia.findById", query = "SELECT z FROM ZonaResidencia z WHERE z.id = :id"),
    @NamedQuery(name = "ZonaResidencia.findByNombre", query = "SELECT z FROM ZonaResidencia z WHERE z.nombre = :nombre")})
public class ZonaResidencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id", nullable = false, length = 50)
    private String id;
    @Size(max = 50)
    @Column(name = "nombre", length = 50)
    private String nombre;
    @OneToMany(mappedBy = "idZonaResidencia")
    private List<Alumno> alumnoList;

    public ZonaResidencia() {
    }

    public ZonaResidencia(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ZonaResidencia)) {
            return false;
        }
        ZonaResidencia other = (ZonaResidencia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.ZonaResidencia[ id=" + id + " ]";
    }
    
}
