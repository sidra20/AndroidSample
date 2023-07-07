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
        Food food1 = new Food("Pizza", "340gm", "$200", "https://www.foodandwine.com/thmb/Wd4lBRZz3X_8qBr69UOu2m7I2iw=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/classic-cheese-pizza-FT-RECIPE0422-31a2c938fc2546c9a07b7011658cfd05.jpg");
        Food food2 = new Food("Burger", "340gm", "$200","https://www.recipetineats.com/wp-content/uploads/2022/08/Stack-of-cheeseburgers.jpg");
        Food food3 = new Food("Biryani", "340gm", "$200","https://images.food52.com/7f0yncraWeYUJG_lLbH2ie1xd6g=/2016x1344/d815e816-4664-472e-990b-d880be41499f--chicken-biryani-recipe.jpg");
        Food food4 = new Food("Broast", "340gm", "$200","https://funcooking.co.uk/wp-content/uploads/2016/03/Crispy-Broast-68.jpg");

        arrayList.add(food1);
        arrayList.add(food2);
        arrayList.add(food3);
        arrayList.add(food4);


        floadAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Food obj = new Food("Chineese", "300gm", "$20","https://i.ytimg.com/vi/aJvzY3crdyg/maxresdefault.jpg");
                arrayList.add(obj);
                foodAdapter.notifyDataSetChanged();
            }
        });

        foodAdapter = new FoodAdapter(this,arrayList);
        foodRecyclerview.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();


    }
}
