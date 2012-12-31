/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.ldap;

import com.unboundid.ldap.sdk.Control;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.persist.LDAPPersistException;
import com.unboundid.ldap.sdk.persist.LDAPPersister;
import com.unboundid.ldap.sdk.persist.PersistedObjects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author root
 */
public final class LDAPManager
{

private static LDAPManager ldapManagerInstance = null;
private static LDAPPersister<UsuarioLDAP> persister = null;
private static LDAPConnection conexion = null;

public static LDAPManager getInstance()
{
    if (ldapManagerInstance == null)
        {
        ldapManagerInstance = new LDAPManager();
        }
    return ldapManagerInstance;
}

static
    {
    try
        {
        persister = LDAPPersister.getInstance(UsuarioLDAP.class);
        conexion = new LDAPConnection("127.0.0.1", 389, "cn=Directory Manager", "infos");
        }
    catch (Exception ex)
        {
        Logger.getLogger(LDAPManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

@Override
public Object clone() throws CloneNotSupportedException
{
    throw new CloneNotSupportedException();
}

public UsuarioLDAP buscar(String cn)
{
    UsuarioLDAP ul = new UsuarioLDAP();
    ul.setCn(cn);
    PersistedObjects<UsuarioLDAP> po;
    try
        {
        po = persister.search(ul, conexion);
        UsuarioLDAP u = po.next();
        return u;
        }
    catch (LDAPPersistException ex)
        {
        Logger.getLogger(LDAPManager.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
}

public void crear(UsuarioLDAP u)
{

    try
        {
        persister.add(u, conexion, "ou=usuarios,dc=infosgroup,dc=com", new Control("1"));
        }
    catch (LDAPPersistException ex)
        {
        Logger.getLogger(LDAPManager.class.getName()).log(Level.SEVERE, null, ex);
        }
}

public void eliminar(UsuarioLDAP u)
{
    try
        {
        persister.delete(u, conexion, new Control("1"));
        }
    catch (LDAPPersistException ex)
        {
        Logger.getLogger(LDAPManager.class.getName()).log(Level.SEVERE, null, ex);
        }
}
}