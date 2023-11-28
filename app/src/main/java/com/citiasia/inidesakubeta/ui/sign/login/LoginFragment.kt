package com.citiasia.inidesakubeta.ui.sign.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.LoginResponse
import com.citiasia.inidesakubeta.data.repo.Resource
import com.citiasia.inidesakubeta.databinding.FragmentLoginBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import kotlin.properties.Delegates

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: LoginViewModel

    private var emailErrorData by Delegates.notNull<Boolean>()
    private var passwordErrorData by Delegates.notNull<Boolean>()

    init {
        emailErrorData = true
        passwordErrorData = true
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vmFactory = ViewModelFactory(requireContext())
        viewModel = ViewModelProvider(
            requireActivity(),
            vmFactory
        ).get(LoginViewModel::class.java)

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().popBackStack()
        }

//        observeData()
        buttonCLick()
        textListener()
    }

    private fun observeData() {
        with(viewModel) {

        }
    }

    private fun textListener() {
        with(binding) {
            textEmail.addTextChangedListener(object : TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    emailErrorData =  !Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()
                }

                override fun afterTextChanged(s: Editable?) {
                    btnLogin.isEnabled = !(emailErrorData || passwordErrorData)
                }

            })

            textPassword.addTextChangedListener(object: TextWatcher{
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    passwordErrorData = s.toString().length < 6
                }

                override fun afterTextChanged(s: Editable?) {
                    btnLogin.isEnabled = !(emailErrorData || passwordErrorData)

                }

            })
        }
    }

    private fun buttonCLick() {
        with(binding) {

            btnLogin.setOnClickListener {
                var email = textEmail.text.toString()
                var password = textPassword.text.toString()

//                loginHandler(email, password)
                findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
            }

            btnLoginPhone.setOnClickListener{
                Toast.makeText(requireContext(),"Masih tahap pengembangan", Toast.LENGTH_SHORT).show()
            }

            btnGoogleLogin.setOnClickListener{
                Toast.makeText(requireContext(),"Masih tahap pengembangan", Toast.LENGTH_SHORT).show()
            }

            btnDaftar.setOnClickListener {
                // handle ketika halaman sebelumnya sudah halaman daftar
                //
                findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
            }

            btnTamu.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_pilihWilayahFragment)
            }
        }
    }

    private fun loginHandler(email: String, password: String) {
        viewModel.login(
            email,
            password
        ).observe(requireActivity()) {
            if (it != null) {
                when(it) {
                    is Resource.Loading -> {
//                        showLoading(true)
                        Toast.makeText(requireContext(), "INI MASIH LOADING...", Toast.LENGTH_SHORT).show()
                    }
                    is Resource.Success -> {
//                        showLoading(false)
                        succesHandler(it.data)
                    }
                    is Resource.Error -> {
//                        showLoading(false)
//                        errorHandler(it.data)
                        Toast.makeText(requireContext(), it.data, Toast.LENGTH_SHORT).show()
                    }
                    else -> {}
                }
            }
        }
    }

    private fun succesHandler(data: LoginResponse) {
        //save data login to preference
//        LoginPreference(requireContext()).saveLogin(data)

        Toast.makeText(requireContext(), data.message, Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
        requireActivity().finish()

        binding.apply {
            textEmail.text = null
            textPassword.text = null
        }
    }

}