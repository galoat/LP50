/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.databaselp50.core.service;

import com.utbm.databaselp50.core.entity.Enjoy;
import com.utbm.databaselp50.core.entity.Position;
import com.utbm.databaselp50.core.repositoryHibernate.HibernateEnjoyRepository;
import java.util.List;

/**
 *
 * @author galoat
 */
public class ServicePosition {
    public List<Position> getListPosition()
        {
            HibernateEnjoyRepository enjoyRepository = new HibernateEnjoyRepository();
            return enjoyRepository.getListPosition();
        }
    
       public void addPosition(float x,float y, String nom)
        {
            HibernateEnjoyRepository enjoyRepository = new HibernateEnjoyRepository();
            enjoyRepository.addPosition(x, nom, y);
        }
}
