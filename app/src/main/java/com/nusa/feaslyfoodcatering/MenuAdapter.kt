package com.nusa.feaslyfoodcatering

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val menuItems: List<MenuItem>) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    private var filteredMenuItems: List<MenuItem> = menuItems

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val menuItem = filteredMenuItems[position]
        holder.bind(menuItem)
    }

    override fun getItemCount(): Int {
        return filteredMenuItems.size
    }

    fun filter(query: String) {
        filteredMenuItems = if (query.isEmpty()) {
            menuItems
        } else {
            menuItems.filter { menuItem ->
                menuItem.name.contains(query, ignoreCase = true) || menuItem.description.contains(query, ignoreCase = true)
            }
        }
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemNameTextView: TextView = itemView.findViewById(R.id.itemNameTextView)
        private val itemDescriptionTextView: TextView = itemView.findViewById(R.id.itemDescriptionTextView)

        fun bind(menuItem: MenuItem) {
            itemNameTextView.text = menuItem.name
            itemDescriptionTextView.text = menuItem.description
        }
    }
}
