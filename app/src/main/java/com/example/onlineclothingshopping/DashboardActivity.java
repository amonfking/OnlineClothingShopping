package com.example.onlineclothingshopping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import adapter.ItemsAdapter;
import modal.Items;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAddItem;
    private RecyclerView rvItem;

    List<Items> itemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btnAddItem = findViewById(R.id.btnAddItem);
        rvItem = findViewById(R.id.rvItem);
        readFromFile();

        ItemsAdapter itemsAdapter = new ItemsAdapter(this, itemsList);
        rvItem.setAdapter(itemsAdapter);
        rvItem.setLayoutManager(new GridLayoutManager(this, 2));

        btnAddItem.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(DashboardActivity.this, AddItemActivity.class);
        startActivity(intent);
    }

    private void readFromFile(){
        try {
            FileInputStream fos = openFileInput("items.txt");
            InputStreamReader isr = new InputStreamReader(fos);
            BufferedReader br = new BufferedReader(isr);
            String line ="";

            while ((line = br.readLine()) != null){
                String[] parts = line.split("->");
                itemsList.add(new Items(parts[0], parts[1], parts[3], this.getResources().getIdentifier(parts[2], "drawable", this.getPackageName())));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
