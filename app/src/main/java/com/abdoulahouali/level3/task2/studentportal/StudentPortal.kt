package com.abdoulahouali.level3.task2.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StudentPortal(var title: String, var url: String) : Parcelable