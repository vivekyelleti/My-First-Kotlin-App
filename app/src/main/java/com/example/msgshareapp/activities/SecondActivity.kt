package com.example.msgshareapp.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.msgshareapp.Constants
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.acitivity_second.*

class SecondActivity : AppCompatActivity(){

    companion object{
        val TAG:String= SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_second)

        // Safe Call ?.
        // Safe Call with let ?.let { lambda exp }

        val bundle: Bundle ? = intent.extras


        // Best way to handle NULL Pointer expression MAKES CODE MORE ROBUST
        bundle?.let {

            val msg = bundle!!.getString(Constants.USER_MSG_KEY)
            showToast(msg.toString())
            //Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
            //Toast.makeText(this, msg ,Toast.LENGTH_LONG).show()
            showTextMessage.text = msg
        }


    }
}