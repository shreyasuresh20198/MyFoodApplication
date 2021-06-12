package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // creating object of ViewPager
    ViewPager mViewPager;
    EditText myfilter;
    ListView listview;
    ArrayAdapter<String> adapter;
    CustomList adapter1;

    private RecyclerView recyclerview;
    String[] food = {"IceCream","Cake","Shawarma","Juices","MilkShake","Biriyani","Chinese","Al Faham","Soup",
            "Salad","Mutton","Chicken","Fish","Starters"

    } ;

    int[] images = {R.drawable.a5,R.drawable.cake,R.drawable.shawarma,R.drawable.juice,R.drawable.milkshake,R.drawable.biriyani,
            R.drawable.chinese,R.drawable.alfaham,R.drawable.soup,R.drawable.salad,R.drawable.mutton,
            R.drawable.chicken,R.drawable.fish,R.drawable.starter};

    // Creating Object of ViewPagerAdapter
    Adapter mViewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initializing the ViewPager Object
        listview=findViewById(R.id.listview);
        myfilter=findViewById(R.id.myfilter);

//        ArrayList<String>arrayList=new ArrayList<>();
//        arrayList.add("IceCream");
//        arrayList.add("Cake");
//        arrayList.add("Shawarma");
//        arrayList.add("Juices");
//        arrayList.add("MilkShake");
//        arrayList.add("Biriyani");
//        arrayList.add("Chinese");
//        arrayList.add("Al Faham");
//        arrayList.add("Soup");
//        arrayList.add("Salad");
//        arrayList.add("Mutton");
//        arrayList.add("Chicken");
//        arrayList.add("Fish");
//        arrayList.add("Starters");
//         arrayAdapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
//        listview.setAdapter(arrayAdapter);
        mViewPager = (ViewPager)findViewById(R.id.viewPagerMain);
        Context context;


         adapter = new ArrayAdapter<String>(this,android.R.layout.test_list_item,food);
//        listView.setAdapter(adapter);




         adapter1 = new
                CustomList(MainActivity.this, food, images);
        listview=(ListView)findViewById(R.id.listview);
        listview.setAdapter(adapter1);


        mViewPagerAdapter = new Adapter(MainActivity.this, images);


        mViewPager.setAdapter(mViewPagerAdapter);


            myfilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                listview.setAdapter(adapter);
                MainActivity.this.adapter.getFilter().filter(charSequence);
//                adapter1.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
//        }
    }
}