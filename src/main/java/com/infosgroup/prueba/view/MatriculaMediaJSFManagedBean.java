/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Alumno;
import com.infosgroup.prueba.model.entities.AlumnoPK;
import com.infosgroup.prueba.model.entities.Autorizacion;
import com.infosgroup.prueba.model.entities.AutorizacionPK;
import com.infosgroup.prueba.model.entities.EstadoFamiliar;
import com.infosgroup.prueba.model.entities.EstadoFamiliarPK;
import com.infosgroup.prueba.model.entities.Estudio;
import com.infosgroup.prueba.model.entities.EstudioPK;
import com.infosgroup.prueba.model.entities.Otrainformacion;
import com.infosgroup.prueba.model.entities.OtrainformacionPK;
import com.infosgroup.prueba.model.entities.Representante;
import com.infosgroup.prueba.model.entities.RepresentantePK;
import com.infosgroup.prueba.model.entities.Tallas;
import com.infosgroup.prueba.model.entities.TallasPK;
import com.infosgroup.prueba.model.entities.ZonaResidencia;
import com.infosgroup.prueba.model.estructuras.FormatoReporte;
import com.infosgroup.prueba.model.facades.AlumnoFacade;
import com.infosgroup.prueba.model.facades.AutorizacionFacade;
import com.infosgroup.prueba.model.facades.EstadoFamiliarFacade;
import com.infosgroup.prueba.model.facades.EstudioFacade;
import com.infosgroup.prueba.model.facades.OtraInformacionFacade;
import com.infosgroup.prueba.model.facades.PeriodoEscolarFacade;
import com.infosgroup.prueba.model.facades.RepresentanteFacade;
import com.infosgroup.prueba.model.facades.TallasFacade;
import com.infosgroup.prueba.model.facades.ZonaResidenciaFacade;
import com.infosgroup.prueba.model.procesos.ReportesStatelessBean;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "matriculaMedia")
@ViewScoped
public class MatriculaMediaJSFManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient ZonaResidenciaFacade zonaResidenciaFacade;
    @EJB
    private transient AlumnoFacade alumnoFacade;
    @EJB
    private transient PeriodoEscolarFacade periodoEscolarFacade;
    @EJB
    private transient EstudioFacade estudioFacade;
    @EJB
    private transient EstadoFamiliarFacade estadoFamiliarFacade;
    @EJB
    private transient TallasFacade tallasFacade;
    @EJB
    private transient RepresentanteFacade representanteFacade;
    @EJB
    private transient AutorizacionFacade autorizacionFacade;
    @EJB
    private transient OtraInformacionFacade otraInformacionFacade;
    //========================
    @EJB
    private transient ReportesStatelessBean reportesBean;
    //========================
    private List<ZonaResidencia> listaZonasResidencia;
    private List<Alumno> listaAlumnos;
    private List<Alumno> listaAlumnosFiltro;
    private Alumno alumnoSeleccionado;
    //========Datos de Alumno=====================
    private String alumno$nie;
    private String alumno$nombre;
    private String alumno$apellido;
    private java.util.Date alumno$fechaNacimiento;
    private String alumno$lugarNacimiento;
    private Integer alumno$edad$anios;
    private String alumno$sexo;
    private String alumno$direccion;
    private String alumno$escuelaAnterior;
    //=============Estudio========================
    private String alumno$gradoEstudio;
    private String alumno$opcionEstudio;
    private String alumno$seccion;
    private String alumno$repiteGrado;
    private String alumno$turno;
    private String alumno$estudioParvularia;
    //=========Estado Familiar=====================
    private String padre$nombre;
    private String padre$apellido;
    private String padre$telefono;
    private String madre$nombre;
    private String madre$apellido;
    private String madre$telefono;
    private String responsable$nombre;
    private String responsable$apellido;
    private String responsable$telefono;
    private String responsable$DUI;
    private String alumno$estadoFamiliar;
    //========Otra Informacion=======================
    private Integer[] alumno$documentosPresentados;
    private Integer alumno$noPartida;
    private Integer alumno$folioPartida;
    private Integer alumno$tomoPartida;
    private Integer alumno$libro;
    private String alumno$actividadEconomica;
    private String alumno$tallaSupuerior;
    private String alumno$tallaInferior;
    private Integer alumno$tallaCalzado;
    //===========Autorizacion========================
    private String autorizacion$vallaSolo;
    private String autorizacion$nombre;
    private String autorizacion$telefono;
    private String autorizacion$DUI;

    //===============================================    
    public List<ZonaResidencia> getListaZonasResidencia() {
        return listaZonasResidencia;
    }

    public void setListaZonasResidencia(List<ZonaResidencia> listaZonasResidencia) {
        this.listaZonasResidencia = listaZonasResidencia;
    }

    public List<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

    public void setListaAlumnos(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    public List<Alumno> getListaAlumnosFiltro() {
        return listaAlumnosFiltro;
    }

    public void setListaAlumnosFiltro(List<Alumno> listaAlumnosFiltro) {
        this.listaAlumnosFiltro = listaAlumnosFiltro;
    }

    public Alumno getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }

    public void setAlumnoSeleccionado(Alumno alumnoSeleccionado) {
        this.alumnoSeleccionado = alumnoSeleccionado;
    }

    //======Set y Get==================
    public String getAlumno$nie() {
        return alumno$nie;
    }

    public void setAlumno$nie(String alumno$nie) {
        this.alumno$nie = alumno$nie;
    }

    public String getAlumno$nombre() {
        return alumno$nombre;
    }

    public void setAlumno$nombre(String alumno$nombre) {
        this.alumno$nombre = alumno$nombre;
    }

    public String getAlumno$apellido() {
        return alumno$apellido;
    }

    public void setAlumno$apellido(String alumno$apellido) {
        this.alumno$apellido = alumno$apellido;
    }

    public java.util.Date getAlumno$fechaNacimiento() {
        return alumno$fechaNacimiento;
    }

    public void setAlumno$fechaNacimiento(java.util.Date alumno$fechaNacimiento) {
        this.alumno$fechaNacimiento = alumno$fechaNacimiento;
    }

    public String getAlumno$lugarNacimiento() {
        return alumno$lugarNacimiento;
    }

    public void setAlumno$lugarNacimiento(String alumno$lugarNacimiento) {
        this.alumno$lugarNacimiento = alumno$lugarNacimiento;
    }

    public Integer getAlumno$edad$anios() {
        return alumno$edad$anios;
    }

    public void setAlumno$edad$anios(Integer alumno$edad$anios) {
        this.alumno$edad$anios = alumno$edad$anios;
    }

    public String getAlumno$sexo() {
        return alumno$sexo;
    }

    public void setAlumno$sexo(String alumno$sexo) {
        this.alumno$sexo = alumno$sexo;
    }

    public String getAlumno$direccion() {
        return alumno$direccion;
    }

    public void setAlumno$direccion(String alumno$direccion) {
        this.alumno$direccion = alumno$direccion;
    }

    public String getAlumno$escuelaAnterior() {
        return alumno$escuelaAnterior;
    }

    public void setAlumno$escuelaAnterior(String alumno$escuelaAnterior) {
        this.alumno$escuelaAnterior = alumno$escuelaAnterior;
    }

    public String getAlumno$gradoEstudio() {
        return alumno$gradoEstudio;
    }

    public void setAlumno$gradoEstudio(String alumno$gradoEstudio) {
        this.alumno$gradoEstudio = alumno$gradoEstudio;
    }

    public String getAlumno$opcionEstudio() {
        return alumno$opcionEstudio;
    }

    public void setAlumno$opcionEstudio(String alumno$opcionEstudio) {
        this.alumno$opcionEstudio = alumno$opcionEstudio;
    }

    public String getAlumno$seccion() {
        return alumno$seccion;
    }

    public void setAlumno$seccion(String alumno$seccion) {
        this.alumno$seccion = alumno$seccion;
    }

    public String getAlumno$repiteGrado() {
        return alumno$repiteGrado;
    }

    public void setAlumno$repiteGrado(String alumno$repiteGrado) {
        this.alumno$repiteGrado = alumno$repiteGrado;
    }

    public String getAlumno$turno() {
        return alumno$turno;
    }

    public void setAlumno$turno(String alumno$turno) {
        this.alumno$turno = alumno$turno;
    }

    public String getAlumno$estudioParvularia() {
        return alumno$estudioParvularia;
    }

    public void setAlumno$estudioParvularia(String alumno$estudioParvularia) {
        this.alumno$estudioParvularia = alumno$estudioParvularia;
    }

    public String getPadre$nombre() {
        return padre$nombre;
    }

    public void setPadre$nombre(String padre$nombre) {
        this.padre$nombre = padre$nombre;
    }

    public String getPadre$apellido() {
        return padre$apellido;
    }

    public void setPadre$apellido(String padre$apellido) {
        this.padre$apellido = padre$apellido;
    }

    public String getPadre$telefono() {
        return padre$telefono;
    }

    public void setPadre$telefono(String padre$telefono) {
        this.padre$telefono = padre$telefono;
    }

    public String getMadre$nombre() {
        return madre$nombre;
    }

    public void setMadre$nombre(String madre$nombre) {
        this.madre$nombre = madre$nombre;
    }

    public String getMadre$apellido() {
        return madre$apellido;
    }

    public void setMadre$apellido(String madre$apellido) {
        this.madre$apellido = madre$apellido;
    }

    public String getMadre$telefono() {
        return madre$telefono;
    }

    public void setMadre$telefono(String madre$telefono) {
        this.madre$telefono = madre$telefono;
    }

    public String getResponsable$nombre() {
        return responsable$nombre;
    }

    public void setResponsable$nombre(String responsable$nombre) {
        this.responsable$nombre = responsable$nombre;
    }

    public String getResponsable$apellido() {
        return responsable$apellido;
    }

    public void setResponsable$apellido(String responsable$apellido) {
        this.responsable$apellido = responsable$apellido;
    }

    public String getResponsable$telefono() {
        return responsable$telefono;
    }

    public void setResponsable$telefono(String responsable$telefono) {
        this.responsable$telefono = responsable$telefono;
    }

    public String getResponsable$DUI() {
        return responsable$DUI;
    }

    public void setResponsable$DUI(String responsable$DUI) {
        this.responsable$DUI = responsable$DUI;
    }

    public String getAlumno$estadoFamiliar() {
        return alumno$estadoFamiliar;
    }

    public void setAlumno$estadoFamiliar(String alumno$estadoFamiliar) {
        this.alumno$estadoFamiliar = alumno$estadoFamiliar;
    }

    public Integer[] getAlumno$documentosPresentados() {
        return alumno$documentosPresentados;
    }

    public void setAlumno$documentosPresentados(Integer[] alumno$documentosPresentados) {
        this.alumno$documentosPresentados = alumno$documentosPresentados;
    }

    public Integer getAlumno$noPartida() {
        return alumno$noPartida;
    }

    public void setAlumno$noPartida(Integer alumno$noPartida) {
        this.alumno$noPartida = alumno$noPartida;
    }

    public Integer getAlumno$folioPartida() {
        return alumno$folioPartida;
    }

    public void setAlumno$folioPartida(Integer alumno$folioPartida) {
        this.alumno$folioPartida = alumno$folioPartida;
    }

    public Integer getAlumno$tomoPartida() {
        return alumno$tomoPartida;
    }

    public void setAlumno$tomoPartida(Integer alumno$tomoPartida) {
        this.alumno$tomoPartida = alumno$tomoPartida;
    }

    public Integer getAlumno$libro() {
        return alumno$libro;
    }

    public void setAlumno$libro(Integer alumno$libro) {
        this.alumno$libro = alumno$libro;
    }

    public String getAlumno$actividadEconomica() {
        return alumno$actividadEconomica;
    }

    public void setAlumno$actividadEconomica(String alumno$actividadEconomica) {
        this.alumno$actividadEconomica = alumno$actividadEconomica;
    }

    public String getAlumno$tallaSupuerior() {
        return alumno$tallaSupuerior;
    }

    public void setAlumno$tallaSupuerior(String alumno$tallaSupuerior) {
        this.alumno$tallaSupuerior = alumno$tallaSupuerior;
    }

    public String getAlumno$tallaInferior() {
        return alumno$tallaInferior;
    }

    public void setAlumno$tallaInferior(String alumno$tallaInferior) {
        this.alumno$tallaInferior = alumno$tallaInferior;
    }

    public Integer getAlumno$tallaCalzado() {
        return alumno$tallaCalzado;
    }

    public void setAlumno$tallaCalzado(Integer alumno$tallaCalzado) {
        this.alumno$tallaCalzado = alumno$tallaCalzado;
    }

    public String getAutorizacion$vallaSolo() {
        return autorizacion$vallaSolo;
    }

    public void setAutorizacion$vallaSolo(String autorizacion$vallaSolo) {
        this.autorizacion$vallaSolo = autorizacion$vallaSolo;
    }

    public String getAutorizacion$nombre() {
        return autorizacion$nombre;
    }

    public void setAutorizacion$nombre(String autorizacion$nombre) {
        this.autorizacion$nombre = autorizacion$nombre;
    }

    public String getAutorizacion$telefono() {
        return autorizacion$telefono;
    }

    public void setAutorizacion$telefono(String autorizacion$telefono) {
        this.autorizacion$telefono = autorizacion$telefono;
    }

    public String getAutorizacion$DUI() {
        return autorizacion$DUI;
    }

    public void setAutorizacion$DUI(String autorizacion$DUI) {
        this.autorizacion$DUI = autorizacion$DUI;
    }

    //========================
    @PostConstruct
    @Override
    public void _init() {
        super._init();
        listaZonasResidencia = zonaResidenciaFacade.findAll();
        listaAlumnos = alumnoFacade.findByNivel("M");
        alumno$edad$anios = 13;
        alumno$sexo = "M";
        alumno$estadoFamiliar = "VPM";
        alumno$repiteGrado = "No";
        alumno$estudioParvularia = "Si";
        autorizacion$vallaSolo = "Si";

        listaRepresentantes = representanteFacade.findAll();
    }

    public String seleccionarAlumno$action() {
        alumno$nie = alumnoSeleccionado.getAlumnoPK().getNie();
        alumno$nombre = alumnoSeleccionado.getNombres();
        alumno$fechaNacimiento = alumnoSeleccionado.getFechaNacimiento();
        return null;
    }

    public String guardarAlumno$action() {

        Alumno alumnoBuscar = alumnoFacade.find(new AlumnoPK(2013, alumno$nie));
        if (alumnoBuscar != null) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Ya existe registro del alumno en el periodo escolar");
            return null;
        }

        AlumnoPK alumnoPK = new AlumnoPK();
        alumnoPK.setIdPeriodoEscolar(2013);
        alumnoPK.setNie(alumno$nie);

        Alumno alumno = new Alumno();
        alumno.setAlumnoPK(alumnoPK);

        alumno.setNombres(alumno$nombre);
        alumno.setApellidos(alumno$apellido);
        alumno.setEdad(alumno$edad$anios);
        alumno.setFechaNacimiento(alumno$fechaNacimiento);
        alumno.setSexo(alumno$sexo);
        alumno.setLugarNacimiento(alumno$lugarNacimiento);
        alumno.setDireccion(alumno$direccion);
        alumno.setEscuelaanterior(alumno$escuelaAnterior);
        alumno.setIdEstadoFamiliar(alumno$estadoFamiliar);
        alumno.setPeriodoEscolar(periodoEscolarFacade.find(2013));
        alumnoFacade.create(alumno);

        EstudioPK estudioPK = new EstudioPK(alumno.getAlumnoPK().getIdPeriodoEscolar(), alumno.getAlumnoPK().getNie());
        Estudio estudioAlumno = new Estudio(estudioPK);
        estudioAlumno.setAlumno(alumno);
        estudioAlumno.setNivel("M");
        estudioAlumno.setGradoestudio(alumno$gradoEstudio);
        estudioAlumno.setOpcionestudio(alumno$opcionEstudio);
        estudioAlumno.setSeccionestudio(alumno$seccion);
        estudioAlumno.setRepitegrado(alumno$repiteGrado);
        estudioAlumno.setEstudioparvularia(alumno$estudioParvularia);
        estudioFacade.create(estudioAlumno);

        OtrainformacionPK otraInformacionPK = new OtrainformacionPK(alumno.getAlumnoPK().getIdPeriodoEscolar(), alumno.getAlumnoPK().getNie());
        Otrainformacion otrainformacion = new Otrainformacion(otraInformacionPK);
        otrainformacion.setAlumno(alumno);
        for (Integer i : alumno$documentosPresentados) {
            switch (i) {
                case 1:
                    otrainformacion.setPresentapartida(Boolean.TRUE);
                    break;
                case 2:
                    otrainformacion.setPresentacertificado(Boolean.TRUE);
                    break;
                case 3:
                    otrainformacion.setPresentaficha(Boolean.TRUE);
                    break;
            }
        }
        otrainformacion.setPartidanumero(alumno$noPartida);
        otrainformacion.setPartidafolio(alumno$folioPartida);
        otrainformacion.setPartidatomo(alumno$tomoPartida);
        otrainformacion.setPartidalibro(alumno$libro);
        otrainformacion.setActividadeconomica(alumno$actividadEconomica);
        otraInformacionFacade.create(otrainformacion);

