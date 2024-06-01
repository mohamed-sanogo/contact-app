/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.songdev.contact.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import repository.songdev.contact.app.Apprenant;

/**
 *
 * @author mohamed.sanogo1
 */
public class ApprenantDao {

    private String jdbcURL = "jdbc:mysql://localhost:3306/firstdbjava?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "";
    
    private static final String INSERT_APPRENANTS_SQL = "INSERT INTO contact (nom, tel, email, adresse, competence) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_APPRENANT_BY_ID = "SELECT idContact, nom, tel, email, adresse, competence FROM contact WHERE idContact = ?;";
    private static final String SELECT_ALL_APPRENANTS = "SELECT * FROM contact";
    private static final String DELETE_APPRENANT_SQL = "DELETE FROM contact WHERE idContact = ?";
    private static final String UPDATE_APPRENANT_SQL = "UPDATE contact SET nom = ?, tel = ?, email = ?, adresse = ?, competence = ? WHERE idContact = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertApprenant(Apprenant apprenant) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_APPRENANTS_SQL)) {
            preparedStatement.setString(1, apprenant.getNom());
            preparedStatement.setString(2, apprenant.getTel());
            preparedStatement.setString(3, apprenant.getEmail());
            preparedStatement.setString(4, apprenant.getAdresse());
            preparedStatement.setString(5, apprenant.getCompetence());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Apprenant selectApprenant(int idContact) {
        Apprenant apprenant = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_APPRENANT_BY_ID)) {
            preparedStatement.setInt(1, idContact);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String nom = rs.getString("nom");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String adresse = rs.getString("adresse");
                String competence = rs.getString("competence");
                apprenant = new Apprenant(idContact, nom, tel, email, adresse, competence);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apprenant;
    }

    public List<Apprenant> selectAllApprenants() {
        List<Apprenant> apprenants = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_APPRENANTS)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idContact = rs.getInt("idContact");
                String nom = rs.getString("nom");
                String tel = rs.getString("tel");
                String email = rs.getString("email");
                String adresse = rs.getString("adresse");
                String competence = rs.getString("competence");
                apprenants.add(new Apprenant(idContact, nom, tel, email, adresse, competence));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return apprenants;
    }

    public boolean deleteApprenant(int idContact) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_APPRENANT_SQL)) {
            preparedStatement.setInt(1, idContact);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateApprenant(Apprenant apprenant) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_APPRENANT_SQL)) {
            preparedStatement.setString(1, apprenant.getNom());
            preparedStatement.setString(2, apprenant.getTel());
            preparedStatement.setString(3, apprenant.getEmail());
            preparedStatement.setString(4, apprenant.getAdresse());
            preparedStatement.setString(5, apprenant.getCompetence());
            preparedStatement.setInt(6, apprenant.getIdContact());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    
}
