package com.example.superrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ObjetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initRecycler();
        this.remplirRecycler();

        this.remplacer();

    }

    private void remplacer(){
        adapter.list.clear();
        for (int i = 0 ; i < 10 ; i++) {
            Secret p = new Secret();
            p.nom = "Charles ";
            int io = 20 + (new Random().nextInt(20));
            Long num = Long.valueOf(io);
            p.nbGrand = num;
            adapter.list.add(p);
        }
        adapter.notifyDataSetChanged();
    }

    private void remplirRecycler() {
        for (int i = 0 ; i < 10000 ; i++) {
            Secret p = new Secret();
            p.nom = "Bob " + i;
            int io = 20 + (new Random().nextInt(20));
            Long num = Long.valueOf(io);
            p.nbGrand = num;
            adapter.list.add(p);
        }
        adapter.notifyDataSetChanged();
    }

    private void initRecycler(){
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new ObjetAdapter();
        recyclerView.setAdapter(adapter);
    }

}