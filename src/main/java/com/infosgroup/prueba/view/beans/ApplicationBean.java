/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.view.beans;

import com.infosgroup.prueba.view.AbstractJSFBean;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author root
 */
@ManagedBean(name = "ApplicationBean", eager = true)
@ApplicationScoped
public class ApplicationBean extends AbstractJSFBean implements Serializable
{

private static final long serialVersionUID = 1L;
//
//private LDAPConnection conexionLDAP = null;

@Override
@PostConstruct
public void _init()
{
    super._init();
//    try
//        {
//        conexionLDAP = new LDAPConnection("svrinfos02", 389, "cn=Directory Manager", "infos");
//        }
//    catch (LDAPException ex)
//        {
//        Logger.getLogger(ApplicationBean.class.getName()).log(Level.SEVERE, null, ex);
//        }
}
// =============================================================================

//public LDAPConnection getConexionLDAP()
//{
//    return conexionLDAP;
//}
//
//public void setConexionLDAP(LDAPConnection conexionLDAP)
//{
//    this.conexionLDAP = conexionLDAP;
//}
}
