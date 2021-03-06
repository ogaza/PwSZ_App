/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mojbudzet.repozytoria;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mojbudzet.encje.Kategoria;
import mojbudzet.encje.Wpis;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Repozytorium {

    public Kategoria pobierzKategorie(int id) {

        Kategoria result = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("select k from "
                    + Kategoria.class.getName()
                    + " w where k.id = :id");

            query.setInteger("id", id);

            query.setMaxResults(1);
            
            result = (Kategoria) query.uniqueResult();           

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

    public int edytujKategorie(Kategoria kategoria) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        int id = 0;

        try {
            tx = session.beginTransaction();
            
            Query query = session.createQuery("select k from "
                    + Kategoria.class.getName()
                    + " k where k.id = :id");

            query.setInteger("id", kategoria.getId());

            query.setMaxResults(1);
            
            Kategoria result = (Kategoria) query.uniqueResult();
            
            result.setNazwa(kategoria.getNazwa());            
            
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

    public Wpis pobierzWpis(int id) {

        Wpis result = null;

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("select w from "
                    + Wpis.class.getName()
                    + " w where w.id = :id");

            query.setInteger("id", id);

            query.setMaxResults(1);
            
            result = (Wpis) query.uniqueResult();           

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

    public List<Wpis> pobierzWpisyDlaKategorii(Kategoria kategoria) {

        List<Wpis> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("select w from "
                    + Wpis.class.getName()
                    + " w where w.kategoria.id = :id");

            query.setInteger("id", kategoria.getId());

            result = query.list();

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

    public List<Wpis> pobierzWpisyDlaOkresu(Date start, Date koniec) {

        List<Wpis> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("select w from "
                    + Wpis.class.getName()
                    + " w where w.data BETWEEN :start and :koniec");

            query.setDate("start", start);
            query.setDate("koniec", koniec);

            result = query.list();

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

    public List<Wpis> pobierzWpisyTypu(byte typ) {

        List<Wpis> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("select w from "
                    + Wpis.class.getName()
                    + " w where w.typ = :typ");

            query.setByte("typ", typ);

            result = query.list();

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

    public int edytujWpis(Wpis wpis) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        int id = 0;

        try {
            tx = session.beginTransaction();
            
            Query query = session.createQuery("select w from "
                    + Wpis.class.getName()
                    + " w where w.id = :id");

            query.setInteger("id", wpis.getId());

            query.setMaxResults(1);
            
            Wpis result = (Wpis) query.uniqueResult();
            
            result.setData(wpis.getData());
            result.setTyp(wpis.getTyp());
            result.setKategoria(wpis.getKategoria());
            result.setWartosc(wpis.getWartosc());
            
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
