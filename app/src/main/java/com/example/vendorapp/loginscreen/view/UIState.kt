package com.example.vendorapp.loginscreen.view

import com.example.vendorapp.neworderscreen.model.IncompleteOrderStatus

sealed class UIState {

    object ShowLoadingState : UIState()

    object ShowInitialState : UIState()

    object ShowWorkingState : UIState()

    object GoToMainScreen : UIState()
    data class ErrorState(val message:String):UIState()

    data class SuccessStateFetchingOrders(val message:String,/*val orderId :Int,*/val incompleteOrderList: List<IncompleteOrderStatus>): UIState()

    data class ErrorStateFetchingOrders(val message:String/*,val orderId :Int*/,val incompleteOrderList: List<IncompleteOrderStatus>): UIState()
}