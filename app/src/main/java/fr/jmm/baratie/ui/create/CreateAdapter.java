package fr.jmm.baratie.ui.create;

import android.content.Context;
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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;

import fr.jmm.baratie.R;
import fr.jmm.baratie.metier.Ingredient;
import fr.jmm.baratie.metier.Recette;

public class CreateAdapter extends RecyclerView.Adapter<CreateAdapter.CreateViewHolder> implements Filterable {

    private static final String TAG = " ";

    private ArrayList<Ingredient> ingredientsAll;
    private ArrayList<Ingredient> ingredients;
    private Context mContext;

    public CreateAdapter(ArrayList<Ingredient> ingredients, Context mContext) {
        this.ingredients = ingredients;
        this.ingredientsAll = new ArrayList<>(ingredients);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CreateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listingredients, parent, false);
        CreateViewHolder createViewHolder = new CreateViewHolder(view);
        return createViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CreateViewHolder holder, int position) {
        holder.nomIngredient.setText(ingredients.get(holder.getAdapterPosition()).getDesignation());
        holder.unite.setText(ingredients.get(holder.getAdapterPosition()).getUnite());
        holder.layoutIng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, ingredients.get(holder.getAdapterPosition()).getDesignation(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            ArrayList<Ingredient> filteredList = new ArrayList<>();
            if(constraint.toString().isEmpty()){
                filteredList.addAll(ingredientsAll);
            } else {
                for(Ingredient ingredient : ingredientsAll){
                    if(ingredient.getDesignation().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredList.add(ingredient);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            ingredients.clear();
            ingredients.addAll((Collection<? extends Ingredient>) results.values);
            notifyDataSetChanged();
        }
    };


    public class CreateViewHolder extends RecyclerView.ViewHolder{

        TextView nomIngredient;
        TextView unite;
        ConstraintLayout layoutIng;

        public CreateViewHolder(@NonNull View itemView) {
            super(itemView);
            nomIngredient = itemView.findViewById(R.id.nomIngredient);
            unite = itemView.findViewById(R.id.unite);
            layoutIng = itemView.findViewById(R.id.layoutIng);
        }
    }

}
