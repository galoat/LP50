/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.webservicelp50.core.servletEnjoy;

import com.utbm.databaselp50.core.entity.Enjoy;
import com.utbm.databaselp50.core.service.ServiceEnjoy;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nicolas
 */
public class NewEnjoy extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        response.setContentType("text/html;charset=UTF-8");
    
        this.getServletContext().getRequestDispatcher( "/newEnjoyJsp.jsp" ).forward( request, response );
        
    }
      
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
      
  
        String name = req.getParameter("Name");
        String type   = req.getParameter("Type");   
        String description = req.getParameter("Description");
        String h_Lundi = req.getParameter("H_Lundi");
        String h_Mardi = req.getParameter("H_Mardi");
        String h_Mercredi = req.getParameter("H_Mercredi");
        String h_Jeudi = req.getParameter("H_Jeudi");
        String h_Vendredi = req.getParameter("H_Vendredi");
        String h_Samedi = req.getParameter("H_Samedi");
        String h_Dimanche = req.getParameter("H_Dimanche");
        
        Enjoy newEnjoy = new Enjoy();
        newEnjoy.setName(name);
        newEnjoy.setType(type);
        newEnjoy.setDescription(description);
        newEnjoy.setHorraireLundi(h_Lundi);
        newEnjoy.setHorraireMardi(h_Mardi);
        newEnjoy.setHorraireMercredi(h_Mercredi);
        newEnjoy.setHorraireJeudi(h_Jeudi);
        newEnjoy.setHorraireVendredi(h_Vendredi);
        newEnjoy.setHorraireSamedi(h_Samedi);
        newEnjoy.setHorraireDimanche(h_Dimanche);
        newEnjoy.setNote(0);
        newEnjoy.setNbrNote(0);
        
                 
         ServiceEnjoy serviceEnjoy = new ServiceEnjoy();
         serviceEnjoy.addNewEnjoy(newEnjoy);
       
        //this.getServletContext().getRequestDispatcher( "/Catalogue" ).forward( req, resp );
        resp.sendRedirect("");
    }

}
