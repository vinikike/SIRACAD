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
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "tallas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tallas.findAll", query = "SELECT t FROM Tallas t"),
    @NamedQuery(name = "Tallas.findByIdPeriodoEscolar", query = "SELECT t FROM Tallas t WHERE t.tallasPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Tallas.findByNie", query = "SELECT t FROM Tallas t WHERE t.tallasPK.nie = :nie"),
    @NamedQuery(name = "Tallas.findByTallasuperior", query = "SELECT t FROM Tallas t WHERE t.tallasuperior = :tallasuperior"),
    @NamedQuery(name = "Tallas.findByTallainferior", query = "SELECT t FROM Tallas t WHERE t.tallainferior = :tallainferior"),
    @NamedQuery(name = "Tallas.findByTallacalzado", query = "SELECT t FROM Tallas t WHERE t.tallacalzado = :tallacalzado")})
public class Tallas implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TallasPK tallasPK;
    @Size(max = 2147483647)
    @Column(name = "tallasuperior", length = 2147483647)
    private String tallasuperior;
    @Size(max = 2147483647)
    @Column(name = "tallainferior", length = 2147483647)
    private String tallainferior;
    @Column(name = "tallacalzado")
    private Integer tallacalzado;
    @JoinColumns({
        @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id_periodo_escolar", nullable = false, insertable = false, updatable = false),
        @JoinColumn(name = "nie", referencedColumnName = "nie", nullable = false, insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Alumno alumno;

    public Tallas() {
    }

    public Tallas(TallasPK tallasPK) {
        this.tallasPK = tallasPK;
    }

    public Tallas(int idPeriodoEscolar, String nie) {
        this.tallasPK = new TallasPK(idPeriodoEscolar, nie);
    }

    public TallasPK getTallasPK() {
        return tallasPK;
    }

    public void setTallasPK(TallasPK tallasPK) {
        this.tallasPK = tallasPK;
    }

    public String getTallasuperior() {
        return tallasuperior;
    }

    public void setTallasuperior(String tallasuperior) {
        this.tallasuperior = tallasuperior;
    }

    public String getTallainferior() {
        return tallainferior;
    }

    public void setTallainferior(String tallainferior) {
        this.tallainferior = tallainferior;
    }

    public Integer getTallacalzado() {
        return tallacalzado;
    }

    public void setTallacalzado(Integer tallacalzado) {
        this.tallacalzado = tallacalzado;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tallasPK != null ? tallasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tallas)) {
            return false;
        }
        Tallas other = (Tallas) object;
        if ((this.tallasPK == null && other.tallasPK != null) || (this.tallasPK != null && !this.tallasPK.equals(other.tallasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Tallas[ tallasPK=" + tallasPK + " ]";
    }
    
}
