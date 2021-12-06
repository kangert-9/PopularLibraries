package com.example.myapplication


class MainPresenter(val view: MainView) {
    val model = CountersModel()

  fun counterOneClick(index: Int) {
    val nextValue = model.next(index)
    view.setButtonText(index, nextValue.toString())
}
}