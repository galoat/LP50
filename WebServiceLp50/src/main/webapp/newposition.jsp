<%-- 
    Document   : newposition
    Created on : 5 janv. 2016, 11:17:25
    Author     : galoat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="resources/theme1/css/style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New position</title>
    </head>
    
    <body align="center">
        <h1>New Position</h1>
        <div align="center" style="margin:50px; border-color:  black;border-width: thick;"> 

        <form action="NewPosition" method="POST">
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
                                <label>Position x</label>
                                <input name="x" type="text">
                            </div> 
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
                        <td>
                            <div class="label">
                                <label>Position y</label>
                                <input name="y" type="text">
                            </div> 
                        </td>
                    </tr>
                   
                    
                    <tr>
                        <td align="center">
                            <div class="label">
                                <button class="button" type="submit">Ajouter une position</button>	
                            </div> 
                        </td>
                    </tr>
                </table>
        </form>
        </div>
    </body>
</html>
