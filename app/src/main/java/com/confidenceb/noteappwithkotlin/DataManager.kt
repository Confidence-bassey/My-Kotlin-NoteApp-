package com.confidenceb.noteappwithkotlin

import java.util.*

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses(){
        var course = CourseInfo("android_intent", "Android Programming with Intents")
        courses.set(course.courseId, course)

         course = CourseInfo("kotlin_android", "Android Programming with Kotlin")
        courses.set(course.courseId, course)

         course = CourseInfo("android_java", "Android Programming with Java")
        courses.set(course.courseId, course)
    }

    private fun initializeNotes(){
            var course = courses["android_intent"]!!
            var note = NoteInfo(course, "Android Programming with Intents",
                    "Wow, intents allow components to be resolved at runtime")
            notes.add(note)
            note = NoteInfo(course, "Delegating intents",
                    "PendingIntents are powerful; they delegate much more than just a component invocation")
            notes.add(note)

            course = courses["kotlin_android"]!!
            note = NoteInfo(course, "Programming",
                    "Did you know that by default an Android Service will tie up the UI thread?")
            notes.add(note)
            note = NoteInfo(course, "Long running operations",
                    "Foreground Services can be tied to a notification icon")
            notes.add(note)

            course = courses["android_java"]!!
            note = NoteInfo(course, "Android Programming with Java",
                    "Leverage variable-length parameter lists")
            notes.add(note)
            note = NoteInfo(course, "Anonymous classes",
                    "Anonymous classes simplify implementing one-use types")
            notes.add(note)

           /* course = courses["java_core"]!!
            note = NoteInfo(course, "Compiler options",
                    "The -jar option isn't compatible with with the -cp option")
            notes.add(note)
            note = NoteInfo(course, "Serialization",
                    "Remember to include SerialVersionUID to assure version compatibility")
            notes.add(note)  */
    }
}