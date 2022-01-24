package com.example.myapplication.data

import io.reactivex.rxjava3.core.Observable

interface UserRepository {
    fun getUsers(): Observable<List<CountersModel>>
    fun getUserByLogin(userLogin: String): Observable<CountersModel?>
    fun getLogins(): Observable<String>
}