package com.arabam.android.assigment.ui.cardetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide

import com.arabam.android.assigment.R
import com.arabam.android.assigment.model.CarDetail
import kotlinx.android.synthetic.main.car_detail_fragment.*

class CarDetailFragment : Fragment() {

    private val cars: CarDetail? by lazy { arguments?.let { CarDetailFragmentArgs.fromBundle(it).cars } }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.car_detail_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepareUi()
    }

    private fun prepareUi() {
        cars?.let { cars ->

            Glide.with(this).load(cars.photos).into(imageView)
            categoryName.text = cars.category.name
            townName.text = cars.location.townName


        }
    }
}
