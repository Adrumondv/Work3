package com.example.alexanderdrumond.work3.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.alexanderdrumond.work3.R;
import com.example.alexanderdrumond.work3.models.Pokemon;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by Alexander Drumond on 10-08-2017.
 */

public class PokemonAdapter extends FirebaseRecyclerAdapter<Pokemon, PokemonAdapter.PokemonHolder> {

    private PokemonListener listener;
    private boolean firstTime = true;

    public PokemonAdapter(Class<Pokemon> modelClass, int modelLayout, Class<PokemonHolder> viewHolderClass, Query ref) {
        super(modelClass, modelLayout, viewHolderClass, ref);
    }

    public PokemonAdapter(PokemonListener listener, Query query) {
        super(Pokemon.class, R.layout.list_item_pokemon, PokemonHolder.class, query);
        this.listener = listener;
    }

    @Override
    protected void populateViewHolder(final PokemonHolder viewHolder, Pokemon model, int position) {
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

    @Override
    protected void onDataChanged() {
        super.onDataChanged();

        if (firstTime) {
            firstTime = false;
            listener.ready();
        }
    }

    public static class PokemonHolder extends RecyclerView.ViewHolder{

        public PokemonHolder(View itemView) {
            super(itemView);
        }
    }
}
