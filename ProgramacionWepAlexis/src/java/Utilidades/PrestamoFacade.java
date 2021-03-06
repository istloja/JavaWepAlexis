/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AlexisO
 */
@Stateless
public class PrestamoFacade extends AbstractFacade<Prestamo> {

    @PersistenceContext(unitName = "ProgramacionWepAlexisPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestamoFacade() {
        super(Prestamo.class);
    }
    
}
