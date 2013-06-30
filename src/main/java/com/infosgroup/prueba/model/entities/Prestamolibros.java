/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "prestamolibros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamolibros.findAll", query = "SELECT p FROM Prestamolibros p"),
    @NamedQuery(name = "Prestamolibros.findByCodprestamo", query = "SELECT p FROM Prestamolibros p WHERE p.codprestamo = :codprestamo"),
    @NamedQuery(name = "Prestamolibros.findByNombrelibro", query = "SELECT p FROM Prestamolibros p WHERE p.nombrelibro = :nombrelibro"),
    @NamedQuery(name = "Prestamolibros.findByCodigo", query = "SELECT p FROM Prestamolibros p WHERE p.codigo = :codigo"),
    @NamedQuery(name = "Prestamolibros.findByCantidad", query = "SELECT p FROM Prestamolibros p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Prestamolibros.findByTipopresona", query = "SELECT p FROM Prestamolibros p WHERE p.tipopresona = :tipopresona"),
    @NamedQuery(name = "Prestamolibros.findByGrado", query = "SELECT p FROM Prestamolibros p WHERE p.grado = :grado"),
    @NamedQuery(name = "Prestamolibros.findByNombre", query = "SELECT p FROM Prestamolibros p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Prestamolibros.findByFechaprestamo", query = "SELECT p FROM Prestamolibros p WHERE p.fechaprestamo = :fechaprestamo"),
    @NamedQuery(name = "Prestamolibros.findByFechadevolucion", query = "SELECT p FROM Prestamolibros p WHERE p.fechadevolucion = :fechadevolucion"),
    @NamedQuery(name = "Prestamolibros.findByEstado", query = "SELECT p FROM Prestamolibros p WHERE p.estado = :estado")})
public class Prestamolibros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codprestamo")
    private Integer codprestamo;
    @Size(max = 2147483647)
    @Column(name = "nombrelibro")
    private String nombrelibro;
    @Size(max = 2147483647)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Size(max = 2147483647)
    @Column(name = "tipopresona")
    private String tipopresona;
    @Size(max = 2147483647)
    @Column(name = "grado")
    private String grado;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fechaprestamo")
    @Temporal(TemporalType.DATE)
    private Date fechaprestamo;
    @Column(name = "fechadevolucion")
    @Temporal(TemporalType.DATE)
    private Date fechadevolucion;
    @Size(max = 2147483647)
    @Column(name = "estado")
    private String estado;

    public Prestamolibros() {
    }

    public Prestamolibros(Integer codprestamo) {
        this.codprestamo = codprestamo;
    }

    public Integer getCodprestamo() {
        return codprestamo;
    }

    public void setCodprestamo(Integer codprestamo) {
        this.codprestamo = codprestamo;
    }

    public String getNombrelibro() {
        return nombrelibro;
    }

    public void setNombrelibro(String nombrelibro) {
        this.nombrelibro = nombrelibro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipopresona() {
        return tipopresona;
    }

    public void setTipopresona(String tipopresona) {
        this.tipopresona = tipopresona;
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

    public Date getFechaprestamo() {
        return fechaprestamo;
    }

    public void setFechaprestamo(Date fechaprestamo) {
        this.fechaprestamo = fechaprestamo;
    }

    public Date getFechadevolucion() {
        return fechadevolucion;
    }

    public void setFechadevolucion(Date fechadevolucion) {
        this.fechadevolucion = fechadevolucion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codprestamo != null ? codprestamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamolibros)) {
            return false;
        }
        Prestamolibros other = (Prestamolibros) object;
        if ((this.codprestamo == null && other.codprestamo != null) || (this.codprestamo != null && !this.codprestamo.equals(other.codprestamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Prestamolibros[ codprestamo=" + codprestamo + " ]";
    }
    
}
