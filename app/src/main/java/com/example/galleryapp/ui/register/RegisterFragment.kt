package com.example.galleryapp.ui.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.galleryapp.R
import com.example.galleryapp.databinding.FragmentRegisterBinding
import com.example.galleryapp.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterFragment : BaseFragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
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
                RegisterViewModel.EnumUiFields.FIELD_EMAIL -> {
                    binding.emailInputLayout.error = it.second
                }
                RegisterViewModel.EnumUiFields.FIELD_AGE -> {
                    binding.ageInputLayout.error = it.second
                }
                RegisterViewModel.EnumUiFields.FIELD_PASSWORD -> {
                    binding.passwordInputLayout.error = it.second
                }
            }
        }

        viewModel.navigate.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_registerFragment_to_homeFragment)
        }

        binding.signUpBtn.setOnClickListener {
            viewModel.signUp(
                binding.emailEditText.text.toString(),
                binding.ageEditText.text.toString(),
                binding.passwordEditText.text.toString()
            )
        }

    }

}