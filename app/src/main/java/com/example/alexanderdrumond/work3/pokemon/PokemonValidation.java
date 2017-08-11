package com.example.alexanderdrumond.work3.pokemon;

import com.example.alexanderdrumond.work3.data.CurrentUser;
import com.example.alexanderdrumond.work3.data.Nodes;
import com.example.alexanderdrumond.work3.models.Pokemon;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Alexander Drumond on 10-08-2017.
 */

public class PokemonValidation {

    private PokemonCallback callback;
    public PokemonValidation(PokemonCallback callback){this.callback = callback;}

    public void addPokemon(String name, String description, boolean availability, Pokemon pokemon){

        String key = (pokemon != null) ? pokemon.getKey() : new Nodes().pokemons().push().getKey();

        FirebaseUser currentUser = new CurrentUser().getCurrent();
        String uid = currentUser.getUid();

        pokemon = new Pokemon();
        pokemon.setKey(key);
        pokemon.setUid(uid);

        pokemon.setName(name);
        pokemon.setDescription(description);
        pokemon.setAvailability(availability);

        new Nodes().pokemons().child(key).setValue(pokemon);

        callback.success();
    }
}
