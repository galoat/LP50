/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.databaselp50.core.repositoryHibernate;

import com.utbm.databaselp50.core.entity.Evenement;
import com.utbm.databaselp50.core.entity.CommentaireEven;
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
public class HibernateEvenementRepository {
    
    public List<Evenement> getListEvenement()
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Evenement> listeEvenement = null;
        
        try 
        {
            session.beginTransaction();
            Query query = session.createQuery("from Evenement");
            listeEvenement= query.list();     
              for ( Evenement e : listeEvenement)
                Hibernate.initialize(e.getType());
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
        return listeEvenement;
        
    }
    
    public Evenement getById(int id)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Evenement e = null;
        
        try 
        {   
            session.beginTransaction();       
            e= (Evenement)session.get(Evenement.class,id);
            Hibernate.initialize(e.getCommentaires());
            Hibernate.initialize(e.getType());
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
    
    
    public void addCommentById(int id, String com)
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        
        try 
        {   
            Evenement e = null;
            session.beginTransaction();       
            e= (Evenement)session.get(Evenement.class,id);
            Hibernate.initialize(e.getCommentaires());  
            
            CommentaireEven commentaire = new CommentaireEven();
            commentaire.setCommentaire(com);
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
    
    public List<Evenement> getEvenementByDate (Date date )
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Evenement> listeEvenement = null;
        
        try 
        {
            session.beginTransaction();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            
            Query query = session.createQuery("from Evenement ev where ev.startDate like '%" + simpleDateFormat.format(date) + "%'");
            listeEvenement= query.list();    
            for ( Evenement e : listeEvenement)
                Hibernate.initialize(e.getType());
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
        return listeEvenement;
    }
}



