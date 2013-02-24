/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
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
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByPeriodoEscolar", query = "SELECT e FROM Empleado e WHERE e.empleadoPK.periodoEscolar = :periodoEscolar"),
    @NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.empleadoPK.id = :id"),
    @NamedQuery(name = "Empleado.findByApartadoEmail", query = "SELECT e FROM Empleado e WHERE e.apartadoEmail = :apartadoEmail"),
    @NamedQuery(name = "Empleado.findByApellidoCasada", query = "SELECT e FROM Empleado e WHERE e.apellidoCasada = :apellidoCasada"),
    @NamedQuery(name = "Empleado.findByCelular", query = "SELECT e FROM Empleado e WHERE e.celular = :celular"),
    @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empleado.findByEmail", query = "SELECT e FROM Empleado e WHERE e.email = :email"),
    @NamedQuery(name = "Empleado.findByEstado", query = "SELECT e FROM Empleado e WHERE e.estado = :estado"),
    @NamedQuery(name = "Empleado.findByEstadoCivil", query = "SELECT e FROM Empleado e WHERE e.estadoCivil = :estadoCivil"),
    @NamedQuery(name = "Empleado.findByExterno", query = "SELECT e FROM Empleado e WHERE e.externo = :externo"),
    @NamedQuery(name = "Empleado.findByFechaIngreso", query = "SELECT e FROM Empleado e WHERE e.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByNombres", query = "SELECT e FROM Empleado e WHERE e.nombres = :nombres"),
    @NamedQuery(name = "Empleado.findBySexo", query = "SELECT e FROM Empleado e WHERE e.sexo = :sexo"),
    @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empleado.findByTelefonoCelular", query = "SELECT e FROM Empleado e WHERE e.telefonoCelular = :telefonoCelular"),
    @NamedQuery(name = "Empleado.findByTipoSangre", query = "SELECT e FROM Empleado e WHERE e.tipoSangre = :tipoSangre"),
    @NamedQuery(name = "Empleado.findByEspecialidad", query = "SELECT e FROM Empleado e WHERE e.especialidad = :especialidad"),
    @NamedQuery(name = "Empleado.findByCargo", query = "SELECT e FROM Empleado e WHERE e.cargo = :cargo"),
    @NamedQuery(name = "Empleado.findByJefe", query = "SELECT e FROM Empleado e WHERE e.jefe = :jefe")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EmpleadoPK empleadoPK;
    @Size(max = 500)
    @Column(name = "apartado_email", length = 500)
    private String apartadoEmail;
    @Size(max = 100)
    @Column(name = "apellido_casada", length = 100)
    private String apellidoCasada;
    @Size(max = 255)
    @Column(name = "celular", length = 255)
    private String celular;
    @Size(max = 1000)
    @Column(name = "direccion", length = 1000)
    private String direccion;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email", length = 255)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado", nullable = false)
    private int estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_civil", nullable = false)
    private int estadoCivil;
    @Basic(optional = false)
    @NotNull
    @Column(name = "externo", nullable = false)
    private boolean externo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "apellidos", nullable = false, length = 100)
    private String apellidos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombres", nullable = false, length = 100)
    private String nombres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sexo", nullable = false)
    private int sexo;
    @Size(max = 255)
    @Column(name = "telefono", length = 255)
    private String telefono;
    @Size(max = 255)
    @Column(name = "telefono_celular", length = 255)
    private String telefonoCelular;
    @Size(max = 255)
    @Column(name = "tipo_sangre", length = 255)
    private String tipoSangre;
    @Size(max = 255)
    @Column(name = "especialidad", length = 255)
    private String especialidad;
    @Column(name = "cargo")
    private Integer cargo;
    @Size(max = 50)
    @Column(name = "jefe", length = 50)
    private String jefe;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "empleado")
    private Usuario usuario;
    @JoinColumn(name = "periodo_escolar", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PeriodoEscolar periodoEscolar1;

    public Empleado() {
    }

    public Empleado(EmpleadoPK empleadoPK) {
        this.empleadoPK = empleadoPK;
    }

    public Empleado(EmpleadoPK empleadoPK, int estado, int estadoCivil, boolean externo, Date fechaIngreso, String apellidos, String nombres, int sexo) {
        this.empleadoPK = empleadoPK;
        this.estado = estado;
        this.estadoCivil = estadoCivil;
        this.externo = externo;
        this.fechaIngreso = fechaIngreso;
        this.apellidos = apellidos;
        this.nombres = nombres;
        this.sexo = sexo;
    }

    public Empleado(int periodoEscolar, String id) {
        this.empleadoPK = new EmpleadoPK(periodoEscolar, id);
    }

    public EmpleadoPK getEmpleadoPK() {
        return empleadoPK;
    }

    public void setEmpleadoPK(EmpleadoPK empleadoPK) {
        this.empleadoPK = empleadoPK;
    }

    public String getApartadoEmail() {
        return apartadoEmail;
    }

    public void setApartadoEmail(String apartadoEmail) {
        this.apartadoEmail = apartadoEmail;
    }

    public String getApellidoCasada() {
        return apellidoCasada;
    }

    public void setApellidoCasada(String apellidoCasada) {
        this.apellidoCasada = apellidoCasada;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(int estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public boolean getExterno() {
        return externo;
    }

    public void setExterno(boolean externo) {
        this.externo = externo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Integer getCargo() {
        return cargo;
    }

    public void setCargo(Integer cargo) {
        this.cargo = cargo;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        this.jefe = jefe;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PeriodoEscolar getPeriodoEscolar1() {
        return periodoEscolar1;
    }

    public void setPeriodoEscolar1(PeriodoEscolar periodoEscolar1) {
        this.periodoEscolar1 = periodoEscolar1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empleadoPK != null ? empleadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.empleadoPK == null && other.empleadoPK != null) || (this.empleadoPK != null && !this.empleadoPK.equals(other.empleadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.infosgroup.prueba.model.entities.Empleado[ empleadoPK=" + empleadoPK + " ]";
    }
    
}
