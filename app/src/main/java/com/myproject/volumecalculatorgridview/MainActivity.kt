package com.myproject.volumecalculatorgridview

import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView.Adapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val gridview:GridView = findViewById(R.id.gridViewItem)

        val listItem:List<Shape> = listOf(
            Shape(R.drawable.cube,"Cube"),
            Shape(R.drawable.cylinder,"Cylinder"),
            Shape(R.drawable.prism,"Prism"),
            Shape(R.drawable.sphere,"Sphere")

        )

        gridview.adapter = MyCostumList(this,listItem)
    }
}