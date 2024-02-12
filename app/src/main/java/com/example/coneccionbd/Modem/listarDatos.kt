package com.example.coneccionbd.Modem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.coneccionbd.R
import com.example.coneccionbd.databinding.ActivityListarDatosBinding

class listarDatos : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_datos)

        val manager = ManangerDb(this)
        val arrayCiudad = manager.getData()

        val listView: ListView = findViewById(R.id.getData)
        val arrayAdapter = ArrayAdapter<Ciudad>(this, android.R.layout.simple_list_item_1, arrayCiudad)

        listView.adapter = arrayAdapter

        Toast.makeText(this, "Datos listados", Toast.LENGTH_SHORT).show()
    }
}