package com.george.mvvmshoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItems (
    @ColumnInfo(name = "item_name")
    var itemName: String,
    @ColumnInfo(name = "amount")
    var amount: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}