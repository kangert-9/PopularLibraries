package com.example.myapplication

import com.github.terrakok.cicerone.Screen

interface IScreens {
    fun users(): Screen
    fun show(model: CountersModel): Screen
}