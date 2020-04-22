package com.example.dd5th.data.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Equipment (
    val index: String,
    val name: String,
    @SerializedName("equipment_category")
    val equipmentCategory: String,
    @SerializedName("gear_category")
    val gearCategory: String,
    val cost: Cost,
    val weight: Int
): Parcelable