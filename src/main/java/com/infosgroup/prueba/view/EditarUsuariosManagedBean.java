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
import javax.inject.Inject;

@ManagedBean(name = "editarUsusarios")
@ViewScoped
public class EditarUsuariosManagedBean extends AbstractJSFBean implements Serializable {

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
    //private Rol usuario$rol;
    private String usuario$id;
    private String usuario$nombre;
    private String usuario$contraseniaAnterior;
    private String usuario$contrasenia1;
    private String usuario$contrasenia2;
    //private String usuario$cargo;
    private List<Docente> listaDocentes;
    private List<Rol> listaRol;

    public Docente getUsuario$docente() {
        return usuario$docente;
    }

    public void setUsuario$docente(Docente usuario$docente) {
        this.usuario$docente = usuario$docente;
    }

    public String getUsuario$id() {
        return usuario$id;
    }

    public void setUsuario$id(String usuario$id) {
        this.usuario$id = usuario$id;
    }

    public String getUsuario$nombre() {
        return usuario$nombre;
    }

    public void setUsuario$nombre(String usuario$nombre) {
        this.usuario$nombre = usuario$nombre;
    }

    public String getUsuario$contraseniaAnterior() {
        return usuario$contraseniaAnterior;
    }

    public void setUsuario$contraseniaAnterior(String usuario$contraseniaAnterior) {
        this.usuario$contraseniaAnterior = usuario$contraseniaAnterior;
    }

    public String getUsuario$contrasenia1() {
        return usuario$contrasenia1;
    }

    public void setUsuario$contrasenia1(String usuario$contrasenia1) {
        this.usuario$contrasenia1 = usuario$contrasenia1;
    }

    public String getUsuario$contrasenia2() {
        return usuario$contrasenia2;
    }

    public void setUsuario$contrasenia2(String usuario$contrasenia2) {
        this.usuario$contrasenia2 = usuario$contrasenia2;
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

        usuario$nombre = sessionBean.getUsuario().getDocente().getNombre();
        usuario$id = sessionBean.getUsuario().getId();
        listaDocentes = docenteFacade.findAll();
        listaRol = rolFacade.findAll();

    }

    public String actualizarUsuario$action() {
        Usuario u = sessionBean.getUsuario();
        if (u == null) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_FATAL, "No hay ningun usuario en sesion");
            return null;
        }
        if (!u.getPassw().equals(encriptarTexto(usuario$contraseniaAnterior))) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_WARN, "La contraseña anterior no coincide");
            return null;
        }
        u.setPassw(encriptarTexto(usuario$contrasenia1));
        usuarioFacade.edit(u);
        mostrarMensajeJSF(FacesMessage.SEVERITY_INFO, "Contraseña cambiada exitosamente");
        return null;
    }

//=====================================================================================================

    private String encriptarTexto(String texto) {
        try {
            final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(texto.getBytes(Charset.forName("UTF8")));
            final byte[] resultByte = messageDigest.digest();
            String s = "";
            for (int i = 0; i < resultByte.length; i++) {
                s += Integer.toHexString((resultByte[i] >> 4) & 0xf);
                s += Integer.toHexString(resultByte[i] & 0xf);
            }
            System.out.println("Resumen MD5: " + s);
            return s;
        } catch (Exception excpt) {
            excpt.printStackTrace(System.err);
            return null;
        }
    }
}
