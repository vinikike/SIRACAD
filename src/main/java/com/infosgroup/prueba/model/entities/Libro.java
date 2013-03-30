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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "libro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l"),
    @NamedQuery(name = "Libro.findByTitulo", query = "SELECT l FROM Libro l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libro.findByAutor", query = "SELECT l FROM Libro l WHERE l.autor = :autor"),
    @NamedQuery(name = "Libro.findByEditorial", query = "SELECT l FROM Libro l WHERE l.editorial = :editorial"),
    @NamedQuery(name = "Libro.findByPais", query = "SELECT l FROM Libro l WHERE l.pais = :pais"),
    @NamedQuery(name = "Libro.findByCantidad", query = "SELECT l FROM Libro l WHERE l.cantidad = :cantidad"),
    @NamedQuery(name = "Libro.findByIdPeriodoEscolar", query = "SELECT l FROM Libro l WHERE l.libroPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Libro.findByCodigo", query = "SELECT l FROM Libro l WHERE l.libroPK.codigo = :codigo"),
    @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio"),
    @NamedQuery(name = "Libro.findByClave", query = "SELECT l FROM Libro l WHERE l.clave = :clave")})
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LibroPK libroPK;
    @Size(max = 200)
    @Column(name = "titulo", length = 200)
    private String titulo;
    @Size(max = 200)
    @Column(name = "autor", length = 200)
    private String autor;
    @Size(max = 200)
    @Column(name = "editorial", length = 200)
    private String editorial;
    @Size(max = 200)
    @Column(name = "pais", length = 200)
    private String pais;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio", precision = 17, scale = 17)
    private Double precio;
    @Size(max = 5)
    @Column(name = "clave", length = 5)
    private String clave;
    @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PeriodoEscolar periodoEscolar;

    public Libro() {
    }

    public Libro(LibroPK libroPK) {
        this.libroPK = libroPK;
    }

    public Libro(int idPeriodoEscolar, String codigo) {
        this.libroPK = new LibroPK(idPeriodoEscolar, codigo);
    }

    public LibroPK getLibroPK() {
        return libroPK;
    }

    public void setLibroPK(LibroPK libroPK) {
        this.libroPK = libroPK;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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
        hash += (libroPK != null ? libroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.libroPK == null && other.libroPK != null) || (this.libroPK != null && !this.libroPK.equals(other.libroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Libro[ libroPK=" + libroPK + " ]";
    }
    
}
