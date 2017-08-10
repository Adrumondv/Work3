package com.example.alexanderdrumond.work3.data;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

/**
 * Created by Alexander Drumond on 09-08-2017.
 */

public class Nodes {

    private DatabaseReference root = FirebaseDatabase.getInstance().getReference();

    public Query availablePokemons(){


        return root.child("pokemons").orderByChild("availability").equalTo(true);
    }

    public DatabaseReference user(){return  root.child("users");}
    public DatabaseReference pokemons(){return root.child("pokemons");}

    public Query poke(){
        return root.child("pokemons").orderByChild("uid").equalTo(new CurrentUser().uid());
    }

}
