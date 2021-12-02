package fr.jmm.baratie.ui.create;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

import fr.jmm.baratie.MainActivity;
import fr.jmm.baratie.R;
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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateFragment.
     */
    // TODO: Rename and change types and number of parameters
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


        SearchView searchView = getView().findViewById(R.id.svIngredients);
        TextView ingredient = (TextView) getView().findViewById(R.id.tvSearchResult);

        ArrayList<Ingredient> querySearch = new ArrayList<>();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {

                querySearch.clear();

                for (Ingredient ingredient : MainActivity.ingredients) {
                    if (ingredient.getDesignation().toLowerCase().startsWith(query.toLowerCase())) {
                        querySearch.add(ingredient);
                    }
                }

                String result = "";
                for (Ingredient i : querySearch
                ) {
                    result += i.getDesignation() + " - ";
                }
                ingredient.setText(result);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }
        });




    /*      Spinner spinner = (Spinner) getView().findViewById(R.id.spinnerIngredients);
        ArrayAdapter<Ingredient> ingredientRecetteAdapter = new ArrayAdapter<Ingredient>(getContext(), android.R.layout.simple_spinner_dropdown_item, MainActivity.ingredients);

        ingredientRecetteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(ingredientRecetteAdapter);*/


    }
}