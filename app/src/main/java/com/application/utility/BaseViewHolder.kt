package com.application.utility

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var abstractItem: T? = null
    abstract fun bind(item: T, onClickListener: ((T) -> Unit)? = null)
}