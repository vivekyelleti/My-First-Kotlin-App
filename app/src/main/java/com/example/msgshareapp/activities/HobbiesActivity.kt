package com.example.msgshareapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.msgshareapp.adapter.HobbiesAdapter
import com.example.msgshareapp.R
import com.example.msgshareapp.model.Supplier
import kotlinx.android.synthetic.main.activity_hobbies.*

class HobbiesActivity : AppCompatActivity() {

    companion object{
        val TAG:String= HobbiesActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hobbies)

        // Linear,Grid,Staggered
        setRecycleViewon()
    }

    private fun setRecycleViewon() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        showRecyclerView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(
            this,
            Supplier.hobbies
        )
        showRecyclerView.adapter = adapter
    }

}