package com.example.searchimages;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOk = findViewById(R.id.okay);
        EditText editText = findViewById(R.id.edit_text);
        ImageView imageView = findViewById(R.id.image_view);
        String image = editText.getText().toString();


        View.OnClickListener oclBtnOk = view -> {
          try{
              Picasso.get()
                      .load(editText.getText().toString())
                      .into(imageView, new Callback() {
                          @Override
                          public void onSuccess() {
                          }

                          @Override
                          public void onError(Exception e) {
                              Toast.makeText(MainActivity.this, "check the link for typos", Toast.LENGTH_LONG).show();
                          }
                      });

          }catch (NullPointerException e){Toast.makeText(MainActivity.this, "null", Toast.LENGTH_LONG).show();};

        };
        btnOk.setOnClickListener(oclBtnOk);
    }
}