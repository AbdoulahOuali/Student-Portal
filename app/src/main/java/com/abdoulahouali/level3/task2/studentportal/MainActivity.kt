package com.abdoulahouali.level3.task2.studentportal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private val studentPortals = arrayListOf<StudentPortal>()
    private val studentPortalAdapter =
        StudentPortalAdapter(
            studentPortals
        )
    private val spanCount = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        populateInitialDataSet()
        initViews()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun initViews() {
        portal_recycler_view.layoutManager =
            GridLayoutManager(this@MainActivity, spanCount, GridLayoutManager.VERTICAL, false)

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
