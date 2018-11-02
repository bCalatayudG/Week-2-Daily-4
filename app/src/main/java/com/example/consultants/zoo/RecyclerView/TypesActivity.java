package com.example.consultants.zoo.RecyclerView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.consultants.zoo.R;
import com.example.consultants.zoo.db.InfoDatabase;
import com.example.consultants.zoo.model.Animal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TypesActivity extends AppCompatActivity {

    @BindView(R.id.rvAnimal)
    RecyclerView rvAnimal;

    private TypesActivityAdapter adapter; //mine
    private RecyclerView.LayoutManager layoutManager; //Android
    private InfoDatabase infoDatabase;

    private static final String TAG = TypesActivity.class.getSimpleName() + "_tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_types);

        Bundle b = getIntent().getExtras();
        String index = b.getString("animal");

        //String clicked_animal = savedInstanceState.getString("animal");
        Log.d(TAG, "onCreate: clicked_animal: " + index);
        ButterKnife.bind(this);
        rvAnimal = findViewById(R.id.rvAnimal);
        List<Animal> animalList = new ArrayList<>();

        infoDatabase = new InfoDatabase(getApplicationContext());

        animalList = infoDatabase.showAnimal();
        Log.d(TAG, "onCreate: clicked_animal: " + animalList);

        adapter = new TypesActivityAdapter(animalList);
        layoutManager = new LinearLayoutManager(this);
        rvAnimal.setAdapter(adapter);
        rvAnimal.setLayoutManager(layoutManager);

    }
}
