/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view;

import com.infosgroup.prueba.model.entities.Menu;
import com.infosgroup.prueba.model.entities.Rol;
import com.infosgroup.prueba.model.entities.Usuario;
import com.infosgroup.prueba.model.facades.MenuFacade;
import com.infosgroup.prueba.model.facades.PeriodoEscolarFacade;
import com.infosgroup.prueba.model.facades.UsuarioFacade;
import com.infosgroup.prueba.view.beans.SessionBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;

/**
 *
 * @author root
 */
@ManagedBean(name = "loginManager")
@ViewScoped
public class LoginManager extends AbstractJSFBean implements Serializable {

    private static final long serialVersionUID = 1L;
//
    @EJB
    private transient UsuarioFacade usuarioFacade;
    @EJB
    private transient MenuFacade menuFacade;
    @EJB
    private transient PeriodoEscolarFacade periodoEscolarFacade;
//
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
//
    //
    private String usuario;
    private String pass;

    @Override
    @PostConstruct
    public void _init() {
        super._init();
    }

// ==============================================================================
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

// ==============================================================================
    public String iniciarSesion$action() {
        String navegacion = null;
        List<Object> objs = new ArrayList<>();
        sessionBean.setMenuBarModel(new DefaultMenuModel());
        sessionBean.getMenuBarModel().getContents().clear();
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            request.login(usuario, pass);
            FacesContext.getCurrentInstance().getExternalContext().getSession(true);

            Usuario u = usuarioFacade.find(usuario);

            sessionBean.setUsuario(u);
            sessionBean.setPeriodoEscolar(periodoEscolarFacade.find(periodoEscolarFacade.max()));
            sessionBean.setCompania(sessionBean.getUsuario().getCompania());
            sessionBean.setRol(sessionBean.getUsuario().getRol());
            sessionBean.setFechaHoraInicioSesion(GregorianCalendar.getInstance().getTime());
            List<Menu> listaMenus0 = menuFacade.findAllNivel0(sessionBean.getRol());
            List<UIComponent> listaMenusGenerados = generarMenu(listaMenus0, sessionBean.getRol());
            for (UIComponent objMenu : listaMenusGenerados) {
                sessionBean.getMenuBarModel().getContents().add(objMenu);
            }
            objs.add(usuario != null ? usuario : "[Ninguno]");
            objs.add(sessionBean.getFechaHoraInicioSesion());
            logger.log(Level.INFO, "[Inicio de sesion del usuario {0}: {1}]", objs.toArray(new Object[0]));
            navegacion = inicio$action();
        } catch (Exception excpt) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_ERROR, "No se permite el inicio de sesión: Nombre de usuario y/o contraseña incorrectos");
            excpt.printStackTrace(System.err);
            navegacion = null;
        } finally {
            return navegacion;
        }
    }

    public String cerrarSesion$action() {
        String navegacion = null;
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

            List<Object> objs = new ArrayList<>();
            objs.add(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
            objs.add(GregorianCalendar.getInstance().getTime());
            logger.log(Level.INFO, "[Cierre de sesion del usuario {0}: {1}]", objs.toArray(new Object[0]));

            request.logout();
            session.invalidate();

            navegacion = inicio$action();
        } catch (Exception excpt) {
            mostrarMensajeJSF(FacesMessage.SEVERITY_ERROR, excpt.toString());
            excpt.printStackTrace(System.err);
            navegacion = null;
        } finally {
            return navegacion;
        }
    }

    // =============================================================================
    private List<UIComponent> generarMenu(List<Menu> menus0, Rol _rol) {
        List<UIComponent> lo = new ArrayList<>();
        if ((menus0 != null) && !menus0.isEmpty()) {
            for (Menu menu : menus0) {
                List<Menu> menusHijos = menuFacade.menusHijosPorRol(menu, _rol);
                if (/*(menusHijos == null) ||*/menusHijos.isEmpty()) // es un menuitem!
                {
                    MenuItem menuItem = new MenuItem();
                    menuItem.setValue(menu.getTitulo());
                    menuItem.setUrl(menu.getDireccion());
                    menuItem.setIcon(menu.getIcono());
                    lo.add(menuItem);
                } else // es un submenu!
                {
                    Submenu submenu = new Submenu();
                    submenu.setLabel(menu.getTitulo());
                    submenu.setIcon(menu.getIcono());
                    for (UIComponent obj : generarMenu(menusHijos, _rol)) {
                        submenu.getChildren().add(obj);
                    }
                    lo.add(submenu);
                }
            }
        }
        return lo;
    }
}