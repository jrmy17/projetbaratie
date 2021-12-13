package fr.jmm.baratie.ui.create;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

import fr.jmm.baratie.MainActivity;
import fr.jmm.baratie.R;
import fr.jmm.baratie.metier.Recette;
import fr.jmm.baratie.ui.home.HomeFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateFragment() {

    }

    public static CreateFragment newInstance(String param1, String param2) {
        CreateFragment fragment = new CreateFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_create, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText etNomRecette = getView().findViewById(R.id.etNomRecette);


        EditText etNbPers = getView().findViewById(R.id.etNbPers);


        EditText etTemps = getView().findViewById(R.id.etTemps);


        EditText etDesc = getView().findViewById(R.id.etDesc);


        EditText etIngredients = getView().findViewById(R.id.etIngredients);


        Button btnCreate = getView().findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nom = etNomRecette.getText().toString();
                int nbPers = Integer.parseInt(etNbPers.getText().toString());
                int temps = Integer.parseInt(etTemps.getText().toString());
                String description = etDesc.getText().toString();
                String ingredients = etIngredients.getText().toString();

                MainActivity.recettes.add(new Recette(nom, nbPers, temps, description, ingredients));

                Navigation.findNavController(view).navigate(R.id.nav_home);

            }

        });


    }


}