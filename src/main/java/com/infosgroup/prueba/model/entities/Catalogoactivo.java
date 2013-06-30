/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "catalogoactivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogoactivo.findAll", query = "SELECT c FROM Catalogoactivo c"),
    @NamedQuery(name = "Catalogoactivo.findByIdPeriodoEscolar", query = "SELECT c FROM Catalogoactivo c WHERE c.catalogoactivoPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Catalogoactivo.findByCodigoactivo", query = "SELECT c FROM Catalogoactivo c WHERE c.catalogoactivoPK.codigoactivo = :codigoactivo"),
    @NamedQuery(name = "Catalogoactivo.findByDescripcion", query = "SELECT c FROM Catalogoactivo c WHERE c.descripcion = :descripcion")})
public class Catalogoactivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CatalogoactivoPK catalogoactivoPK;
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogoactivo")
    private Collection<Activofijo> activofijoCollection;

    public Catalogoactivo() {
    }

    public Catalogoactivo(CatalogoactivoPK catalogoactivoPK) {
        this.catalogoactivoPK = catalogoactivoPK;
    }

    public Catalogoactivo(int idPeriodoEscolar, String codigoactivo) {
        this.catalogoactivoPK = new CatalogoactivoPK(idPeriodoEscolar, codigoactivo);
    }

    public CatalogoactivoPK getCatalogoactivoPK() {
        return catalogoactivoPK;
    }

    public void setCatalogoactivoPK(CatalogoactivoPK catalogoactivoPK) {
        this.catalogoactivoPK = catalogoactivoPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Activofijo> getActivofijoCollection() {
        return activofijoCollection;
    }

    public void setActivofijoCollection(Collection<Activofijo> activofijoCollection) {
        this.activofijoCollection = activofijoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catalogoactivoPK != null ? catalogoactivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogoactivo)) {
            return false;
        }
        Catalogoactivo other = (Catalogoactivo) object;
        if ((this.catalogoactivoPK == null && other.catalogoactivoPK != null) || (this.catalogoactivoPK != null && !this.catalogoactivoPK.equals(other.catalogoactivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Catalogoactivo[ catalogoactivoPK=" + catalogoactivoPK + " ]";
    }
    
}
