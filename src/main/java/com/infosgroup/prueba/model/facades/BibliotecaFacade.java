/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infosgroup.prueba.model.facades;

import com.infosgroup.prueba.model.entities.Biblioteca;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import org.bouncycastle.asn1.x509.qualified.BiometricData;

/**
 *
 * @author Guille
 */
@Stateless
public class BibliotecaFacade extends AbstractFacade<Biblioteca, String> {

    public BibliotecaFacade() {
        super(Biblioteca.class);
    }

    public Integer max() {
        TypedQuery<Integer> tq = getEntityManager().createQuery("SELECT MAX(b.bibliotecaPK.codigoCorrelativo) FROM Biblioteca b", Integer.class);
        Integer resultado = tq.getSingleResult();
        return (resultado == null) ? 0 : resultado;
    }
    
    public List<Biblioteca> findByAutor(String autor)
    {
        TypedQuery<Biblioteca> tq = getEntityManager().createQuery("SELECT b FROM Biblioteca b WHERE UPPER(b.autor) LIKE UPPER(:autor)", entityClass);
        tq.setParameter("autor", "%"+autor+"%");
        return tq.getResultList();
    }
    
        public List<Biblioteca> findByTitulo(String titulo)
    {
        TypedQuery<Biblioteca> tq = getEntityManager().createQuery("SELECT b FROM Biblioteca b WHERE UPPER(b.titulo) LIKE UPPER(:titulo)", entityClass);
        tq.setParameter("titulo", "%"+titulo+"%");
        return tq.getResultList();
    }
}
