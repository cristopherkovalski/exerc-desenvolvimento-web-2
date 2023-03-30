<%-- 
    Document   : inserir.jsp
    Created on : 21 de nov. de 2022, 15:09:01
    Author     : T-GAMER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir</title>
    </head>
    <body>
         <c:choose>
           <c:when test="${not empty sessionScope.login}">
               <a class=navbar-brand href=#><c:out value="${sessionScope.login}" /></a>
                </c:when>
           <c:otherwise>
               <jsp:forward page="index.jsp">
                <jsp:param name="msg" value="Usuário deve se autenticar para acessar o Sistema"/>
                </jsp:forward>
                </c:otherwise>
       </c:choose>
        <h1>Cadastro</h1>
        <div><form action="CadastrarUsuarioServlet1" method="post">
        Nome:<input type="text" name="username"/><br/><br/>            
       Login:<input type="text" name="login"/><br/><br/>  
       Senha:<input type="password" name="userpass"/><br/><br/>  
       <input type="submit" value="Salvar"/>  
       </form></div>
    </body>
</html>
