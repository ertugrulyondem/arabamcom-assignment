package com.arabam.android.assigment.remote

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.arabam.android.assigment.model.CarDetail
import com.arabam.android.assigment.model.CarList

object RetrofitAPI {

    private const val BASE_URL = "http://sandbox.arabamd.com/"

    var service: CarService

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(CarService::class.java)
    }

    fun getCarList(): Single<List<CarList>> {
        return service.getCarList()
    }
    fun getCarDetail(id: Int): Single<CarDetail> {
        return service.getCarDetail()
    }
}