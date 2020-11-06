package com.codequest.postsviewer.presentation

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.codequest.postsviewer.R
import com.codequest.postsviewer.domain.User

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter() : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {
    private val users = mutableListOf<User>()

    fun setData(newItems: List<User>) {
        users.clear()
        users.addAll(newItems)
        notifyItemRangeChanged(0, newItems.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = users[position]
        holder.userFirstNameView.text = item.name.firstName
        holder.userLastNameView.text = item.name.lastName

        Glide.with(holder.itemView)
            .load(item.picture.userPictureUrl)
            .into(holder.userPictureView)
    }

    override fun getItemCount(): Int = users.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userFirstNameView: TextView = view.findViewById(R.id.userFirstName)
        val userLastNameView: TextView = view.findViewById(R.id.userLastName)
        val userPictureView: ImageView = view.findViewById(R.id.userPicture)
    }
}