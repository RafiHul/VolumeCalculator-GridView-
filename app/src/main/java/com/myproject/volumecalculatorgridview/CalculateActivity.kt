package com.myproject.volumecalculatorgridview

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isGone

class CalculateActivity : AppCompatActivity() {

    private lateinit var editTextInputCalculate:EditText
    private lateinit var editTextInputCalculate2:EditText
    private lateinit var textViewHasil:TextView
    private lateinit var imageViewGambar:ImageView
    private lateinit var buttonHitung:Button

    private fun calculate(a:Int,b:Int = 0,jen:String?){
        when (jen){
            "Cube" -> textViewHasil.text = "${a.toDouble() * a * a}"
            "Cylinder" -> textViewHasil.text = "${Math.PI * a * a * b}"
            "Prism" -> textViewHasil.text = "${a * b}"
            "Sphere" -> textViewHasil.text = "${(4.0/3.0) * Math.PI * a * a *a }"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculate)
        val gambar = intent.getIntExtra("Gambarnya",0)
        val jenis = intent.getStringExtra("Jenis")

        editTextInputCalculate = findViewById(R.id.editTextInputCalculate)
        editTextInputCalculate2 = findViewById(R.id.editTextInputCalculate2)
        textViewHasil = findViewById(R.id.textViewHasil)
        imageViewGambar = findViewById(R.id.imageViewGambar)
        buttonHitung = findViewById(R.id.buttonHitung)

        textViewHasil.text = jenis
        imageViewGambar.setImageResource(gambar)

        if (jenis == "Cube"){
            editTextInputCalculate.hint = "Masukkan Radius"
            editTextInputCalculate2.visibility = View.GONE
        } else if (jenis == "Cylinder"){
            editTextInputCalculate.hint = "Masukkan Radius"
            editTextInputCalculate2.hint = "Masukkan Height"
        }else if (jenis == "Prism"){
            editTextInputCalculate.hint = "Masukkan BaseArea"
            editTextInputCalculate2.hint = "Masukkan Height"
        }else if (jenis == "Sphere"){
            editTextInputCalculate.hint = "Masukkan Radius"
            editTextInputCalculate2.visibility = View.GONE
        }

        buttonHitung.setOnClickListener{
            val num = editTextInputCalculate.text.toString()
            val num2 = editTextInputCalculate2.text.toString()
            if (num.isNotEmpty()){
                calculate(num.toInt(),if (num2.length == 0) 0 else num2.toInt(), jenis)
            } else {
                Toast.makeText(this, "Tidak Boleh Kosong", Toast.LENGTH_SHORT).show()
            }
        }
    }
}