package com.example.myapplication

import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class FirstPresenter(val model: CountersModel, val router: Router, val screens: IScreens) :
    MvpPresenter<FirstView>() {

    fun saveData (login: String, password: String){
        model.login=login
        model.password=password
        openGreeting()
    }

    private fun openGreeting() {
        router.replaceScreen(screens.show())
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}