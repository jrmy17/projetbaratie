package fr.jmm.baratie.metier;

import java.util.HashMap;

public class Recette {

    private String intitule;
    private int nbPers;
    private int tempsPreparation;
    private String description;
    private HashMap<Ingredient, Double> listeIngredient;
    private HashMap<Utilisateur, Integer> notes;



    public Recette(String intitule, int nbPers, int tempsPreparation, String description, HashMap<Ingredient, Double> listeIngredient) {
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


    public HashMap<Ingredient, Double> getListeIngredient() {
        return listeIngredient;
    }


    public void setListeIngredient(HashMap<Ingredient, Double> listeIngredient) {
        this.listeIngredient = listeIngredient;
    }

    public HashMap<Utilisateur, Integer> getNotes() {
        return notes;
    }

    public void setNotes(HashMap<Utilisateur, Integer> notes) {
        this.notes = notes;
    }

}
