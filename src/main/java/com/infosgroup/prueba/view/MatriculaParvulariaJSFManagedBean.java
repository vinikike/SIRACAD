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
import com.infosgroup.prueba.model.entities.Ninosvive;
import com.infosgroup.prueba.model.entities.NinosvivePK;
import com.infosgroup.prueba.model.entities.Otrainformacion;
import com.infosgroup.prueba.model.entities.OtrainformacionPK;
import com.infosgroup.prueba.model.entities.Representante;
import com.infosgroup.prueba.model.entities.RepresentantePK;
import com.infosgroup.prueba.model.entities.Salud;
import com.infosgroup.prueba.model.entities.SaludPK;
import com.infosgroup.prueba.model.entities.Tallas;
import com.infosgroup.prueba.model.entities.TallasPK;
import com.infosgroup.prueba.model.entities.ZonaResidencia;
import com.infosgroup.prueba.model.estructuras.FormatoReporte;
import com.infosgroup.prueba.model.facades.AlumnoFacade;
import com.infosgroup.prueba.model.facades.AutorizacionFacade;
import com.infosgroup.prueba.model.facades.EstadoFamiliarFacade;
import com.infosgroup.prueba.model.facades.EstudioFacade;
import com.infosgroup.prueba.model.facades.NinosViveFacade;
import com.infosgroup.prueba.model.facades.OtraInformacionFacade;
import com.infosgroup.prueba.model.facades.PeriodoEscolarFacade;
import com.infosgroup.prueba.model.facades.RepresentanteFacade;
import com.infosgroup.prueba.model.facades.SaludFacade;
import com.infosgroup.prueba.model.facades.TallasFacade;
import com.infosgroup.prueba.model.facades.ZonaResidenciaFacade;
import com.infosgroup.prueba.model.procesos.ReportesStatelessBean;
import java.io.Serializable;
import java.util.Date;
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
@ManagedBean(name = "matriculaParvularia")
@ViewScoped
public class MatriculaParvulariaJSFManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient ZonaResidenciaFacade zonaResidenciaFacade;
    @EJB
    private transient AlumnoFacade alumnoFacade;
    @EJB
    private transient PeriodoEscolarFacade periodoEscolarFacade;
    @EJB
    private transient EstudioFacade estudioFacade;
    @EJB
    private transient SaludFacade saludAlumnoFacade;
    @EJB
    private transient EstadoFamiliarFacade estadoFamiliarFacade;
    @EJB
    private transient RepresentanteFacade representanteFacade;
    @EJB
    private transient AutorizacionFacade autorizacionFacade;
    @EJB
    private transient NinosViveFacade ninosViveFacade;
    @EJB
    private transient OtraInformacionFacade otraInformacionFacade;
    @EJB
    private transient TallasFacade tallasFacade;
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
    private Date alumno$fechaNacimiento;
    private String alumno$lugarNacimiento;
    private Integer alumno$edad$anios;
    private Integer alumno$edad$meses;
    private String alumno$sexo;
    private Integer alumno$zonaResidencia;
    private String alumno$direccion;
    private String alumno$escuelaAnterior;
    //=============Estudio========================
    private String alumno$gradoEstudio;
    private String alumno$seccion;
    private Integer alumno$anioEstudio;
    private String alumno$turno;
    private String alumno$nivel;
    //========Salud===============================
    private String alumno$discapacidad;
    private String alumno$tipoDiscapacidad;
    private String alumno$vacunasCompletas;
    private String alumno$problemaSalud;
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
    private String alumno$viveConEspesifique;
    private Integer alumno$numeroNinos;
    private Integer alumno$numeroNinas;
    //========Otra Informacion=======================
    private String alumno$recibeApoyo;
    private String alumno$claseDeApoyo;
    private Integer alumno$noPartida;
    private Integer alumno$folioPartida;
    private Integer alumno$tomoPartida;
    private Integer alumno$libroPartida;
    private String alumno$actividadEconomica;
    private String alumno$tallaSpuerior;
    private String alumno$tallaInferior;
    private Integer alumno$tallaCalzado;
    //===========Autorizacion========================
    private String autorizacion$nombre;
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

    public Date getAlumno$fechaNacimiento() {
        return alumno$fechaNacimiento;
    }

    public void setAlumno$fechaNacimiento(Date alumno$fechaNacimiento) {
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

    public Integer getAlumno$edad$meses() {
        return alumno$edad$meses;
    }

    public void setAlumno$edad$meses(Integer alumno$edad$meses) {
        this.alumno$edad$meses = alumno$edad$meses;
    }

    public String getAlumno$sexo() {
        return alumno$sexo;
    }

    public void setAlumno$sexo(String alumno$sexo) {
        this.alumno$sexo = alumno$sexo;
    }

    public Integer getAlumno$zonaResidencia() {
        return alumno$zonaResidencia;
    }

    public void setAlumno$zonaResidencia(Integer alumno$zonaResidencia) {
        this.alumno$zonaResidencia = alumno$zonaResidencia;
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

    public String getAlumno$nivel() {
        return alumno$nivel;
    }

    public void setAlumno$nivel(String alumno$nivel) {
        this.alumno$nivel = alumno$nivel;
    }

    public String getAlumno$gradoEstudio() {
        return alumno$gradoEstudio;
    }

    public void setAlumno$gradoEstudio(String alumno$gradoEstudio) {
        this.alumno$gradoEstudio = alumno$gradoEstudio;
    }

    public String getAlumno$seccion() {
        return alumno$seccion;
    }

    public void setAlumno$seccion(String alumno$seccion) {
        this.alumno$seccion = alumno$seccion;
    }

    public Integer getAlumno$anioEstudio() {
        return alumno$anioEstudio;
    }

    public void setAlumno$anioEstudio(Integer alumno$anioEstudio) {
        this.alumno$anioEstudio = alumno$anioEstudio;
    }

    public String getAlumno$turno() {
        return alumno$turno;
    }

    public void setAlumno$turno(String alumno$turno) {
        this.alumno$turno = alumno$turno;
    }

    public String getAlumno$discapacidad() {
        return alumno$discapacidad;
    }

    public void setAlumno$discapacidad(String alumno$discapacidad) {
        this.alumno$discapacidad = alumno$discapacidad;
    }

    public String getAlumno$tipoDiscapacidad() {
        return alumno$tipoDiscapacidad;
    }

    public void setAlumno$tipoDiscapacidad(String alumno$tipoDiscapacidad) {
        this.alumno$tipoDiscapacidad = alumno$tipoDiscapacidad;
    }

    public String getAlumno$vacunasCompletas() {
        return alumno$vacunasCompletas;
    }

    public void setAlumno$vacunasCompletas(String alumno$vacunasCompletas) {
        this.alumno$vacunasCompletas = alumno$vacunasCompletas;
    }

    public String getAlumno$problemaSalud() {
        return alumno$problemaSalud;
    }

    public void setAlumno$problemaSalud(String alumno$problemaSalud) {
        this.alumno$problemaSalud = alumno$problemaSalud;
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

    public String getAlumno$viveConEspesifique() {
        return alumno$viveConEspesifique;
    }

    public void setAlumno$viveConEspesifique(String alumno$viveConEspesifique) {
        this.alumno$viveConEspesifique = alumno$viveConEspesifique;
    }

    public Integer getAlumno$numeroNinos() {
        return alumno$numeroNinos;
    }

    public void setAlumno$numeroNinos(Integer alumno$numeroNinos) {
        this.alumno$numeroNinos = alumno$numeroNinos;
    }

    public Integer getAlumno$numeroNinas() {
        return alumno$numeroNinas;
    }

    public void setAlumno$numeroNinas(Integer alumno$numeroNinas) {
        this.alumno$numeroNinas = alumno$numeroNinas;
    }

    public String getAlumno$recibeApoyo() {
        return alumno$recibeApoyo;
    }

    public void setAlumno$recibeApoyo(String alumno$recibeApoyo) {
        this.alumno$recibeApoyo = alumno$recibeApoyo;
    }

    public String getAlumno$claseDeApoyo() {
        return alumno$claseDeApoyo;
    }

    public void setAlumno$claseDeApoyo(String alumno$claseDeApoyo) {
        this.alumno$claseDeApoyo = alumno$claseDeApoyo;
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

    public Integer getAlumno$libroPartida() {
        return alumno$libroPartida;
    }

    public void setAlumno$libroPartida(Integer alumno$libroPartida) {
        this.alumno$libroPartida = alumno$libroPartida;
    }

    public String getAlumno$actividadEconomica() {
        return alumno$actividadEconomica;
    }

    public void setAlumno$actividadEconomica(String alumno$actividadEconomica) {
        this.alumno$actividadEconomica = alumno$actividadEconomica;
    }

    public String getAlumno$tallaSpuerior() {
        return alumno$tallaSpuerior;
    }

    public void setAlumno$tallaSpuerior(String alumno$tallaSpuerior) {
        this.alumno$tallaSpuerior = alumno$tallaSpuerior;
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

    public String getAutorizacion$nombre() {
        return autorizacion$nombre;
    }

    public void setAutorizacion$nombre(String autorizacion$nombre) {
        this.autorizacion$nombre = autorizacion$nombre;
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
        listaAlumnos = alumnoFacade.findByNivel("P");
        alumno$sexo = "M";

        alumno$anioEstudio = 2013;
        //alumno$turno = 1;
        alumno$edad$anios = 4;
        alumno$edad$meses = 0;

        alumno$discapacidad = "No";
        alumno$vacunasCompletas = "Si";

        alumno$estadoFamiliar = "VPM";
        alumno$numeroNinos = 0;
        alumno$numeroNinas = 0;

        alumno$recibeApoyo = "No";

        listaRepresentantes = representanteFacade.findAll();
    }

    public String seleccionarAlumno$action() {
        alumno$nie = alumnoSeleccionado.getAlumnoPK().getNie();
        alumno$nombre = alumnoSeleccionado.getNombres();
        alumno$fechaNacimiento = alumnoSeleccionado.getFechaNacimiento();
        return null;
    }

    public String guardarAlumno$action() {
        AlumnoPK alumnoPK = new AlumnoPK();
        alumnoPK.setIdPeriodoEscolar(2013);
        alumnoPK.setNie(alumno$nie);

        Alumno alumno = new Alumno();
        alumno.setAlumnoPK(alumnoPK);

        alumno.setNombres(alumno$nombre);
        alumno.setApellidos(alumno$apellido);
        alumno.setLugarNacimiento(alumno$lugarNacimiento);
        alumno.setEdad(alumno$edad$anios);
        alumno.setMeses(alumno$edad$meses);
        alumno.setDireccion(alumno$direccion);
        alumno.setFechaNacimiento(alumno$fechaNacimiento);
        alumno.setEdad(alumno$edad$anios);
        alumno.setSexo(alumno$sexo);
        alumno.setIdZonaResidencia(zonaResidenciaFacade.find("1"));
        alumno.setIdEstadoFamiliar(alumno$estadoFamiliar);
        alumno.setPeriodoEscolar(periodoEscolarFacade.find(2013));
        alumnoFacade.create(alumno);

        EstudioPK estudioPK = new EstudioPK(alumno.getAlumnoPK().getIdPeriodoEscolar(), alumno.getAlumnoPK().getNie());
        Estudio estudioAlumno = new Estudio(estudioPK);
        estudioAlumno.setAlumno(alumno);
        estudioAlumno.setNivel("P");
        estudioAlumno.setGradoestudio(alumno$gradoEstudio);
        estudioAlumno.setSeccionestudio(alumno$seccion);
        estudioFacade.create(estudioAlumno);

        SaludPK saludPK = new SaludPK(alumno.getAlumnoPK().getIdPeriodoEscolar(), alumno.getAlumnoPK().getNie());
        Salud salud = new Salud(saludPK);
        salud.setAlumno(alumno);
        salud.setPoseediscapacidad(alumno$discapacidad);
        salud.setTipodediscapacidad(alumno$tipoDiscapacidad);
        salud.setVacunascompletas(alumno$vacunasCompletas);
        salud.setProblemadesalud(alumno$problemaSalud);
        saludAlumnoFacade.create(salud);

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

        NinosvivePK ninosvivePK = new NinosvivePK(alumno.getAlumnoPK().getIdPeriodoEscolar(), alumno.getAlumnoPK().getNie());
        Ninosvive ninosvive = new Ninosvive(ninosvivePK);
        ninosvive.setAlumno(alumno);
        ninosvive.setCantidadninos(alumno$numeroNinos);
        ninosvive.setCantidadninas(alumno$numeroNinas);
        ninosViveFacade.create(ninosvive);

        OtrainformacionPK otrainformacionPK = new OtrainformacionPK(alumno.getAlumnoPK().getIdPeriodoEscolar(), alumno.getAlumnoPK().getNie());
        Otrainformacion otrainformacion = new Otrainformacion(otrainformacionPK);
        otrainformacion.setAlumno(alumno);
        otrainformacion.setRecibeapoyo(alumno$recibeApoyo);
        otrainformacion.setTipodeapoyo(alumno$claseDeApoyo);
        otrainformacion.setPartidanumero(alumno$noPartida);
        otrainformacion.setPartidafolio(alumno$folioPartida);
        otrainformacion.setPartidatomo(alumno$tomoPartida);
        otrainformacion.setPartidalibro(alumno$libroPartida);
        otrainformacion.setActividadeconomica(alumno$actividadEconomica);
        otraInformacionFacade.create(otrainformacion);

        TallasPK tallasPK = new TallasPK(alumno.getAlumnoPK().getIdPeriodoEscolar(), alumno.getAlumnoPK().getNie());
        Tallas tallas = new Tallas(tallasPK);
        tallas.setAlumno(alumno);
        tallas.setTallasuperior(alumno$tallaSpuerior);
        tallas.setTallainferior(alumno$tallaInferior);
        tallas.setTallacalzado(alumno$tallaCalzado);
        tallasFacade.create(tallas);

        AutorizacionPK autorizacionPK = new AutorizacionPK(alumno.getAlumnoPK().getIdPeriodoEscolar(), alumno.getAlumnoPK().getNie());
        Autorizacion autorizacion = new Autorizacion(autorizacionPK);
        autorizacion.setAlumno(alumno);
        autorizacion.setPersonarecogernombre(autorizacion$nombre);
        autorizacion.setPersonarecogerdui(autorizacion$DUI);
        autorizacionFacade.create(autorizacion);

        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Alumno registrado exitosamente");

        listaAlumnos = alumnoFacade.findByNivel("P");
        return null;
    }

    public String imprimirReporte$action() {
        HashMap<String, Object> parametros = new HashMap<String, Object>();
        reportesBean.generarReporteSQL(FacesContext.getCurrentInstance(), parametros, "report1", FormatoReporte.PDF);
        return null;
    }
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
