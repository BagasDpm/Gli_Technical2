package com.example.technicaltest_gli

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter (private val studentList: ArrayList<Data>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.student_list, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = studentList[position]
        holder.imageStd.setImageResource(currentItem.image)
        holder.nameStd.text = currentItem.name
        holder.addressStd.text = currentItem.address
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageStd : ShapeableImageView = itemView.findViewById(R.id.imageStudent)
        val nameStd : TextView = itemView.findViewById(R.id.nameBody)
        val addressStd: TextView = itemView.findViewById(R.id.addressBody)

    }
}