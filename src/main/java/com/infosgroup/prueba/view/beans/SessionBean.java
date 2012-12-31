/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view.beans;

import com.infosgroup.ldap.LDAPManager;
import com.infosgroup.ldap.UsuarioLDAP;
import com.infosgroup.prueba.model.entities.Compania;
import com.infosgroup.prueba.model.entities.Menu;
import com.infosgroup.prueba.model.entities.Rol;
import com.infosgroup.prueba.model.entities.Usuario;
import com.infosgroup.prueba.model.facades.MenuFacade;
import com.infosgroup.prueba.model.facades.UsuarioFacade;
import com.infosgroup.prueba.view.AbstractJSFBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;

/**
 *
 * @author root
 */
@ManagedBean(name = "SessionBean")
@SessionScoped
public class SessionBean extends AbstractJSFBean implements Serializable
{

private static final long serialVersionUID = 1L;
//
@EJB
private transient UsuarioFacade usuarioFacade;
@EJB
private transient MenuFacade menuFacade;
//
private Usuario _usuario;
private Compania _compania;
private Rol _rol;
//
private DefaultMenuModel _menuBarModel;
private Date _fechaHoraInicioSesion;
//

@Override
@PostConstruct
public void _init()
{
    super._init();
    //
    List<Object> objs = new ArrayList<Object>();
    //
    _menuBarModel = new DefaultMenuModel();
    _menuBarModel.getContents().clear();
    //
    _fechaHoraInicioSesion = GregorianCalendar.getInstance().getTime();
    _usuario = usuarioFacade.find(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
    if (_usuario != null)
        {
        _compania = _usuario.getCompania();
        _rol = _usuario.getRol();
        List<Integer> listaIDMenus = menuFacade.findAllNivel0(_rol);
        List<Menu> listaMenus0 = new ArrayList<Menu>();
        for (Integer idMenu : listaIDMenus)
            {
            listaMenus0.add(menuFacade.find(idMenu));
            }
        List<UIComponent> listaMenusGenerados = generarMenu(listaMenus0);
        for (UIComponent objMenu : listaMenusGenerados)
            {
            _menuBarModel.getContents().add(objMenu);
            }
        }
    objs.add(_usuario != null ? _usuario.getUsuarioPK().getId() : "[Ninguno]");
    objs.add(_fechaHoraInicioSesion);
    logger.log(Level.INFO, "[Inicio de sesion del usuario {0}: {1}]", objs.toArray(new Object[0]));

//    try
//        {
//        LDAPManager ldapManager = LDAPManager.getInstance();
//
//        UsuarioLDAP u = new UsuarioLDAP();
//        u.setCn("vinikike");
//        u.setUid("vinikike");
//        u.setGivenName("Vinicio");
//        u.setSn("Mercado");
//        u.setUserPassword("vinikike");
//        ldapManager.crear(u);
//
//        u = ldapManager.buscar("vinikike");
//        logger.log(Level.WARNING, u.toString());
//
//        ldapManager.eliminar(u);
//        }
//    catch (Exception e)
//        {
//        }
}

// =============================================================================
private List<UIComponent> generarMenu(List<Menu> menus0)
{
    List<UIComponent> lo = new ArrayList<UIComponent>();
    if ((menus0 != null) && !menus0.isEmpty())
        {
        for (Menu menu : menus0)
            {
            List<Integer> menusHijosObj = menuFacade.menusHijosPorRol(menu, _rol);
            List<Menu> menusHijos = new ArrayList<Menu>();
            for (Integer codMenu : menusHijosObj)
                {
                menusHijos.add(menuFacade.find(codMenu));
                }
            if ((menusHijos == null) || menusHijos.isEmpty()) // es un menuitem!
                {
                MenuItem menuItem = new MenuItem();
                menuItem.setValue(menu.getTitulo());
                menuItem.setUrl(menu.getDireccion());
                menuItem.setIcon(menu.getIcono());
                lo.add(menuItem);
                }
            else // es un submenu!
                {
                Submenu submenu = new Submenu();
                submenu.setLabel(menu.getTitulo());
                submenu.setIcon(menu.getIcono());
                for (UIComponent obj : generarMenu(menusHijos))
                    {
                    submenu.getChildren().add(obj);
                    }
                lo.add(submenu);
                }
            }
        }
    return lo;
}

// =============================================================================
public Usuario getUsuario()
{
    return _usuario;
}

public void setUsuario(Usuario _usuario)
{
    this._usuario = _usuario;
}

public Compania getCompania()
{
    return _compania;
}

public void setCompania(Compania _compania)
{
    this._compania = _compania;
}

public Rol getRol()
{
    return _rol;
}

public void setRol(Rol _rol)
{
    this._rol = _rol;
}

// =======
public DefaultMenuModel getMenuBarModel()
{
    return _menuBarModel;
}

public void setMenuBarModel(DefaultMenuModel _menuBarModel)
{
    this._menuBarModel = _menuBarModel;
}

public Date getFechaHoraInicioSesion()
{
    return _fechaHoraInicioSesion;
}

public void setFechaHoraInicioSesion(Date fechaHoraInicioSesion)
{
    this._fechaHoraInicioSesion = fechaHoraInicioSesion;
}

}