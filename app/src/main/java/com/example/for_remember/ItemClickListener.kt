package com.example.for_remember

interface ItemClickListener {
    fun add(itemsViewModel: ItemsViewModel,position : Int)
    fun minus(itemsViewModel: ItemsViewModel,position : Int)
}