package com.arabam.android.assigment.remote

import com.arabam.android.assigment.model.CarDetail
import com.arabam.android.assigment.model.CarList
import io.reactivex.Single
import retrofit2.http.GET

interface CarService {

    @GET("api/v1/listing?sort=1&sortDirection=0&take=10")
    fun getCarList(): Single<List<CarList>>

    @GET("api/v1/detail?")
    fun getCarDetail(): Single<CarDetail>
}