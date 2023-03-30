<%-- 
    Document   : clienteVisualizar
    Created on : 16 de jan. de 2023, 15:10:19
    Author     : T-GAMER
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
          <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
          <link href="resource/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal</title>
    </head>
    <body>
        <body class="bg-gradient-primary">
             <nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
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
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Menu
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item"><form action="ClienteServlet?action=list" method = "POST"><input type = "submit" class="btn btn-secondary btn-user" value = "Listar Clientes"/></form></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item"><form action="logout" method = "POST">
                <input type = "submit" class="btn btn-danger btn-user" value = "Sair"/></form></a> 
            </li>
          </ul>
        </li>
      </ul>
    </div>
  </div>
</nav>
    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
             <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
            <tr><th>CPF</th><th>Nome</th><th>E-Mail</th><th>Data</th><th>Endereço</th><th>Número</th><th>Cidade</th><th>UF</th><th>CEP</th><tr>    
        <jsp items="${requestScope.cliente}" var="cliente" >    
        <tr><td>${cliente.CPF}</td>
            <td>${cliente.nome}</td>
            <td>${cliente.email}</td>
            <td>${cliente.data}</td>
            <td>${cliente.rua}</td>
            <td>${cliente.numerorua}</td>
            <td>${cliente.cidade.nome}</td>
           <td>${cliente.cidade.estado.nome}</td>
            <td>${cliente.CEP}</td>
        </tr>   
        </table>
        <div>
         <a class="btn btn-danger btn-circle btn-sm" href="ClienteServlet?action=list" role="button">
                                                     <i class="fas fa-arrow-left"></i></a>
        </div>
    <%-- <jsp:useBean id="login" class="beans.LoginBean" scope="session">
            <p>
            <jsp:getProperty name="login" property = "userName"/></jsp:useBean>
            </p> --%>
    </body>
     <footer class="bg-light text-center text-lg-start">
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    © 2023:
    <a><jsp:useBeanid = "configuracao" class="beans.ConfigBean" scope="application"/> 
        Em caso de problemas contate o administrador: <jsp:getPropertyname = "configuracao" property="email"/></a>
  </div>
