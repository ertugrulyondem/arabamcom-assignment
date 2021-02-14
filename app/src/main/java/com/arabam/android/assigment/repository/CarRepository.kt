package com.arabam.android.assigment.repository

import com.arabam.android.assigment.remote.RetrofitAPI

class CarRepository {

    suspend fun getCarList() = RetrofitAPI.service.getCarList()
    suspend fun getCarDetail() = RetrofitAPI.service.getCarDetail()
}