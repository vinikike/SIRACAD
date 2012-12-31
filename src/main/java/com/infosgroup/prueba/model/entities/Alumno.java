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
@Table(name = "alumno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumno.findAll", query = "SELECT a FROM Alumno a"),
    @NamedQuery(name = "Alumno.findByIdPeriodoEscolar", query = "SELECT a FROM Alumno a WHERE a.alumnoPK.idPeriodoEscolar = :idPeriodoEscolar"),
    @NamedQuery(name = "Alumno.findByNie", query = "SELECT a FROM Alumno a WHERE a.alumnoPK.nie = :nie"),
    @NamedQuery(name = "Alumno.findByNombres", query = "SELECT a FROM Alumno a WHERE a.nombres = :nombres"),
    @NamedQuery(name = "Alumno.findByApellidos", query = "SELECT a FROM Alumno a WHERE a.apellidos = :apellidos"),
    @NamedQuery(name = "Alumno.findByLugarnacimiento", query = "SELECT a FROM Alumno a WHERE a.lugarnacimiento = :lugarnacimiento"),
    @NamedQuery(name = "Alumno.findByFechanacimiento", query = "SELECT a FROM Alumno a WHERE a.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Alumno.findByEdad", query = "SELECT a FROM Alumno a WHERE a.edad = :edad"),
    @NamedQuery(name = "Alumno.findByDireccion", query = "SELECT a FROM Alumno a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Alumno.findByZonaResidencia", query = "SELECT a FROM Alumno a WHERE a.zonaResidencia = :zonaResidencia"),
    @NamedQuery(name = "Alumno.findByEstadoFamiliar", query = "SELECT a FROM Alumno a WHERE a.estadoFamiliar = :estadoFamiliar"),
    @NamedQuery(name = "Alumno.findByNombrePadre", query = "SELECT a FROM Alumno a WHERE a.nombrePadre = :nombrePadre"),
    @NamedQuery(name = "Alumno.findByTelPadre", query = "SELECT a FROM Alumno a WHERE a.telPadre = :telPadre"),
    @NamedQuery(name = "Alumno.findByNombreMadre", query = "SELECT a FROM Alumno a WHERE a.nombreMadre = :nombreMadre"),
    @NamedQuery(name = "Alumno.findByTelMadre", query = "SELECT a FROM Alumno a WHERE a.telMadre = :telMadre")})
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlumnoPK alumnoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos", nullable = false, length = 50)
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lugarnacimiento", nullable = false, length = 50)
    private String lugarnacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "fechanacimiento", nullable = false, length = 50)
    private String fechanacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad", nullable = false)
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "zona_residencia", nullable = false, length = 50)
    private String zonaResidencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado_familiar", nullable = false, length = 50)
    private String estadoFamiliar;
    @Size(max = 100)
    @Column(name = "nombre_padre", length = 100)
    private String nombrePadre;
    @Column(name = "tel_padre")
    private Integer telPadre;
    @Size(max = 100)
    @Column(name = "nombre_madre", length = 100)
    private String nombreMadre;
    @Column(name = "tel_madre")
    private Integer telMadre;
    @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PeriodoEscolar periodoEscolar;

    public Alumno() {
    }

    public Alumno(AlumnoPK alumnoPK) {
        this.alumnoPK = alumnoPK;
    }

    public Alumno(AlumnoPK alumnoPK, String nombres, String apellidos, String lugarnacimiento, String fechanacimiento, int edad, String direccion, String zonaResidencia, String estadoFamiliar) {
        this.alumnoPK = alumnoPK;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.lugarnacimiento = lugarnacimiento;
        this.fechanacimiento = fechanacimiento;
        this.edad = edad;
        this.direccion = direccion;
        this.zonaResidencia = zonaResidencia;
        this.estadoFamiliar = estadoFamiliar;
    }

    public Alumno(int idPeriodoEscolar, String nie) {
        this.alumnoPK = new AlumnoPK(idPeriodoEscolar, nie);
    }

    public AlumnoPK getAlumnoPK() {
        return alumnoPK;
    }

    public void setAlumnoPK(AlumnoPK alumnoPK) {
        this.alumnoPK = alumnoPK;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getZonaResidencia() {
        return zonaResidencia;
    }

    public void setZonaResidencia(String zonaResidencia) {
        this.zonaResidencia = zonaResidencia;
    }

    public String getEstadoFamiliar() {
        return estadoFamiliar;
    }

    public void setEstadoFamiliar(String estadoFamiliar) {
        this.estadoFamiliar = estadoFamiliar;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public Integer getTelPadre() {
        return telPadre;
    }

    public void setTelPadre(Integer telPadre) {
        this.telPadre = telPadre;
    }

    public String getNombreMadre() {
        return nombreMadre;
    }

    public void setNombreMadre(String nombreMadre) {
        this.nombreMadre = nombreMadre;
    }

    public Integer getTelMadre() {
        return telMadre;
    }

    public void setTelMadre(Integer telMadre) {
        this.telMadre = telMadre;
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
        hash += (alumnoPK != null ? alumnoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.alumnoPK == null && other.alumnoPK != null) || (this.alumnoPK != null && !this.alumnoPK.equals(other.alumnoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Alumno[ alumnoPK=" + alumnoPK + " ]";
    }
    
}
