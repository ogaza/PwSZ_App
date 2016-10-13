/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet.repozytoria;

import java.util.ArrayList;
import java.util.List;
import mojbudzet.encje.Kategoria;
import mojbudzet.encje.Wpis;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Repozytorium {

    public List<Kategoria> pobierzKategorie() {

        List<Kategoria> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            result = session.
                    createQuery("select p from " + Kategoria.class.getName() + " p").list();

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

        return result;
    }

    public int dodajKategorie(String nazwa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        int id = 0;

        try {
            tx = session.beginTransaction();
            Kategoria kategoria = new Kategoria(nazwa);
            id = (int) session.save(kategoria);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return id;
    }

    public void usunKategorie(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Kategoria kategoria
                    = (Kategoria) session.get(Kategoria.class, id);
            session.delete(kategoria);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }

    public int dodajKategorie(Kategoria kategoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        int id = 0;

        try {
            tx = session.beginTransaction();
            id = (int) session.save(kategoria);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return id;
    }

    public List<Wpis> pobierzWpisy() {

        List<Wpis> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            result = session.
                    createQuery("select w from " + Wpis.class.getName() + " w").
                    list();
//            for (Iterator iterator
//                    = result.iterator(); iterator.hasNext();) {
//                Wpis wpis = (Wpis) iterator.next();
//                Kategoria kategoria = wpis.getKategoria();
//
//                int id = kategoria.getId();
//                // tutaj zadziala nawet bez lazy na false, bo mamy sesje
//                String nazwa = kategoria.getNazwa();
//
//                int x = 0;
//            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }

        return result;
    }

    public int dodajWpis(Wpis wpis) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        int id = 0;

        try {
            tx = session.beginTransaction();
            id = (int) session.save(wpis);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
        return id;
    }
    
    public void usunWpis(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Wpis wpis
                    = (Wpis) session.get(Wpis.class, id);
            session.delete(wpis);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            session.close();
        }
    }
}
