package com.confidenceb.noteappwithkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var noteposition = POSITION_NOT_SET

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar1))


        val coursesAdapter = ArrayAdapter<CourseInfo>(this,
                android.R.layout.simple_spinner_item,
                DataManager.courses.values.toList())
        coursesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerCourses.adapter = coursesAdapter

        noteposition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)
        if(noteposition != POSITION_NOT_SET)
            displayNote()
    }

    private fun displayNote() {
        val note = DataManager.notes[noteposition]
        textNoteTitle.setText(note.title )
        textNoteTitle.setText(note.text)

        val selectedCoursePositn = DataManager.courses.values.indexOf(note.course)
        spinnerCourses.setSelection(selectedCoursePositn)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.next_action -> {
                goToNextNote()
                true
            }
            R.id.back_action -> {
                backToNotes()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun goToNextNote() {
        ++noteposition
        displayNote()
        invalidateOptionsMenu()
    }

    private fun backToNotes() {
        val goBack = Intent(this, NotesList::class.java)
        startActivity(goBack)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if(noteposition >= DataManager.notes.lastIndex) {
            val menuItem = menu?.findItem(R.id.next_action)
            if(menuItem != null){
                menuItem.icon = getDrawable(R.drawable.ic_block)
                menuItem.isEnabled = false
            }
        }
        return super.onPrepareOptionsMenu(menu)
    }
}