/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.databaselp50.core.client;

import com.utbm.databaselp50.core.entity.CommentaireEnjoy;
import com.utbm.databaselp50.core.entity.Enjoy;
import com.utbm.databaselp50.core.service.ServiceEnjoy;
import com.utbm.databaselp50.core.service.ServicePosition;
import java.util.List;

/**
 *
 * @author nicolas
 */
public class app {
     public static void main(String[] args)
     {
         
         
  
        // ServicePosition sp = new ServicePosition();
        // System.out.println(sp.getListPosition().toString());
         
        // Session session=HibernateUtil.getSessionFactory().openSession();
      //  ServiceEnjoy serviceEnjoy = new ServiceEnjoy();
        //serviceEnjoy.addCommentById(1, "new comment2222" ,"marc dorcel");   
         
        /* Session session=HibernateUtil.getSessionFactory().openSession();
         ServiceEvenement serviceEvenement = new ServiceEvenement();
         SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
         Date date = null;
         String date1 = "2015-01-24";

         try
        {
            date = simpleDateFormat.parse(date1);
            List<Evenement> liste = serviceEvenement.getEvenementByDate(date);
            
            System.err.println("liste evenement");
            for( Evenement e : liste)
            {
                System.err.println(e.getName());
                System.err.println(e.getType().getType());
            }
        } catch (ParseException e)
        {
            e.printStackTrace();
         }*/
         
        // serviceEvenement.getEvenementByDate(date)
       //  serviceEvenement.addCommentById(2, "nouveau comm test");
        /* Evenement e = serviceEvenement.getById(1);
        
         System.err.println("result : ");
         System.err.println(e.getId());
         System.err.println(e.getDescription());
         
         System.err.println("Commentaire : ");
         for ( CommentaireEven i : e.getCommentaires())
            System.err.println(i.getCommentaire());
         
         System.err.println("Type " + e.getType().getType());*/
              
     }
}
