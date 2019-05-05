package com.example.onlineclothingshopping;

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

import modal.Items;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAddItem;
    private RecyclerView rvItem;

    List<Items> itemsList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rvItem = findViewById(R.id.rvItem);
        readFromFile();

//        ItemAdapter itemsAdapter = new ItemAdapter(this, contactList);
//        rvContact.setAdapter(itemsAdapter);
//        rvContact.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    public void onClick(View v) {

    }

    private void readFromFile(){
        try {
            FileInputStream fos = openFileInput("items.txt");
            InputStreamReader isr = new InputStreamReader(fos);
            BufferedReader br = new BufferedReader(isr);
            String line ="";

            while ((line = br.readLine()) != null){
                String[] parts = line.split("->");
                itemsList.add(new Items(parts[0], parts[1], parts[2], R.drawable.ic_launcher_background));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
