package fr.jmm.baratie;

import android.os.Bundle;
import android.view.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;

import fr.jmm.baratie.databinding.ActivityMainBinding;
import fr.jmm.baratie.metier.Recette;

public class MainActivity extends AppCompatActivity {

    /* Jeux de test */
    public static ArrayList<Recette> recettes = new ArrayList<>();
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


        recettes.clear();


        Recette patesCarbo = new Recette("Pates Carbonara", 4, 20,
                "De délicieuses pates à la carbonara", "200 grammes de lardons, 20 grammes de pattes...");




        Recette pizza = new Recette("Pizza", 6, 45,
                "Une pizza tah délicieuse", "Patte a pizza, ...");
        Recette cookie = new Recette("Cookie", 6, 25,
                "Des cookies chococroco", "chocolat, farine...");

        Recette feuilletesSaucisse = new Recette("Feuilletés apéritif à la saucisse", 6, 20,
                "Un apéro tah j'ai faim", "ingredients...");

        Recette tartiflette = new Recette("La vraie Tartiflette", 4, 75,
                "Une tartiflette tah lewandoski qui te fait peter le bide", "ingrTartiflette...");

        recettes.add(pizza);
        recettes.add(patesCarbo);
        recettes.add(cookie);
        recettes.add(feuilletesSaucisse);
        recettes.add(tartiflette);


    }

}