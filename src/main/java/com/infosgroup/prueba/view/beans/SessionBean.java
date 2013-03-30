/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view.beans;

import com.infosgroup.prueba.model.entities.Alumno;
import com.infosgroup.prueba.model.entities.Compania;
import com.infosgroup.prueba.model.entities.PeriodoEscolar;
import com.infosgroup.prueba.model.entities.Rol;
import com.infosgroup.prueba.model.entities.Usuario;
import com.infosgroup.prueba.view.AbstractJSFBean;
import java.io.Serializable;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DefaultMenuModel;

/**
 *
 * @author root
 */
@ManagedBean(name = "SessionBean")
@SessionScoped
public class SessionBean extends AbstractJSFBean implements Serializable {

    private static final long serialVersionUID = 1L;
//
//    @EJB
//    private transient UsuarioFacade usuarioFacade;
//
    private Usuario _usuario;
    private Compania _compania;
    private Rol _rol;
    private PeriodoEscolar _periodoEscolar;
//
    private DefaultMenuModel _menuBarModel;
    private Date _fechaHoraInicioSesion;
//

    @Override
    @PostConstruct
    public void _init() {
        super._init();
//////////        //
//////////        List<Object> objs = new ArrayList<>();
//////////        //
//////////        _menuBarModel = new DefaultMenuModel();
//////////        _menuBarModel.getContents().clear();
//////////        //
//////////        _fechaHoraInicioSesion = GregorianCalendar.getInstance().getTime();
//////////        // TODO: Cambiar periodo escolar
//////////        _usuario = usuarioFacade.find(new UsuarioPK(2012, FacesContext.getCurrentInstance().getExternalContext().getRemoteUser()));
//////////        if (_usuario != null) {
//////////            _compania = _usuario.getCompania();
//////////            _rol = _usuario.getRol();
//////////            List<Menu> listaMenus0 = menuFacade.findAllNivel0(_rol);
//////////            List<UIComponent> listaMenusGenerados = generarMenu(listaMenus0);
//////////            for (UIComponent objMenu : listaMenusGenerados) {
//////////                _menuBarModel.getContents().add(objMenu);
//////////            }
//////////        }
//////////        objs.add(_usuario != null ? _usuario.getUsuarioPK().getId() : "[Ninguno]");
//////////        objs.add(_fechaHoraInicioSesion);
//////////        logger.log(Level.INFO, "[Inicio de sesion del usuario {0}: {1}]", objs.toArray(new Object[0]));

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
    public Usuario getUsuario() {
        return _usuario;
    }

    public void setUsuario(Usuario _usuario) {
        this._usuario = _usuario;
    }

    public Compania getCompania() {
        return _compania;
    }

    public void setCompania(Compania _compania) {
        this._compania = _compania;
    }

    public Rol getRol() {
        return _rol;
    }

    public void setRol(Rol _rol) {
        this._rol = _rol;
    }

    public PeriodoEscolar getPeriodoEscolar() {
        return _periodoEscolar;
    }

    public void setPeriodoEscolar(PeriodoEscolar _periodoEscolar) {
        this._periodoEscolar = _periodoEscolar;
    }

// =======
    public DefaultMenuModel getMenuBarModel() {
        return _menuBarModel;
    }

    public void setMenuBarModel(DefaultMenuModel _menuBarModel) {
        this._menuBarModel = _menuBarModel;
    }

    public Date getFechaHoraInicioSesion() {
        return _fechaHoraInicioSesion;
    }

    public void setFechaHoraInicioSesion(Date fechaHoraInicioSesion) {
        this._fechaHoraInicioSesion = fechaHoraInicioSesion;
    }
// ***********************************************************
    private Alumno alumno;

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
}