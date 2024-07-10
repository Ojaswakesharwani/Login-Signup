package com.example.mvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel
   // lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding= ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.viewmodel=viewModel
        binding.lifecycleOwner=this
       // viewBinding= ActivityMainBinding.inflate(layoutInflater)
       // setContentView(viewBinding.root)



        viewModel.loginResult.observe(this, Observer { user ->
            if (user != null){
                Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                val bundle = Bundle().apply {
                    putString("authentication",user.username)
                }
                val intent = Intent(this,SuccessActivity::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.navigateToSignUp.observe(this,Observer{navigate ->
            if (navigate){
                startActivity(Intent(this@MainActivity,SignUpActivity::class.java))
                viewModel.doneNavigating()
            }
        })

       /* binding.signUpBtn.setOnClickListener {
            viewModel.onSignupClicked()
        }*/

        /*binding.signUpBtn.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }*/

      /*  binding.logInBtn.setOnClickListener {
            val email=binding.etEmail.text.toString()
            val password=binding.etPassword.text.toString()
            viewModel.login(email,password).observe(this, Observer { user ->
                if(user!=null){
                    Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                    val bundle=Bundle()
                    bundle.putString("authentication",email)
                    val intent=Intent(this,SuccessActivity::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
                }
            })
        }*/


    }
}