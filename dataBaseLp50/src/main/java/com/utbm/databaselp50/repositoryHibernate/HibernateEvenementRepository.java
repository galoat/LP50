/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.databaselp50.repositoryHibernate;

import com.utbm.databaselp50.core.entity.Evenement;
import com.utbm.databaselp50.core.util.HibernateUtil;
import java.util.List;
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
