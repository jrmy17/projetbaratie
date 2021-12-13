package fr.jmm.baratie.ui.create;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.HashMap;

import fr.jmm.baratie.MainActivity;
import fr.jmm.baratie.R;
import fr.jmm.baratie.databinding.FragmentCreateBinding;
import fr.jmm.baratie.metier.Ingredient;

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
    // Array list des ingrédients
    private HashMap<Ingredient, Double> listeIngredients = new HashMap<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rvAdded;

    //


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

        listeIngredients.put(new Ingredient("test", "test2"), 2.2);

        RecyclerView recyclerView = getView().findViewById(R.id.rvAddIngredient);
        CreateAdapter adapter = new CreateAdapter(MainActivity.ingredients, getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        rvAdded = getView().findViewById(R.id.rvAdded);
        CreateAddedAdapter adapter2 = new CreateAddedAdapter(listeIngredients, getContext());
        rvAdded.setAdapter(adapter2);
        rvAdded.setLayoutManager(new LinearLayoutManager(getContext()));


        androidx.appcompat.widget.SearchView searchView = getView().findViewById(R.id.svIngredients);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });

    }


    public void showAddDialog(Context c, Ingredient ingredient) {
        final EditText taskEditText = new EditText(c);
        taskEditText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("Ajouter : " + ingredient.getDesignation())
                .setMessage("Veuillez saisir une valeur en " + ingredient.getUnite())
                .setView(taskEditText)
                .setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (!String.valueOf(taskEditText.getText()).isEmpty()) {
                            double quantite = Double.parseDouble(String.valueOf(taskEditText.getText()));

                            setContentView(R.layout.activity_main);

                            listeIngredients.put(ingredient, quantite);
                            CreateAddedAdapter adapter = (CreateAddedAdapter) rvAdded.getAdapter();
                            adapter.notifyDataSetChanged();
                        }
                    }
                })
                .setNegativeButton("Annuler", null)
                .create();
        dialog.show();
    }


}