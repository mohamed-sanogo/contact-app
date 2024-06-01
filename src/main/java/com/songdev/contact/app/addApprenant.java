/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songdev.contact.app;

import dao.songdev.contact.app.ApprenantDao;
import repository.songdev.contact.app.Apprenant;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mohamed.sanogo1
 */
@WebServlet(name = "addApprenant", urlPatterns = {"/addApprenant"})
public class addApprenant extends HttpServlet {

    private ApprenantDao apprenantDAO;

    public void init() {
        apprenantDAO = new ApprenantDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String tel = request.getParameter("tel");
        String email = request.getParameter("email");
        String adresse = request.getParameter("adresse");
        String competence = request.getParameter("competence");

        Apprenant apprenant = new Apprenant(nom, tel, email, adresse, competence);
        try {
            apprenantDAO.insertApprenant(apprenant);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("allApprenants");
    }

}
