package com.example.tiroirsimple;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tiroirsimple.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        NavigationView nv = binding.navView;
        drawerLayout = binding.drawerLayout;

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_item_one:
                        finish();
                        System.exit(0);
                        break;
                    case R.id.nav_item_two:
                        Toast.makeText(MainActivity.this, "Vladislav", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_item_three:
                        Log.i("Message", "Je sais pas si c'est ca");
                        break;
                }
                return false;
            }
        });




    }


}