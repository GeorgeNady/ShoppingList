package com.george.mvvmshoppinglist.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.george.mvvmshoppinglist.data.db.entities.ShoppingItems
import com.george.mvvmshoppinglist.data.repositores.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ShoppingViewModel(
    private val reposetory: ShoppingRepository
) : ViewModel() {
    fun upsert(item: ShoppingItems) = CoroutineScope(Dispatchers.Main).launch {
        reposetory.upsert(item)
    }

    fun delete(item: ShoppingItems) = CoroutineScope(Dispatchers.Main).launch {
        reposetory.delete(item)
    }

    fun getAllShoppingItems() = reposetory.getAllShoppingItems()

}