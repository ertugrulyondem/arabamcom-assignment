package com.arabam.android.assigment.model

data class CarDetail (
    val id: Int,
    val title: String,
    val location: LocationDetail,
    val category: CategoryDetail,
    val modelName: String,
    val price: Int,
    val priceFormatted: String,
    val date: String,
    val dateFormatted: String,
    val photos: List<String>,
    val properties: List<PropertyDetail>,
    var text: String,
    val userInfo: UserInfo
)


data class LocationDetail(
    val cityName: String,
    val townName: String
)

data class CategoryDetail(
    val id: Int,
    val name: String
)

data class PropertyDetail(
    val name: String,
    val value: String
)

data class UserInfo(
    val id: Int,
    val nameSurname: String,
    val phone: String,
    val phoneFormatted: String
)