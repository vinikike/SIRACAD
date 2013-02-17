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
@Table(name = "estado_familiar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoFamiliar.findAll", query = "SELECT e FROM EstadoFamiliar e"),
    @NamedQuery(name = "EstadoFamiliar.findByIdPeriodoEscolar", query = "SELECT e FROM EstadoFamiliar e WHERE e.estadoFamiliarPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "EstadoFamiliar.findByNie", query = "SELECT e FROM EstadoFamiliar e WHERE e.estadoFamiliarPK.nie = :nie"),
    @NamedQuery(name = "EstadoFamiliar.findByPadrenombre", query = "SELECT e FROM EstadoFamiliar e WHERE e.padrenombre = :padrenombre"),
    @NamedQuery(name = "EstadoFamiliar.findByPadreapellido", query = "SELECT e FROM EstadoFamiliar e WHERE e.padreapellido = :padreapellido"),
    @NamedQuery(name = "EstadoFamiliar.findByPadretelefono", query = "SELECT e FROM EstadoFamiliar e WHERE e.padretelefono = :padretelefono"),
    @NamedQuery(name = "EstadoFamiliar.findByMadrenombre", query = "SELECT e FROM EstadoFamiliar e WHERE e.madrenombre = :madrenombre"),
    @NamedQuery(name = "EstadoFamiliar.findByMadreapellido", query = "SELECT e FROM EstadoFamiliar e WHERE e.madreapellido = :madreapellido"),
    @NamedQuery(name = "EstadoFamiliar.findByMadretelefono", query = "SELECT e FROM EstadoFamiliar e WHERE e.madretelefono = :madretelefono")})
public class EstadoFamiliar implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstadoFamiliarPK estadoFamiliarPK;
    @Size(max = 50)
    @Column(name = "padrenombre")
    private String padrenombre;
    @Size(max = 50)
    @Column(name = "padreapellido")
    private String padreapellido;
    @Size(max = 50)
    @Column(name = "padretelefono")
    private String padretelefono;
    @Size(max = 50)
    @Column(name = "madrenombre")
    private String madrenombre;
    @Size(max = 50)
    @Column(name = "madreapellido")
    private String madreapellido;
    @Size(max = 50)
    @Column(name = "madretelefono")
    private String madretelefono;
    @JoinColumns({
        @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id_periodo_escolar", insertable = false, updatable = false),
        @JoinColumn(name = "nie", referencedColumnName = "nie", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Alumno alumno;

    public EstadoFamiliar() {
    }

    public EstadoFamiliar(EstadoFamiliarPK estadoFamiliarPK) {
        this.estadoFamiliarPK = estadoFamiliarPK;
    }

    public EstadoFamiliar(int idPeriodoEscolar, String nie) {
        this.estadoFamiliarPK = new EstadoFamiliarPK(idPeriodoEscolar, nie);
    }

    public EstadoFamiliarPK getEstadoFamiliarPK() {
        return estadoFamiliarPK;
    }

    public void setEstadoFamiliarPK(EstadoFamiliarPK estadoFamiliarPK) {
        this.estadoFamiliarPK = estadoFamiliarPK;
    }

    public String getPadrenombre() {
        return padrenombre;
    }

    public void setPadrenombre(String padrenombre) {
        this.padrenombre = padrenombre;
    }

    public String getPadreapellido() {
        return padreapellido;
    }

    public void setPadreapellido(String padreapellido) {
        this.padreapellido = padreapellido;
    }

    public String getPadretelefono() {
        return padretelefono;
    }

    public void setPadretelefono(String padretelefono) {
        this.padretelefono = padretelefono;
    }

    public String getMadrenombre() {
        return madrenombre;
    }

    public void setMadrenombre(String madrenombre) {
        this.madrenombre = madrenombre;
    }

    public String getMadreapellido() {
        return madreapellido;
    }

    public void setMadreapellido(String madreapellido) {
        this.madreapellido = madreapellido;
    }

    public String getMadretelefono() {
        return madretelefono;
    }

    public void setMadretelefono(String madretelefono) {
        this.madretelefono = madretelefono;
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
        hash += (estadoFamiliarPK != null ? estadoFamiliarPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoFamiliar)) {
            return false;
        }
        EstadoFamiliar other = (EstadoFamiliar) object;
        if ((this.estadoFamiliarPK == null && other.estadoFamiliarPK != null) || (this.estadoFamiliarPK != null && !this.estadoFamiliarPK.equals(other.estadoFamiliarPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.EstadoFamiliar[ estadoFamiliarPK=" + estadoFamiliarPK + " ]";
    }
    
}
