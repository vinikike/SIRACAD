/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Menu;
import com.infosgroup.prueba.model.entities.Rol;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu, Integer> {
    @PersistenceContext(unitName = "WebApplicationPFPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuFacade() {
        super(Menu.class);
    }
    
// =========================================================================
@PermitAll
@SuppressWarnings("unchecked")
public List<Integer> findAllNivel0(Rol rol)
{
    TypedQuery<Integer> q = (TypedQuery<Integer>) getEntityManager().createNativeQuery("select m.id from menu m, menu_rol mr where m.id = mr.menu and m.menu_padre is null and mr.rol = ?1 order by m.id");
    q.setParameter(1, rol.getId());
    return q.getResultList();
}

@PermitAll
@SuppressWarnings("unchecked")
public List<Integer> menusHijosPorRol(Menu menuPadre, Rol rol)
{
    TypedQuery<Integer> q = (TypedQuery<Integer>) getEntityManager().createNativeQuery("select m.id from menu m, menu_rol mr where m.id = mr.menu and m.menu_padre = ?1 and mr.rol = ?2 order by m.id");
    q.setParameter(1, menuPadre.getId());
    q.setParameter(2, rol.getId());
    return q.getResultList();
}

}
