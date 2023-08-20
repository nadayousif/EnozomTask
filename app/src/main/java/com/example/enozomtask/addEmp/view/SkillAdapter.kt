package com.example.enozomtask.addEmp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enozomtask.R
import com.example.enozomtask.model.Skills


class SkillAdapter(private val skills: List<Skills>) : RecyclerView.Adapter<SkillAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.skills, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val skill = skills[position]
        holder.bind(skill)
    }

    override fun getItemCount(): Int = skills.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(skill: Skills) {
            itemView.findViewById<TextView>(R.id.skill).text = skill.name
        }
    }
}
