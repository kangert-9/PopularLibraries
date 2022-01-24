package com.example.myapplication.first

import com.example.myapplication.navigation.IScreens
import com.example.myapplication.data.CountersModel
import com.example.myapplication.data.UserRepository
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class FirstPresenter(val model: CountersModel, val router: Router, val screens: IScreens, private val userRepository: UserRepository) :
    MvpPresenter<FirstView>() {

    fun saveData (login: String?, password: String?){
        if(login==null||password==null){
            viewState.showErrorMessage()
        } else{
            model.login=login
            model.password=password
            openGreeting(model)
        }
    }

    private fun openGreeting(model: CountersModel) {
        router.navigateTo(screens.show(model))
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}