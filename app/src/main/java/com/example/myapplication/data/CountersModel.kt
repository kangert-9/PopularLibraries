package com.example.myapplication.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class CountersModel (var login: String?, var password: String?): Parcelable
