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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Guille
 */
@Entity
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findById", query = "SELECT d FROM Docente d WHERE d.id = :id"),
    @NamedQuery(name = "Docente.findByDocenteNip", query = "SELECT d FROM Docente d WHERE d.docenteNip = :docenteNip"),
    @NamedQuery(name = "Docente.findByNombre", query = "SELECT d FROM Docente d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Docente.findByNivelEscalafon", query = "SELECT d FROM Docente d WHERE d.nivelEscalafon = :nivelEscalafon"),
    @NamedQuery(name = "Docente.findByEspecialidad", query = "SELECT d FROM Docente d WHERE d.especialidad = :especialidad"),
    @NamedQuery(name = "Docente.findByJornadamatutino", query = "SELECT d FROM Docente d WHERE d.jornadamatutino = :jornadamatutino"),
    @NamedQuery(name = "Docente.findByDireccion", query = "SELECT d FROM Docente d WHERE d.direccion = :direccion"),
    @NamedQuery(name = "Docente.findByTelefono", query = "SELECT d FROM Docente d WHERE d.telefono = :telefono"),
    @NamedQuery(name = "Docente.findByCelular", query = "SELECT d FROM Docente d WHERE d.celular = :celular"),
    @NamedQuery(name = "Docente.findByJornadavespertino", query = "SELECT d FROM Docente d WHERE d.jornadavespertino = :jornadavespertino"),
    @NamedQuery(name = "Docente.findByJornadanocturno", query = "SELECT d FROM Docente d WHERE d.jornadanocturno = :jornadanocturno"),
    @NamedQuery(name = "Docente.findByDui", query = "SELECT d FROM Docente d WHERE d.dui = :dui")})
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "id")
    private String id;
    @Size(max = 2147483647)
    @Column(name = "docente_nip")
    private String docenteNip;
    @Size(max = 2147483647)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 2147483647)
    @Column(name = "nivel_escalafon")
    private String nivelEscalafon;
    @Size(max = 2147483647)
    @Column(name = "especialidad")
    private String especialidad;
    @Size(max = 2147483647)
    @Column(name = "jornadamatutino")
    private String jornadamatutino;
    @Size(max = 2147483647)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 2147483647)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 2147483647)
    @Column(name = "celular")
    private String celular;
    @Size(max = 2147483647)
    @Column(name = "jornadavespertino")
    private String jornadavespertino;
    @Size(max = 2147483647)
    @Column(name = "jornadanocturno")
    private String jornadanocturno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "dui")
    private String dui;
    @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PeriodoEscolar idPeriodoEscolar;

    public Docente() {
    }

    public Docente(String id) {
        this.id = id;
    }

    public Docente(String id, String dui) {
        this.id = id;
        this.dui = dui;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDocenteNip() {
        return docenteNip;
    }

    public void setDocenteNip(String docenteNip) {
        this.docenteNip = docenteNip;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelEscalafon() {
        return nivelEscalafon;
    }

    public void setNivelEscalafon(String nivelEscalafon) {
        this.nivelEscalafon = nivelEscalafon;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getJornadamatutino() {
        return jornadamatutino;
    }

    public void setJornadamatutino(String jornadamatutino) {
        this.jornadamatutino = jornadamatutino;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getJornadavespertino() {
        return jornadavespertino;
    }

    public void setJornadavespertino(String jornadavespertino) {
        this.jornadavespertino = jornadavespertino;
    }

    public String getJornadanocturno() {
        return jornadanocturno;
    }

    public void setJornadanocturno(String jornadanocturno) {
        this.jornadanocturno = jornadanocturno;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public PeriodoEscolar getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(PeriodoEscolar idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
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
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Docente[ id=" + id + " ]";
    }
    // ===========================================
    @Transient
    private String jornadas;
    
    public String getJornadas() {
        jornadas = "";
        if (getJornadamatutino() != null) {
            jornadas += "Matutino ";
}
        if (getJornadavespertino() != null) {
            jornadas += "Verpertino ";
        }
        if (getJornadanocturno() != null) {
            jornadas += "Nocturno";
        }
        return jornadas;
    }

    public void setJornadas(String jornadas) {
        this.jornadas = jornadas;
    }
}
