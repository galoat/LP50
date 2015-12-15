/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.webservicelp50.core.servletEvenement;

import com.utbm.databaselp50.core.service.ServiceEvenement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author nicolas
 */
public class ServletAddCommentaireById extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        serviceEvenement.addCommentById(3, "new comment2222" ,"marc dorcel");        
    }
}
