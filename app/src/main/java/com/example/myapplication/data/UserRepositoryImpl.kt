package com.example.myapplication.data

import io.reactivex.rxjava3.core.Observable

class UserRepositoryImpl: UserRepository {

    private val users = listOf(
        CountersModel("login1", "1"),
        CountersModel("login2","2"),
        CountersModel("login3", "3"),
        CountersModel("login4", "4"),
        CountersModel("login5", "5"),
    )

    override fun getUsers(): Observable<List<CountersModel>> {
        return Observable.just(users)
    }

    override fun getUserByLogin(userLogin: String): Observable<CountersModel?> {
        return Observable.just(users)
            .map { it.findLast { it.login == userLogin} }
    }

    override fun getLogins(): Observable<String> {
        val logins = listOf("login1","login2","login3","login4","login2")
        return Observable.fromIterable(logins)
    }
}