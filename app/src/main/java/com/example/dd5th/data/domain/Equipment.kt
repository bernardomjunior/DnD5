package com.example.dd5th.data.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Equipment (
    val index: String,
    val name: String,
    val equipmentCategory: String,
    val gearCategory: String,
    val cost: Cost,
    val weight: Int
): Parcelable