package com.example.myapplication.navigation

import com.example.myapplication.data.CountersModel
import com.example.myapplication.first.FirstFragment
import com.example.myapplication.second.SecondFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AndroidScreens : IScreens {
    override fun users() = FragmentScreen { FirstFragment.newInstance() }
    override fun show(model: CountersModel) = FragmentScreen { SecondFragment().newInstance(model) }
}