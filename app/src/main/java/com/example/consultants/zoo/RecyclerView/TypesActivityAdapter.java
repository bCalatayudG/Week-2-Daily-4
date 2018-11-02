package com.example.consultants.zoo.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.consultants.zoo.R;
import com.example.consultants.zoo.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class TypesActivityAdapter extends RecyclerView.Adapter<TypesActivityAdapter.ViewHolder> {

    public static final String TAG = TypesActivityAdapter.class.getSimpleName() + "_tag";
    List<Animal> animalList;

    public TypesActivityAdapter(List<Animal> animalList) {
        this.animalList = animalList;
        Log.d(TAG, "TypesActivityAdapter: "+this.animalList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        int itemViewLayout = getItemViewLayout(viewType);
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemViewLayout, viewGroup, false);

        return new ViewHolder(view);
    }

    private int getItemViewLayout(int viewType) {
        int itemViewLayout;
        if (viewType == 1) {
            itemViewLayout = R.layout.animal_item_mammal;
        } else {
            itemViewLayout = R.layout.animal_item_fish;
        }
        return itemViewLayout;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Animal animal = animalList.get(i);

        viewHolder.tvName.setText(animal.getName());
        viewHolder.tvWeight.setText(animal.getWeight());
    }

    @Override
    public int getItemCount() {
        return animalList.size();
    }

    @Override
    public int getItemViewType(int position) {

        String weight = (animalList.get(position).getWeight());

        if (Integer.parseInt(weight)>500) return 1;
        else return 2;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvName;
        private final TextView tvWeight;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvWeight = itemView.findViewById(R.id.tvWeight);

        }
    }
}
