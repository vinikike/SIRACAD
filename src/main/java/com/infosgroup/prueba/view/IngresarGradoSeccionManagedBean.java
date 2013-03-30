/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Grado;
import com.infosgroup.prueba.model.entities.GradoPK;
import com.infosgroup.prueba.model.entities.ListaGrados;
import com.infosgroup.prueba.model.entities.Nivel;
import com.infosgroup.prueba.model.entities.Opcion;
import com.infosgroup.prueba.model.facades.GradoFacade;
import com.infosgroup.prueba.model.facades.ListaGradosFacade;
import com.infosgroup.prueba.model.facades.NivelFacade;
import com.infosgroup.prueba.model.facades.OpcionFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "ingresarGradoSeccion")
@ViewScoped
public class IngresarGradoSeccionManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient GradoFacade gradoFacade;
    @EJB
    private transient NivelFacade nivelFacade;
    @EJB
    private transient ListaGradosFacade listaGradosFacade;
    @EJB
    private transient OpcionFacade opcionFacade;
    //---------------------------------------------------
    private Integer grado$periodo_Escolar;
    private String grado$nivel;
    private String grado$grado;
    private String grado$opcion;
    private String grado$seccion;
    private String grado$nombre;
    private String grado$turno;
//    private Object grado$nivel;
//    private Object grado$grado;
//    private Object grado$opcion;
//    private Object grado$seccion;
//    private Object grado$nombre;
//    private Object grado$turno;
    private List<Nivel> listaNiveles;
    private List<ListaGrados> listaGrados;
    private List<Opcion> listaOpciones;

//--------------------------------------------------------------------
    public Integer getGrado$periodo_Escolar() {
        return grado$periodo_Escolar;
    }

    public void setGrado$periodo_Escolar(Integer grado$periodo_Escolar) {
        this.grado$periodo_Escolar = grado$periodo_Escolar;
    }

    public String getGrado$nivel() {
        return grado$nivel;
    }

    public void setGrado$nivel(String grado$nivel) {
        this.grado$nivel = grado$nivel;
    }

    public String getGrado$grado() {
        return grado$grado;
    }

    public void setGrado$grado(String grado$grado) {
        this.grado$grado = grado$grado;
    }

    public String getGrado$opcion() {
        return grado$opcion;
    }

    public void setGrado$opcion(String grado$opcion) {
        this.grado$opcion = grado$opcion;
    }

    public String getGrado$seccion() {
        return grado$seccion;
    }

    public void setGrado$seccion(String grado$seccion) {
        this.grado$seccion = grado$seccion;
    }

    public String getGrado$nombre() {
        return grado$nombre;
    }

    public void setGrado$nombre(String grado$nombre) {
        this.grado$nombre = grado$nombre;
    }

    public String getGrado$turno() {
        return grado$turno;
    }

    public void setGrado$turno(String grado$turno) {
        this.grado$turno = grado$turno;
    }

    public List<Nivel> getListaNiveles() {
        return listaNiveles;
    }

    public void setListaNiveles(List<Nivel> listaNiveles) {
        this.listaNiveles = listaNiveles;
    }

    public List<ListaGrados> getListaGrados() {
        return listaGrados;
    }

    public void setListaGrados(List<ListaGrados> listaGrados) {
        this.listaGrados = listaGrados;
    }

    public List<Opcion> getListaOpciones() {
        return listaOpciones;
    }

    public void setListaOpciones(List<Opcion> listaOpciones) {
        this.listaOpciones = listaOpciones;
    }

    //--------------------------------------------------------------------
    //========================
    @PostConstruct
    @Override
    public void _init() {
        super._init();

        grado$nivel = "0";
        grado$grado = "0";
        grado$opcion = "0";
        grado$turno = "M";
        grado$seccion = "";
    }

    public String guardarGradoSeccion$action() {
//revisarrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
        Grado gradoBucar = gradoFacade.find(new GradoPK(2013, grado$nivel, grado$grado,((grado$opcion == null) ? "0" : grado$opcion), grado$seccion));
        if (gradoBucar != null) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Ya existe el registro este grado en el periodo escolar");
            return null;
        }

        if ("0".equals(grado$nivel)) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Seleccione uno de los Niveles");
            return null;
        } else if ("0".equals(grado$grado)) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Seleccione el grado a ingresar");
            return null;
