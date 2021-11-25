package fr.jmm.baratie.metier;

public class Ingredient {

    private String designation;
    private String unite;

    public Ingredient(String designation, String unite) {
        this.designation = designation;
        this.unite = unite;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

}
