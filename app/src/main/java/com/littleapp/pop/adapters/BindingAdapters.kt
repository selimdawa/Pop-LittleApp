package com.littleapp.pop.adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.littleapp.pop.models.PopItem

@BindingAdapter("listData")
fun bindRecyclerView(
    recyclerView: RecyclerView,
    data: List<PopItem>?,
) {
    val adapter = recyclerView.adapter as FunkoListAdapter
    if (data != null) {
        adapter.submitList(data)
    }
}