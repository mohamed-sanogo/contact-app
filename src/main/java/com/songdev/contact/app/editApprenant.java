/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songdev.contact.app;

import dao.songdev.contact.app.ApprenantDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.songdev.contact.app.Apprenant;

/**
 *
 * @author mohamed.sanogo1
 */
@WebServlet(name = "editApprenant", urlPatterns = {"/editApprenant"})
public class editApprenant extends HttpServlet {
      private ApprenantDao apprenantDAO;

    public void init() {
        apprenantDAO = new ApprenantDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idContact = Integer.parseInt(request.getParameter("idContact"));
        Apprenant apprenant = apprenantDAO.selectApprenant(idContact);
        request.setAttribute("apprenant", apprenant);
        request.getRequestDispatcher("editApprenant.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idContact = Integer.parseInt(request.getParameter("idContact"));
        String nom = request.getParameter("nom");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String adresse = request.getParameter("adresse");
        String competence = request.getParameter("comptence");

        Apprenant apprenant = new Apprenant(idContact, nom, tel, email, adresse, competence);
        try {
            apprenantDAO.updateApprenant(apprenant);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("allApprenants");
    }


}
