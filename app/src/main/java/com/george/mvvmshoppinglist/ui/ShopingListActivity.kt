package com.george.mvvmshoppinglist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.george.mvvmshoppinglist.R
import com.george.mvvmshoppinglist.adapters.ShoppingItemsAdapter
import com.george.mvvmshoppinglist.data.db.ShoppingDatabase
import com.george.mvvmshoppinglist.data.db.entities.ShoppingItems
import com.george.mvvmshoppinglist.data.repositores.ShoppingRepository
import com.george.mvvmshoppinglist.ui.shoppinglist.AddDialogListener
import com.george.mvvmshoppinglist.ui.shoppinglist.AddShoppingItemDialog
import com.george.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModel
import com.george.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_shopping_list.*

class ShopingListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

        val database = ShoppingDatabase(this)
        //val repository = ShoppingRepository(database)
        val repository = ShoppingRepository(database)
        val factory: ShoppingViewModelFactory = ShoppingViewModelFactory(repository)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemsAdapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.shoppingItems = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingItemDialog(this,
                object : AddDialogListener {
                    override fun onButtonClicked(item: ShoppingItems) {
                        viewModel.upsert(item)
                    }
                }).show()
        }


    }
}