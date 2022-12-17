package com.example.galleryapp.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.galleryapp.R
import com.example.galleryapp.databinding.FragmentLoginBinding
import com.example.galleryapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.message.observe(viewLifecycleOwner) {
            showMessage(it)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            showProgress(it)
        }

        viewModel.errorMessage.observe(viewLifecycleOwner) {
            when (it.first) {
                LoginViewModel.EnumUiFields.FIELD_EMAIL -> {
                    binding.emailInputLayout.error = it.second
                }
                LoginViewModel.EnumUiFields.FIELD_PASSWORD -> {
                    binding.passwordInputLayout.error = it.second
                }
            }
        }

        viewModel.navigate.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        binding.accountHintTv.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }

        binding.loginBtn.setOnClickListener {
            viewModel.login(
                binding.emailEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }
    }

}