package com.example.consultants.zoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.consultants.zoo.db.InfoDatabase;
import com.example.consultants.zoo.model.Animal;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainZoo extends AppCompatActivity {

    @BindView(R.id.btnCreateDB)
    Button btnCreateDB;
    @BindView(R.id.btnListCategories)
    Button btnListCategories;
    @BindView(R.id.btnSeeDB)
    Button btnSeeDB;
    @BindView(R.id.tvImage)
    ListView tvImage;

    private InfoDatabase infoDatabase;
    private ArrayAdapter<String> infoAdapter;
    List<Animal> animalList = new ArrayList<>();

    private static final String TAG = MainZoo.class.getSimpleName() + "_tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        infoDatabase = new InfoDatabase(getApplicationContext());
        infoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        tvImage.setAdapter(infoAdapter);
    }

    @OnClick(R.id.btnCreateDB)
    public void onBtnCreateDBClicked() {
        Log.d(TAG, "onBtnCreateDBClicked: ");

        infoDatabase.saveInfo(createAnimalList());
    }

    @OnClick(R.id.btnListCategories)
    public void onBtnListCategoriesClicked() {
        Intent intent = new Intent(getApplicationContext(), CategoriesActivity.class);
//        Bundle bundle = new Bundle();
//
//        intent.putExtras("",bundle);
        startActivity(intent);
    }

    private List<Animal> createAnimalList() {
        List<Animal> animalList = new ArrayList<>();
        byte[] image = new byte[10];
        Animal animal = new Animal("mammal", "bear", "990",
                "roar", "polar bear", "mammal1", image);
        Animal animal1 = new Animal("mammal", "monkey", "82",
                "monkeySound", "Mandrill", "mammal2", image);
        Animal animal2 = new Animal("mammal", "bear", "660",
                "roar", "panda bear", "mammal3", image);


        Animal animal3 = new Animal("bird", "falcon", "7",
                "pip", "Red-footed falcon", "bird1", image);
        Animal animal4 = new Animal("bird", "Owl", "8",
                "pip", "big Owl", "bird2", image);
        Animal animal5 = new Animal("bird", "Hummingbird", "26",
                "pip", "royal Hummingbird", "bird3", image);

        Animal animal6 = new Animal("fish", "golden fish", "1",
                "blob", "big", "fish1", image);
        Animal animal7 = new Animal("fish", "bear", "5",
                "blob", "dead", "fish1", image);
        Animal animal8 = new Animal("fish", "bear", "90",
                "blob", "alive", "fish1", image);

        animalList.add(animal);
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        animalList.add(animal4);
        animalList.add(animal5);
        animalList.add(animal6);
        animalList.add(animal7);
        animalList.add(animal8);
        Log.d(TAG, "createAnimalList: List: "+animalList);
        return animalList;
    }

    @OnClick(R.id.btnSeeDB)
    public void onViewClicked() {//Shows the database
        infoAdapter.clear();
        for (Animal animal : infoDatabase.showTable()) {
            infoAdapter.add(animal.toString());
        }
    }
}
