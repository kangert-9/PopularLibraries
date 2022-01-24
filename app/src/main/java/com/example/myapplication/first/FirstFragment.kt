package com.example.myapplication.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.example.myapplication.data.CountersModel
import com.example.myapplication.data.RepositoryFactory
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.navigation.AndroidScreens
import com.example.myapplication.navigation.App
import com.example.myapplication.navigation.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class FirstFragment : MvpAppCompatFragment(), FirstView, BackButtonListener {
    companion object {
        fun newInstance() = FirstFragment()
    }
    private val presenter: FirstPresenter by moxyPresenter {
        FirstPresenter(CountersModel("",""), App.instance.router, AndroidScreens(), RepositoryFactory.create()) }
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

    override fun setData(login: String?, password: String?) {
        presenter.saveData(login, password)
    }

    override fun showErrorMessage() {
        Toast.makeText(requireContext(), "Введите данные", LENGTH_SHORT).show()
    }

}