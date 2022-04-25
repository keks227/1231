package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.jetbrains.anko.doAsync
import org.json.JSONObject
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.net.URL

class MainActivity : AppCompatActivity() {
    private var cityUser: EditText? = null
    private var button: Button? = null
    private var result: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cityUser = findViewById(R.id.citiView)
        button = findViewById(R.id.buttonView)
        result = findViewById(R.id.resultView)


        button?.setOnClickListener{
            if(cityUser?.text?.toString()?.trim()?.equals("")!!){
                Toast.makeText(this, "Введите город", Toast.LENGTH_LONG).show()
            }
            else{
                var city: String = cityUser?.text.toString()
                var key: String = "47c83870d669062aec3140b9620e2214"
                var url: String = "https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$key&units=metric&lang=ru"

//                getWeather(city, key)

                doAsync {
                    val api = URL(url).readText()
                    Log.d("info", api)

                    val weather = JSONObject(api).getJSONArray("weather")
                    val desc = weather.getJSONObject(0).getString("description")
                    val main = JSONObject(api).getJSONObject("main")
                    val temp = main.getString("temp") + "°С"

                    result?.text = "Температура: $temp\n$desc"
                }
            }
        }
    }
//    private fun getWeather(city: String, key: String){
//        cityUser = findViewById(R.id.citiView)
//        button = findViewById(R.id.buttonView)
//        result = findViewById(R.id.resultView)
//
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
//            .baseUrl("https://api.openweathermap.org/data/2.5/weather?q=$city&appid=$key&units=metric&lang=ru")
//            .client(okHttpClient)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//
//        Log.i("retrofit", "retrofit")
//
//        val service = retrofit.create(WeatherService::class.java)
//        val response = service.getList()

//        response.enqueue (object: Callback<DataList> {
//            override fun onResponse(call: Call<DataList>?, response: Response<DataList>?)
//            {
//                val DataResponse = response!!.body()!!
//                for (cripta in DataResponse.data)
//                {
//                    Log.i("TEST", cripta.temp)
//                    result.setText(cripta.temp)
//                }
//            }
//
//            override fun onFailure(call: Call<DataList>, t: Throwable) {
//                TODO("Not yet implemented")
//            }
//        })
//    }
}