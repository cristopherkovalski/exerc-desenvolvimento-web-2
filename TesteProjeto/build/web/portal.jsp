<%-- 
    Document   : portal
    Created on : 13 de jan. de 2023, 15:11:48
    Author     : T-GAMER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
         <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
          <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal</title>
    </head>
    <body>
        <body class="bg-gradient-primary">
             <nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
       <%-- if(null != session.getAttribute("login")){
        String log = (String) request.getSession().getAttribute("login");
        out.println("<a class=navbar-brand href=#>" + log + "</a>");
       // out.println("<div><a href='" + getServletContext().getContextPath() + "/inserir.jsp" +"'>Cadastrar Novo Usuário</a></div>"); --
      }else{ 
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        request.setAttribute("msg", "Usuário deve se autenticar para acessar o Sistema");
        dispatcher.forward(request,response);}--%>
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
            <li><a class="dropdown-item"><form action="AtendimentoServlet?action=listar" method = "POST"><input type = "submit" class="btn btn-secondary btn-user" value = "Mostrar Atendimentos"/></form></li>
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
            <div class="card-body p-0">
                <div class="p-5">
                </div>    
            </div>
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

      
    </footer>
</html>