//        TallasPK tallasPK = new TallasPK(alumno.getAlumnoPK().getIdPeriodoEscolar(), alumno.getAlumnoPK().getNie());
//        Tallas tallas = new Tallas(tallasPK);
//        tallas.setAlumno(alumno);
//        tallas.setTallainferior(alumno$tallaInferior);
//        tallas.setTallasuperior(alumno$tallaSupuerior);
//        tallas.setTallacalzado(alumno$tallaCalzado);
//        tallasFacade.create(tallas);

        EstadoFamiliarPK estadoFamiliarPK = new EstadoFamiliarPK(alumno.getAlumnoPK().getIdPeriodoEscolar(), alumno.getAlumnoPK().getNie());
        EstadoFamiliar estadoFamiliar = new EstadoFamiliar(estadoFamiliarPK);
        estadoFamiliar.setAlumno(alumno);
        estadoFamiliar.setPadrenombre(padre$nombre);
        estadoFamiliar.setPadreapellido(padre$apellido);
        estadoFamiliar.setPadretelefono(padre$telefono);
        estadoFamiliar.setMadrenombre(madre$nombre);
        estadoFamiliar.setMadreapellido(madre$apellido);
        estadoFamiliar.setMadretelefono(madre$telefono);
        estadoFamiliarFacade.create(estadoFamiliar);

        if (representante == null) {
            RepresentantePK representantePK = new RepresentantePK(alumno.getAlumnoPK().getIdPeriodoEscolar(), responsable$DUI);
            Representante r = representanteFacade.find(representantePK);
            if (r == null) {
                representante = new Representante(representantePK);
                representante.setNombre(responsable$nombre);
                representante.setApellido(responsable$apellido);
                representante.setTelefono(responsable$telefono);
                representanteFacade.create(representante);
            } else {
                representante = r;
            }
        }
        alumno.setRepresentante(representante);
        alumnoFacade.edit(alumno);

        AutorizacionPK autorizacionPK = new AutorizacionPK(alumno.getAlumnoPK().getIdPeriodoEscolar(), alumno.getAlumnoPK().getNie());
        Autorizacion autorizacion = new Autorizacion(autorizacionPK);
        autorizacion.setAlumno(alumno);
        autorizacion.setAutorizacionsolo(autorizacion$vallaSolo);
        autorizacion.setPersonarecogernombre(autorizacion$nombre);
        autorizacion.setPersonarecogertelefono(autorizacion$telefono);
        autorizacion.setPersonarecogerdui(autorizacion$DUI);
        autorizacionFacade.create(autorizacion);

        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Alumno registrado exitosamente");

        listaAlumnos = alumnoFacade.findByNivel("M");
        return null;
    }
