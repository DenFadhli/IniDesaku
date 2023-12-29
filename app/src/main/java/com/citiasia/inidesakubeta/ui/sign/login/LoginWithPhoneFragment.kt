package com.citiasia.inidesakubeta.ui.sign.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.LoginData
import com.citiasia.inidesakubeta.databinding.FragmentLoginBinding
import com.citiasia.inidesakubeta.databinding.FragmentLoginWithPhoneBinding
import com.citiasia.inidesakubeta.ui.ViewModelFactory
import com.citiasia.inidesakubeta.ui.ViewModelFactorySign
import com.citiasia.inidesakubeta.ui.tvcc.tvccHome.TvccFrontFragment
import com.citiasia.inidesakubeta.utils.LoginPreference
import kotlin.properties.Delegates

class LoginWithPhoneFragment : Fragment() {
    private var _binding: FragmentLoginWithPhoneBinding? = null
    private val binding get() = _binding!!

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var pref: LoginPreference

    private var usernameErrorData by Delegates.notNull<Boolean>()
    private var passwordErrorData by Delegates.notNull<Boolean>()

    init {
        usernameErrorData = true
        passwordErrorData = true
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginWithPhoneBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vmFactory = ViewModelFactorySign.getInstance(requireActivity().application)
        loginViewModel = ViewModelProvider(
            requireActivity(),
            vmFactory
        )[LoginViewModel::class.java]

        pref = LoginPreference(requireContext())

        binding.btnTamu.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginWithPhoneFragment_to_pilihWilayahFragment
            )
        }

        binding.btnEmailPhone.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginWithPhoneFragment_to_loginFragment
            )
        }

        binding.btnDaftar.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginWithPhoneFragment_to_signUpFragment
            )
        }
        textListener()
        buttonCLick()
    }

    private fun textListener() {
        with(binding) {
            textUsername.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    usernameErrorData = s.toString().trim().length >= 13  || textUsername.text.toString().trim().isEmpty() || !textUsername.text.toString().trim().startsWith("8")
                    if (textUsername.toString().trim().isNullOrEmpty()) {
                        binding.phoneNumberError.text = getString(R.string.format_phone_emtpy)
                        binding.phoneNumberError.alpha = 1F
                    } else {
                        binding.phoneNumberError.alpha = 0F
                    }
                    if (textUsername.text.toString().trim().length >= 13 || !textUsername.text.toString().trim().startsWith("8")) {
                        binding.phoneNumberError.alpha = 1F
                    } else {
                        binding.phoneNumberError.alpha = 0F
                    }
                    btnLogin.isEnabled = !(usernameErrorData || passwordErrorData)
                }

                override fun afterTextChanged(s: Editable?) {
                }

            })

            textPassword.addTextChangedListener(object: TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    passwordErrorData = s.toString().length < 6 || s.toString().trim().isEmpty()
                    if (passwordErrorData) {
                        binding.passwordError.alpha = 1F
                    } else {
                        binding.passwordError.alpha = 0F
                    }
                    btnLogin.isEnabled = !(usernameErrorData || passwordErrorData)
                }

                override fun afterTextChanged(s: Editable?) {
                }

            })
        }

    }

    private fun generateToken(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    private fun buttonCLick() {
        binding.btnLogin.setOnClickListener {
            val username = binding.textUsername.text.toString().trim()
            val password = binding.textPassword.text.toString().trim()

            loginViewModel.loginUser(username, username, password) { isLoginSuccess ->
                if (isLoginSuccess) {
                    val token = generateToken(15)
                    val userLiveData = loginViewModel.getUserByUsernameAndEmail(username, username)
                    userLiveData.observe(viewLifecycleOwner) { user ->
                        val data = LoginData(token, user?.username, user?.name, user?.email, user?.phoneNumber)
                        if (user != null) {
                            val bundle = Bundle().apply {
                                putString("TOKEN", token)
                                putString("USERNAME", username)
                                putString("NAMA", user?.name)
                                putString("EMAIL", username)
                            }
                            pref.saveData(data)
                            findNavController().navigate(
                                R.id.action_loginWithPhoneFragment_to_homeActivity,
                                bundle
                            )
                            requireActivity().finish()
                        } else {
                            Log.d("LoginFragment", "Gadapet data dari database")
                        }
                    }

                } else {
                    binding.btnLogin.post {
                        binding.btnLogin.isEnabled = false
                    }
                    Toast.makeText(requireContext(), "Login gagal, cek kembali username dan password Anda", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = childFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}