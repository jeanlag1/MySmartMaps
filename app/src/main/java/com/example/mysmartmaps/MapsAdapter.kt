package com.example.mysmartmaps

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.mysmartmaps.models.UserMap


private const val TAG = "MapsAdapter"
class MapsAdapter(val context: Context, val userMaps: List<UserMap>, val onClickistener: OnClickistener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    interface OnClickistener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user_map,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount() = userMaps.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val userMap = userMaps[position]
        holder.itemView.setOnClickListener {
            onClickistener.onItemClick(position)
        }
        val textViewTitle = holder.itemView.findViewById<TextView>(R.id.tvMapTitle)
        textViewTitle.text = userMap.title
        val numPlaces = holder.itemView.findViewById<TextView>(R.id.placeCount)
        numPlaces.text = "Place(s): ${userMap.places.size.toString()}"

    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
