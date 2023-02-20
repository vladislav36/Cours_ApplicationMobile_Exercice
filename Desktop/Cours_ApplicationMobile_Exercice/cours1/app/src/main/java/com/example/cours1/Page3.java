package com.example.cours1;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.cours1.databinding.ActivityPage2Binding;
import com.example.cours1.databinding.ActivityPage3Binding;

public class Page3 extends AppCompatActivity {

    private ActivityPage3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPage3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setTitle("Page3");
        setContentView(view);



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
                Intent i = new Intent(Page3.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.PAG2:
                i = new Intent(Page3.this, Page2.class);
                startActivity(i);
                break;
            case R.id.PAG3:
                Toast.makeText(this, "On est deja present sur la page", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
