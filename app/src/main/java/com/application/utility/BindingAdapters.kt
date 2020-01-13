package com.application.utility

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.application.R

@BindingAdapter("totalOf")
fun TextView.bindTotalOf(total: Int){
    val indicatorText = resources.getString(R.string.indicator_text) + " " + total.toString()
    text = indicatorText
}