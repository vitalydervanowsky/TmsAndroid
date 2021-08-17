package com.example.tmsandroid.dz.dz21

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.example.tmsandroid.R
import com.example.tmsandroid.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            bLogin.setOnClickListener {
                val email = eEmail.text.toString()
                val password = ePassword.text.toString()
                login(email, password)
            }

            eEmail.doOnTextChanged { _, _, _, _ ->
                tvEmail.error = null
            }

            ePassword.doOnTextChanged { _, _, _, _ ->
                tvPassword.error = null
            }
        }
    }

    private fun login(email: String, password: String) {
        if (email == "1" && password == "1")
            openMenu()
        else {
            showError()
        }
    }

    private fun openMenu() {
        Toast.makeText(context, getString(R.string.logging_in), Toast.LENGTH_SHORT).show()
    }

    private fun showError() {
        binding.tvEmail.error = getString(R.string.email_password_error)
        binding.tvPassword.error = getString(R.string.email_password_error)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}