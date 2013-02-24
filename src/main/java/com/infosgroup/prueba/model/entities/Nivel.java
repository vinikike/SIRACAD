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
@Table(name = "nivel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nivel.findAll", query = "SELECT n FROM Nivel n"),
    @NamedQuery(name = "Nivel.findByIdNivel", query = "SELECT n FROM Nivel n WHERE n.idNivel = :idNivel"),
    @NamedQuery(name = "Nivel.findByDescripcion", query = "SELECT n FROM Nivel n WHERE n.descripcion = :descripcion"),
    @NamedQuery(name = "Nivel.findByNivel", query = "SELECT n FROM Nivel n WHERE n.nivel = :nivel")})
public class Nivel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nivel", nullable = false)
    private Integer idNivel;
    @Size(max = 50)
    @Column(name = "descripcion", length = 50)
    private String descripcion;
    @Size(max = 50)
    @Column(name = "nivel", length = 50)
    private String nivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nivel")
    private List<Periodo> periodoList;
    @OneToMany(mappedBy = "nivel")
    private List<ListaGrados> listaGradosList;

    public Nivel() {
    }

    public Nivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public List<Periodo> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(List<Periodo> periodoList) {
        this.periodoList = periodoList;
    }

    @XmlTransient
    public List<ListaGrados> getListaGradosList() {
        return listaGradosList;
    }

    public void setListaGradosList(List<ListaGrados> listaGradosList) {
        this.listaGradosList = listaGradosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNivel != null ? idNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nivel)) {
            return false;
        }
        Nivel other = (Nivel) object;
        if ((this.idNivel == null && other.idNivel != null) || (this.idNivel != null && !this.idNivel.equals(other.idNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Nivel[ idNivel=" + idNivel + " ]";
    }
    
}
