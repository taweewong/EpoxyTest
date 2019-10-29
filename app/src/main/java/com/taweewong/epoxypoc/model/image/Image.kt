package com.taweewong.epoxypoc.model.image

import android.os.Parcelable
import com.taweewong.epoxypoc.model.UserBase
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    var id: Int,
    var title: String,
    var path: String
) : UserBase(), Parcelable