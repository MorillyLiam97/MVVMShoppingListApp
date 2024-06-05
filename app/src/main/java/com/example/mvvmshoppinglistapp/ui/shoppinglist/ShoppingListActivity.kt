package com.example.mvvmshoppinglistapp.ui.shoppinglist

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmshoppinglistapp.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglistapp.databinding.ActivityShoppinglistBinding
import com.example.mvvmshoppinglistapp.other.ShoppingItemAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShoppingListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShoppinglistBinding
    private val viewModel : ShoppingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityShoppinglistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        binding.rvShoppingItems.layoutManager = LinearLayoutManager(this)
        binding.rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        binding.fab.setOnClickListener {
            AddShoppingItemDialogue(this,
                object : AddDialogueListener {
                    override fun onAddButtonClick(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }
    }
}