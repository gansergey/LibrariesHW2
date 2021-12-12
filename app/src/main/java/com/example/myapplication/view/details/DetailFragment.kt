package com.example.myapplication.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.myapplication.databinding.FragmentDetailsBinding
import com.example.myapplication.model.GithubUser
import com.example.myapplication.model.GithubUsersRepo
import com.example.myapplication.presenter.DetailPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class DetailFragment : MvpAppCompatFragment(), DetailsView {

    companion object {

        private const val ARG_USER = "arg_user"

        fun newInstance(userLogin: String): DetailFragment {
            return DetailFragment().apply {
                arguments = bundleOf(ARG_USER to userLogin)
            }
        }
    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER).orEmpty()
    }

    val presenter: DetailPresenter by moxyPresenter {
        DetailPresenter(userLogin, GithubUsersRepo())
    }

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun showUser(user: GithubUser) {
        binding.loginUser.text = user.login
    }
}