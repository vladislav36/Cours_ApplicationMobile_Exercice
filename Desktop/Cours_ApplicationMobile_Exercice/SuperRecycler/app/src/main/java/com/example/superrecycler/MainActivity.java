package com.example.superrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;

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
            p.Time = generateRandomDate();
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
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new ObjetAdapter();
        recyclerView.setAdapter(adapter);
    }

    //Generate random date
    private static int randBetween(int start, int end){
        return  start + (int) Math.round(Math.random() * (end - start));
    }


    private LocalDate generateRandomDate(){
        String finaleDate = "";


        int year = MainActivity.randBetween(1900, 2013);// Here you can set Range of years you need
        int month = MainActivity.randBetween(1, 11);



        GregorianCalendar gc = new GregorianCalendar(year, month, 1);
        int day = MainActivity.randBetween(1, gc.getActualMaximum(gc.DAY_OF_MONTH));

        String mois = "";
        String jour = "";
        if(month < 10){
            mois = "0" + month;
        }
        else {
            mois = Integer.toString(month);
        }
        if(day < 10){
            jour = "0" + day;
        }
        else {
            jour = Integer.toString(day);
        }

        finaleDate = year + "-" + mois + "-" + jour;

        DateTimeFormatter formatter = null;
        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(finaleDate, formatter);
        return dateTime;




    }

}