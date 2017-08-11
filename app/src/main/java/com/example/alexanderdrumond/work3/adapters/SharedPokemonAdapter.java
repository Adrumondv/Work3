package com.example.alexanderdrumond.work3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alexanderdrumond.work3.R;
import com.example.alexanderdrumond.work3.data.Nodes;
import com.example.alexanderdrumond.work3.models.Pokemon;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by Alexander Drumond on 10-08-2017.
 */

public class SharedPokemonAdapter extends FirebaseRecyclerAdapter<Pokemon,SharedPokemonAdapter.SharedPokemonHolder>{

    PokemonListener listener;

    public SharedPokemonAdapter(Class<Pokemon> modelClass, int modelLayout, Class<SharedPokemonHolder> viewHolderClass, Query ref) {
        super(Pokemon.class, R.layout.list_item_pokemon, SharedPokemonHolder.class, new Nodes().availablePokemons());
    }

    @Override
    protected void populateViewHolder(final SharedPokemonHolder viewHolder, Pokemon model, int position) {
        TextView textView = (TextView) viewHolder.itemView;
        textView.setText(model.getName());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pokemon auxPokemon = getItem(viewHolder.getAdapterPosition());
                listener.clicked(auxPokemon);
            }
        });

    }

    public static class SharedPokemonHolder extends RecyclerView.ViewHolder{

        public SharedPokemonHolder(View itemView) {
            super(itemView);
        }
    }
}
