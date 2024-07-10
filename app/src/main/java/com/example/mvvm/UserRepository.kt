package com.example.mvvm

class UserRepository (private val userDao: UserDao){
    suspend fun insert(user: User) {
        userDao.insert(user)
    }

    suspend fun login(username: String, password: String): User? {
        return userDao.login(username, password)
    }
}