package com.george.mvvmshoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.george.mvvmshoppinglist.data.db.entities.ShoppingItems

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(shoppingItems: ShoppingItems)

    @Delete
    suspend fun delete(shoppingItems: ShoppingItems)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems(): LiveData<List<ShoppingItems>>

}