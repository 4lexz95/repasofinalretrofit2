package com.example.repasofinalretrofit2.conexiones;

import com.example.repasofinalretrofit2.modelos.Coin;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiConexiones {


    @GET("/assets")
    Call<ArrayList<Coin>> getMonedas();

}
