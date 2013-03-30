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
@Table(name = "periodo_escolar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodoEscolar.findAll", query = "SELECT p FROM PeriodoEscolar p"),
    @NamedQuery(name = "PeriodoEscolar.findById", query = "SELECT p FROM PeriodoEscolar p WHERE p.id = :id"),
    @NamedQuery(name = "PeriodoEscolar.findByDescripcion", query = "SELECT p FROM PeriodoEscolar p WHERE p.descripcion = :descripcion")})
public class PeriodoEscolar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 200)
    @Column(name = "descripcion", length = 200)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoEscolar")
    private List<Alumno> alumnoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoEscolar")
    private List<Libro> libroList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoEscolar")
    private List<Talleres> talleresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoEscolar")
    private List<Periodo> periodoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoEscolar")
    private List<Grado> gradoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoEscolar")
    private List<Catalogolibros> catalogolibrosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoEscolar")
    private List<Representante> representanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeriodoEscolar")
    private List<Docente> docenteList;

    public PeriodoEscolar() {
    }

    public PeriodoEscolar(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    @XmlTransient
    public List<Libro> getLibroList() {
        return libroList;
    }

    public void setLibroList(List<Libro> libroList) {
        this.libroList = libroList;
    }

    @XmlTransient
    public List<Talleres> getTalleresList() {
        return talleresList;
    }

    public void setTalleresList(List<Talleres> talleresList) {
        this.talleresList = talleresList;
    }

    @XmlTransient
    public List<Periodo> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(List<Periodo> periodoList) {
        this.periodoList = periodoList;
    }

    @XmlTransient
    public List<Grado> getGradoList() {
        return gradoList;
    }

    public void setGradoList(List<Grado> gradoList) {
        this.gradoList = gradoList;
    }

    @XmlTransient
    public List<Catalogolibros> getCatalogolibrosList() {
        return catalogolibrosList;
    }

    public void setCatalogolibrosList(List<Catalogolibros> catalogolibrosList) {
        this.catalogolibrosList = catalogolibrosList;
    }

    @XmlTransient
    public List<Representante> getRepresentanteList() {
        return representanteList;
    }

    public void setRepresentanteList(List<Representante> representanteList) {
        this.representanteList = representanteList;
    }

    @XmlTransient
    public List<Docente> getDocenteList() {
        return docenteList;
    }

    public void setDocenteList(List<Docente> docenteList) {
        this.docenteList = docenteList;
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
        if (!(object instanceof PeriodoEscolar)) {
            return false;
        }
        PeriodoEscolar other = (PeriodoEscolar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.PeriodoEscolar[ id=" + id + " ]";
    }
    
}
