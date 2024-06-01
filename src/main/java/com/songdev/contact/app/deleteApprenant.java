/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.songdev.contact.app;

import dao.songdev.contact.app.ApprenantDao;
import repository.songdev.contact.app.Apprenant;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "deleteApprenant", urlPatterns = {"/deleteApprenant"})
public class deleteApprenant extends HttpServlet {
        
    private ApprenantDao apprenantDAO;

    public void init() {
        apprenantDAO = new ApprenantDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idContact = Integer.parseInt(request.getParameter("idContact"));
        try {
            apprenantDAO.deleteApprenant(idContact);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("allApprenants");
    }

}
