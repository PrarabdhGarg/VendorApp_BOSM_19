package com.example.vendorapp.neworderscreen.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vendorapp.R
import com.example.vendorapp.neworderscreen.view.adapters.RecyclerAdapterFragment
import com.example.vendorapp.singletonobjects.viewmodels.NewOrderViewModelInstance

class NewOrderFragment : Fragment() , RecyclerAdapterFragment.RecyclerButtonClickListener{

    private val viewModel by lazy {
        NewOrderViewModelInstance.getInstance(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_fra_new_order, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeView()
    }

    fun initializeView()
    {

    }

    override fun buttonClicked(orderId: String, accepted: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}