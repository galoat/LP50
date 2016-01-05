/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.webservicelp50.core.servlet.position;

import com.utbm.databaselp50.core.service.ServicePosition;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author galoat
 */
public class NewPosition extends HttpServlet {

  

    
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        response.setContentType("text/html;charset=UTF-8");
    
        this.getServletContext().getRequestDispatcher( "/newposition.jsp" ).forward( request, response );
        
    }
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String name = req.getParameter("Name");
        String x   = req.getParameter("x");   
        String y = req.getParameter("y");
        
        ServicePosition sp = new ServicePosition();
        sp.addPosition(Float.parseFloat(x), Float.parseFloat(y), name);
    
    
    }
    
  

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
