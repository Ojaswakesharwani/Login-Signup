package com.example.mvvm

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel
    lateinit var binding: ActivitySignUpBinding

    // lateinit var viewBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // viewBinding= ActivitySignUpBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        // setContentView(viewBinding.root)

        viewModel.signupResult.observe(this, Observer { success ->
            Log.e(TAG, "onCreate: $success")
            if (success) {
                Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this,"Empty Credentials",Toast.LENGTH_SHORT).show()
            }
        })

        binding.logInBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        /* viewBinding.logInBtn.setOnClickListener {
             startActivity(Intent(this,MainActivity::class.java))
             finish()
         }*/


        /* binding.logInBtn.setOnClickListener {
             startActivity(Intent(this,MainActivity::class.java))
             finish()
         }*/

        /* binding.createAccountBtn.setOnClickListener {
             val email=binding.etEmail.text.toString()
             val password=binding.etPassword.text.toString()
             val user=User(username = email, password = password)
             viewModel.insert(user)
             Toast.makeText(this,"Signup successfull",Toast.LENGTH_SHORT).show()
             finish()
         }*/
    }
}