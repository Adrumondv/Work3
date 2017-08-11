package com.example.alexanderdrumond.work3.tabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alexanderdrumond.work3.R;
import com.example.alexanderdrumond.work3.adapters.PokemonAdapter;
import com.example.alexanderdrumond.work3.adapters.PokemonListener;
import com.example.alexanderdrumond.work3.data.Nodes;
import com.example.alexanderdrumond.work3.models.Pokemon;
import com.example.alexanderdrumond.work3.pokemon.AddPokemonActivity;


public class SharedPokemonsFragment extends Fragment implements PokemonListener {

    private PokemonAdapter adapter;
    private RecyclerView recyclerView;

    public SharedPokemonsFragment() {
        // Required empty public constructor
    }

    public static SharedPokemonsFragment newInstance() {
        return new SharedPokemonsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shared_pokemons, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        adapter = new PokemonAdapter((PokemonListener) this, new Nodes().availablePokemons());

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void clicked(Pokemon pokemon) {

        Intent intent= new Intent(getActivity(),AddPokemonActivity.class);
        intent.putExtra("pomeon",pokemon);
        startActivity(intent);
    }

    @Override
    public void ready() {

    }
}
