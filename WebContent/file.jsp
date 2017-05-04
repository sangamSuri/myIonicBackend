<%-- 
    Document   : klk
    Created on : Apr 2, 2017, 8:05:48 AM
    Author     : 123
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url(newmoney-home-dark2.jpeg); color: lightslategray;">
     
           <div style="margin-left: 150px; margin-top: 50px; height: 50px; width: 700px;"><h1 style="font-size: 50px; font: bold; color: lightslategrey; font-style: italic;">File Upload to Database </h1></div>
           <div style="margin-left: 150px; margin-top: 50px;">
        <form method="post" action=uploadImg enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>First Name: </td>
                    <td><input type="text" name="firstName" size="50"/></td>
                </tr></br></br>
                <tr>
                    <td>Last Name: </td>
                    <td><input type="text" name="lastName" size="50"/></td>
                </tr></br</br>
                <tr>
                    <td>Portrait Photo: </td>
                    <td><input type="file" name="photo" size="50"/></td>
                </tr></br</br>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>

            </table>
        </form></div>
   

    </body>
</html>
