package com.example.sharecar2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_orase.*
import kotlinx.android.synthetic.main.activity_users.*


class UsersClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        val addUserList = ArrayList<User>()
        addUserList.add(User(R.drawable.icon, "Manolache Cristian", "Brasov"))
        addUserList.add(User(R.drawable.icon2, "Radu Elena", "Bucuresti"))
        addUserList.add(User(R.drawable.icon3, "Chiva Catalin", "Suceava"))
        addUserList.add(User(R.drawable.icon4, "Oprea Madalina", "Bacau"))
        addUserList.add(User(R.drawable.icon5, "Velisar Mihai", "Ploiesti"))
        addUserList.add(User(R.drawable.icon6, "Vladuca George", "Bucuresti"))
        addUserList.add(User(R.drawable.icon7, "Roman Valentina", "Suceava"))
        addUserList.add(User(R.drawable.icon, "Neagu Maria", "Constanta"))
        addUserList.add(User(R.drawable.icon2, "Serghiei Adriana", "Suceava"))
        addUserList.add(User(R.drawable.icon3, "Laptuca Alexandru", "Timisoara"))
        addUserList.add(User(R.drawable.icon4, "Merezeanu Ana", "Cluj"))
        addUserList.add(User(R.drawable.icon5, "Chiva Catalin", "Suceava"))
        addUserList.add(User(R.drawable.icon6, "Manolache Cristian", "Brasov"))
        addUserList.add(User(R.drawable.icon7, "Radu Elena", "Bucuresti"))
        addUserList.add(User(R.drawable.icon, "Chiva Alexandra", "Suceava"))
        addUserList.add(User(R.drawable.icon2, "Manolache Cristian", "Brasov"))
        addUserList.add(User(R.drawable.icon3, "Radu Florin", "Bucuresti"))
        addUserList.add(User(R.drawable.icon4, "Chiva Madalina", "Suceava"))

        val userAdapter = UserAdapter (addUserList, this);
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = userAdapter

        /*
        val userList = generateDummyList(100)
        recycler_view.adapter = UserAdapter(userList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        */

        //recycler_view.adapter = UserAdapter(userList)

    }

    /*
    private fun generateDummyList(size: Int): List<User> {
        val list = ArrayList<User>()
        for (i in 1 until size) {
            val drawable = when (i % 7) {
                0 -> R.drawable.icon
                1 -> R.drawable.icon2
                2 -> R.drawable.icon3
                3 -> R.drawable.icon4
                4 -> R.drawable.icon5
                5 -> R.drawable.icon6
                else -> R.drawable.icon7
            }
            val user = User(drawable, "Person $i", "Address $i")
            list += user
        }
        return list
    }
    */


}