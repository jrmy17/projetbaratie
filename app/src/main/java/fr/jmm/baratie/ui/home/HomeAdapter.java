package fr.jmm.baratie.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import fr.jmm.baratie.MainActivity;
import fr.jmm.baratie.R;
import fr.jmm.baratie.metier.Recette;
import fr.jmm.baratie.ui.info.InfoFragment;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> implements Filterable {

    private static final String TAG = " ";

    private ArrayList<Recette> recettesAll;
    private ArrayList<Recette> recettes;
    private Context mContext;

    public HomeAdapter(ArrayList<Recette> recettes, Context mContext) {
        this.recettes = recettes;
        this.recettesAll = new ArrayList<>(recettes);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listrecettes, parent, false);
        HomeViewHolder homeViewHolder = new HomeViewHolder(view);
        return homeViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        holder.recetteNom.setText(recettes.get(holder.getAdapterPosition()).getIntitule());
        Integer temps = recettes.get(holder.getAdapterPosition()).getTempsPreparation();
        holder.recetteTemps.setText(temps.toString() + " minutes");
        Integer nbPers = recettes.get(holder.getAdapterPosition()).getNbPers();
        holder.recetteNbPers.setText(nbPers.toString() + " pers.");
        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putInt("envoiRecette", holder.getAdapterPosition());

                Navigation.findNavController(v).navigate(R.id.nav_info, bundle);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recettes.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            ArrayList<Recette> filteredList = new ArrayList<>();
            if(constraint.toString().isEmpty()){
                filteredList.addAll(recettesAll);
            } else {
                for(Recette recette : recettesAll){
                    if(recette.getIntitule().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(recette);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            recettes.clear();
            recettes.addAll((Collection<? extends Recette>) results.values);
            notifyDataSetChanged();
        }
    };


    public class HomeViewHolder extends RecyclerView.ViewHolder{

        TextView recetteNom;
        TextView recetteTemps;
        TextView recetteNbPers;
        RelativeLayout parent_layout;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            recetteNom = itemView.findViewById(R.id.recetteNom);
            recetteTemps = itemView.findViewById(R.id.recetteTemps);
            recetteNbPers = itemView.findViewById(R.id.recetteNbPers);
            parent_layout = itemView.findViewById(R.id.parent_layout);
        }
    }

}
