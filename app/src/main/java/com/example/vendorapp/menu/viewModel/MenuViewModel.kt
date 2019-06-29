package com.example.vendorapp.menu.viewModel

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vendorapp.menu.model.MenuRepository
import com.example.vendorapp.shared.dataclasses.retroClasses.MenuPojo
import com.example.vendorapp.shared.dataclasses.roomClasses.MenuItemData
import com.example.vendorapp.shared.singletonobjects.repositories.MenuRepositoryInstance
import com.example.vendorapp.shared.utils.NetworkConnectivityCheck
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MenuViewModel(context: Context) :ViewModel() {

    var menuList:LiveData<List<MenuItemData>> = MutableLiveData()
    var error : LiveData<String> = MutableLiveData()
    var menuRepository:MenuRepository=MenuRepositoryInstance.getInstance(context)

    init {

        if (NetworkConnectivityCheck().checkIntenetConnection(context)) {
            menuRepository.updateMenu().subscribeOn(Schedulers.io()).doOnError {
                Log.e("Error in Menu VM" , "Error in updating menu = ${it.toString()}")
            }.doOnComplete { menuRepository.getMenuRoom().observeOn(AndroidSchedulers.mainThread())
                .subscribe({menu->
                    (menuList as MutableLiveData<List<MenuItemData>>).postValue(menu)
                },{
                    Log.d("Error",it.stackTrace.toString())
                }) }.subscribe()
        } else {
            (error as MutableLiveData<String>).postValue("Please check your internet connection and restart the app")
        }
    }

    fun updateStatus(id:String,status:String){

    }
}