//    public String imprimirReporte$action() {
//        HashMap<String, Object> parametros = new HashMap<String, Object>();
//        reportesBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "report1", FormatoReporte.PDF);
//        return null;
//    }
    // ***************************************************************
    private List<Representante> listaRepresentantes;
    private List<Representante> listaRepresentantesFiltro;
    private Representante representante;

    public List<Representante> getListaRepresentantes() {
        return listaRepresentantes;
    }

    public void setListaRepresentantes(List<Representante> listaRepresentantes) {
        this.listaRepresentantes = listaRepresentantes;
    }

    public List<Representante> getListaRepresentantesFiltro() {
        return listaRepresentantesFiltro;
    }

    public void setListaRepresentantesFiltro(List<Representante> listaRepresentantesFiltro) {
        this.listaRepresentantesFiltro = listaRepresentantesFiltro;
    }

    public Representante getRepresentante() {
        return representante;
    }

    public void setRepresentante(Representante representante) {
        this.representante = representante;
    }

    public String seleccionarRepresentante$action() {
        if (representante != null) {
            responsable$nombre = representante.getNombre();
            responsable$apellido = representante.getApellido();
            responsable$telefono = representante.getTelefono();
            responsable$DUI = representante.getRepresentantePK().getDui();
        }
        return null;
    }

    public String deseleccionarRepresentante$action() {
        responsable$nombre = null;
        responsable$apellido = null;
        responsable$telefono = null;
        responsable$DUI = null;
        representante = null;
        return null;
    }
}
