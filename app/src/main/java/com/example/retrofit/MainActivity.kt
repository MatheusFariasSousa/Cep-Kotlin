package com.example.retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.retrofit.Retro.RetroModel
import com.example.retrofit.Retro.RetrofitInstance
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val retrofit = RetrofitInstance.getInstance()
        binding.button.setOnClickListener {
            retrofit.getData().enqueue(object  : Callback<RetroModel>{
                override fun onResponse(call: Call<RetroModel>, response: Response<RetroModel>) {
                    if (response.isSuccessful){
                        Toast.makeText(applicationContext,"funfo",Toast.LENGTH_SHORT).show()
                    }
                    binding.textView.text = response.body()?.cep.toString()


                }

                override fun onFailure(call: Call<RetroModel>, t: Throwable) {
                    Toast.makeText(applicationContext,"n funfo",Toast.LENGTH_SHORT).show()
                }
            }
            )

        }
    }
}