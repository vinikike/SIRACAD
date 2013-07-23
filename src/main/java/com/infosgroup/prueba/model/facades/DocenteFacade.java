/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Docente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class DocenteFacade extends AbstractFacade<Docente, String> {

    public DocenteFacade() {
        super(Docente.class);
    }

    public List<Docente> findDocentesConUsuario() {
        TypedQuery<Docente> tq = getEntityManager().createQuery("SELECT u.docente FROM Usuario u WHERE u.docente IS NOT NULL", entityClass);
        return tq.getResultList();
    }

    public List<Docente> findDocentesSinUsuario(List<Docente> listaDocentesConUsuario) {
        TypedQuery<Docente> tq = getEntityManager().createQuery("SELECT d FROM Docente d WHERE d NOT IN :listaDocentes", entityClass);
        tq.setParameter("listaDocentes", listaDocentesConUsuario);
        return tq.getResultList();
    }
}
