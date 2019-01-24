/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warstwa_integracjiORM;

import entities.Trener;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kkk
 */
@Stateless
public class TrenerFacade extends AbstractFacade<Trener> {

    @PersistenceContext(unitName = "WebFitnessPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrenerFacade() {
        super(Trener.class);
    }
    
}
