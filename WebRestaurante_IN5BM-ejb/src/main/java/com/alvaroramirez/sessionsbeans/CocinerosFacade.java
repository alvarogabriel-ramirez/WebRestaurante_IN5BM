/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alvaroramirez.sessionsbeans;

import com.alvaroramirez.entities.Cocineros;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author programacion
 */
@Stateless
public class CocinerosFacade extends AbstractFacade<Cocineros> implements CocinerosFacadeLocal {

    @PersistenceContext(unitName = "WebRestaurantePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CocinerosFacade() {
        super(Cocineros.class);
    }
    
}
