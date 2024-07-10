package com.example.mvvm

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository: UserRepository
    val email = MutableLiveData<String>()
    val pass = MutableLiveData<String>()

    private val _loginResult = MutableLiveData<User?>()
    val loginResult: LiveData<User?> get() = _loginResult

    private val _navigateToSignUp = MutableLiveData<Boolean>()
    val navigateToSignUp: LiveData<Boolean> get() = _navigateToSignUp

    private val _signupResult = MutableLiveData<Boolean>()
    val signupResult: LiveData<Boolean> get() = _signupResult

    init {
        val userDao = AppDatabase.getDatabase(application).userDao()
        userRepository = UserRepository(userDao)
    }

    fun insert() = viewModelScope.launch {
        val emailValue = email.value ?: ""
        val passwordValue = pass.value ?: ""
        Log.e(TAG, "insert: ${email.value}")
        Log.e(TAG, "insert: $emailValue ")
        if (emailValue.isNotEmpty() && passwordValue.isNotEmpty()) {
            val user = User(username = emailValue, password = passwordValue)
            userRepository.insert(user)
            _signupResult.postValue(true)
        } else {
            // Handle case where email or password is empty
            Log.e(TAG, "insert: Email or Password is empty")
            _signupResult.postValue(false)
        }
    }

    fun login() = viewModelScope.launch {
        val emailValue = email.value ?: ""
        val passwordValue = pass.value ?: ""
        Log.e(TAG, "login: $emailValue && $passwordValue")
        val user = userRepository.login(emailValue, passwordValue)
        _loginResult.postValue(user)
    }

    fun onLoginClicked() {
        login()
    }

    fun onSignupClicked() {
        _navigateToSignUp.value = true
    }

    fun doneNavigating() {
        _navigateToSignUp.value = false
    }

    fun onCreateAccount() {
        insert()
    }
}