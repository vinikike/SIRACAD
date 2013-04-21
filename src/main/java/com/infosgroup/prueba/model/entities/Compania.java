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
@Table(name = "compania")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compania.findAll", query = "SELECT c FROM Compania c"),
    @NamedQuery(name = "Compania.findById", query = "SELECT c FROM Compania c WHERE c.id = :id"),
    @NamedQuery(name = "Compania.findByNombre", query = "SELECT c FROM Compania c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Compania.findByCodigo", query = "SELECT c FROM Compania c WHERE c.codigo = :codigo"),
    @NamedQuery(name = "Compania.findByDistrito", query = "SELECT c FROM Compania c WHERE c.distrito = :distrito"),
    @NamedQuery(name = "Compania.findByDireccion", query = "SELECT c FROM Compania c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Compania.findByDepartamento", query = "SELECT c FROM Compania c WHERE c.departamento = :departamento"),
    @NamedQuery(name = "Compania.findByMunicipio", query = "SELECT c FROM Compania c WHERE c.municipio = :municipio"),
    @NamedQuery(name = "Compania.findByTelefono", query = "SELECT c FROM Compania c WHERE c.telefono = :telefono")})
public class Compania implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 100)
    @Column(name = "nombre", length = 100)
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "codigo", length = 2147483647)
    private String codigo;
    @Size(max = 2147483647)
    @Column(name = "distrito", length = 2147483647)
    private String distrito;
    @Size(max = 2147483647)
    @Column(name = "direccion", length = 2147483647)
    private String direccion;
    @Size(max = 2147483647)
    @Column(name = "departamento", length = 2147483647)
    private String departamento;
    @Size(max = 2147483647)
    @Column(name = "municipio", length = 2147483647)
    private String municipio;
    @Size(max = 2147483647)
    @Column(name = "telefono", length = 2147483647)
    private String telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "compania")
    private List<Usuario> usuarioList;

    public Compania() {
    }

    public Compania(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        if (!(object instanceof Compania)) {
            return false;
        }
        Compania other = (Compania) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Compania[ id=" + id + " ]";
    }
    
}
