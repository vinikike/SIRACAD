/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "activofijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activofijo.findAll", query = "SELECT a FROM Activofijo a"),
    @NamedQuery(name = "Activofijo.findByTipoCargo", query = "SELECT a FROM Activofijo a WHERE a.tipoCargo = :tipoCargo"),
    @NamedQuery(name = "Activofijo.findByCodigoInstitucion", query = "SELECT a FROM Activofijo a WHERE a.activofijoPK.codigoInstitucion = :codigoInstitucion"),
    @NamedQuery(name = "Activofijo.findByCaracteristica", query = "SELECT a FROM Activofijo a WHERE a.caracteristica = :caracteristica"),
    @NamedQuery(name = "Activofijo.findByEstadoFisico", query = "SELECT a FROM Activofijo a WHERE a.estadoFisico = :estadoFisico"),
    @NamedQuery(name = "Activofijo.findByFechaAquision", query = "SELECT a FROM Activofijo a WHERE a.fechaAquision = :fechaAquision"),
    @NamedQuery(name = "Activofijo.findByValorUnitario", query = "SELECT a FROM Activofijo a WHERE a.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Activofijo.findByCantidad", query = "SELECT a FROM Activofijo a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "Activofijo.findByValorTotal", query = "SELECT a FROM Activofijo a WHERE a.valorTotal = :valorTotal"),
    @NamedQuery(name = "Activofijo.findByClave", query = "SELECT a FROM Activofijo a WHERE a.clave = :clave"),
    @NamedQuery(name = "Activofijo.findByIdPeriododEscolar", query = "SELECT a FROM Activofijo a WHERE a.activofijoPK.idPeriododEscolar = :idPeriododEscolar"),
    @NamedQuery(name = "Activofijo.findByCodigoCatalogo", query = "SELECT a FROM Activofijo a WHERE a.activofijoPK.codigoCatalogo = :codigoCatalogo"),
    @NamedQuery(name = "Activofijo.findByCodigoCorrelativo", query = "SELECT a FROM Activofijo a WHERE a.activofijoPK.codigoCorrelativo = :codigoCorrelativo")})
public class Activofijo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActivofijoPK activofijoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo_cargo")
    private String tipoCargo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "caracteristica")
    private String caracteristica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "estado_fisico")
    private String estadoFisico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_aquision")
    @Temporal(TemporalType.DATE)
    private Date fechaAquision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_unitario")
    private int valorUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor_total")
    private int valorTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "clave")
    private String clave;

    public Activofijo() {
    }

    public Activofijo(ActivofijoPK activofijoPK) {
        this.activofijoPK = activofijoPK;
    }

    public Activofijo(ActivofijoPK activofijoPK, String tipoCargo, String caracteristica, String estadoFisico, Date fechaAquision, int valorUnitario, int cantidad, int valorTotal, String clave) {
        this.activofijoPK = activofijoPK;
        this.tipoCargo = tipoCargo;
        this.caracteristica = caracteristica;
        this.estadoFisico = estadoFisico;
        this.fechaAquision = fechaAquision;
        this.valorUnitario = valorUnitario;
        this.cantidad = cantidad;
        this.valorTotal = valorTotal;
        this.clave = clave;
    }

    public Activofijo(String codigoInstitucion, String idPeriododEscolar, int codigoCatalogo, int codigoCorrelativo) {
        this.activofijoPK = new ActivofijoPK(codigoInstitucion, idPeriododEscolar, codigoCatalogo, codigoCorrelativo);
    }

    public ActivofijoPK getActivofijoPK() {
        return activofijoPK;
    }

    public void setActivofijoPK(ActivofijoPK activofijoPK) {
        this.activofijoPK = activofijoPK;
    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getEstadoFisico() {
        return estadoFisico;
    }

    public void setEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
    }

    public Date getFechaAquision() {
        return fechaAquision;
    }

    public void setFechaAquision(Date fechaAquision) {
        this.fechaAquision = fechaAquision;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activofijoPK != null ? activofijoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activofijo)) {
            return false;
        }
        Activofijo other = (Activofijo) object;
        if ((this.activofijoPK == null && other.activofijoPK != null) || (this.activofijoPK != null && !this.activofijoPK.equals(other.activofijoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Activofijo[ activofijoPK=" + activofijoPK + " ]";
    }
    
}
