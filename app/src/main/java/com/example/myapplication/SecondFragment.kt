package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentSecondBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class SecondFragment : MvpAppCompatFragment(), SecondView, BackButtonListener {
    companion object {
        fun newInstance() = SecondFragment()
    }
    val presenter: SecondPresenter by moxyPresenter {
        SecondPresenter(CountersModel(), App.instance.router, AndroidScreens()) }
    private var vb: FragmentSecondBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
        FragmentSecondBinding.inflate(inflater, container, false).also {
            vb = it
        }.root
    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = presenter.backPressed()

    override fun showGreeting(login: String) {
        vb?.greeting?.text = "login"
    }
}