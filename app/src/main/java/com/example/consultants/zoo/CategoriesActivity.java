package com.example.consultants.zoo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.consultants.zoo.RecyclerView.TypesActivity;
import com.example.consultants.zoo.db.InfoDatabase;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesActivity extends AppCompatActivity {

    private static final String TAG = CategoriesActivity.class.getSimpleName() + "_tag";


    @BindView(R.id.tvImage2)
    ListView tvImage;
    @BindView(R.id.tv)
    TextView tv;

    private InfoDatabase infoDatabase;
    private ArrayAdapter<String> infoImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        infoDatabase = new InfoDatabase(getApplicationContext());

        infoImageAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>());
        tvImage.setAdapter(infoImageAdapter);
        infoImageAdapter.clear();
        infoDatabase.showCategories();
        for (String hashKey : infoDatabase.showCategories().keySet()) {
            infoImageAdapter.add(hashKey);
            Log.d(TAG, "onCreate: "+hashKey);
        }

        // Set an item click listener for ListView
        tvImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item text from ListView
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(getApplicationContext(),TypesActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("animal", selectedItem);

                intent.putExtras(bundle);
                startActivity(intent);
                // Display the selected item text on TextView
                tv.setText("Your favorite : " + selectedItem);
            }
        });

    }



}
