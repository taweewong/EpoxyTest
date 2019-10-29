package com.taweewong.epoxypoc.model.user

import android.os.Parcelable
import com.taweewong.epoxypoc.model.UserBase
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var firstName: String,
    var lastName: String,
    var displayName: String
) : UserBase(), Parcelable