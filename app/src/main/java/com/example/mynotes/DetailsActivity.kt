package com.example.mynotes

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val dBHelper = DataBaseHelper(applicationContext)
        val db = dBHelper.writableDatabase
        val saveInfo = Toast.makeText(applicationContext, "Notatka zapisana", Toast.LENGTH_SHORT)

        save_BT_details.setOnClickListener{
            val title = title_details.text.toString()
            val message = message_details.text.toString()

            if (!title.isNullOrEmpty() || !message.isNullOrEmpty())
            {
                val value = ContentValues()
                value.put("title", title)
                value.put("message", message)

                db.insertOrThrow(TableInfo.TABLE_NAME,null,value)
                saveInfo.show()
            } else
            {
                Toast.makeText(applicationContext,"Brak danych do zapisu",Toast.LENGTH_SHORT).show()
            }

        }
    }
}
