package com.example.alexanderdrumond.work3.pokemon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.alexanderdrumond.work3.R;
import com.example.alexanderdrumond.work3.models.Pokemon;

public class AddPokemonActivity extends AppCompatActivity implements PokemonCallback {


    EditText nameEt;
    EditText descriptionEt;
    private Switch aSwitch;
    Button saveBtn;
    private String PokemonKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pokemon);

        nameEt = (EditText) findViewById(R.id.nameEt);
        descriptionEt = (EditText) findViewById(R.id.descriptionEt);
        aSwitch = (Switch) findViewById(R.id.shareSw);
        saveBtn = (Button) findViewById(R.id.saveBtn);

        final Pokemon pokemon = (Pokemon) getIntent().getSerializableExtra("pokemon");

        if (pokemon != null) {
            PokemonKey = pokemon.getKey();
            getSupportActionBar().setTitle(pokemon.getName());

            nameEt.setText(pokemon.getName());
            descriptionEt.setText(pokemon.getDescription());
            aSwitch.setChecked(pokemon.isAvailability());

        }


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEt.getText().toString();
                String description = descriptionEt.getText().toString();
                boolean availability = aSwitch.isChecked();

                new PokemonValidation(AddPokemonActivity.this).addPokemon(name, description, availability, pokemon);


            }
        });
    }

    @Override
    public void success() {
        Toast.makeText(this, "Agregado/Actualizado", Toast.LENGTH_SHORT).show();
    }
}
