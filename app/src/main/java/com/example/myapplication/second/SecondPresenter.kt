package com.example.myapplication.second

import com.example.myapplication.data.CountersModel
import com.example.myapplication.navigation.IScreens
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class SecondPresenter(var model: CountersModel, val router: Router, val screens: IScreens) :
    MvpPresenter<SecondView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showGreeting(model.login.toString())
    }

    fun backPressed(): Boolean {
        router.backTo(screens.users())
        return true
    }
}