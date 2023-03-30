<%-- 
    Document   : index
    Created on : 13 de jan. de 2023, 00:17:25
    Author     : T-GAMER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="/erro.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <title>Pagina inicial</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<%-- if ( null != request.getAttribute("msg")){
   String mensagem = (String)request.getAttribute("msg");
--%>
<c:if test="${ not empty param.msg}" >   
    <div class="alert alert-danger alert-dismissible d-flex align-items-center fade show">
        <i class="bi-exclamation-octagon-fill"></i>
        <strong class="mx-2">Erro!</strong> <%-- out.println(mensagem);--%><c:out value="${param.msg}"></c:out>
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div><%--}--%> </c:if>
<c:set var="messages" value='${requestScope["msg"]}'/>
<c:if test="${ not empty messages}" >   
    <div class="alert alert-danger alert-dismissible d-flex align-items-center fade show">
        <i class="bi-exclamation-octagon-fill"></i>
        <strong class="mx-2">Erro!</strong> <%-- out.println(mensagem);--%><c:out value="${messages}"></c:out>
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div><%--}--%> </c:if>

<%--if ( null != request.getAttribute("msgC")){
      String mensagem = (String)request.getAttribute("msgC");
--%>
<c:set var="message" value='${requestScope["msgC"]}' />
<c:if test="${ not empty message}" >
    <div class="alert alert-success alert-dismissible fade show">
        <strong>Tudo certo!</strong> <%-- out.println(mensagem);--%><c:out value="${message}"></c:out>
            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
        </div><%--}--%></c:if>
    <!-- Email input -->
    <body class="bg-gradient-primary">
        <div class="container">
            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4">Login</h1>
                            <form class="user" action="LoginServlet" method = "POST">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user"
                                           placeholder="Login" id="login" name="user" >
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control form-control-user"
                                           placeholder="Senha" id="senha" name="userpass" >
                                </div>
                                <input type = "submit" class="btn btn-primary btn-user btn-block" value = "Logar" />
                            </form>
                        </div>
                        <div class="text-center">
                            <a class="small" href="cadastro.jsp">Cadastrar uma conta.</a>
                        </div>
                    </div>    
                </div>
            </div>
    </body>
    <footer class="bg-light text-center text-lg-start">
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2023:
            <a><jsp:useBeanid = "configuracao" class="beans.ConfigBean" scope="application"/> 
            Em caso de problemas contate o administrador: <jsp:getPropertyname = "configuracao" property="email"/></a>
    </div>


</footer>
    
