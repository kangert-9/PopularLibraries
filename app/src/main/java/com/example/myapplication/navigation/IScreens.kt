package com.example.myapplication.navigation

import com.example.myapplication.data.CountersModel
import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun show(model: CountersModel): Screen
}