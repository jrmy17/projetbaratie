package fr.jmm.baratie.ui.create;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.jmm.baratie.R;
import fr.jmm.baratie.metier.Ingredient;

public class CreateAddedAdapter extends RecyclerView.Adapter<CreateAddedAdapter.CreateAddedViewHolder> {

    private static final String TAG = " ";


    private HashMap<Ingredient, Double> listeAddedIngredients;
    private Double[] addedDoubles;
    private Ingredient[] addedIng;
    private Context mContext;


    public CreateAddedAdapter(HashMap<Ingredient, Double> listeAddedIngredients, Context mContext) {
        this.listeAddedIngredients = listeAddedIngredients;
        this.mContext = mContext;
        addedDoubles = new Double[listeAddedIngredients.size()];
        addedIng = new Ingredient[listeAddedIngredients.size()];
        int i = 0;
        for (Map.Entry<Ingredient, Double> e : listeAddedIngredients.entrySet()){
            addedIng[i] = e.getKey();
            addedDoubles[i] = e.getValue();
            i++;
        }
    }

    @NonNull
    @Override
    public CreateAddedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listingredients_added, parent, false);
        CreateAddedViewHolder createAddedViewHolder = new CreateAddedViewHolder(view);
        return createAddedViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CreateAddedViewHolder holder, int position) {
        holder.nomIngredient.setText(addedIng[holder.getAdapterPosition()].getDesignation());
        String doubleQtt = String.valueOf(addedDoubles[holder.getAdapterPosition()].doubleValue());
        holder.quantite.setText(doubleQtt);
        holder.layoutIngAdded.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //

            }
        });
    }

    @Override
    public int getItemCount() {
        return listeAddedIngredients.size();
    }



    public class CreateAddedViewHolder extends RecyclerView.ViewHolder{

        TextView nomIngredient;
        TextView quantite;
        ConstraintLayout layoutIngAdded;

        public CreateAddedViewHolder(@NonNull View itemView) {
            super(itemView);
            nomIngredient = itemView.findViewById(R.id.nomIngredient);
            quantite = itemView.findViewById(R.id.quantite);
            layoutIngAdded = itemView.findViewById(R.id.layoutIngAdded);
        }
    }

}
