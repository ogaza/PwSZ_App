/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet;

import java.util.List;
import org.hibernate.Session;


public class Repo {
    public void createAndStoreEvent(String title) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        
        session.beginTransaction();

        Kategoria theEvent = new Kategoria();
        
        theEvent.setNazwa(title);
        
        session.save(theEvent);

        session.getTransaction().commit();
        
        HibernateUtil.getSessionFactory().close();
    }
    
    public List listEvents() {
        
        // Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
        
        // List result = session.createQuery("from kategoria").list();
        List result = session.createQuery("select p from " + Kategoria.class.getName() + " p").list();
        
        session.getTransaction().commit();
        
        HibernateUtil.getSessionFactory().close();
        
        return result;
    }
}
