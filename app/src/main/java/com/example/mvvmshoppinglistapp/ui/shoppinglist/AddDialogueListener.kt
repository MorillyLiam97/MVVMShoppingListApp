package com.example.mvvmshoppinglistapp.ui.shoppinglist

import com.example.mvvmshoppinglistapp.data.db.entities.ShoppingItem

interface AddDialogueListener {
    fun onAddButtonClick(item: ShoppingItem)
}