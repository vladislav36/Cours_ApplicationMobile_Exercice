package com.example.retrofit2_demo;

import android.util.Log;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.retrofit2_demo.http.RetrofitUtil;
import com.example.retrofit2_demo.http.Service;
import com.example.retrofit2_demo.transfer.Repo;
import com.example.retrofit2_demo.transfer.Utilisateur;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void testSimple() throws IOException {
        Service service = RetrofitUtil.get();
        Call<String> call = service.listReposString("PierreOlivierBrillant");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT", resultat);
    }

    @Test
    public void testSimple2() throws IOException {
        Service service = RetrofitUtil.get();
        Call<String> call = service.utilisateurString("PierreOlivierBrillant");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("RETROFIT", resultat);
    }

    @Test
    public void testSimple3() throws IOException {
        Service service = RetrofitUtil.get();
        Call<Utilisateur> call = service.utilisateur("PierreOlivierBrillant");
        Response<Utilisateur> response = call.execute();
        Utilisateur resultat = response.body();
        Log.i("RETROFIT", resultat.toString());
    }

    @Test
    public void testSimple4() throws IOException {
        Service service = RetrofitUtil.get();
        Call<List<Repo>> call = service.listRepos("jorisdeguet");
        Response<List<Repo>> response = call.execute();
        List<Repo> resultat= response.body();
        Log.i("RETROFIT", resultat.toString());
    }
}