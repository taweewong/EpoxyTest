package com.taweewong.epoxypoc.model.header

import android.os.Parcelable
import com.taweewong.epoxypoc.model.UserBase
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserHeader(
    var title: String
) : UserBase(), Parcelable