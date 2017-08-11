package com.example.alexanderdrumond.work3.tabs;

import android.app.ProgressDialog;
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


public class PokemonsFragment extends Fragment implements PokemonListener {

    private PokemonAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;

    public PokemonsFragment() {
        // Required empty public constructor
    }

    public static PokemonsFragment newInstance(){return new PokemonsFragment();}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pokemons,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.show();

        recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        adapter = new PokemonAdapter(this, new Nodes().poke());

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter.cleanup();
    }

    @Override
    public void clicked(Pokemon pokemon) {
        Intent intent= new Intent(getActivity(),AddPokemonActivity.class);
        intent.putExtra("pokemon",pokemon);
        startActivity(intent);

    }

    @Override
    public void ready() {
        progressDialog.dismiss();
    }
}



