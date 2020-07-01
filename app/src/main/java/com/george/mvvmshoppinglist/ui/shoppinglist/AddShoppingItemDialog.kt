package com.george.mvvmshoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.george.mvvmshoppinglist.R
import com.george.mvvmshoppinglist.data.db.entities.ShoppingItems
import kotlinx.android.synthetic.main.dialog_add_item.*

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) :
    AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_item)

        btnAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {

                return@setOnClickListener
            } else if (amount == String()) {
                Toast.makeText(context, "Please all the information", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val item = ShoppingItems(name, amount.toInt())
            addDialogListener.onButtonClicked(item)
            dismiss()
        }

        btnCansel.setOnClickListener {
            cancel()
        }
    }
}