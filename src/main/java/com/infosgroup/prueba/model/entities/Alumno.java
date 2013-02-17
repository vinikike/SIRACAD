/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    @NamedQuery(name = "Alumno.findByLugarNacimiento", query = "SELECT a FROM Alumno a WHERE a.lugarNacimiento = :lugarNacimiento"),
    @NamedQuery(name = "Alumno.findByEdad", query = "SELECT a FROM Alumno a WHERE a.edad = :edad"),
    @NamedQuery(name = "Alumno.findByDireccion", query = "SELECT a FROM Alumno a WHERE a.direccion = :direccion"),
    @NamedQuery(name = "Alumno.findByIdEstadoFamiliar", query = "SELECT a FROM Alumno a WHERE a.idEstadoFamiliar = :idEstadoFamiliar"),
    @NamedQuery(name = "Alumno.findByFechaNacimiento", query = "SELECT a FROM Alumno a WHERE a.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Alumno.findByMeses", query = "SELECT a FROM Alumno a WHERE a.meses = :meses"),
    @NamedQuery(name = "Alumno.findByEscuelaanterior", query = "SELECT a FROM Alumno a WHERE a.escuelaanterior = :escuelaanterior"),
    @NamedQuery(name = "Alumno.findBySexo", query = "SELECT a FROM Alumno a WHERE a.sexo = :sexo")})
public class Alumno implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlumnoPK alumnoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombres")
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellidos")
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lugar_nacimiento")
    private String lugarNacimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "id_estado_familiar")
    private String idEstadoFamiliar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "meses")
    private Integer meses;
    @Size(max = 100)
    @Column(name = "escuelaanterior")
    private String escuelaanterior;
    @Size(max = 50)
    @Column(name = "sexo")
    private String sexo;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno")
    private EstadoFamiliar estadoFamiliar;
    @JoinColumn(name = "id_zona_residencia", referencedColumnName = "id")
    @ManyToOne
    private ZonaResidencia idZonaResidencia;
    @JoinColumns({
        @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id_periodo_escolar", insertable = false, updatable = false),
        @JoinColumn(name = "representante", referencedColumnName = "dui")})
    @ManyToOne(optional = false)
    private Representante representante;
    @JoinColumn(name = "id_periodo_escolar", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PeriodoEscolar periodoEscolar;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Salud salud;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<FichaAlumno> fichaAlumnoList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Ninosvive ninosvive;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Estudio estudio;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Autorizacion autorizacion;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Tallas tallas;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "alumno")
    private Otrainformacion otrainformacion;

    public Alumno() {
    }

    public Alumno(AlumnoPK alumnoPK) {
        this.alumnoPK = alumnoPK;
    }

    public Alumno(AlumnoPK alumnoPK, String nombres, String apellidos, String lugarNacimiento, int edad, String direccion, String idEstadoFamiliar, Date fechaNacimiento) {
        this.alumnoPK = alumnoPK;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.lugarNacimiento = lugarNacimiento;
        this.edad = edad;
        this.direccion = direccion;
        this.idEstadoFamiliar = idEstadoFamiliar;
        this.fechaNacimiento = fechaNacimiento;
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

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
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

    public String getIdEstadoFamiliar() {
        return idEstadoFamiliar;
    }

    public void setIdEstadoFamiliar(String idEstadoFamiliar) {
        this.idEstadoFamiliar = idEstadoFamiliar;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getMeses() {
        return meses;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }

    public String getEscuelaanterior() {
        return escuelaanterior;
    }

    public void setEscuelaanterior(String escuelaanterior) {
        this.escuelaanterior = escuelaanterior;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public EstadoFamiliar getEstadoFamiliar() {
        return estadoFamiliar;
    }

    public void setEstadoFamiliar(EstadoFamiliar estadoFamiliar) {
        this.estadoFamiliar = estadoFamiliar;
    }

    public ZonaResidencia getIdZonaResidencia() {
        return idZonaResidencia;
    }

    public void setIdZonaResidencia(ZonaResidencia idZonaResidencia) {
        this.idZonaResidencia = idZonaResidencia;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public PeriodoEscolar getPeriodoEscolar() {
        return periodoEscolar;
    }

    public void setPeriodoEscolar(PeriodoEscolar periodoEscolar) {
        this.periodoEscolar = periodoEscolar;
    }

    public Salud getSalud() {
        return salud;
    }

    public void setSalud(Salud salud) {
        this.salud = salud;
    }

    @XmlTransient
    public List<FichaAlumno> getFichaAlumnoList() {
        return fichaAlumnoList;
    }

    public void setFichaAlumnoList(List<FichaAlumno> fichaAlumnoList) {
        this.fichaAlumnoList = fichaAlumnoList;
    }

    public Ninosvive getNinosvive() {
        return ninosvive;
    }

    public void setNinosvive(Ninosvive ninosvive) {
        this.ninosvive = ninosvive;
    }

    public Estudio getEstudio() {
        return estudio;
    }

    public void setEstudio(Estudio estudio) {
        this.estudio = estudio;
    }

    public Autorizacion getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Autorizacion autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Tallas getTallas() {
        return tallas;
    }

    public void setTallas(Tallas tallas) {
        this.tallas = tallas;
    }

    public Otrainformacion getOtrainformacion() {
        return otrainformacion;
    }

    public void setOtrainformacion(Otrainformacion otrainformacion) {
        this.otrainformacion = otrainformacion;
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
