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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "activofijo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activofijo.findAll", query = "SELECT a FROM Activofijo a"),
    @NamedQuery(name = "Activofijo.findByTipocargo", query = "SELECT a FROM Activofijo a WHERE a.tipocargo = :tipocargo"),
    @NamedQuery(name = "Activofijo.findByCodigoinstitucion", query = "SELECT a FROM Activofijo a WHERE a.activofijoPK.codigoinstitucion = :codigoinstitucion"),
    @NamedQuery(name = "Activofijo.findByCaracteristicas", query = "SELECT a FROM Activofijo a WHERE a.caracteristicas = :caracteristicas"),
    @NamedQuery(name = "Activofijo.findByEstadofisico", query = "SELECT a FROM Activofijo a WHERE a.estadofisico = :estadofisico"),
    @NamedQuery(name = "Activofijo.findByFechaaquision", query = "SELECT a FROM Activofijo a WHERE a.fechaaquision = :fechaaquision"),
    @NamedQuery(name = "Activofijo.findByValorunitario", query = "SELECT a FROM Activofijo a WHERE a.valorunitario = :valorunitario"),
    @NamedQuery(name = "Activofijo.findByCantidad", query = "SELECT a FROM Activofijo a WHERE a.cantidad = :cantidad"),
    @NamedQuery(name = "Activofijo.findByValortotal", query = "SELECT a FROM Activofijo a WHERE a.valortotal = :valortotal"),
    @NamedQuery(name = "Activofijo.findByClave", query = "SELECT a FROM Activofijo a WHERE a.clave = :clave"),
    @NamedQuery(name = "Activofijo.findByIdperiodoescolar", query = "SELECT a FROM Activofijo a WHERE a.activofijoPK.idperiodoescolar = :idperiodoescolar"),
    @NamedQuery(name = "Activofijo.findByCodigocatalogo", query = "SELECT a FROM Activofijo a WHERE a.activofijoPK.codigocatalogo = :codigocatalogo"),
    @NamedQuery(name = "Activofijo.findByCodigocorrelativo", query = "SELECT a FROM Activofijo a WHERE a.activofijoPK.codigocorrelativo = :codigocorrelativo"),
    @NamedQuery(name = "Activofijo.findByInicio", query = "SELECT a FROM Activofijo a WHERE a.inicio = :inicio"),
    @NamedQuery(name = "Activofijo.findByFin", query = "SELECT a FROM Activofijo a WHERE a.fin = :fin")})
public class Activofijo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ActivofijoPK activofijoPK;
    @Size(max = 2147483647)
    @Column(name = "tipocargo")
    private String tipocargo;
    @Size(max = 2147483647)
    @Column(name = "caracteristicas")
    private String caracteristicas;
    @Size(max = 2147483647)
    @Column(name = "estadofisico")
    private String estadofisico;
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
    @Size(max = 2147483647)
    @Column(name = "clave")
    private String clave;
    @Column(name = "inicio")
    private Integer inicio;
    @Column(name = "fin")
    private Integer fin;
    @JoinColumns({
        @JoinColumn(name = "idperiodoescolar", referencedColumnName = "id_periodo_escolar", insertable = false, updatable = false),
        @JoinColumn(name = "codigocatalogo", referencedColumnName = "codigoactivo", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Catalogoactivo catalogoactivo;

    public Activofijo() {
    }

    public Activofijo(ActivofijoPK activofijoPK) {
        this.activofijoPK = activofijoPK;
    }

    public Activofijo(String codigoinstitucion, int idperiodoescolar, String codigocatalogo, String codigocorrelativo) {
        this.activofijoPK = new ActivofijoPK(codigoinstitucion, idperiodoescolar, codigocatalogo, codigocorrelativo);
    }

    public ActivofijoPK getActivofijoPK() {
        return activofijoPK;
    }

    public void setActivofijoPK(ActivofijoPK activofijoPK) {
        this.activofijoPK = activofijoPK;
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

    public String getEstadofisico() {
        return estadofisico;
    }

    public void setEstadofisico(String estadofisico) {
        this.estadofisico = estadofisico;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public Catalogoactivo getCatalogoactivo() {
        return catalogoactivo;
    }

    public void setCatalogoactivo(Catalogoactivo catalogoactivo) {
        this.catalogoactivo = catalogoactivo;
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
