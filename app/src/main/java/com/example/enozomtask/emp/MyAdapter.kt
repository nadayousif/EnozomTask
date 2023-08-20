package com.example.enozomtask.emp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enozomtask.R


class MyAdapter(private val data: List<Pair<String, Int>>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define views here using itemView.findViewById()
       /* val empImage: ImageView
            get()  = itemView.findViewById(R.id.emps_photo)
        val name: TextView
            get()  = itemView.findViewById(R.id.name)
        val email: TextView
            get()  = itemView.findViewById(R.id.email)*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.employee, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = data[position]
        val itemName = item.first
        val itemImageResId = item.second

        // Bind data to views inside the ViewHolder
        holder.itemView.findViewById<TextView>(R.id.name).text = itemName
        holder.itemView.findViewById<ImageView>(R.id.emps_photo).setImageResource(itemImageResId)

        // Bind data to views inside the ViewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }
}