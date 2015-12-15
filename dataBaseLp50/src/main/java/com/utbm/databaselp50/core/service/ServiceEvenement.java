/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.databaselp50.core.service;

import com.utbm.databaselp50.core.entity.Evenement;
import com.utbm.databaselp50.core.repositoryHibernate.HibernateEvenementRepository;
import java.util.Date;
import java.util.List;

/**
 *
 * @author nicolas
 */
public class ServiceEvenement {
    
    public List<Evenement> getListEvenement()
    {
        HibernateEvenementRepository evenementRepository = new HibernateEvenementRepository();
        return evenementRepository.getListEvenement();
    }
    
    public Evenement getById(int id)
    {
        HibernateEvenementRepository evenementRepository = new HibernateEvenementRepository();
        return evenementRepository.getById(id);
    }
    
    public void addCommentById(int id, String com)
    {
        HibernateEvenementRepository evenementRepository = new HibernateEvenementRepository();
        evenementRepository.addCommentById(id, com);
    }
    
    public List<Evenement> getEvenementByDate (Date date )
    {
        HibernateEvenementRepository evenementRepository = new HibernateEvenementRepository();
        return evenementRepository.getEvenementByDate(date);
    }
}
