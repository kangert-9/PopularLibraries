package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentFirstBinding
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class FirstFragment : MvpAppCompatFragment(), FirstView, BackButtonListener  {
    companion object {
        fun newInstance() = FirstFragment()
    }
    val presenter: FirstPresenter by moxyPresenter {
        FirstPresenter(CountersModel(), App.instance.router, AndroidScreens()) }
    private var vb: FragmentFirstBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
        FragmentFirstBinding.inflate(inflater, container, false).also {
            vb = it
            vb?.button?.setOnClickListener {
                setData(vb?.loginText?.text.toString(), vb?.passwordText?.text.toString())
            }
        }.root
    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed() = presenter.backPressed()

    override fun setData(login: String, password: String) {
        presenter.saveData(login, password)
    }

    override fun showGreeting() {
        TODO("Not yet implemented")
    }
}