//        } else if ("0".equals(grado$opcion)) {
//            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Debe seleccionar la opcion");
//            return null;
        } else if ("0".equals(grado$turno)) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Seleccione el turno");
            return null;
        }

        GradoPK gradoPK = new GradoPK();
        gradoPK.setIdPeriodoEscolar(2013);
        gradoPK.setNivel(grado$nivel);
        gradoPK.setGrado(grado$grado);

        if ("P".equals(grado$nivel)) {
            gradoPK.setOpcion("0");
        } else if ("B".equals(grado$nivel)) {
            gradoPK.setOpcion("0");
        } else if (Integer.parseInt(grado$grado) < 100) {
            gradoPK.setOpcion("0");
        } else {
            gradoPK.setOpcion(grado$opcion);
        }

        gradoPK.setSeccion(grado$seccion);

        Grado grado = new Grado();
        grado.setGradoPK(gradoPK);

        gradoFacade.create(grado);

        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Grado registrado exitosamente");

        grado$nivel = "0";
        grado$grado = "0";
        grado$opcion = "0";
        grado$turno = "M";
        //grado$nombre = "";
        grado$seccion = "";

        return null;

    }


    public void nivel$valueChangeListener(ValueChangeEvent evt) {
        grado$grado = null;
        grado$opcion = null;
        String valor = (String) evt.getNewValue();
        listaGradosSel = new ArrayList<>();
        listaTurnoSel = new ArrayList<>();
        if ("P".equals(valor)) {
            listaGradosSel.add(new SelectItem(4, "Kinder 4"));
            listaGradosSel.add(new SelectItem(5, "Kinder 5"));
            listaGradosSel.add(new SelectItem(6, "Kinder 6"));

            listaTurnoSel.add(new SelectItem("M", "Matutino"));
            listaTurnoSel.add(new SelectItem("V", "Vespertino"));

        } else if ("B".equals(valor)) {
            listaGradosSel.add(new SelectItem(1, "Primero"));
            listaGradosSel.add(new SelectItem(2, "Segundo"));
            listaGradosSel.add(new SelectItem(3, "Tercero"));
            listaGradosSel.add(new SelectItem(4, "Cuarto"));
            listaGradosSel.add(new SelectItem(5, "Quinto"));
            listaGradosSel.add(new SelectItem(6, "Sexto"));
            listaGradosSel.add(new SelectItem(7, "Septimo"));
            listaGradosSel.add(new SelectItem(8, "Octavo"));
            listaGradosSel.add(new SelectItem(9, "Noveno"));

            listaTurnoSel.add(new SelectItem("M", "Matutino"));
            listaTurnoSel.add(new SelectItem("V", "Vespertino"));
        } else if ("M".equals(valor)) {
            listaGradosSel.add(new SelectItem(101, "Primer Año"));
            listaGradosSel.add(new SelectItem(102, "Segundo Año"));
            listaGradosSel.add(new SelectItem(103, "Tercer Año"));

            listaTurnoSel.add(new SelectItem("M", "Matutino"));
            listaTurnoSel.add(new SelectItem("V", "Vespertino"));
        } else if ("N".equals(valor)) {
            listaGradosSel.add(new SelectItem(12, "Nivel I"));
            listaGradosSel.add(new SelectItem(34, "Nivel II"));
            listaGradosSel.add(new SelectItem(56, "Nivel III"));
            listaGradosSel.add(new SelectItem(7, "Septimo"));
            listaGradosSel.add(new SelectItem(8, "Octavo"));
            listaGradosSel.add(new SelectItem(9, "Noveno"));
            listaGradosSel.add(new SelectItem(101, "Primer Año"));
            listaGradosSel.add(new SelectItem(102, "Segundo Año"));

            listaTurnoSel.add(new SelectItem("N", "Nocturno"));
        }
    }

    //--------------------------
    public void grado$valueChangeListener(ValueChangeEvent evt) {
        grado$opcion = null;
        String grado = (String) evt.getNewValue();
        listaOpcionSel = new ArrayList<>();
        if ("M".equals(grado$nivel) && ("101".equals(grado) || "102".equals(grado))) {
            listaOpcionSel.add(new SelectItem("G", "General"));
            listaOpcionSel.add(new SelectItem("C", "Contador"));
        }
         else if ("103".equals(grado)) {
            listaOpcionSel.add(new SelectItem("C", "Contador"));
        } else if ( "N".equals(grado$nivel) && ("101".equals(grado) || "102".equals(grado)))
        {
            listaOpcionSel.add(new SelectItem("G", "General"));
        }

    }
    
    private List<SelectItem> listaGradosSel;
    private List<SelectItem> listaTurnoSel;
    private List<SelectItem> listaOpcionSel;

    public List<SelectItem> getListaGradosSel() {
        return listaGradosSel;
    }

    public void setListaGradosSel(List<SelectItem> listaGradosSel) {
        this.listaGradosSel = listaGradosSel;
    }

    public List<SelectItem> getListaTurnoSel() {
        return listaTurnoSel;
    }

    public void setListaTurnoSel(List<SelectItem> listaTurnoSel) {
        this.listaTurnoSel = listaTurnoSel;
    }

    public List<SelectItem> getListaOpcionSel() {
        return listaOpcionSel;
    }

    public void setListaOpcionSel(List<SelectItem> listaOpcionSel) {
        this.listaOpcionSel = listaOpcionSel;
    }
}
