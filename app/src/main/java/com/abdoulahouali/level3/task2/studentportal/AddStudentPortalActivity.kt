package com.abdoulahouali.level3.task2.studentportal

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_portal.*
import kotlinx.android.synthetic.main.activity_main.*

class AddStudentPortalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_portal)

        initializeViews()
    }

    override fun onSupportNavigateUp(): Boolean {
        startActivity(Intent(this, MainActivity::class.java))
        return true
    }

    private fun initializeViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.add_portal_name)
        add_card_btn.setOnClickListener { onPortalCreation() }
    }

    private fun onPortalCreation() {
        val portal = StudentPortal(add_title_et.text.toString(), add_url_et.text.toString())
        val portals = intent.getParcelableArrayListExtra<StudentPortal>(INITIAL_STUDENT_PORTALS)

        val addedPortalActivityIntent = Intent(this, MainActivity::class.java)
        addedPortalActivityIntent.putExtra(NEW_STUDENT_PORTAL, portal)
        addedPortalActivityIntent.putExtra(INITIAL_STUDENT_PORTALS, portals)
        startActivity(addedPortalActivityIntent)
    }
}