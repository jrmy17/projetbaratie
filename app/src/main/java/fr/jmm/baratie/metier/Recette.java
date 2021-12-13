package fr.jmm.baratie.metier;

import java.util.HashMap;

public class Recette {

    private String intitule;
    private int nbPers;
    private int tempsPreparation;
    private String description;
    private String listeIngredient;
    private HashMap<Utilisateur, Integer> notes = new HashMap<Utilisateur, Integer>();


    public Recette(String intitule, int nbPers, int tempsPreparation, String description, String listeIngredient) {
        this.intitule = intitule;
        this.nbPers = nbPers;
        this.tempsPreparation = tempsPreparation;
        this.description = description;
        this.listeIngredient = listeIngredient;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public int getNbPers() {
        return nbPers;
    }

    public void setNbPers(int nbPers) {
        this.nbPers = nbPers;
    }

    public int getTempsPreparation() {
        return tempsPreparation;
    }

    public void setTempsPreparation(int tempsPreparation) {
        this.tempsPreparation = tempsPreparation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getListeIngredient() {
        return listeIngredient;
    }


    public void setListeIngredient(String listeIngredient) {
        this.listeIngredient = listeIngredient;
    }

    public HashMap<Utilisateur, Integer> getNotes() {
        return notes;
    }

    public void setNotes(HashMap<Utilisateur, Integer> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "intitule='" + intitule;
    }
}
