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
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class MenuFacade extends AbstractFacade<Menu, Integer> {

    public MenuFacade() {
        super(Menu.class);
    }

// =========================================================================
    @PermitAll
    public List<Menu> findAllNivel0(Rol rol) {
        TypedQuery<Menu> tq = getEntityManager().createQuery("SELECT m FROM Menu m INNER JOIN m.rolList r WHERE m.menuPadre IS NULL AND r = :rol ORDER BY m.id ASC", entityClass);
        tq.setParameter("rol", rol);
        return tq.getResultList();
    }

    @PermitAll
    public List<Menu> menusHijosPorRol(Menu menuPadre, Rol rol) {
        TypedQuery<Menu> tq = getEntityManager().createQuery("SELECT m FROM Menu m INNER JOIN m.rolList r WHERE m.menuPadre = :menuPadre AND r = :rol ORDER BY m.id ASC", entityClass);
        tq.setParameter("menuPadre", menuPadre);
        tq.setParameter("rol", rol);
        return tq.getResultList();
    }
}
