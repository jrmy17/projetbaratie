package fr.jmm.baratie.ui.info;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

import fr.jmm.baratie.MainActivity;
import fr.jmm.baratie.R;
import fr.jmm.baratie.metier.Recette;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
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


        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvIntitule = (TextView) getView().findViewById(R.id.tvInfoIntitule);
        TextView tvNbPersonne = (TextView) getView().findViewById(R.id.tvNbPersonne);
        TextView tvTempsPreparation = (TextView) getView().findViewById(R.id.tvTempsPreparation);
        TextView tvDescription = (TextView) getView().findViewById(R.id.tvDescription);
        TextView tvIngredients = (TextView) getView().findViewById(R.id.tvIngredients);

        int recupRecette=0;
        recupRecette = getArguments().getInt("envoiRecette");
        Recette maRecette = MainActivity.recettes.get(recupRecette);

        tvIntitule.setText(maRecette.getIntitule());
        tvNbPersonne.setText(String.valueOf(maRecette.getNbPers()));
        tvTempsPreparation.setText(String.valueOf(maRecette.getTempsPreparation())+" minutes");
        tvDescription.setText(maRecette.getDescription());

        tvIngredients.setText(maRecette.getListeIngredient());

    }
}
