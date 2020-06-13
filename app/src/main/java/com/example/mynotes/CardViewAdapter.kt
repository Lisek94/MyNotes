package com.example.mynotes

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_view.view.*


class CardViewAdapter( val context: Context, val db: SQLiteDatabase): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cardViewNote = layoutInflater.inflate(R.layout.card_view,parent,false)
        return MyViewHolder(cardViewNote)
    }

    override fun getItemCount(): Int {
        val cursor = db.query(TableInfo.TABLE_NAME,null,null, null,
            null,null,null)


        return cursor.count
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val cardViewNote = holder.view.note_cardView
        val title = holder.view.title_cardView
        val message = holder.view.message_cardView

        val cursor = db.query(TableInfo.TABLE_NAME,null,BaseColumns._ID + "=?",
            arrayOf(holder.adapterPosition.plus(1).toString()),
        null,null,null)

        if(cursor.moveToFirst()) {
            if (!cursor.getString(1).isNullOrEmpty() || !cursor.getString(2).isNullOrEmpty()){
                title.text = cursor.getString(1)
                message.text = cursor.getString(2)
            }
        }
    }

}


class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view)