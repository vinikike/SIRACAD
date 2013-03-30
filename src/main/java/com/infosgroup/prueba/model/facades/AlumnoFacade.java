/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Alumno;
import com.infosgroup.prueba.model.entities.AlumnoPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class AlumnoFacade extends AbstractFacade<Alumno, AlumnoPK> {

    public AlumnoFacade() {
        super(Alumno.class);
    }

    public List<Alumno> findByNIE(String nie) {
        TypedQuery<Alumno> tq = getEntityManager().createQuery("SELECT a FROM Alumno a WHERE a.alumnoPK.nie = :nie", Alumno.class);
        tq.setParameter("nie", nie);
        return tq.getResultList();
    }

    public List<Alumno> findByNivel(String nivel) {
        TypedQuery<Alumno> tq = getEntityManager().createQuery("SELECT a FROM Alumno a WHERE a.estudio.nivel = :nivel", Alumno.class);
        tq.setParameter("nivel", nivel);
        return tq.getResultList();
    }
}
