package com.example.myapplication.second

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.data.CountersModel
import com.example.myapplication.databinding.FragmentSecondBinding
import com.example.myapplication.navigation.AndroidScreens
import com.example.myapplication.navigation.App
import com.example.myapplication.navigation.BackButtonListener
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter


class SecondFragment : MvpAppCompatFragment(), SecondView, BackButtonListener {
    private val ARG_INDEX = "PARAM_MODEL"
    private lateinit var model: CountersModel

        fun newInstance(model: CountersModel) : Fragment{
            val f = SecondFragment()
            val args = Bundle()
            args.putParcelable(ARG_INDEX, model as Parcelable?)
            f.arguments = args
            return f
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            model = requireArguments().getParcelable(ARG_INDEX)!!
            presenter.model = model
        }
    }

    private val presenter: SecondPresenter by moxyPresenter {
        SecondPresenter(CountersModel("",""), App.instance.router, AndroidScreens()) }
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
        vb?.greeting?.text = "Добрый день, ${login}"
    }
}