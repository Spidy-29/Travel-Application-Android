package com.example.travelapplication.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.travelapplication.Adapter.CategoryAdapter;
import com.example.travelapplication.Adapter.PopularAdapter;
import com.example.travelapplication.R;
import com.example.travelapplication.domains.CategoryDomain;
import com.example.travelapplication.domains.PopularDomain;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CategoryAdapter categoryAdapter;
    private PopularAdapter popularAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        List<PopularDomain> list = new ArrayList<PopularDomain>();
        list.add(new PopularDomain("Mar caible, avendia lago","Miami Beach","This 2 Bed /11 bath home boasts an enormous,"+
                " open-living plan, accented by striking"+
                " architectural features and high-end finishes."+
                " Feel inspired by open sight lines that"+
                " embrace the outdoors, crowned by stunning"+
                " coffered ceilings. ",2,true,4.8,"pic1",true,1000));

        list.add(new PopularDomain("Passo Rolle, TN","Hawaii Beach","This 2 Bed /11 bath home boasts an enormous,"+
                " open-living plan, accented by striking"+
                " architectural features and high-end finishes."+
                " Feel inspired by open sight lines that"+
                " embrace the outdoors, crowned by stunning"+
                " coffered ceilings. ",1,false,5,"pic2",false,2500));

        list.add(new PopularDomain("Mar caible, avendia lago","Miami Beach","This 2 Bed /11 bath home boasts an enormous,"+
                " open-living plan, accented by striking"+
                " architectural features and high-end finishes."+
                " Feel inspired by open sight lines that"+
                " embrace the outdoors, crowned by stunning"+
                " coffered ceilings. ",3,true,4.3,"pic3",true,3000));

        RecyclerView rv_popular = findViewById(R.id.rv_popular);
        rv_popular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rv_popular.setAdapter(new PopularAdapter(list));


        List<CategoryDomain> listCategory = new ArrayList<CategoryDomain>();

        listCategory.add(new CategoryDomain("Beaches","cat1"));
        listCategory.add(new CategoryDomain("Camps","cat2"));
        listCategory.add(new CategoryDomain("Forest","cat3"));
        listCategory.add(new CategoryDomain("Desert","cat4"));
        listCategory.add(new CategoryDomain("Mountains","cat5"));
        RecyclerView rv_category = findViewById(R.id.rv_category);
        rv_category.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        rv_category.setAdapter(new CategoryAdapter(listCategory));
    }
}
