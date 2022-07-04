package com.theoptimust.loginvalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.EditText
import com.theoptimust.loginvalidation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        emailValidationLiatener()
        binding=ActivityMainBinding.inflate(layoutInflater)
    }

    private fun emailValidationLiatener() {
        binding.EmailEdit.setOnFocusChangeListener { _,focused ->
            if(!focused){
                binding.EmailContainer.helperText=validEmail()
            }
        }

    }

    private fun validEmail(): String? {
        val email=binding.EmailEdit.text.toString()
        if(Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            return "invalid Email Address"
        }
    return null
    }
    private fun passwordValidationLiatener() {
        binding.passwordEdit.setOnFocusChangeListener { _,focused ->
            if(!focused){
                binding.passwordContainer.helperText=validPassword()
            }
        }

    }

    private fun validPassword(): String? {
        val password=binding.passwordEdit.text.toString()
        if(password.length<8)
        {
            return "Minimum 8 Character Password"
        }
        if(!password.matches(".*[A-Z].*".toRegex()))
        {
            return "Must Contain 1 Upper-case Character"
        }
        if(!password.matches(".*[a-z].*".toRegex()))
        {
            return "Must Contain 1 Lower-case Character"
        }
        if(!password.matches(".*[@#\$%^&*()_!.,;:+=].*".toRegex()))
        {
            return "Must Contain 1 Special Character"
        }
        return null
    }
}