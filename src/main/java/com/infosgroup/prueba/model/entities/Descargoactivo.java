/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "descargoactivo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descargoactivo.findAll", query = "SELECT d FROM Descargoactivo d"),
    @NamedQuery(name = "Descargoactivo.findByTipocargo", query = "SELECT d FROM Descargoactivo d WHERE d.tipocargo = :tipocargo"),
    @NamedQuery(name = "Descargoactivo.findByCodigoinstitucion", query = "SELECT d FROM Descargoactivo d WHERE d.descargoactivoPK.codigoinstitucion = :codigoinstitucion"),
    @NamedQuery(name = "Descargoactivo.findByCaracteristicas", query = "SELECT d FROM Descargoactivo d WHERE d.caracteristicas = :caracteristicas"),
    @NamedQuery(name = "Descargoactivo.findByFechaaquision", query = "SELECT d FROM Descargoactivo d WHERE d.fechaaquision = :fechaaquision"),
    @NamedQuery(name = "Descargoactivo.findByValorunitario", query = "SELECT d FROM Descargoactivo d WHERE d.valorunitario = :valorunitario"),
    @NamedQuery(name = "Descargoactivo.findByCantidad", query = "SELECT d FROM Descargoactivo d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "Descargoactivo.findByValortotal", query = "SELECT d FROM Descargoactivo d WHERE d.valortotal = :valortotal"),
    @NamedQuery(name = "Descargoactivo.findByIdperiodoescolar", query = "SELECT d FROM Descargoactivo d WHERE d.descargoactivoPK.idperiodoescolar = :idperiodoescolar"),
    @NamedQuery(name = "Descargoactivo.findByCodigocatalogo", query = "SELECT d FROM Descargoactivo d WHERE d.descargoactivoPK.codigocatalogo = :codigocatalogo"),
    @NamedQuery(name = "Descargoactivo.findByCodigocorrelativo", query = "SELECT d FROM Descargoactivo d WHERE d.descargoactivoPK.codigocorrelativo = :codigocorrelativo")})
public class Descargoactivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DescargoactivoPK descargoactivoPK;
    @Size(max = 2147483647)
    @Column(name = "tipocargo")
    private String tipocargo;
    @Size(max = 2147483647)
    @Column(name = "caracteristicas")
    private String caracteristicas;
    @Column(name = "fechaaquision")
    @Temporal(TemporalType.DATE)
    private Date fechaaquision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorunitario")
    private Double valorunitario;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "valortotal")
    private Double valortotal;

    public Descargoactivo() {
    }

    public Descargoactivo(DescargoactivoPK descargoactivoPK) {
        this.descargoactivoPK = descargoactivoPK;
    }

    public Descargoactivo(String codigoinstitucion, int idperiodoescolar, String codigocatalogo, String codigocorrelativo) {
        this.descargoactivoPK = new DescargoactivoPK(codigoinstitucion, idperiodoescolar, codigocatalogo, codigocorrelativo);
    }

    public DescargoactivoPK getDescargoactivoPK() {
        return descargoactivoPK;
    }

    public void setDescargoactivoPK(DescargoactivoPK descargoactivoPK) {
        this.descargoactivoPK = descargoactivoPK;
    }

    public String getTipocargo() {
        return tipocargo;
    }

    public void setTipocargo(String tipocargo) {
        this.tipocargo = tipocargo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Date getFechaaquision() {
        return fechaaquision;
    }

    public void setFechaaquision(Date fechaaquision) {
        this.fechaaquision = fechaaquision;
    }

    public Double getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(Double valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (descargoactivoPK != null ? descargoactivoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descargoactivo)) {
            return false;
        }
        Descargoactivo other = (Descargoactivo) object;
        if ((this.descargoactivoPK == null && other.descargoactivoPK != null) || (this.descargoactivoPK != null && !this.descargoactivoPK.equals(other.descargoactivoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Descargoactivo[ descargoactivoPK=" + descargoactivoPK + " ]";
    }
    
}
