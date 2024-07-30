package com.example.retrofit2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.retrofit2.Retro.RetroInterface
import com.example.retrofit2.Retro.RetroModel
import com.example.retrofit2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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
        val retrofit:RetroInterface=Retrofit.Builder()
            .baseUrl("https://viacep.com.br/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetroInterface::class.java)

        binding.buttonBusca.setOnClickListener {
            val cep = binding.editCep.text.toString()
            val resposta =retrofit.getData(cep)
            resposta.enqueue(object : Callback<RetroModel>{
                    override fun onResponse(call: Call<RetroModel>,response: Response<RetroModel>) {
                        if (response.isSuccessful){
                            Toast.makeText(applicationContext,"Funfo",Toast.LENGTH_SHORT).show()
                            binding.textLogradouro.text = response.body()?.logradouro.toString()
                            binding.textBairro.text = response.body()?.bairro.toString()
                            binding.textUf.text = response.body()?.uf.toString()
                            binding.textLocalidade.text= response.body()?.localidade

                        }
                    }

                    override fun onFailure(call: Call<RetroModel>, t: Throwable) {
                        Toast.makeText(applicationContext,"Nao",Toast.LENGTH_SHORT).show()
                    }


                }
            )

        }
    }

}


