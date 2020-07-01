package com.george.mvvmshoppinglist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.george.mvvmshoppinglist.R
import com.george.mvvmshoppinglist.data.db.entities.ShoppingItems
import com.george.mvvmshoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingItemsAdapter(
    var shoppingItems: List<ShoppingItems>,
    private val viewModel: ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemsAdapter.ShoppingItemViewHolder>() {

    inner class ShoppingItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.shopping_item,
            parent,
            false
        )
        return ShoppingItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return shoppingItems.size
    }

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        val curruntShoppingItem = shoppingItems[position]
        holder.itemView.tvItemName.text = curruntShoppingItem.itemName
        holder.itemView.tvAmount.text = curruntShoppingItem.amount.toString()
        holder.itemView.tvAmount1.text = curruntShoppingItem.amount.toString()
        holder.itemView.btnDelete.setOnClickListener {
            viewModel.delete(curruntShoppingItem)
        }
        holder.itemView.btnAdd.setOnClickListener {
            curruntShoppingItem.amount++
            viewModel.upsert(curruntShoppingItem)
        }
        holder.itemView.btnMinus.setOnClickListener {
            if (curruntShoppingItem.amount > 0) curruntShoppingItem.amount--
            viewModel.upsert(curruntShoppingItem)
        }
    }
}