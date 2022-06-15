package com.confidenceb.noteappwithkotlin

import java.util.*

class DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
    }

    private fun initializeCourses(){
        var course = CourseInfo("android_intent", "Android Programming with Intents")
        courses.put(course.courseId, course)

         course = CourseInfo("kotlin_android", "Android Programming with Kotlin")
        courses.put(course.courseId, course)

         course = CourseInfo("android_java", "Android Programming with Java")
        courses.put(course.courseId, course)
    }
}