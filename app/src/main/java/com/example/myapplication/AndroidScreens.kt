package com.example.myapplication

import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { FirstFragment.newInstance() }
    override fun show(model: CountersModel) = FragmentScreen { SecondFragment().newInstance(model) }
}