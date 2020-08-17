package com.example.msgshareapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.*
import androidx.recyclerview.widget.RecyclerView
import com.example.msgshareapp.model.Hobby
import com.example.msgshareapp.R
import com.example.msgshareapp.showToast
import kotlinx.android.synthetic.main.list_view.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>(){

    companion object{
        val TAG:String= HobbiesAdapter::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_view, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby=hobbies[position]
        holder.setData(hobby,position)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var currentHobby : Hobby?= null
        var currentpos : Int = 0

        init{
            itemView.setOnClickListener{
                currentHobby?.let{
                    context.showToast(currentHobby !!.title + " Clicked !")
                }

//                Toast.makeText( context, currentHobby !!.title + " Clicked !", LENGTH_SHORT).show()
            }
            itemView.imgShare.setOnClickListener{
                currentHobby?.let {
                    val msg:String = "My Hobby is "+ currentHobby!!.title.toString()
                    val intent= Intent()
                    intent.action = Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT,msg)
                    intent.type="plain/text"
                    context.startActivity(intent)
                }

            }


        }

        fun setData(hobby: Hobby?, position: Int){

            hobby?.let {
                itemView.txvTitle.text = hobby!!.title

                this.currentHobby = hobby
                this.currentpos = position
            }

        }



    }

}