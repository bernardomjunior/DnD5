package com.example.dd5th.data.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Cost (
    val quantity: Int,
    val unit: String
): Parcelable