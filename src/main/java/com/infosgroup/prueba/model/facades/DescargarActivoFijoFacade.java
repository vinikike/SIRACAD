/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Descargoactivo;
import com.infosgroup.prueba.model.entities.Catalogoactivo;
import com.infosgroup.prueba.model.entities.DescargoactivoPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Guille
 */
@Stateless
public class DescargarActivoFijoFacade extends AbstractFacade<Descargoactivo, DescargoactivoPK> {

    public DescargarActivoFijoFacade() {
        super(Descargoactivo.class);
    }

//    public Integer max() {
//        TypedQuery<Integer> tq = getEntityManager().createQuery("SELECT MAX(b.activofijoPK.codigocorrelativo) FROM Activofijo b", Integer.class);
//        Integer resultado = tq.getSingleResult();
//        return (resultado == null) ? 0 : resultado;
//    }
    
    public Integer max() {
        TypedQuery<Integer> tq = getEntityManager().createQuery("SELECT MAX(b.descargoactivoPK.codigocorrelativo) FROM Descargoactivo b", Integer.class);
        Integer resultado = tq.getSingleResult();
        return (resultado == null) ? 0 : resultado;
    }

        public List<Catalogoactivo> listaActivos() {
        TypedQuery<Catalogoactivo> tq = getEntityManager().createQuery("SELECT distinct c FROM Catalogoactivo c JOIN c.activofijoCollection a", Catalogoactivo.class);
        return tq.getResultList();   
    }
//    public Integer cantidadActivos(PeriodoEscolar p, Compania c, Catalogoactivo t) {
//        Integer resultado;
//        try {
//            TypedQuery<Integer> tq = getEntityManager().createQuery("SELECT MAX(l.fin) FROM Activofijo l WHERE l.activofijoPK.idperiodoescolar = :periodoEscolar AND l.activofijoPK.codigoinstitucion = :ocdigoInstitucion AND l.activofijoPK.codigocatalogo = :codigoCatalogo", Integer.class);
//            tq.setParameter("periodoEscolar", p.getId());
//            tq.setParameter("ocdigoInstitucion", c.getCodigo());
//            tq.setParameter("codigoCatalogo", t.getCatalogoactivoPK().getCodigoactivo());
//            resultado = tq.getSingleResult();
//            return (resultado == null) ? 0 : resultado;
//        } catch (Exception excpt) {
//            resultado = 0;
//        }
//        return resultado;
//    }
}
