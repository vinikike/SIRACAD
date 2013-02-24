/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "representante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Representante.findAll", query = "SELECT r FROM Representante r"),
    @NamedQuery(name = "Representante.findByIdPeriodoEscolar", query = "SELECT r FROM Representante r WHERE r.representantePK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Representante.findByDui", query = "SELECT r FROM Representante r WHERE r.representantePK.dui = :dui"),
    @NamedQuery(name = "Representante.findByNombre", query = "SELECT r FROM Representante r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Representante.findByApellido", query = "SELECT r FROM Representante r WHERE r.apellido = :apellido"),
    @NamedQuery(name = "Representante.findByTelefono", query = "SELECT r FROM Representante r WHERE r.telefono = :telefono")})
public class Representante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RepresentantePK representantePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    @Size(max = 30)
    @Column(name = "telefono", length = 30)
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "representante")
    private List<Alumno> alumnoList;

    public Representante() {
    }

    public Representante(RepresentantePK representantePK) {
        this.representantePK = representantePK;
    }

    public Representante(RepresentantePK representantePK, String nombre, String apellido) {
        this.representantePK = representantePK;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Representante(int idPeriodoEscolar, String dui) {
        this.representantePK = new RepresentantePK(idPeriodoEscolar, dui);
    }

    public RepresentantePK getRepresentantePK() {
        return representantePK;
    }

    public void setRepresentantePK(RepresentantePK representantePK) {
        this.representantePK = representantePK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash += (representantePK != null ? representantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Representante)) {
            return false;
        }
        Representante other = (Representante) object;
        if ((this.representantePK == null && other.representantePK != null) || (this.representantePK != null && !this.representantePK.equals(other.representantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Representante[ representantePK=" + representantePK + " ]";
    }
    
}
