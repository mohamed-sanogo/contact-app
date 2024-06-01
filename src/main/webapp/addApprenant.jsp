<%-- 
    Document   : addApprenant
    Created on : 29 mai 2024, 11:02:40
    Author     : mohamed.sanogo1
--%>
<%
    if (session.getAttribute("nomUser") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ajout d'unn apprenant</title>

        <!-- Font Icon -->
        <link rel="stylesheet"
              href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <input type="hidden" id="status" value="<%= request.getAttribute("status")%>">

        <div class="main">

            <!-- Sign up form -->
            <section class="signup">
                <div class="container">
                    <div class="signup-content">
                        <div class="signup-form">
                            <h2 class="form-title">Ajout d'un Apprenant</h2>

                            <form method="post" action="addApprenant" class="register-form"
                                  id="register-form">
                                <div class="form-group">
                                    <label for="Nom Complet"><i
                                            class="zmdi zmdi-account material-icons-name"></i></label> <input
                                        type="text" name="nom" id="nom" placeholder="Nom complet" />
                                </div>
                                <div class="form-group">
                                    <label for="contact"><i class="zmdi zmdi-phone"></i></label>
                                    <input type="text" name="tel" id="tel"
                                           placeholder="Tel no" />
                                </div>
                                <div class="form-group">
                                    <label for="email"><i class="zmdi zmdi-email"></i></label> <input
                                        type="email" name="email" id="email" placeholder="Email" />
                                </div>
                                <div class="form-group">
                                    <label for="re-pass"><i class="zmdi zmdi-home"></i></label>
                                    <input type="text" name="adresse" id="adresse"
                                           placeholder="Adresse" />
                                </div> 

                                <div class="form-group">
                                    <label for="competence"><i class="zmdi zmdi-gradient"></i></label>
                                    <input type="text" name="competence" id="competence"
                                           placeholder="competence" />
                                </div>
                                <div class="form-group form-button">
                                    <input type="submit" name="signup" id="signup"
                                           class="form-submit" value="Envoyer" />
                                </div>
                            </form>
                        </div>
                        <div class="signup-image">
                            <figure>
                                <img src="images/signup-image.jpg" alt="sing up image">
                            </figure>
                            <a href="./listeApprenant.jsp" class="signup-image-link">Retour</a>
                        </div>
                    </div>
                </div>
            </section>


        </div>
        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>

        <!--<script type="text/javascript">
                var status =document.getElementById("status").value;
                if(status == success){
                        swal("Congratualtions", "your account is connected")
                }
        </script>-->
    </body>
</html>
