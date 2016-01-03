<%-- 
    Document   : newEnjoyJsp
    Created on : 3 janv. 2016, 14:41:04
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
        <h1>New Enjoy</h1>
        <div align="center" style="margin:50px; border-color:  black;border-width: thick;"> 

        <form action="NewEnjoy" method="POST">
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
                                <label>Type:</label>
                                <input name="Type" type="text">
                            </div> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td>
                            <div class="label">
                                <label>Description:</label>
                                <input name="Description" type="text">
                            </div> 
                        </td>
                        <td>
                            <div class="label">
                                <label>Horraire Lundi:</label>
                                <input name="H_Lundi" type="text">
                            </div> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td>
                            <div class="label">
                                <label>Horraire Mardi:</label>
                                <input name="H_Mardi" type="text">
                            </div> 
                        </td>
                        <td>
                            <div class="label">
                                <label>Horraire Mercredi:</label>
                                <input name="H_Mercredi" type="text">
                            </div> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td>
                            <div class="label">
                                <label>Horraire jeudi:</label>
                                <input name="H_Jeudi" type="text">
                            </div> 
                        </td>
                        <td>
                            <div class="label">
                                <label>Horraire Vendredi:</label>
                                <input name="H_Vendredi" type="text">
                            </div> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td>
                            <div class="label">
                                <label>Horraire Samedi:</label>
                                <input name="H_Samedi" type="text">
                            </div> 
                        </td>
                        <td>
                            <div class="label">
                                <label>Horraire Dimanche:</label>
                                <input name="H_Dimanche" type="text">
                            </div> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td align="center">
                            <div class="label">
                                <button class="button" type="submit">Ajouter Enjoy</button>	
                            </div> 
                        </td>
                    </tr>
                </table>
        </form>
        </div>
    </body>
</html>
