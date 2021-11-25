package fr.jmm.baratie.metier;

public class Utilisateur {

    private String mail;
    private String password;
    private String nom;
    private String prenom;

    public Utilisateur(String mail, String password, String nom, String prenom) {
        this.mail = mail;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
