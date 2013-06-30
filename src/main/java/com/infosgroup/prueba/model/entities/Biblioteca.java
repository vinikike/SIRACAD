/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "biblioteca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biblioteca.findAll", query = "SELECT b FROM Biblioteca b"),
    @NamedQuery(name = "Biblioteca.findByTitulo", query = "SELECT b FROM Biblioteca b WHERE b.titulo = :titulo"),
    @NamedQuery(name = "Biblioteca.findByAutor", query = "SELECT b FROM Biblioteca b WHERE b.autor = :autor"),
    @NamedQuery(name = "Biblioteca.findByEditorial", query = "SELECT b FROM Biblioteca b WHERE b.editorial = :editorial"),
    @NamedQuery(name = "Biblioteca.findByPais", query = "SELECT b FROM Biblioteca b WHERE b.pais = :pais"),
    @NamedQuery(name = "Biblioteca.findByCantidad", query = "SELECT b FROM Biblioteca b WHERE b.cantidad = :cantidad"),
    @NamedQuery(name = "Biblioteca.findByIdPeriodoEscolar", query = "SELECT b FROM Biblioteca b WHERE b.bibliotecaPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Biblioteca.findByCodigoCorrelativo", query = "SELECT b FROM Biblioteca b WHERE b.bibliotecaPK.codigoCorrelativo = :codigoCorrelativo"),
    @NamedQuery(name = "Biblioteca.findByCodigoCatalogo", query = "SELECT b FROM Biblioteca b WHERE b.bibliotecaPK.codigoCatalogo = :codigoCatalogo"),
    @NamedQuery(name = "Biblioteca.findByCodigoInstitucion", query = "SELECT b FROM Biblioteca b WHERE b.bibliotecaPK.codigoInstitucion = :codigoInstitucion"),
    @NamedQuery(name = "Biblioteca.findByInicio", query = "SELECT b FROM Biblioteca b WHERE b.inicio = :inicio"),
    @NamedQuery(name = "Biblioteca.findByFin", query = "SELECT b FROM Biblioteca b WHERE b.fin = :fin")})
public class Biblioteca implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BibliotecaPK bibliotecaPK;
    @Size(max = 200)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 200)
    @Column(name = "autor")
    private String autor;
    @Size(max = 200)
    @Column(name = "editorial")
    private String editorial;
    @Size(max = 200)
    @Column(name = "pais")
    private String pais;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "inicio")
    private Integer inicio;
    @Column(name = "fin")
    private Integer fin;

    public Biblioteca() {
    }

    public Biblioteca(BibliotecaPK bibliotecaPK) {
        this.bibliotecaPK = bibliotecaPK;
    }

    public Biblioteca(int idPeriodoEscolar, int codigoCorrelativo, String codigoCatalogo, String codigoInstitucion) {
        this.bibliotecaPK = new BibliotecaPK(idPeriodoEscolar, codigoCorrelativo, codigoCatalogo, codigoInstitucion);
    }

    public BibliotecaPK getBibliotecaPK() {
        return bibliotecaPK;
    }

    public void setBibliotecaPK(BibliotecaPK bibliotecaPK) {
        this.bibliotecaPK = bibliotecaPK;
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
        hash += (bibliotecaPK != null ? bibliotecaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biblioteca)) {
            return false;
        }
        Biblioteca other = (Biblioteca) object;
        if ((this.bibliotecaPK == null && other.bibliotecaPK != null) || (this.bibliotecaPK != null && !this.bibliotecaPK.equals(other.bibliotecaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Biblioteca[ bibliotecaPK=" + bibliotecaPK + " ]";
    }
    
}
