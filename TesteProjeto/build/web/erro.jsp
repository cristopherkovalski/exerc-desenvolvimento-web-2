<%-- 
    Document   : erro.jsp
    Created on : 21 de nov. de 2022, 14:17:26
    Author     : T-GAMER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <style>
         footer {  
            clear: both;
            position: absolute;         
            bottom:0;
            width:100%;
            height:60px;   /* Height of the footer */
            background:#6cf;}
    </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erro</title>
    <h1 style="color:red;">${pageContext.exception.message}</h1>
    <h2>${pageContext.out.flush()}
        ${pageContext.exception.printStackTrace(pageContext.response.writer)}</h2>
    </head>
    <body>
       <%-- out.print("<a href='" + getServletContext().getContextPath() + pagina +"'>Retornar para a tela de Login</a>"); --%>
    </body>
    <footer>
        <jsp:useBeanid = "configuracao" class="beans.ConfigBean" scope="application"/> 
        Em caso de problemas contate o administrador: <jsp:getPropertyname = "configuracao" property="email"/>
    </footer>
</html>
