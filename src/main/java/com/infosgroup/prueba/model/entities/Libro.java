/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
    @NamedQuery(name = "Libro.findByCodigoCorrelativo", query = "SELECT l FROM Libro l WHERE l.libroPK.codigoCorrelativo = :codigoCorrelativo"),
    @NamedQuery(name = "Libro.findByPrecio", query = "SELECT l FROM Libro l WHERE l.precio = :precio"),
    @NamedQuery(name = "Libro.findByClave", query = "SELECT l FROM Libro l WHERE l.clave = :clave"),
    @NamedQuery(name = "Libro.findByCodigoCatalogo", query = "SELECT l FROM Libro l WHERE l.libroPK.codigoCatalogo = :codigoCatalogo"),
    @NamedQuery(name = "Libro.findByCodigoInstitucion", query = "SELECT l FROM Libro l WHERE l.libroPK.codigoInstitucion = :codigoInstitucion")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LibroPK libroPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "editorial")
    private String editorial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "clave")
    private String clave;
    @Column(name = "inicio")
    private Integer inicio;
    @Column(name = "fin")
    private Integer fin;
    @JoinColumns({
        @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id_periodo_escolar", insertable = false, updatable = false),
        @JoinColumn(name = "codigo_catalogo", referencedColumnName = "codigolibro", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogolibros catalogolibros;

    public Libro() {
    }

    public Libro(LibroPK libroPK) {
        this.libroPK = libroPK;
    }

    public Libro(LibroPK libroPK, String titulo, String autor, String editorial, String pais, int cantidad, double precio, String clave) {
        this.libroPK = libroPK;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.pais = pais;
        this.cantidad = cantidad;
        this.precio = precio;
        this.clave = clave;
    }

    public Libro(int idPeriodoEscolar, String codigoCorrelativo, String codigoCatalogo, String codigoInstitucion) {
        this.libroPK = new LibroPK(idPeriodoEscolar, codigoCorrelativo, codigoCatalogo, codigoInstitucion);
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Catalogolibros getCatalogolibros() {
        return catalogolibros;
    }

    public void setCatalogolibros(Catalogolibros catalogolibros) {
        this.catalogolibros = catalogolibros;
    }

    public Integer getInicio() {
        return inicio;
    }

    public void setInicio(Integer inicio) {
        this.inicio = inicio;
    }

    public Integer getFin() {
        return fin;
    }

    public void setFin(Integer fin) {
        this.fin = fin;
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
