package com.example.mvvmshoppinglistapp.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.mvvmshoppinglistapp.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglistapp.databinding.DialogueAddShoppingItemBinding


class AddShoppingItemDialogue(context: Context, var addDialogueListener: AddDialogueListener) : AppCompatDialog(context) {

    private lateinit var binding: DialogueAddShoppingItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DialogueAddShoppingItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvAdd.setOnClickListener{
            val name = binding.etName.text.toString()
            val amount = binding.etAmount.text.toString()

            if(name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter a name and an amount", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogueListener.onAddButtonClick(item)
            dismiss()
        }

        binding.tvCancel.setOnClickListener{
            cancel()
        }

    }
}