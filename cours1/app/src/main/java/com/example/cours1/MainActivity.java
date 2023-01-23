package com.example.cours1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.cours1.databinding.ActivityMainBinding;

public class  MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Page2.class);
                i.putExtra("texte", binding.textView20.getText().toString());
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return  super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item ) {
        switch (item.getItemId()){
            case R.id.PAG:
                Toast.makeText(this, "On est deja present sur la page 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.PAG2:
                 Intent i = new Intent(MainActivity.this, Page2.class);
                startActivity(i);
                break;
            case R.id.PAG3:
                i = new Intent(MainActivity.this, Page3.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}