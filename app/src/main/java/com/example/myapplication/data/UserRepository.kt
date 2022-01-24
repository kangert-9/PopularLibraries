package com.example.myapplication.data

import io.reactivex.rxjava3.core.Observable

interface UserRepository {
    fun getUsers(): Observable<List<CountersModel>>
    fun checkUser(userLogin: String, userPassword: String): Observable<CountersModel>
    fun getLogins(): Observable<String>
}