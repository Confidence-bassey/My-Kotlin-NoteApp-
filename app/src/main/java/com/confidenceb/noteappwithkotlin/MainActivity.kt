package com.confidenceb.noteappwithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var noteposition = POSITION_NOT_SET

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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
}