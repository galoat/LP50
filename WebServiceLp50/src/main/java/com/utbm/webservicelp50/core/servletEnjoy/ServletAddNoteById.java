/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.webservicelp50.core.servletEnjoy;

import com.utbm.databaselp50.core.service.ServiceEnjoy;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author nicolas
 */
public class ServletAddNoteById extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        ServiceEnjoy serviceEnjoy = new ServiceEnjoy();
         int id =Integer.parseInt(request.getParameter("id"));
          int note =Integer.parseInt(request.getParameter("note"));
        serviceEnjoy.newNoteById(id, note);
    }
}
