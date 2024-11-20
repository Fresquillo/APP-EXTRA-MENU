package com.example.app_extra_menu

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

// Declaración de las variables globales
lateinit var bt1: AppCompatButton
lateinit var bt2: AppCompatButton
lateinit var bt3: AppCompatButton
lateinit var bt4: AppCompatButton
lateinit var bt5: AppCompatButton
lateinit var txtOculto: TextView

class Botones : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_botones)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

            vincular()
            initListeners()

        }
    }

    // Función para vincular los elementos de la interfaz de usuario
    fun vincular(){
        bt1 = findViewById(R.id.bt1)
        bt2 = findViewById(R.id.bt2)
        bt3 = findViewById(R.id.bt3)
        bt4 = findViewById(R.id.bt4)
        bt5 = findViewById(R.id.bt5)
        txtOculto = findViewById(R.id.txtOculto)
    }



    // Función para inicializar los listeners de los botones
    fun initListeners(): WindowInsetsCompat {

        // Botón 1: Navegar a la segunda actividad
        bt1.setOnClickListener {
            navigateToSecondActivity()

        }
        // Botón 2: Mostrar un Toast
        bt2.setOnClickListener {
            Toast.makeText(this, "Me gusta mi Toast básico", Toast.LENGTH_SHORT).show()
        }

        // Botón 3: Mostrar un Snackbar
        bt3.setOnClickListener {
            Snackbar.make(findViewById(R.id.main), "Me gusta mi Snackbar", Snackbar.LENGTH_LONG).show()
        }

        // Botón 4: Cerrar la aplicación
        bt4.setOnClickListener {
            finishAffinity()
        }

        // Botón 5: Cambiar el texto del TextView
        bt5.setOnClickListener {
            if (txtOculto.text.toString() == ""){
                txtOculto.text = "Increíble, ¿eh?"
            }else{
                txtOculto.text = ""
            }

        }

        return WindowInsetsCompat.CONSUMED
    }

    // Función que permite la navegación a la segunda actividad
    fun navigateToSecondActivity(){
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}