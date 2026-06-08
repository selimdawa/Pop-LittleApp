package com.littleapp.pop.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.littleapp.pop.models.PopItem

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<PopItem>? ) {
    if (data == null) return
    val adapter = recyclerView.adapter as? FunkoListAdapter
    adapter?.submitList(data)
}