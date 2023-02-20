package com.example.cours1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cours1.databinding.ActivityMainBinding;
import com.example.cours1.databinding.ActivityPage2Binding;

public class Page2 extends AppCompatActivity {
    private ActivityPage2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPage2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setTitle("Page2");
        setContentView(view);
        binding.textView.setText(getIntent().getStringExtra("texte"));




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
                Intent i = new Intent(Page2.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.PAG2:
                Toast.makeText(this, "On est deja present sur la page", Toast.LENGTH_SHORT).show();
                break;
            case R.id.PAG3:
                i = new Intent(Page2.this, Page3.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
