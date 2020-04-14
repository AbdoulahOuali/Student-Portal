package com.abdoulahouali.level3.task2.studentportal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

const val NEW_STUDENT_PORTAL = "NEW_STUDENT_PORTAL"
const val INITIAL_STUDENT_PORTALS = "INITIAL_STUDENT_PORTALS"
private const val SPAN_COUNT = 2

class MainActivity : AppCompatActivity() {

    private var studentPortals = arrayListOf<StudentPortal>()
    private lateinit var studentPortalAdapter: StudentPortalAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        populateInitialDataSet()

        fab.setOnClickListener {
            val addStudentPortalIntent = Intent(this, AddStudentPortalActivity::class.java).apply {
                putExtra(INITIAL_STUDENT_PORTALS, studentPortals)
            }
            startActivity(addStudentPortalIntent)
        }

        initializeViews()
    }

    private fun initializeViews() {
        val listOfStudentPortals = intent.getParcelableArrayListExtra<StudentPortal>(INITIAL_STUDENT_PORTALS)
        val newStudentPortal = intent.getParcelableExtra<StudentPortal>(NEW_STUDENT_PORTAL)

        if (listOfStudentPortals != null) {
            this.studentPortals = listOfStudentPortals
            if (newStudentPortal != null) {
                this.studentPortals.add(newStudentPortal)
                println(newStudentPortal.title)
                println(newStudentPortal.url)
            }
        }

        studentPortalAdapter = StudentPortalAdapter(this.studentPortals)

        portal_recycler_view.layoutManager =
            GridLayoutManager(this@MainActivity, SPAN_COUNT, GridLayoutManager.VERTICAL, false)

        portal_recycler_view.adapter = studentPortalAdapter
    }

    private fun populateInitialDataSet() {
        studentPortals.add(
            StudentPortal(
                getString(R.string.title_1_tv),
                getString(R.string.url_1_tv)
            )
        )
        studentPortals.add(
            StudentPortal(
                getString(R.string.title_2_tv),
                getString(R.string.url_2_tv)
            )
        )
        studentPortals.add(
            StudentPortal(
                getString(R.string.title_3_tv),
                getString(R.string.url_3_tv)
            )
        )
        studentPortals.add(
            StudentPortal(
                getString(R.string.title_4_tv),
                getString(R.string.url_4_tv)
            )
        )
    }
}
