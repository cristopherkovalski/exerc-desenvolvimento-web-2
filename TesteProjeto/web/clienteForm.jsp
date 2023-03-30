<%-- 
    Document   : clienteForm
    Created on : 23 de jan. de 2023, 00:37:49
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <link href="resource/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script type="text/javascript" >

            $(document).ready(function () {
                $("#estado").change(function () {
                    getCidades();
                });
            });

            function getCidades() {
                var estadoId = $("#estado").val();
                var url = "AJAXServlet";
                $.ajax({
                    url: url, // URL da sua Servlet
                    data: {
                        estadoId: estadoId
                    }, // Parâmetro passado para a Servlet
                    dataType: 'json',
                    success: function (data) {
                        // Se sucesso, limpa e preenche a combo de cidade
                        // alert(JSON.stringify(data));
                        $("#cidade").empty();
                        $.each(data, function (i, obj) {
                            $("#cidade").append('<option value=' + obj.id + '>' + obj.nome + '</option>');
                        });
                    },
                    error: function (request, textStatus, errorThrown) {
                        alert(request.status + ', Error: ' + request.statusText);
                        // Erro
                    }
                });
            }
        </script> 

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
            <div class="card o-hidden border-0 shadow-lg"> 
                <c:if test='${ not empty requestScope["form"]}' >   
                    <c:set var="form" value='${requestScope["form"]}'/>
                </c:if>
                <c:choose>
                    <c:when test="${form eq 'alterar'}">
                        <c:set var="Span" value="Alterar Cliente"/>  
                        <c:set var="cliente" value='${requestScope.cliente}'/>
                        <c:set var="CPF" value='${cliente.CPF}'/>
                        <c:set var="name" value='${cliente.nome}'/>
                        <c:set var="eMail" value='${cliente.email}'/>
                        <c:set var="Data" value='${cliente.data}'/>
                        <c:set var="Rua" value='${cliente.rua}'/>
                        <c:set var="NRua" value='${cliente.numerorua}'/>
                        <c:set var="Cidade" value='${cliente.cidade.nome}'/>
                        <c:set var="Idcidade" value='${cliente.cidade.id}'/>
                        <c:set var="UF" value=' ${cliente.cidade.estado.nome}'/>
                        <c:set var="UFID" value=' ${cliente.cidade.estado.id}'/>
                        <c:set var="cep" value='${cliente.CEP}'/>
                        <c:set var="idc" value='${cliente.id}'/>
                    </c:when>
                    <c:otherwise>
                        <c:set var="Span" value="Novo Cliente"/>
                        <c:set var="name" value=""/>
                        <c:set var="CPF" value=""/>
                        <c:set var="eMail" value=""/>
                        <c:set var="Data" value=""/>
                        <c:set var="Rua" value=""/>
                        <c:set var="NRua" value=""/>
                        <c:set var="Idcidade" value=""/>
                        <c:set var="Cidade" value=""/>
                        <c:set var="UF" value="Selecione um Estado"/>
                        <c:set var="cep" value=""/>
                        <c:set var="idc" value=""/>


                    </c:otherwise>
                </c:choose>
                <span><h1><c:out value="${Span}" /></h1></span>
            </div>
            <div class="card o-hidden border-0 shadow-lg">
                <c:if test="${form eq 'alterar'}"> 
                    <form action="ClienteServlet?action=update" method="post"></c:if>
                    <c:if test="${form != 'alterar'}"> 
                        <form action="ClienteServlet?action=new" method="post"></c:if>    
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <tr><th>CPF</th><th>Nome</th><th>E-Mail</th><th>Data</th><th>Endereço</th><th>Número</th><tr>    
                                <tr>
                                    <td><input type="text" name="cpf" value="${CPF}"></td>
                                <td><input type="text" name="nome" value="${name}"></td>
                                <td><input type="text" name="email" value="${eMail}"></td>
                                <td><input type="date" name="data" value="${Data}"></td>
                                <td><input type="text" name="rua" value="${Rua}"></td>
                                <td><input type="text" name="numerorua" value="${NRua}"></td>
                            <tr><th>Cidade</th><th>UF</th><th>CEP</th><tr> 
                                <td><select name="estado" id="estado">
                                        <option value="${UFID}">${UF}</option>
                                        <c:forEach items="${requestScope.estados}" var="estad" > 
                                            <option value="${estad.id}">${estad.nome}</option>
                                        </c:forEach></select></td>  
                                <td><select name="cidade" id="cidade">
                                        <option value="${Idcidade}">${Cidade}</option>
                                    </select></td>
                                <td><input type="text" name="CEP" value="${cep}"></td>
                            <input type="hidden" name="id" value="${idc}">
                            </tr>   
                        </table><input class="btn btn-success btn-circle btn-sm" type="submit" value="Inserir"/>                                     
                    </form>
                    <div>
                        <a class="btn btn-danger btn-circle btn-sm" href="ClienteServlet?action=list" role="button">
                            <i class="fas fa-arrow-left"></i></a>                                           
                    </div>
            </div>
        </div> 


        <%--<span><h1>Novo cliente</h1></span>
       </div>
       <div class="card o-hidden border-0 shadow-lg">
           <form action="ClienteServlet?action=new" method="post">
            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
           <tr><th>CPF</th><th>Nome</th><th>E-Mail</th><th>Data</th><th>Endereço</th><th>Número</th><tr>       
           <tr>
           <td><input type="text" name="cpf" value=""></td>
           <td><input type="text" name="nome" value=""></td>
           <td><input type="text" name="email" value=""></td>
           <td><input type="date" name="data" value=""></td>
           <td><input type="text" name="rua" value=""></td>
           <td><input type="text" name="numerorua" value=""></td>
           <tr><th>Cidade</th><th>UF</th><th>CEP</th><tr> 
           <td><input type="text" name="cidade" value=""></td>
           <td><input type="text" name="estado" value=""></td>
           <td><input type="text" name="CEP" value=""></td>
       </tr>   
       </table><input class="btn btn-success btn-circle btn-sm" type="submit" value="Adicionar"/>                                     
           </form>
        <div>
        <a class="btn btn-danger btn-circle btn-sm" href="ClienteServlet?action=list" role="button">
                                                    <i class="fas fa-arrow-left"></i></a>                                           
       </div>
       </div>        
                   </c:otherwise>
                 </c:choose> 
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