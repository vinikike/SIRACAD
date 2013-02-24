/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "lista_grados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListaGrados.findAll", query = "SELECT l FROM ListaGrados l"),
    @NamedQuery(name = "ListaGrados.findByIdGrado", query = "SELECT l FROM ListaGrados l WHERE l.idGrado = :idGrado"),
    @NamedQuery(name = "ListaGrados.findByGrado", query = "SELECT l FROM ListaGrados l WHERE l.grado = :grado"),
    @NamedQuery(name = "ListaGrados.findByNombre", query = "SELECT l FROM ListaGrados l WHERE l.nombre = :nombre"),
    @NamedQuery(name = "ListaGrados.findByOpcion", query = "SELECT l FROM ListaGrados l WHERE l.opcion = :opcion")})
public class ListaGrados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_grado", nullable = false)
    private Integer idGrado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "grado", nullable = false, length = 2147483647)
    private String grado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nombre", nullable = false, length = 2147483647)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "opcion", nullable = false, length = 2147483647)
    private String opcion;
    @JoinColumn(name = "nivel", referencedColumnName = "id_nivel")
    @ManyToOne
    private Nivel nivel;

    public ListaGrados() {
    }

    public ListaGrados(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public ListaGrados(Integer idGrado, String grado, String nombre, String opcion) {
        this.idGrado = idGrado;
        this.grado = grado;
        this.nombre = nombre;
        this.opcion = opcion;
    }

    public Integer getIdGrado() {
        return idGrado;
    }

    public void setIdGrado(Integer idGrado) {
        this.idGrado = idGrado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrado != null ? idGrado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListaGrados)) {
            return false;
        }
        ListaGrados other = (ListaGrados) object;
        if ((this.idGrado == null && other.idGrado != null) || (this.idGrado != null && !this.idGrado.equals(other.idGrado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.ListaGrados[ idGrado=" + idGrado + " ]";
    }
    
}
