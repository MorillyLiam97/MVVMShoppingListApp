package com.example.mvvmshoppinglistapp.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.mvvmshoppinglistapp.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglistapp.data.repositories.ShoppingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShoppingViewModel @Inject constructor(
    private val repository: ShoppingRepository
): ViewModel() {

    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)

    }

    fun getAllShoppingItems() = repository.getAllShoppingItems()
}