/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Docente;
import com.infosgroup.prueba.model.facades.DocenteFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "ingresarUsusarios")
@ViewScoped
public class UsuariosManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient DocenteFacade docenteFacade;
    
    private Docente usuarios$nuevoUsuario;
    private String usuarios$contrasenia;
    private String usuarios$cargo;
            
    private List<Docente> listaDocentes;

    public Docente getUsuarios$nuevoUsuario() {
        return usuarios$nuevoUsuario;
    }

    public void setUsuarios$nuevoUsuario(Docente usuarios$nuevoUsuario) {
        this.usuarios$nuevoUsuario = usuarios$nuevoUsuario;
    }

    public String getUsuarios$contrasenia() {
        return usuarios$contrasenia;
    }

    public void setUsuarios$contrasenia(String usuarios$contrasenia) {
        this.usuarios$contrasenia = usuarios$contrasenia;
    }

    public String getUsuarios$cargo() {
        return usuarios$cargo;
    }

    public void setUsuarios$cargo(String usuarios$cargo) {
        this.usuarios$cargo = usuarios$cargo;
    }

    public List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }


    @PostConstruct
    @Override
    public void _init() {
        super._init();
        listaDocentes = docenteFacade.findAll();

    }
    
        public String guardarUsuario$action() {
            

        return null;
    }
        
           //--------------------------
    public void usuario$valueChangeListener(ValueChangeEvent evt) {
        usuarios$contrasenia = "";
        usuarios$cargo = "";
        
//        String grado = (String) evt.getNewValue();
        Docente user = (Docente) evt.getNewValue();
        
        
//        listaDocentes = new ArrayList<>();
        
//        docenteFacade.find(new Doce)
//        usuarios$contrasenia = 
        
//        
//        if ("M".equals(grado$nivel) && ("101".equals(grado) || "102".equals(grado))) {
//            listaOpcionSel.add(new SelectItem("G", "General"));
//            listaOpcionSel.add(new SelectItem("C", "Contador"));
//        }
//         else if ("103".equals(grado)) {
//            listaOpcionSel.add(new SelectItem("C", "Contador"));
//        } else if ( "N".equals(grado$nivel) && ("101".equals(grado) || "102".equals(grado)))
//        {
//            listaOpcionSel.add(new SelectItem("G", "General"));
//        }
//        

    }
}
