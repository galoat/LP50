/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.databaselp50.core.repositoryHibernate;

import com.utbm.databaselp50.core.entity.CommentaireEnjoy;
import com.utbm.databaselp50.core.entity.Enjoy;
import com.utbm.databaselp50.core.entity.Evenement;
import com.utbm.databaselp50.core.entity.Position;
import com.utbm.databaselp50.core.util.HibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.classic.Session;

/**
 *
 * @author nicolas
 */
public class HibernateEnjoyRepository {
     
    public void addPosition(float x, String nom, float y)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try {
            session.beginTransaction();       
            Position p = new Position(x,y,nom);
            session.persist(p);
             session.getTransaction().commit();
        } catch (HibernateException he) 
        {
            he.printStackTrace();
            if(session.getTransaction() != null)
            {
                try {
                        session.getTransaction().rollback();
                    } catch(HibernateException he2)
                    {
                        he2.printStackTrace();
                    }
            }
        } finally
        {
            if(session != null) 
            {
                try
                { 
                    session.close();
                }
                catch (HibernateException he) 
                {
                }
            }
        }
          
    }
     public List<Position> getListPosition()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Position> listeEnjoy = null;
        
        try 
        {
            session.beginTransaction();
            Query query = session.createQuery("from Position");
            listeEnjoy= query.list();
            
            session.getTransaction().commit();
        } catch (HibernateException he) 
        {
            he.printStackTrace();
            if(session.getTransaction() != null)
            {
                try {
                        session.getTransaction().rollback();
                    } catch(HibernateException he2)
                    {
                        he2.printStackTrace();
                    }
            }
        } finally
        {
            if(session != null) 
            {
                try
                { 
                    session.close();
                }
                catch (HibernateException he) 
                {
                }
            }
        }
        return listeEnjoy;
        
    }
    
    public void addNewEnjoy( Enjoy newEnjoy )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
   	try 
        {
            session.beginTransaction();
	    session.persist(newEnjoy);
	    session.getTransaction().commit();
	} catch (HibernateException he) {
            he.printStackTrace();
            if(session.getTransaction() != null) { 
                try {
                    session.getTransaction().rollback();	
                } catch(HibernateException he2) {
                    he2.printStackTrace();
                } 
            }
        } finally {
            if(session != null) {
                try { session.close();

                }
                catch (HibernateException he) {
                }
            }
        }
    }
    
    public List<Enjoy> getListEnjoy()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Enjoy> listeEnjoy = null;
        
        try 
        {
            session.beginTransaction();
            Query query = session.createQuery("from Enjoy");
            listeEnjoy= query.list();
            
            session.getTransaction().commit();
        } catch (HibernateException he) 
        {
            he.printStackTrace();
            if(session.getTransaction() != null)
            {
                try {
                        session.getTransaction().rollback();
                    } catch(HibernateException he2)
                    {
                        he2.printStackTrace();
                    }
            }
        } finally
        {
            if(session != null) 
            {
                try
                { 
                    session.close();
                }
                catch (HibernateException he) 
                {
                }
            }
        }
        return listeEnjoy;
        
    }
    
     public Enjoy getById(int id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Enjoy e = null;
        
        try 
        {   
            session.beginTransaction();       
            e= (Enjoy)session.get(Enjoy.class,id);
            if(e != null)
            {
                Hibernate.initialize(e.getCommentaires());
            }
            session.getTransaction().commit();
        } catch (HibernateException he) 
        {
            he.printStackTrace();
            if(session.getTransaction() != null)
            {
                try {
                        session.getTransaction().rollback();
                    } catch(HibernateException he2)
                    {
                        he2.printStackTrace();
                    }
            }
        } finally
        {
            if(session != null) 
            {
                try
                { 
                    session.close();
                }
                catch (HibernateException he) 
                {
                }
            }
        }
        return e;
        
    }
     
    public void newNoteById ( int id , int note )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try 
        {   
            Enjoy e = null;
            session.beginTransaction();       
            e= (Enjoy)session.get(Enjoy.class,id);
            
            double nouvelleNote = ( (e.getNbrNote() * e.getNote()) + note )/(e.getNbrNote()+1);
            
            e.setNbrNote(e.getNbrNote() + 1 );
            e.setNote(nouvelleNote);
            
            session.getTransaction().commit();
        } catch (HibernateException he) 
        {
            he.printStackTrace();
            if(session.getTransaction() != null)
            {
                try {
                        session.getTransaction().rollback();
                    } catch(HibernateException he2)
                    {
                        he2.printStackTrace();
                    }
            }
        } finally
        {
            if(session != null) 
            {
                try
                { 
                    session.close();
                }
                catch (HibernateException he) 
                {
                }
            }
        }
          
    }
    
    public void addCommentById(int id, String com, String user)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        try 
        {   
            Enjoy e = null;
            session.beginTransaction();       
            e= (Enjoy)session.get(Enjoy.class,id);
         
             Hibernate.initialize(e.getCommentaires());  
            
            CommentaireEnjoy commentaire = new CommentaireEnjoy();
            commentaire.setCommentaire(com);
            commentaire.setUser(user);
             e.getCommentaires().add(commentaire);
            
            session.getTransaction().commit();
        } catch (HibernateException he) 
        {
            he.printStackTrace();
            if(session.getTransaction() != null)
            {
                try {
                        session.getTransaction().rollback();
                    } catch(HibernateException he2)
                    {
                        he2.printStackTrace();
                    }
            }
        } finally
        {
            if(session != null) 
            {
                try
                { 
                    session.close();
                }
                catch (HibernateException he) 
                {
                }
            }
        }
          
    }
   
    public List<Enjoy> geListEnjoyByName (String name )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Enjoy> listeEnjoy = null;
        
        try 
        {
            session.beginTransaction();
                        
            Query query = session.createQuery("from Enjoy en where en.name like '%" + name + "%'");
            listeEnjoy = query.list();    
            session.getTransaction().commit();
        } catch (HibernateException he) 
        {
            he.printStackTrace();
            if(session.getTransaction() != null)
            {
                try {
                        session.getTransaction().rollback();
                    } catch(HibernateException he2)
                    {
                        he2.printStackTrace();
                    }
            }
        } finally
        {
            if(session != null) 
            {
                try
                { 
                    session.close();
                }
                catch (HibernateException he) 
                {
                }
            }
        }
        return listeEnjoy;
    }
      public List<Enjoy> geListEnjoyByType (String name )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Enjoy> listeEnjoy = null;
        
        try 
        {
            session.beginTransaction();
                        
            Query query = session.createQuery("from Enjoy en where en.type like '%" + name + "%'");
            listeEnjoy = query.list();    
            session.getTransaction().commit();
        } catch (HibernateException he) 
        {
            he.printStackTrace();
            if(session.getTransaction() != null)
            {
                try {
                        session.getTransaction().rollback();
                    } catch(HibernateException he2)
                    {
                        he2.printStackTrace();
                    }
            }
        } finally
        {
            if(session != null) 
            {
                try
                { 
                    session.close();
                }
                catch (HibernateException he) 
                {
                }
            }
        }
        return listeEnjoy;
    }
}
