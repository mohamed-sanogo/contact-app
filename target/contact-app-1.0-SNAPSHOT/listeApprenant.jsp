<%@page import="java.util.List"%>
<%@page import="repository.songdev.contact.app.Apprenant"%>
<%@page import="dao.songdev.contact.app.ApprenantDao"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    if (session.getAttribute("nomUser") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Gestion Apprenants | Liste Apprenant</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/index-styles.css" rel="stylesheet" />
    <link href="css/styleTable.css" rel="stylesheet" />
</head>
<body> 
    <%
        ApprenantDao apprenantDAO = new ApprenantDao();
        List<Apprenant> listApprenants = apprenantDAO.selectAllApprenants();
        request.setAttribute("listApprenants", listApprenants);
    %>
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
        <div class="container">
            <a class="navbar-brand" href="#page-top"><%=session.getAttribute("nomUser")%></a>
            <button class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded" type="button" data-bs-toggle="collapse" data-bs-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                Menu <i class="fas fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ms-auto"> 
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="index.jsp">ACCEUIL</a></li>
                    <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="./listeApprenant.jsp">APPRENANTS</a></li>
                    <li class="nav-item mx-0 mx-lg-1 bg-danger"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Deconnexion</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <header class="masthead bg-primary text-center">
        <div class="container">
            <section class="main" id="main">
                <section class="attendance">
                    <div class="attendance-list">
                        <div class="head">
                            <h1>Liste des Apprenants</h1>
                            <a href="./addApprenant.jsp">Nouveau apprenant</a>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th>Nom</th>
                                        <th>Tel</th>
                                        <th>Email</th>
                                        <th>Adresse</th>
                                        <th>Competence</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="apprenant" items="${listApprenants}">
                                        <tr>
                                            <td>${apprenant.nom}</td>
                                            <td>${apprenant.tel}</td>
                                            <td>${apprenant.email}</td>
                                            <td>${apprenant.adresse}</td>
                                            <td>${apprenant.competence}</td>
                                            <td>
                                                <a href="EditApprenantServlet?id=${apprenant.idContact}" class="btn btn-primary btn-sm">
                                                    <i class="fas fa-edit"></i>
                                                </a>
                                                <a href="DeleteApprenantServlet?id=${apprenant.idContact}" class="btn btn-danger btn-sm">
                                                    <i class="fas fa-trash"></i>
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </section>
            </section>
        </div>
    </header>

    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
</body>
</html>
