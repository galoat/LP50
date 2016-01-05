/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.webservicelp50.core.servletEvenement;

import com.utbm.databaselp50.core.entity.Evenement;
import com.utbm.databaselp50.core.entity.TypeEven;
import com.utbm.databaselp50.core.service.ServiceEvenement;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nicolas
 */
public class NewEvent extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
            response.setContentType("text/html;charset=UTF-8");
    
            this.getServletContext().getRequestDispatcher( "/newEventJsp.jsp" ).forward( request, response );
        
    }
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
      
  
        String name = req.getParameter("Name");
        String Description   = req.getParameter("Description");   
        String start = req.getParameter("Start_Date");
        String hDebut = req.getParameter("Heure_D");
        String mDebut = req.getParameter("Minute_D");
        String HFin = req.getParameter("Heure_F");
        String MFin = req.getParameter("Heure_F");
        String type = req.getParameter("type");
        // faire le parse en Date
        Evenement newEvenement= new Evenement();
        SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yy");
        Date d=null;
        try {
          d=  formater.parse(start);
        } catch (ParseException ex) {
            Logger.getLogger(NewEvent.class.getName()).log(Level.SEVERE, null, ex);
        }
        TypeEven ev = new TypeEven();
        ev.setType(type);
        newEvenement.setName(name);
        newEvenement.setDescription(Description);
        newEvenement.setHeureD(Integer.parseInt(hDebut));
        newEvenement.setHeureF(Integer.parseInt(HFin));
        newEvenement.setMinuteF(Integer.parseInt(MFin));
        newEvenement.setMinuteD(Integer.parseInt(mDebut));
        newEvenement.setType(ev);
        newEvenement.setStartDate(d);
         ServiceEvenement serviceEnjoy = new ServiceEvenement();
         serviceEnjoy.addNewEvenement(newEvenement);
       
        //this.getServletContext().getRequestDispatcher( "/Catalogue" ).forward( req, resp );
        resp.sendRedirect("");
    }

}
