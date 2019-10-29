package com.taweewong.epoxypoc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import com.taweewong.epoxypoc.controller.UserEpoxyController
import kotlinx.android.synthetic.main.activity_main.*
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    private val userController : UserEpoxyController by lazy { UserEpoxyController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        recyclerViewTest.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = userController.adapter
        }
        userController.requestModelBuild()
    }
}
