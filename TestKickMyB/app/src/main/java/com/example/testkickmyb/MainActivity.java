package com.example.testkickmyb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.testkickmyb.databinding.ActivityMainBinding;
import com.example.testkickmyb.http.RetrofitUtil;
import com.example.testkickmyb.http.Service;

import org.kickmyb.transfer.HomeItemResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        service = RetrofitUtil.get();

        setContentView(binding.getRoot());

//        getTest();
        getHome();
    }

    private void getHome() {
        service.home().enqueue(new Callback<List<HomeItemResponse>>() {
            @Override
            public void onResponse(Call<List<HomeItemResponse>> call, Response<List<HomeItemResponse>> response) {
                List<HomeItemResponse> list = response.body();
                binding.tvTest.setText(list.toString());
            }

            @Override
            public void onFailure(Call<List<HomeItemResponse>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Une erreur est survenue en communicant avec le serveur.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getTest() {
        service.test().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String res = response.body();
                binding.tvTest.setText(res);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Une erreur est survenue en communicant avec le serveur.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}