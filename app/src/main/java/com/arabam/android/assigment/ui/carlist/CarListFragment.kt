package com.arabam.android.assigment.ui.carlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.arabam.android.assigment.R
import com.arabam.android.assigment.ui.carlist.adapter.CarListAdapter
import com.arabam.android.assigment.viewmodel.CarListViewModel
import kotlinx.android.synthetic.main.car_list_fragment.*

class CarListFragment : Fragment() {

    private val carListAdapter = CarListAdapter()

    private lateinit var viewModel: CarListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.car_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CarListViewModel::class.java)

        initCarListRecyclerView()
        initLiveData()
        onItemClicked()

        viewModel.getCarList()
    }

    private fun initCarListRecyclerView() {
        recyclerViewCarList.apply {
            setHasFixedSize(true)
            adapter = carListAdapter
        }
    }

    private fun initLiveData() {
        viewModel.carListLiveData.observe(viewLifecycleOwner, Observer {
            carListAdapter.carList = it
        })
    }

    private fun onItemClicked() {
        carListAdapter.setOnItemClickListener { clickedCars ->
            val action = CarListFragmentDirections.actionCarListFragmentToCarDetailFragment().also {
                    it.cars = clickedCars
                }

            findNavController().navigate(action)
        }
    }
}
