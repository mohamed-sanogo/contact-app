/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repository.songdev.contact.app;

/**
 *
 * @author mohamed.sanogo1
 */
public class Apprenant {

    private int idContact;
    private String nom;
    private String tel;
    private String email;
    private String adresse;
    private String competence;

    public Apprenant(int idContact, String nom, String tel, String email, String adresse, String competence) {
        this.idContact = idContact;
        this.nom = nom;
        this.tel = tel;
        this.email = email;
        this.adresse = adresse;
        this.competence = competence;
    }

    public Apprenant(String nom, String tel, String email, String adresse, String competence) {
        this.nom = nom;
        this.tel = tel;
        this.email = email;
        this.adresse = adresse;
        this.competence = competence;
    }
    // Getters et setters

    public int getIdContact() {
        return idContact;
    }

    public void setIdContact(int idContact) {
        this.idContact = idContact;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    @Override
    public String toString() {
        return "Apprenant{"
                + "idContact=" + idContact
                + ", nom='" + nom + '\''
                + ", tel='" + tel + '\''
                + ", email='" + email + '\''
                + ", adresse='" + adresse + '\''
                + ", competence='" + competence + '\''
                + '}';
    }

}
