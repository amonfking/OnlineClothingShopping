package com.example.onlineclothingshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddItemActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etItemName, etItemPrice, etItemDescription, etItemImage;
    private Button btnAddItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        etItemName = findViewById(R.id.etItemName);
        etItemPrice = findViewById(R.id.etItemPrice);
        etItemDescription = findViewById(R.id.etItemDescription);
        etItemImage = findViewById(R.id.etItemImage);
        btnAddItem = findViewById(R.id.btnAddItem);

        btnAddItem.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (validation()) {
            addItem();
        }
    }

    public void addItem(){
        try {
            PrintStream printstream = new PrintStream(openFileOutput("items.txt",MODE_PRIVATE |MODE_APPEND));
            printstream.println(etItemName.getText().toString() +"->"+etItemPrice.getText().toString()+"->"+etItemImage.getText().toString()+"->"+etItemDescription.getText().toString());
            Toast.makeText(this, "Saved to "+getFilesDir(), Toast.LENGTH_LONG).show();
            printstream.close();
        }
        catch (IOException e){

        }
    }

    public boolean validation(){
        boolean flag = true;
        if (TextUtils.isEmpty(etItemName.getText().toString())){
            etItemName.setError("Please Enter Item Name");
            etItemName.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etItemPrice.getText().toString())){
            etItemPrice.setError("Please Enter Price");
            etItemPrice.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etItemImage.getText().toString())){
            etItemImage.setError("Please Enter Image Name");
            etItemImage.requestFocus();
            flag = false;
        }
        else if (TextUtils.isEmpty(etItemDescription.getText().toString())){
            etItemDescription.setError("Please Enter Description");
            etItemDescription.requestFocus();
            flag = false;
        }

        return flag;
    }
}
