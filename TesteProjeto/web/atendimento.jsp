<%-- 
    Document   : atendimento
    Created on : 29 de jan. de 2023, 16:28:59
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
          <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
          <link href="resource/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Atendimento</title>
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
             <li><a class="dropdown-item"><form action="AtendimentoServlet?action=efetuar" method = "POST"><input type = "submit" class="btn btn-secondary btn-user" value = "Efetuar Atendimento"/></form></li>
            <li><a class="dropdown-item"><form action="AtendimentoServlet?action=listar" method = "POST"><input type = "submit" class="btn btn-secondary btn-user" value = "Mostar Atendimentos"/></form></li>
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
  <form action="processAtendimento" method="post">
    <!-- Data/hora default -->
    <label for="dataHora">Data/Hora:</label>
    <input type="datetime-local" id="dataHora" name="dataHora" value="<%= new java.util.Date() %>">
    <br><br>

    <!-- Lista de produtos -->
    <label for="produto">Produto:</label>
    <select id="produto" name="produto">
        <c:forEach items="${requestScope.listaProduto}" var="produto" > 
                        <option value="${produto.idProduto}">${produto.nomeProduto}</option>
                       </c:forEach></select> 
    <br><br>

    <!-- Lista de tipos de atendimento -->
    <label for="tipoAtendimento">Tipo de Atendimento:</label>
    <select id="tipoAtendimento" name="tipoAtendimento">
     <c:forEach items="${requestScope.listaTipoAtend}" var="tipo" > 
                        <option value="${tipo.idTipoAtendimento}">${tipo.nomeTipoAtendimento}</option>
                       </c:forEach></select> 
 
    <br><br>

    <!-- Lista de clientes -->
    <label for="cliente">Cliente:</label>
    <select id="cliente" name="cliente">
      <c:forEach items="${requestScope.listaCliente}" var="clientes" > 
                        <option value="${clientes.id}">${clientes.nome}</option>
                       </c:forEach>
    </select>
    <br><br>

    <!-- Checkbox para indicar se o atendimento foi resolvido -->
    <label for="resolvido">Atendimento resolvido?</label>
    <input type="checkbox" id="resolvido" name="resolvido">
    <br><br>
     <div>
         <a class="btn btn-primary btn-circle btn-sm" href="ClienteServlet?action=list" role="button">
                                                     <i class="fa fa-check"></i></a>
        </div> 
        </form>
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
