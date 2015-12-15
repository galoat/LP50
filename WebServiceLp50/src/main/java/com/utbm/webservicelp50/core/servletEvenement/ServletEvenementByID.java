/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.webservicelp50.core.servletEvenement;

import com.utbm.databaselp50.core.entity.CommentaireEven;
import com.utbm.databaselp50.core.entity.Evenement;
import com.utbm.databaselp50.core.service.ServiceEvenement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author nicolas
 */
public class ServletEvenementByID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        Evenement event;
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        event = serviceEvenement.getById(2);
        json.put("ID", event.getId());
        json.put("Name", event.getName());
        json.put("Description",event.getDescription());
        json.put("HeureD", event.getHeureD());
        json.put("HeureF", event.getHeureF());
        json.put("MinuteD", event.getMinuteD());
        json.put("MinuteF", event.getMinuteF());
        json.put("StartDate", event.getStartDate());
        json.put("Type", event.getType().getType());
            
        JSONArray jsonListComment = new JSONArray();
        Set <CommentaireEven> listeCommentaire = event.getCommentaires();
        
        for (CommentaireEven i : listeCommentaire) 
        {
            jsonListComment.add(i.getCommentaire());
        }
       // json.put("nombre", list.size());
        json.put("Evenement",jsonListComment);
        json.put("NbrComment",listeCommentaire.size());
        out.print(json.toString());
        
    }
}
