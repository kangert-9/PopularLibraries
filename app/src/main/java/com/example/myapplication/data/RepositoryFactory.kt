package com.example.myapplication.data

object RepositoryFactory {
    fun create(): UserRepository = UserRepositoryImpl()
}