package com.example.recyclerviewexample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rcMain: RecyclerView
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var lista: ArrayList<Example>
    val FORM = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = ArrayList()
        this.rcMain = findViewById(R.id.rcMain)
        this.fabAdd = findViewById(R.id.fabMainAdd)
        rcMain.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rcMain.adapter = RecyclerAdapter(lista)
        this.fabAdd.setOnClickListener { add(it) }
    }

    private fun add(view: View) {
        val it = Intent(this@MainActivity, FormActivity::class.java)
        startActivityForResult(it, FORM)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK && requestCode == FORM) {
            val example = data?.getSerializableExtra("EXAMPLE") as Example
            this.lista.add(example)
            (this.rcMain.adapter as RecyclerAdapter).notifyDataSetChanged()
        }
    }
}