package com.example.recyclerviewexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var btnCancelar: Button
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etNome = findViewById(R.id.etAddNome)
        this.btnCancelar = findViewById(R.id.btnAddCancelar)
        this.btnSalvar = findViewById(R.id.btnAddSalvar)

        this.btnCancelar.setOnClickListener { cancelar(it) }
        this.btnSalvar.setOnClickListener { salvar(it) }
    }

    private fun cancelar(view: View) {
        finish()
    }

    private fun salvar(view: View) {
        val nome = this.etNome.text.toString()

        val example  = Example(nome)

        val it = Intent()
        it.putExtra("EXAMPLE", example)
        setResult(Activity.RESULT_OK, it)

        finish()
    }
}