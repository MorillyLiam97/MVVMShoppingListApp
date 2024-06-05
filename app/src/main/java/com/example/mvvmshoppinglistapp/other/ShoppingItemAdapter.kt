package com.example.mvvmshoppinglistapp.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmshoppinglistapp.data.db.entities.ShoppingItem
import com.example.mvvmshoppinglistapp.databinding.ShoppingItemBinding
import com.example.mvvmshoppinglistapp.ui.shoppinglist.ShoppingViewModel


class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val binding = ShoppingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShoppingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currentItem = items[position]
        holder.binding.tvName.text = currentItem.name
        holder.binding.tvAmount.text = "${currentItem.amount}"

        holder.binding.ivDelete.setOnClickListener{
            viewModel.delete(currentItem)
        }

        holder.binding.ivAdd.setOnClickListener {
            currentItem.amount++
            viewModel.upsert(currentItem)
        }

        holder.binding.ivRemove.setOnClickListener {
            if (currentItem.amount > 0) {
                currentItem.amount--
                viewModel.upsert(currentItem)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ShoppingViewHolder(val binding: ShoppingItemBinding ): RecyclerView.ViewHolder(binding.root)

}