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
public class ServletListeEnjoyByName extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
    
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        ServiceEnjoy serviceEnjoy = new ServiceEnjoy();
        List<Enjoy> list = serviceEnjoy.getListEnjoyByName("biere");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        JSONArray jsonListEnjoy = new JSONArray();
        for (Enjoy i : list)
        {
            JSONObject jo = new JSONObject();
            
            jo.put("ID", i.getId());
            jo.put("NAME",i.getName());
            jo.put("DESCRIPTION", i.getDescription());
            jo.put("NOMBRE_NOTE", i.getNbrNote());
            jo.put("NOTE", i.getNote());
            jo.put("TYPE", i.getType());
            
            jsonListEnjoy.add(jo);
        }
        json.put("nombre", list.size());
        json.put("Enjoy",jsonListEnjoy);
        out.print(json.toString());     
        
    }
}
