/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.webservicelp50.core.servletEnjoy;

import com.utbm.databaselp50.core.entity.CommentaireEnjoy;
import com.utbm.databaselp50.core.entity.Enjoy;
import com.utbm.databaselp50.core.service.ServiceEnjoy;
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
public class ServletEnjoyByID extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        Enjoy enjoy;
        ServiceEnjoy serviceEnjoy = new ServiceEnjoy();
        enjoy = serviceEnjoy.getById(1);
        json.put("ID", enjoy.getId());
        json.put("NAME", enjoy.getName());
        json.put("DESCRIPTION", enjoy.getDescription());
        json.put("NOMBRE_NOTE", enjoy.getNbrNote());
        json.put("NOTE", enjoy.getNote());
        json.put("TYPE", enjoy.getType());
        
        json.put("HORRAIRE_LUNDI", enjoy.getHorraireLundi());
        json.put("HORRAIRE_MARDI", enjoy.getHorraireMardi());
        json.put("HORRAIRE_MERCREDI", enjoy.getHorraireMercredi());
        json.put("HORRAIRE_JEUDI", enjoy.getHorraireJeudi());
        json.put("HORRAIRE_VENDREDI", enjoy.getHorraireVendredi());
        json.put("HORRAIRE_SAMEDI", enjoy.getHorraireSamedi());
        json.put("HORRAIRE_DIMANCHE", enjoy.getHorraireDimanche());
               
        JSONArray jsonListComment = new JSONArray();
        Set <CommentaireEnjoy> listeCommentaire = enjoy.getCommentaires();
        
        for (CommentaireEnjoy i : listeCommentaire) 
        {
            JSONObject jsonComment = new JSONObject();
            jsonComment.put("commentaire", i.getCommentaire());
            jsonComment.put("user", i.getUser());
            jsonListComment.add(jsonComment);
        }
       // json.put("nombre", list.size());
        json.put("ListeComment",jsonListComment);
        json.put("NbrComment",listeCommentaire.size());
        out.print(json.toString());
        
    }
}
