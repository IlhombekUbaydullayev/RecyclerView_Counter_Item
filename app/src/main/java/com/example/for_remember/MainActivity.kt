package com.example.for_remember

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity(),ItemClickListener {
    private var rv_item : RecyclerView? = null
    var adapter : CustomAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        val members = prepareMemerList()
        refreshAdapter(members)
    }

    private fun initViews() {
        rv_item = findViewById(R.id.rv_items)
        rv_item!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun prepareMemerList(): List<ItemsViewModel> {
        val members : ArrayList<ItemsViewModel> = ArrayList()
        for (i in 0..20) {
            members.add(ItemsViewModel("Ilhombek$i",0))
        }
        return members
    }

    private fun refreshAdapter(members: List<ItemsViewModel>) {
        adapter = CustomAdapter(members,this)
        rv_item!!.adapter = adapter
    }

    override fun add(itemsViewModel: ItemsViewModel, position: Int) {
        itemsViewModel.itemCount+=1
        adapter!!.notifyItemChanged(position)
    }

    override fun minus(itemsViewModel: ItemsViewModel, position: Int) {
        if (itemsViewModel.itemCount > 0) {
            itemsViewModel.itemCount-=1
            adapter!!.notifyItemChanged(position)
        }
    }
}