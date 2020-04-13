package com.abdoulahouali.level3.task2.studentportal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.student_portal_grid_item.view.*

class StudentPortalAdapter(private val studentPortalList: List<StudentPortal>) :
    RecyclerView.Adapter<StudentPortalAdapter.PortalViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PortalViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.student_portal_grid_item,
            parent, false
        )

        return PortalViewHolder(
            itemView
        )
    }

    override fun onBindViewHolder(holder: PortalViewHolder, position: Int) {
        val currentStudentPortal = studentPortalList[position]

        holder.titleTextView.text = currentStudentPortal.name
        holder.urlTextView.text = currentStudentPortal.url

    }

    override fun getItemCount() = studentPortalList.size

    class PortalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTextView: TextView = itemView.title_tv
        val urlTextView: TextView = itemView.url_tv
    }
}
