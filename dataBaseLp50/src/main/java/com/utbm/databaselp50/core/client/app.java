/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.databaselp50.core.client;

import com.utbm.databaselp50.core.entity.Evenement;
import com.utbm.databaselp50.core.service.ServiceEvenement;
import com.utbm.databaselp50.core.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author nicolas
 */
public class app {
     public static void main(String[] args)
     {
        //Session session=HibernateUtil.getSessionFactory().openSession();
         ServiceEvenement serviceEvenement = new ServiceEvenement();
         List<Evenement> listEvenement = serviceEvenement.getListEvenement();
         for ( Evenement i : listEvenement)
         {
             System.out.println(i.getId() + " " +  i.getName());
         }
    }
}
