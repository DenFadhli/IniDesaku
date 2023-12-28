package com.citiasia.inidesakubeta.ui.sign.signUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.citiasia.inidesakubeta.databinding.ActivityOtpBinding
import com.citiasia.inidesakubeta.ui.pilihWilayah.PilihWilayahActivity

class OtpActivity : AppCompatActivity() {

    private var _binding: ActivityOtpBinding? = null
    private val binding get() = _binding!!

    private lateinit var phoneNumber: String
    private lateinit var username: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        phoneNumber = intent.getStringExtra("PHONE_NUMBER")!!
        username = intent.getStringExtra("USERNAME")!!
        password = intent.getStringExtra("PASSWORD")!!

        binding.btnResendOtpLayout.setOnClickListener {
            countdownTimer()
        }
        countdownTimer()
    }

    private fun countdownTimer() {
        val countdownTimer = object : CountDownTimer(120000, 1000) {
            var isOtpAutoFilled = false

            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000

                if (!isOtpAutoFilled && secondsRemaining <= 118) {
                    isOtpAutoFilled = true
                    val generatedOtp = generateOtp()
                    binding.otpView.setOTP(generatedOtp)

                    binding.btnSignup.isEnabled = true
                    binding.btnSignup.setOnClickListener {
                        val intent = Intent(this@OtpActivity, CompleteProfileActivity::class.java)
                        intent.putExtra("PHONE_NUMBER", phoneNumber)
                        intent.putExtra("USERNAME", username)
                        intent.putExtra("PASSWORD", password)
                        startActivity(intent)
                    }
                }

                val minutes = secondsRemaining / 60
                val seconds = secondsRemaining % 60
                val timeLeftFormatted = String.format("(%02d:%02d)", minutes, seconds)
                binding.countdownResendOtp.text = timeLeftFormatted
            }

            override fun onFinish() {
                binding.countdownResendOtp.text = "(00:00)"
                binding.countdownResendOtp.alpha = 0F
                binding.resendOtpText1.alpha = 0F
                binding.btnResendOtpLayout.alpha = 1F
                binding.resendOtpText12.alpha = 1F
            }
        }
        countdownTimer.start()
    }

    private fun generateOtp(): String {
        return (1000..9999).random().toString()
    }
}