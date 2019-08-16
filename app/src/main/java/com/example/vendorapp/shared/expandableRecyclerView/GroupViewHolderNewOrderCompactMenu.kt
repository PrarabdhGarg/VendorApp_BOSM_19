package com.example.vendorapp.shared.expandableRecyclerView

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.res.TypedArrayUtils
import com.example.vendorapp.R
import com.example.vendorapp.shared.Listeners.ListenerRecyViewButtonClick
import com.example.vendorapp.shared.utils.StatusKeyValue
import com.thoughtbot.expandablerecyclerview.listeners.OnGroupClickListener
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder

class GroupViewHolderNewOrderCompactMenu(
    private var isLoading: Boolean,
    private val orderId: Int,
    private val orderAmount: Int,
    val listener3: ListenerRecyViewButtonClick,
    itemView: View?
) : GroupViewHolder(itemView) {

    var textViewOrderId: TextView
    var textViewOrderAmount: TextView
    var textArrowButton: TextView
    var buttonAccept: Button
    var buttonDecline: Button
    var progressBar: ProgressBar


    init {
        //initialising views
        textArrowButton = itemView!!.findViewById(R.id.text_group_view_holder_new_order_heading)
        textViewOrderId = itemView!!.findViewById(R.id.textView_order_id)
        textViewOrderAmount = itemView.findViewById(R.id.textView_order_amount)
        buttonAccept = itemView.findViewById(R.id.button_accept)
        buttonDecline = itemView.findViewById(R.id.button_decline)
        progressBar = itemView.findViewById(R.id.text_group_view_holder_new_order_progress_bar)

        //setting initial states of views
        textViewOrderId.text = "Id#5666" + orderId
        textViewOrderAmount.text = "\u20B9" + "20" + orderAmount

        textViewOrderAmount.setOnClickListener {}
        textViewOrderId.setOnClickListener { }

        if (isLoading) {
            progressBar.visibility = View.VISIBLE
            buttonDecline.visibility = View.INVISIBLE
            buttonAccept.visibility = View.INVISIBLE
        } else {
            progressBar.visibility = View.INVISIBLE
            buttonDecline.visibility = View.VISIBLE
            buttonAccept.visibility = View.VISIBLE

        }

        buttonAccept.setOnClickListener {

            onClickButtons(StatusKeyValue().getStatusInt("accepted"))
        }

        buttonDecline.setOnClickListener {
            onClickButtons(StatusKeyValue().getStatusInt("declined"))
        }
    }

    override fun expand() {
        Log.d("Click", "expand")
        textArrowButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up_arrow, 0)
        super.expand()
    }

    override fun collapse() {
        Log.d("Click", "collapse")
        textArrowButton.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow, 0)
        super.collapse()
    }


    override fun setOnGroupClickListener(listener: OnGroupClickListener?) {
        Log.d("Click", "onGroup")

        super.setOnGroupClickListener(listener)

    }

    override fun onClick(v: View?) {
        Log.d("Click", "onClick")

        super.onClick(v)

    }

    fun setHeading() {
        // textHeading.text = "Menu"
        // super.onClick(textHeading)
        // super.expand()
    }

    private fun onClickButtons(status: Int) {

        listener3.buttonClicked(orderId, status)
    }

}