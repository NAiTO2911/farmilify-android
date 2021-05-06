package com.farmilify.client

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_cuaca.*
import okhttp3.*
import java.io.IOException

class Cuaca : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        //run("https://api.openweathermap.org/data/2.5/forecast?q=purwakarta,ID&appid=2ce659b9c25fc6fe3a07de4ca71d1dac")

        NetworkConfig().getService().getWeathers("purwakarta,ID", "2ce659b9c25fc6fe3a07de4ca71d1dac").enqueue(object : retrofit2.Callback<Response> {

            override fun onResponse(call: retrofit2.Call<Response>, response: retrofit2.Response<Response>) {
                val item = response.body()
                Log.d("response", response.body().toString())

                txtKota.text = item?.city?.name
                txtTanggal.text = item?.list?.get(0)?.dt.let { it?.let { it1 -> Util.getDayName(it1) } }
                text_temp.text = item?.list?.get(0)?.main?.temp.let { it?.let { it1 -> Util.setFormatTemperature(it1) } }
                text_temp_min_max.text = item?.list?.get(0)?.main?.tempMin.let { it?.let { it1 -> Util.setFormatTemperature(it1) } } + " - " + item?.list?.get(0)?.main?.tempMax.let { it?.let { it1 -> Util.setFormatTemperature(it1) } }
                text_desc.text = item?.list?.get(0)?.weather?.get(0)?.description.toString()
                item?.list?.get(0)?.weather?.get(0)?.id?.let { Util.getArtResourceForWeatherCondition(it) }?.let { image_desc.setImageResource(it) }

                var list = item?.list
                var itemAdp = ItemAdapter(list as List<ListItem>)

                recycler_view_container.apply {
                    layoutManager = LinearLayoutManager(this@Cuaca)
                    adapter = itemAdp
                }
            }

            override fun onFailure(call: retrofit2.Call<Response>, t: Throwable) {
                Log.d("error response service", t.message.toString())

                Toast.makeText(applicationContext, t.message.toString(), Toast.LENGTH_LONG).show()
            }
        })

    }

    fun run(url: String){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: okhttp3.Response) = println(response.body?.string())
        })
    }
}