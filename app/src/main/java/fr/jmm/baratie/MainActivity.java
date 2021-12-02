package fr.jmm.baratie;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.HashMap;

import fr.jmm.baratie.databinding.ActivityMainBinding;
import fr.jmm.baratie.metier.Ingredient;
import fr.jmm.baratie.metier.Recette;

public class MainActivity extends AppCompatActivity {

    /* Jeux de test */
    public static ArrayList<Recette> recettes = new ArrayList<>();
    public static ArrayList<Ingredient> ingredients = new ArrayList<>();
    /* ------------ */

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        init();

        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_create, R.id.nav_info)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void init() {

        ingredients.clear();
        recettes.clear();

        Ingredient pattes = new Ingredient("Pattes", "grammes");
        Ingredient jauneOeuf = new Ingredient("Jaune d'oeuf", "nombre");
        Ingredient lardons = new Ingredient("Lardons", "grammes");
        Ingredient cremeFraiche = new Ingredient("Crème fraiche", "grammes");
        HashMap<Ingredient, Double> ingredientPattesCarbo = new HashMap<>();
        ingredientPattesCarbo.put(pattes, (double) 100);
        ingredientPattesCarbo.put(jauneOeuf, (double) 1);
        ingredientPattesCarbo.put(lardons, (double) 50);
        ingredientPattesCarbo.put(cremeFraiche, (double) 100);

        Recette patesCarbo = new Recette("Pates Carbonara", 4, 20,
                "De délicieuses pates à la carbonara", ingredientPattesCarbo);


        Ingredient farine = new Ingredient("Farine", "grammes");
        Ingredient levure = new Ingredient("Levure", "sachet");
        Ingredient eau = new Ingredient("Eau", "cl");
        Ingredient sauceTomate = new Ingredient("Sauce tomate", "cuillère(s) à soupe");
        Ingredient mozzarella = new Ingredient("Mozzarella", "grammes");
        Ingredient jambon = new Ingredient("Jambom", "tranches");
        HashMap<Ingredient, Double> ingredientPizza = new HashMap<>();
        ingredientPizza.put(farine, (double) 350);
        ingredientPizza.put(levure, (double) 1);
        ingredientPizza.put(eau, (double) 25);
        ingredientPizza.put(sauceTomate, (double) 3);
        ingredientPizza.put(mozzarella, (double) 125);
        ingredientPizza.put(jambon, (double) 2);

        ingredients.add(farine);
        ingredients.add(eau);
        ingredients.add(pattes);
        ingredients.add(jambon);
        ingredients.add(lardons);
        ingredients.add(levure);

        Recette pizza = new Recette("Pizza", 6, 45,
                "Une pizza tah délicieuse", ingredientPizza);

        recettes.add(pizza);


    }

}