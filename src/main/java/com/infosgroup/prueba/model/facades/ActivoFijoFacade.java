/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Activofijo;
import com.infosgroup.prueba.model.entities.Catalogoactivo;
import com.infosgroup.prueba.model.entities.Compania;
import com.infosgroup.prueba.model.entities.PeriodoEscolar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import org.bouncycastle.asn1.x509.qualified.BiometricData;

/**
 *
 * @author Guille
 */
@Stateless
public class ActivoFijoFacade extends AbstractFacade<Activofijo, String> {

    public ActivoFijoFacade() {
        super(Activofijo.class);
    }

    public Integer max() {
        TypedQuery<Integer> tq = getEntityManager().createQuery("SELECT MAX(b.activofijoPK.codigocorrelativo) FROM Activofijo b", Integer.class);
        Integer resultado = tq.getSingleResult();
        return (resultado == null) ? 0 : resultado;
    }

    public Integer cantidadActivos(PeriodoEscolar p, Compania c, Catalogoactivo t) {
        Integer resultado;
        try {
            TypedQuery<Integer> tq = getEntityManager().createQuery("SELECT MAX(l.fin) FROM Activofijo l WHERE l.activofijoPK.idperiodoescolar = :periodoEscolar AND l.activofijoPK.codigoinstitucion = :ocdigoInstitucion AND l.activofijoPK.codigocatalogo = :codigoCatalogo", Integer.class);
            tq.setParameter("periodoEscolar", p.getId());
            tq.setParameter("ocdigoInstitucion", c.getCodigo());
            tq.setParameter("codigoCatalogo", t.getCatalogoactivoPK().getCodigoactivo());
            resultado = tq.getSingleResult();
            return (resultado == null) ? 0 : resultado;
        } catch (Exception excpt) {
            resultado = 0;
        }
        return resultado;
    }
}
