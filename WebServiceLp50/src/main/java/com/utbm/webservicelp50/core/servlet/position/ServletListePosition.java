/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utbm.webservicelp50.core.servlet.position;

import com.utbm.databaselp50.core.entity.Enjoy;
import com.utbm.databaselp50.core.entity.Position;
import com.utbm.databaselp50.core.service.ServiceEnjoy;
import com.utbm.databaselp50.core.service.ServicePosition;
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
 * @author galoat
 */
public class ServletListePosition extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        
        List <Position> list;
         ServicePosition sp = new ServicePosition();
        list = sp.getListPosition();
        JSONArray jsonListEnjoy = new JSONArray();
        for (Position p : list) 
        {
            JSONObject jo = new JSONObject();
            jo.put("ID", p.getId());
            jo.put("position_x",p.getPosition_x());
            jo.put("position_y",p.getPosition_y());
            jo.put("name",p.getName());    ;
            jsonListEnjoy.add(jo);
        }
          json.put("Position",jsonListEnjoy);
        
        out.print(json.toString());
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
