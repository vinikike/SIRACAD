/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Docente;
import com.infosgroup.prueba.model.entities.Grado;
import com.infosgroup.prueba.model.entities.GradoPK;
import com.infosgroup.prueba.model.entities.PeriodoEscolar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class GradoFacade extends AbstractFacade<Grado, GradoPK> {

    public GradoFacade() {
        super(Grado.class);
    }

    public String getSeccion(String nivel, String grado, String opcion) {
        try {
            TypedQuery<String> tq = getEntityManager().createQuery("SELECT MAX(g.gradoPK.seccion) FROM Grado g WHERE g.gradoPK.nivel = :nivel AND g.gradoPK.grado = :grado AND g.gradoPK.opcion = :opcion", String.class);
            tq.setParameter("nivel", nivel);
            tq.setParameter("grado", grado);
            tq.setParameter("opcion", opcion);
            return tq.getSingleResult();
        } catch (Exception excpt) {
            return null;
        }
    }
    
    public List<Grado> findGradosSinAsignar(PeriodoEscolar periodo)
    {
        TypedQuery<Grado> tq = getEntityManager().createQuery("SELECT g FROM Grado g WHERE g.periodoEscolar = :periodo AND g.docenteId IS NULL", entityClass);
        tq.setParameter("periodo", periodo);
        return tq.getResultList();
    }
    
    public List<Grado> findGradosAsignadosADocente(PeriodoEscolar periodo, Docente docente)
    {
        TypedQuery<Grado> tq = getEntityManager().createQuery("SELECT g FROM Grado g WHERE g.periodoEscolar = :periodo AND g.docenteId = :docente", entityClass);
        tq.setParameter("periodo", periodo);
        tq.setParameter("docente", docente);
        return tq.getResultList();
    }
}
