package com.yongjincompany.yaho2.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yongjincompany.yaho2.data.Room
import com.yongjincompany.yaho2.databinding.RoomItemBinding

class RoomAdapter : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    inner class RoomViewHolder(val binding: RoomItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Room>() {
        override fun areItemsTheSame(oldItem: Room, newItem: Room): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Room, newItem: Room): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var rooms: List<Room>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

    override fun getItemCount() = rooms.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        return RoomViewHolder(
            RoomItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        holder.binding.apply {
            val ya = rooms[position]
            itemtitle.text = ya.name
        }
    }
}