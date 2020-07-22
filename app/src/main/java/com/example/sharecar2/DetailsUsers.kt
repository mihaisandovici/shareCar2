package com.example.sharecar2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_details_users.*
import kotlinx.android.synthetic.main.activity_show_oras.*

class DetailsUsers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_users)

        val profileUser = intent.getIntExtra("iImageView", 0)
        image_view.setImageResource(profileUser)
        val numeUser= intent.getStringExtra("iTitle")
        text_view_1.text = numeUser
        val orasUser = intent.getStringExtra("iTitle2")
        text_view_2.text = orasUser

    }
}