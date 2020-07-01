package com.george.mvvmshoppinglist.ui.shoppinglist

import com.george.mvvmshoppinglist.data.db.entities.ShoppingItems

interface AddDialogListener {

    fun onButtonClicked(item: ShoppingItems)
}