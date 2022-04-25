package com.example.weather

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherService{
//    @GET("data/2.5/weather?q=$city1&appid=$key&units=metric&lang=ru")
//    private fun getBitoc(weather: List<ListItem>){
//
//        val httpLogingInterceptor = HttpLoggingInterceptor()
//        httpLogingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//
//        val okHttpClient = OkHttpClient.Builder()
//            .addInterceptor(httpLogingInterceptor)
//            .build()
//
////        Log.i("ok", "okHttpClient")
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://api.openweathermap.org/")
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//
////        Log.i("retrofit", "retrofit")
//
//        val service = retrofit.create(WeatherService::class.java)
//    }

    fun getList(): Call<DataList>
}