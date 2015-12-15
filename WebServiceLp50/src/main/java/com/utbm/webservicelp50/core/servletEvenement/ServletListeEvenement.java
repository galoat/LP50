/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.webservicelp50.core.servletEvenement;

import com.utbm.databaselp50.core.entity.Evenement;
import com.utbm.databaselp50.core.service.ServiceEvenement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
public class ServletListeEvenement extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();

        List <Evenement> list;
        ServiceEvenement serviceEvenement = new ServiceEvenement();
        list = serviceEvenement.getListEvenement();

        JSONArray jsonListEvent = new JSONArray();
        for (Evenement i : list) 
        {
            JSONObject jo = new JSONObject();
            
            jo.put("ID", i.getId());
            jo.put("Name", i.getName());
            jo.put("Description",i.getDescription());
            jo.put("HeureD", i.getHeureD());
            jo.put("HeureF", i.getHeureF());
            jo.put("MinuteD", i.getMinuteD());
            jo.put("MinuteF", i.getMinuteF());
            jo.put("StartDate", i.getStartDate());
            jo.put("Type", i.getType().getType());

            jsonListEvent.add(jo);
        }
        json.put("nombre", list.size());
        json.put("Evenement",jsonListEvent);
        
        out.print(json.toString());
        
    }
}
