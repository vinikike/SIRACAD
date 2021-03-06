/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import java.util.Collection;
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
    @Column(name = "id")
    private Integer id;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodoEscolar")
    private Collection<Catalogolibros> catalogolibrosCollection;

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
    public Collection<Catalogolibros> getCatalogolibrosCollection() {
        return catalogolibrosCollection;
    }

    public void setCatalogolibrosCollection(Collection<Catalogolibros> catalogolibrosCollection) {
        this.catalogolibrosCollection = catalogolibrosCollection;
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
