/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Docente;
import com.infosgroup.prueba.model.entities.Rol;
import com.infosgroup.prueba.model.entities.Usuario;
import com.infosgroup.prueba.model.facades.DocenteFacade;
import com.infosgroup.prueba.model.facades.RolFacade;
import com.infosgroup.prueba.model.facades.UsuarioFacade;
import com.infosgroup.prueba.view.beans.SessionBean;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;

@ManagedBean(name = "ingresarUsusarios")
@ViewScoped
public class UsuariosManagedBean extends AbstractJSFBean implements Serializable {

    @EJB
    private transient DocenteFacade docenteFacade;
    @EJB
    private transient RolFacade rolFacade;
    @EJB
    private transient UsuarioFacade usuarioFacade;
    //-----------------------------------------------------------------
    //@ManagedProperty(value = "#{SessionBean}")
    @Inject
    private SessionBean sessionBean;
//    public SessionBean getSessionBean() {
//        return sessionBean;
//    }
//
//    public void setSessionBean(SessionBean sessionBean) {
//        this.sessionBean = sessionBean;
//    }
    //-----------------------------------------------------------------
    private Docente usuario$docente;
    private Rol usuario$rol;
    private String usuario$id;
    private String usuario$contrasenia;
    private String usuario$cargo;
    private List<Docente> listaDocentes;
    private List<Rol> listaRol;

    public Docente getUsuario$docente() {
        return usuario$docente;
    }

    public void setUsuario$docente(Docente usuario$docente) {
        this.usuario$docente = usuario$docente;
    }

    public Rol getUsuario$rol() {
        return usuario$rol;
    }

    public void setUsuario$rol(Rol usuario$rol) {
        this.usuario$rol = usuario$rol;
    }

    public String getUsuario$id() {
        return usuario$id;
    }

    public void setUsuario$id(String usuario$id) {
        this.usuario$id = usuario$id;
    }

    public String getUsuario$contrasenia() {
        return usuario$contrasenia;
    }

    public void setUsuario$contrasenia(String usuario$contrasenia) {
        this.usuario$contrasenia = usuario$contrasenia;
    }

    public String getUsuario$cargo() {
        return usuario$cargo;
    }

    public void setUsuario$cargo(String usuario$cargo) {
        this.usuario$cargo = usuario$cargo;
    }

    public List<Docente> getListaDocentes() {
        return listaDocentes;
    }

    public void setListaDocentes(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    public List<Rol> getListaRol() {
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }

    @PostConstruct
    @Override
    public void _init() {
        super._init();
        listaDocentes = docenteFacade.findAll();
        listaDocentes.removeAll(docenteFacade.findDocentesConUsuario());
        listaRol = rolFacade.findAll();
    }

    public String guardarUsuario$action() {
        Usuario usuarioBuscar = usuarioFacade.find(usuario$docente.getId());
        if (usuarioBuscar != null) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "Ya existe el registro de este usuario");
            return null;
        }

        Usuario usuario = new Usuario();
        usuario.setCompania(sessionBean.getCompania());
        usuario.setId(usuario$docente.getId());

        try {
            String texto = usuario$contrasenia;
            final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(texto.getBytes(Charset.forName("UTF8")));
            final byte[] resultByte = messageDigest.digest();
            String s = "";
            for (int i = 0; i < resultByte.length; i++) {
                s += Integer.toHexString((resultByte[i] >> 4) & 0xf);
                s += Integer.toHexString(resultByte[i] & 0xf);
            }
            usuario.setPassw(s);
            System.out.println("Resumen MD5: " + s);
        } catch (Exception excpt) {
            excpt.printStackTrace(System.err);
        }

        usuario.setRol(usuario$rol);
        usuario.setDocente(usuario$docente);

        usuarioFacade.create(usuario);

        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Usuario registrado exitosamente");

        usuario$id = "";
        usuario$contrasenia = "";

        listaDocentes = docenteFacade.findAll();
        listaDocentes.removeAll(docenteFacade.findDocentesConUsuario());

        return null;
    }

    public void usuario$valueChangeListener(ValueChangeEvent e) {
        Docente d = (Docente) e.getNewValue();
        usuario$id = d.getId();
        usuario$contrasenia = "";

    }
}
