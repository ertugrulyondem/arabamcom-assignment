package com.arabam.android.assigment.ui.carlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arabam.android.assigment.R
import com.arabam.android.assigment.model.CarList

class CarListAdapter : RecyclerView.Adapter<CarListViewHolder>() {

    var carList: List<CarList> = ArrayList()
        set(value) {
            field = value
            this.notifyDataSetChanged()
        }

    private var onItemClickListener: ((CarList?) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return CarListViewHolder(itemView)
    }

    override fun getItemCount(): Int = carList.size

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        holder.bind(carList[position], onItemClickListener)
    }

    fun setOnItemClickListener(onItemClickListener: ((CarList?) -> Unit)?) {
        this.onItemClickListener = onItemClickListener
    }
}