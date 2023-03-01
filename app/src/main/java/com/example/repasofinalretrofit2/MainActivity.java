package com.example.repasofinalretrofit2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.repasofinalretrofit2.conexiones.ApiConexiones;
import com.example.repasofinalretrofit2.conexiones.RetrofitObject;
import com.example.repasofinalretrofit2.modelos.Coin;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    //recycler
    private RecyclerView recy;
    private CoinAdapter adapter;
    private RecyclerView.LayoutManager lm;
    private List<Coin> monedas;
    //Como extra, me voy a crear un atributo de tipo respuesta para guardar la ultima respuesta  que se trae del servidor asi tengo en
    //esa variable el next page y el total count que se traer de esa variable
    private Coin coin;

    private ApiConexiones api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inicializar cosas

        //recycler VIEW
        recy = findViewById(R.id.contenedor);
        monedas = new ArrayList<>();
        adapter = new CoinAdapter(monedas, R.layout.moneda_view_holder, this);
        lm = new GridLayoutManager(this,2);
        recy.setAdapter(adapter);
        recy.setLayoutManager(lm);

        cargaInicialDatos();
    }

    private void cargaInicialDatos() {
        //api = RetrofitObject.getConexion().create(ApiConexiones.class);
        Retrofit retrofit = RetrofitObject.getConexion();
        ApiConexiones api = retrofit.create(ApiConexiones.class);
        api.getMonedas();
        Call<ArrayList<Coin>> getMonedas = api.getMonedas();
        getMonedas.enqueue(new Callback<ArrayList<Coin>>() {
            @Override
            public void onResponse(Call<ArrayList<Coin>> call, Response<ArrayList<Coin>> response) {
                if (response.code() == 200){
                    ArrayList<Coin> temp = response.body();
                    monedas.addAll(temp);
                    adapter.notifyItemRangeInserted(0,temp.size());
                }else {
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Coin>> call, Throwable t) {

            }
        });

    }
}