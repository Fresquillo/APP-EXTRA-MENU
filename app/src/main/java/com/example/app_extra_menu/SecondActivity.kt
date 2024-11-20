package com.example.app_extra_menu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Declaración de las variables globales
lateinit var bt1Act: AppCompatButton


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Función para vincular los elementos de la interfaz de usuario
    fun vincular() {
        bt1Act = findViewById(R.id.bt1Act)
    }

    // Función para inicializar el listeners del botón
    fun initListeners(): WindowInsetsCompat {
        bt1Act.setOnClickListener {
            finish()
        }
        return WindowInsetsCompat.CONSUMED
    }

    // Función para volver a la actividad anterior
    override fun onResume() {
        super.onResume()
        vincular()
        initListeners()
    }
}