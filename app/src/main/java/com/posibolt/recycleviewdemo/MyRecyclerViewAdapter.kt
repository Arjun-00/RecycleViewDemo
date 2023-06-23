package com.posibolt.recycleviewdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(private  val smartPhone: List<SmartPhones>,private val clickListner:(SmartPhones)->Unit) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item,parent,false)
        return MyViewHolder(listItem,clickListner)
    }

    override fun getItemCount(): Int {
      return smartPhone.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val place = smartPhone[position];
        holder.bind(place,clickListner)
    }

}
class MyViewHolder(val view1: View, clickListner: (SmartPhones) -> Unit): RecyclerView.ViewHolder(view1){
    fun bind(smartPhone: SmartPhones, clickListner: (SmartPhones) -> Unit,){
        val myTextView = view1.findViewById<TextView>(R.id.textView)
        myTextView.text = smartPhone.modelName
        view1.setOnClickListener {
            clickListner(smartPhone)
        }
    }
}