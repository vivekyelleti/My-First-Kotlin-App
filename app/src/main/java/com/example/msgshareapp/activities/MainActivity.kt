package com.example.msgshareapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.msgshareapp.Constants
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    companion object{
        private val TAG:String= com.example.msgshareapp.activities.MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnShowToast.setOnClickListener {
            Log.i(MainActivity.TAG,"Button was Clicked")
            showToast(resources.getString(R.string.click_button))
            //Toast.makeText(this,"Button was clicked",Toast.LENGTH_SHORT).show()
            // Show is important here

        }
        btnSendToNextActivity.setOnClickListener {
            val msg:String = etTextMessage.text.toString()
            //Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
            val intent= Intent(this, SecondActivity::class.java)

            intent.putExtra(Constants.USER_MSG_KEY,msg)

            startActivity(intent)
        }

        btnSendToOtherApps.setOnClickListener {
            val msg:String = etTextMessage.text.toString()

            val intent=Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,msg)
            intent.type="plain/text"
            startActivity(intent)
        }

        btnSendToHobbies.setOnClickListener {
            val intent= Intent(this,
                HobbiesActivity::class.java)
            startActivity(intent)
        }

    }

}