/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author root
 */
@ManagedBean(name = "inicio")
@ViewScoped
public class Inicio extends AbstractJSFBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer i;

    @Override
    @PostConstruct
    public void _init() {
        super._init();
        i = 0;
        modelo = new CartesianChartModel();
        ChartSeries serie1 = new ChartSeries("2012");
        serie1.set("Comida", 10);
        serie1.set("Otros", 8);

        ChartSeries serie2 = new ChartSeries("2013");
        serie2.set("Comida", 7);
        serie2.set("Otros", 14);

        modelo.addSeries(serie1);
        modelo.addSeries(serie2);
    }

    public String sumar() {
        ++i;
        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "i: " + i);
        return null;
    }

    public String restar() {
        --i;
        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "i: " + i);
        return null;
    }

    public Integer getI() {
        return i;
    }

    public void setI(Integer i) {
        this.i = i;
    }
    private CartesianChartModel modelo;

    public CartesianChartModel getModelo() {
        return modelo;
    }

    public void setModelo(CartesianChartModel modelo) {
        this.modelo = modelo;
    }
    
    private Integer numero;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    
    public String cambioPagina$action()
    {
        
        if (numero == 1)
            return "editarDatosMedia?faces-redirect=true";
        else if (numero == 10)
            return "editarDatosNocturna?faces-redirect=true";
        else
            return "editarDatosParvularia?faces-redirect=true";
    }
}
