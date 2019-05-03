package com.example.onlineclothingshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    private EditText etItemName, etItemPrice, etItemDescription;
    private Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        etItemName = findViewById(R.id.etItemName);
        etItemPrice = findViewById(R.id.etItemPrice);
        etItemDescription = findViewById(R.id.etItemDescription);
        btnAddItem = findViewById(R.id.btnAddItem);
    }
}
