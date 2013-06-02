/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Docente;
import com.infosgroup.prueba.model.entities.Grado;
import com.infosgroup.prueba.model.facades.DocenteFacade;
import com.infosgroup.prueba.model.facades.GradoFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

/**
 *
 * @author Guille
 */
@ManagedBean(name = "asignarDocente")
@ViewScoped
public class AsignarDocenteManagedBean extends AbstractJSFBean implements Serializable {

    //
    @EJB
    private transient DocenteFacade docenteFacade;
    @EJB
    private transient GradoFacade gradoFacade;
    //
    private List<Docente> listaDocentes;
    private List<Grado> listaGradosSource;
    private List<Grado> listaGradosTarget;
    private DualListModel<Grado> listaGradosDisponibles;
    //

    @Override
    @PostConstruct
    public void _init() {
        super._init();
        listaDocentes = docenteFacade.findAll();
        listaGradosDisponibles = new DualListModel<>();
        listaGradosSource = gradoFacade.findAll();
        listaGradosTarget = new ArrayList<>();

        listaGradosDisponibles.setSource(listaGradosSource);
        listaGradosDisponibles.setTarget(listaGradosTarget);
    }

    //
    public List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    public List<Grado> getListaGradosSource() {
        return listaGradosSource;
    }

    public void setListaGradosSource(List<Grado> listaGradosSource) {
        this.listaGradosSource = listaGradosSource;
    }

    public List<Grado> getListaGradosTarget() {
        return listaGradosTarget;
    }

    public void setListaGradosTarget(List<Grado> listaGradosTarget) {
        this.listaGradosTarget = listaGradosTarget;
    }

    public DualListModel<Grado> getListaGradosDisponibles() {
        return listaGradosDisponibles;
    }

    public void setListaGradosDisponibles(DualListModel<Grado> listaGradosDisponibles) {
        this.listaGradosDisponibles = listaGradosDisponibles;
    }

    public void pisklist$handleTransfer(TransferEvent evt) {
        List<Grado> lg = (List<Grado>) evt.getItems();
        {
//            for (Grado g : lg) {
//                if (evt.isAdd()) {
//                    listaGradosSource.remove(g);
//                    listaGradosTarget.add(g);
//                } else {
//                    listaGradosSource.add(g);
//                    listaGradosTarget.remove(g);
//                }
//            }
        }
        listaGradosDisponibles.setSource(listaGradosSource);
        listaGradosDisponibles.setTarget(listaGradosTarget);
    }

    public void docente$valueChangeListener(ValueChangeEvent evt) {
        listaGradosTarget = new ArrayList<>();
        listaGradosDisponibles.setSource(listaGradosSource);
        listaGradosDisponibles.setTarget(listaGradosTarget);
    }
}
