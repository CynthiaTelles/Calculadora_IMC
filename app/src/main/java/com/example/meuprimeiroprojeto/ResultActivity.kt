package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        hideActionBar()


        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text= result.toString().substring(0..4)

        val classificacao = if (result < 18.5f){
            "Abaixo do peso"
        }else if (result in 18.5f..24.9f){
            "Normal"
        }else if (result in 25f..29.9f){
            "Sobrepeso"
        }else if (result in 30f..35.9f){
            "Obesidade"
        }else {
            "Obesidade Grave"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    private fun hideActionBar() {
        supportActionBar?.hide()
    }


}
