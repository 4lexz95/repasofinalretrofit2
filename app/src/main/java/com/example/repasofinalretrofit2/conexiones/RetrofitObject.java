package com.example.repasofinalretrofit2.conexiones;

import com.example.repasofinalretrofit2.constantes.Constante;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitObject {
    public static Retrofit getConexion(){
        return new Retrofit.Builder().baseUrl(Constante.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();


    }
}
