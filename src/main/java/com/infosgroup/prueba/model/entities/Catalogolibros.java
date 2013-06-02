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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "catalogolibros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Catalogolibros.findAll", query = "SELECT c FROM Catalogolibros c"),
    @NamedQuery(name = "Catalogolibros.findByIdPeriodoEscolar", query = "SELECT c FROM Catalogolibros c WHERE c.catalogolibrosPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Catalogolibros.findByCodigolibro", query = "SELECT c FROM Catalogolibros c WHERE c.catalogolibrosPK.codigolibro = :codigolibro"),
    @NamedQuery(name = "Catalogolibros.findByTipo", query = "SELECT c FROM Catalogolibros c WHERE c.tipo = :tipo")})
public class Catalogolibros implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CatalogolibrosPK catalogolibrosPK;
    @Size(max = 2147483647)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogolibros")
    private Collection<Libro> libroCollection;
    @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PeriodoEscolar periodoEscolar;

    public Catalogolibros() {
    }

    public Catalogolibros(CatalogolibrosPK catalogolibrosPK) {
        this.catalogolibrosPK = catalogolibrosPK;
    }

    public Catalogolibros(int idPeriodoEscolar, String codigolibro) {
        this.catalogolibrosPK = new CatalogolibrosPK(idPeriodoEscolar, codigolibro);
    }

    public CatalogolibrosPK getCatalogolibrosPK() {
        return catalogolibrosPK;
    }

    public void setCatalogolibrosPK(CatalogolibrosPK catalogolibrosPK) {
        this.catalogolibrosPK = catalogolibrosPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Libro> getLibroCollection() {
        return libroCollection;
    }

    public void setLibroCollection(Collection<Libro> libroCollection) {
        this.libroCollection = libroCollection;
    }

    public PeriodoEscolar getPeriodoEscolar() {
        return periodoEscolar;
    }

    public void setPeriodoEscolar(PeriodoEscolar periodoEscolar) {
        this.periodoEscolar = periodoEscolar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catalogolibrosPK != null ? catalogolibrosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Catalogolibros)) {
            return false;
        }
        Catalogolibros other = (Catalogolibros) object;
        if ((this.catalogolibrosPK == null && other.catalogolibrosPK != null) || (this.catalogolibrosPK != null && !this.catalogolibrosPK.equals(other.catalogolibrosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Catalogolibros[ catalogolibrosPK=" + catalogolibrosPK + " ]";
    }
    
}
