package com.george.mvvmshoppinglist.data.repositores

import com.george.mvvmshoppinglist.data.db.ShoppingDatabase
import com.george.mvvmshoppinglist.data.db.entities.ShoppingItems

class ShoppingRepository (
   private val db : ShoppingDatabase
) {
    suspend fun upsert (item : ShoppingItems) = db.getShoppingDao().upsert(item)

    suspend fun delete (item: ShoppingItems) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems () = db.getShoppingDao().getAllShoppingItems()
}