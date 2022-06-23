package com.confidenceb.noteappwithkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_notes_list.*

class NotesList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes_list)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
           val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }

        listsOfNotes.adapter = ArrayAdapter(this,
        android.R.layout.simple_list_item_1,
        DataManager.notes)

        listsOfNotes.setOnItemClickListener{parent, view, position, id ->
            val activityIntent = Intent(this, MainActivity::class.java)
            activityIntent.putExtra(NOTE_POSITION, position)
            startActivity(activityIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        (listsOfNotes.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
    }
}