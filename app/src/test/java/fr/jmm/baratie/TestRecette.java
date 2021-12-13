package fr.jmm.baratie;

import org.junit.Test;

import static org.junit.Assert.*;

import fr.jmm.baratie.metier.Recette;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestRecette {

    @Test
    public void testRecette() {
        Recette maRecette = new Recette("Hamburger", 2, 30,
                "Un Hamburger succulant sur son lit de salade", "4 pains burger, deux steak hachés, 4 tranches de cheddar, sauce ketchup, salade 200g");

        assertTrue(maRecette.getIntitule() == "Hamburger");

        assertTrue(maRecette.getNbPers() == 2);


        ;
    }
}