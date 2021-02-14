package com.arabam.android.assigment.ui.carlist.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.arabam.android.assigment.model.CarList
import kotlinx.android.synthetic.main.list_item.view.*

class CarListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(cars: CarList, onItemClickListener: ((cars: CarList) -> Unit)?) {


        Glide.with(itemView.context).load(cars.photo).into(itemView.carImage)
        itemView.carTitle.text = cars.title
        itemView.carPrice.text = cars.priceFormatted
        itemView.locationCity.text = cars.location.cityName
        itemView.locationTown.text = cars.location.townName

        itemView.setOnClickListener { onItemClickListener?.invoke(cars) }
    }
}