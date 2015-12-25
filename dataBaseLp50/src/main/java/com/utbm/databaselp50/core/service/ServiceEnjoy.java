/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.databaselp50.core.service;

import com.utbm.databaselp50.core.entity.Enjoy;
import com.utbm.databaselp50.core.repositoryHibernate.HibernateEnjoyRepository;
import java.util.List;

/**
 *
 * @author nicolas
 */
public class ServiceEnjoy {
   public List<Enjoy> getListEnjoy()
        {
            HibernateEnjoyRepository enjoyRepository = new HibernateEnjoyRepository();
            return enjoyRepository.getListEnjoy();
        }
   
        public Enjoy getById(int id)
        {
            HibernateEnjoyRepository enjoyRepository = new HibernateEnjoyRepository();
            return enjoyRepository.getById(id);
        }
      
        public void addCommentById(int id, String com, String user)
        {   System.out.println(id+" "+com+" "+user);
            HibernateEnjoyRepository enjoyRepository = new HibernateEnjoyRepository();
            enjoyRepository.addCommentById(id, com, user);
        }
        
        public List<Enjoy> getListEnjoyByName (String name )
        {
            HibernateEnjoyRepository enjoyRepository = new HibernateEnjoyRepository();
            return enjoyRepository.geListEnjoyByName(name);
        }
        
        public void newNoteById ( int id , int note )
        {
            HibernateEnjoyRepository enjoyRepository = new HibernateEnjoyRepository();
            enjoyRepository.newNoteById(id, note);
        }
}

