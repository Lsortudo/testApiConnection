package com.example.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.model.Response
import com.example.apiproject.network.Api
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var manager: RecyclerView.LayoutManager
    private lateinit var packageAdapter: RecyclerView.Adapter<*>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = LinearLayoutManager(this)
        getAllData()
    }
    fun getAllData(){
        Api.retrofitService.getAllData().enqueue(object: Callback<List<Response>> {
            override fun onResponse(
                call: Call<List<Response>>,
                response: retrofit2.Response<List<Response>>
            ) {
                if(response.isSuccessful) {
                    recyclerView = findViewById<RecyclerView>(R.id.recycler_view).apply {
                        packageAdapter = PackageAdapter(response.body()!!)
                        layoutManager = manager
                        adapter = packageAdapter
                    }
                }


            }

            override fun onFailure(call: Call<List<Response>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

}