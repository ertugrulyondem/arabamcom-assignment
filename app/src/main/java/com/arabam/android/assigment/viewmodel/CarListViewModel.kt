package com.arabam.android.assigment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arabam.android.assigment.model.CarList
import com.arabam.android.assigment.repository.CarRepository
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CarListViewModel : ViewModel() {

    val carListLiveData = MutableLiveData<List<CarList>>()
    private val carRepository = CarRepository()

    fun getCarList() {
        viewModelScope.launch {
            val cars: Single<List<CarList>> = carRepository.getCarList()

            withContext(Dispatchers.Main) {
                carListLiveData.value = cars
            }
        }
    }
}