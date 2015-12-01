/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.databaselp50.core.service;

import com.utbm.databaselp50.core.entity.Evenement;
import com.utbm.databaselp50.repositoryHibernate.HibernateEvenementRepository;
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
    
}
