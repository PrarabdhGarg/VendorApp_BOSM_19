package com.example.vendorapp.neworderscreen.viewModel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vendorapp.neworderscreen.view.ModifiedOrdersDataClass
import com.example.vendorapp.shared.expandableRecyclerView.ChildDataClass
import com.example.vendorapp.shared.singletonobjects.repositories.NewOrderRepositoryInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewOrderViewModel(context : Context) : ViewModel(){

    var orders : LiveData<List<ModifiedOrdersDataClass>> = MutableLiveData()
    var newOrderRepo = NewOrderRepositoryInstance.getInstance(context)


    @SuppressLint("CheckResult")
    fun getNewOrders() {

        var list = emptyList<ModifiedOrdersDataClass>()
        newOrderRepo.getNewOrdersList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .doOnNext { orderList ->
                orderList.forEach { order ->
                    //                        var childList = emptyList<ChildDataClass>()
//                        order.items.forEach {
//                            childList.plus(ChildDataClass(itemId = it.itemId , itemName = "Default Name" , price = it.price , quantity = it.quantity))
//                        }
//                        list.plus(ModifiedOrdersDataClass(timestamp = order.timestamp.toString() , totalAmount = order.totalAmount , status = order.status , otp = order.otp , items = childList , orderId = order.orderId))
//                    }
//                    (orders as MutableLiveData<List<ModifiedOrdersDataClass>>).postValue(list)
//                }
//
//    }



                }
            }
    }

    fun refreshOrderData() {
        newOrderRepo.setnewOrderfromServer()
    }
}