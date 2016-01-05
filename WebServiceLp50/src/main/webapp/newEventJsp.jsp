<%-- 
    Document   : newEventJsp
    Created on : 3 janv. 2016, 16:24:14
    Author     : nicolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="resources/theme1/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Enjoy</title>
    </head>
    
    <body align="center">
        <h1>New Evenement</h1>
        <div align="center" style="margin:50px; border-color:  black;border-width: thick;"> 

        <form action="NewEvent" method="POST">
                <table>
                    <tr></tr>
                    <tr>
                        <td>
                            <div class="label">
                                <label>Name:</label>
                                <input name="Name" type="text">
                            </div> 
                        </td>
                        <td>
                            <div class="label">
                                <label>Description:</label>
                                <input name="Description" type="text">
                            </div> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td>
                            <div class="label">
                                <label>Start Date:</label>
                                <input name="Start_Date" type="text">
                            </div> 
                        </td>
                    </tr>
                     <tr>
                        <td>
                            <div class="label">
                                <label>Type</label>
                                <input name="type" type="text">
                            </div> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td>
                            <div class="label">
                                <label>Heure départ:</label>
                                <input name="Heure_D" type="text">
                            </div> 
                        </td>
                        <td>
                            <div class="label">
                                <label>Minute départ:</label>
                                <input name="Minute_D" type="text">
                            </div> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td>
                            <div class="label">
                                <label>Heure fin :</label>
                                <input name="Heure_F" type="text">
                            </div> 
                        </td>
                        <td>
                            <div class="label">
                                <label>Minute fin :</label>
                                <input name="Heure_F" type="text">
                            </div> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td align="center">
                            <div class="label">
                                <button class="button" type="submit">Ajouter Event</button>	
                            </div> 
                        </td>
                    </tr>
                </table>
        </form>
        </div>
    </body>
</html>
