/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Catalogolibros;
import com.infosgroup.prueba.model.entities.Compania;
import com.infosgroup.prueba.model.entities.Libro;
import com.infosgroup.prueba.model.entities.LibroPK;
import com.infosgroup.prueba.model.entities.PeriodoEscolar;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class LibroFacade extends AbstractFacade<Libro, LibroPK> {

    public LibroFacade() {
        super(Libro.class);
    }
    
    public Integer cantidadLibros(PeriodoEscolar p, Compania c, Catalogolibros t)
    {
        Integer resultado ;
        try
        {
        TypedQuery<Integer> tq = getEntityManager().createQuery("SELECT MAX(l.fin) FROM Libro l WHERE l.libroPK.idPeriodoEscolar = :periodoEscolar AND l.libroPK.codigoInstitucion = :ocdigoInstitucion AND l.libroPK.codigoCatalogo = :codigoCatalogo", Integer.class);
        tq.setParameter("periodoEscolar", p.getId());
        tq.setParameter("ocdigoInstitucion", c.getCodigo());
        tq.setParameter("codigoCatalogo", t.getCatalogolibrosPK().getCodigolibro());
        resultado = tq.getSingleResult();
        return (resultado == null) ? 0 : resultado;
        }
        catch(Exception excpt)
        {
            resultado = 0;
        }
        return resultado;
    }
}