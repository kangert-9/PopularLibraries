package com.example.myapplication

import android.util.Log
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class SecondPresenter(val model: CountersModel, val router: Router, val screens: IScreens) :
    MvpPresenter<SecondView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Log.d("tag", model.login.toString())
        viewState.showGreeting("login")
    }

    fun backPressed(): Boolean {
        router.backTo(screens.users())
        return true
    }
}