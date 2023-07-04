package com.example.sidraapp.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidraapp.R;
import com.example.sidraapp.adapters.FoodAdapter;
import com.example.sidraapp.models.Food;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FoodListActivity extends AppCompatActivity {

    private FoodAdapter foodAdapter;
    private ArrayList<Food> arrayList;
    private RecyclerView foodRecyclerview;
    private FloatingActionButton floadAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_foodlist);
        foodRecyclerview = findViewById(R.id.foodlistRv);
        foodRecyclerview.setLayoutManager(new LinearLayoutManager(this));

        floadAdd = findViewById(R.id.floatAdd);

        arrayList = new ArrayList<>();
        Food food1 = new Food("Pizza", "340gm", "$200");
        Food food2 = new Food("Chicken", "340gm", "$200");
        Food food3 = new Food("Biryani", "340gm", "$200");
        Food food4 = new Food("Broast", "340gm", "$200");

        arrayList.add(food1);
        arrayList.add(food2);
        arrayList.add(food3);
        arrayList.add(food4);


        floadAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Food obj = new Food("Chineese", "300gm", "$20");
                arrayList.add(obj);
                foodAdapter.notifyDataSetChanged();
            }
        });

        foodAdapter = new FoodAdapter(this,arrayList);
        foodRecyclerview.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();


    }
}
