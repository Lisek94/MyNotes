package com.example.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataBaseHelper = DataBaseHelper(applicationContext)
        val db = dataBaseHelper.writableDatabase
    }

    fun onClickTakeNotes(v: View) {
        val intent = Intent(applicationContext, DetailsActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        val dataBaseHelper = DataBaseHelper(applicationContext)
        val db = dataBaseHelper.writableDatabase

        recyler_view.layoutManager = GridLayoutManager(applicationContext, 2)
        recyler_view.adapter = CardViewAdapter(applicationContext,db)
    }

}
