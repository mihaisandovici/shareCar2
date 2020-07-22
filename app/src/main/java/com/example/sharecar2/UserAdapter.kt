package com.example.sharecar2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cardview_user.view.*

class UserAdapter(
    private val userList: List<User>, val context: Context)
    : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview_user, parent, false)

        return UserViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]

        holder.imageView.setImageResource(currentUser.imageResource)
        holder.textView1.text = currentUser.text1
        holder.textView2.text = currentUser.text2

        holder.itemView.setOnClickListener {

            //get position of selected item
            val user = userList.get(position)
            // get image with intent, which position is selected
            var gImageView: Int = user.imageResource
            // get title and description of selected item with intent
            var gTitle: String = user.text1
            var gTitle2: String = user.text2

            // create intent in kotlin
            val intent = Intent(context, DetailsUsers::class.java)
            // now put all these item with putExtra
            intent.putExtra("iImageView", gImageView)
            intent.putExtra("iTitle", gTitle)
            intent.putExtra("iTitle2", gTitle2)
            //start DetailsUsers
            context.startActivity(intent)


        }
    }

    override fun getItemCount() = userList.size

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
    }
}