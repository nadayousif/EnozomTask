package com.example.enozomtask.addEmp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.enozomtask.R
import com.example.enozomtask.model.Skills


class AutoCompleteAdapter(context: Context, private var skillList: List<String>) :
    ArrayAdapter<String>(context, android.R.layout.simple_dropdown_item_1line, skillList) {


    fun setData(newSkillList: List<String>) {
        skillList = newSkillList
        notifyDataSetChanged()
    }
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterResults = FilterResults()
                val suggestions = mutableListOf<String>()

                if (constraint != null) {
                    for (skill in skillList) {
                        if (skill.contains(constraint, ignoreCase = true)) {
                            suggestions.add(skill)
                        }
                    }
                    filterResults.values = suggestions
                    filterResults.count = suggestions.size
                }

                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                clear()
                if (results != null && results.count > 0) {
                    addAll(results.values as List<String>)
                }
                notifyDataSetChanged()
            }
        }
    }
}


/*class SkillAdapter(private val skills: List<Skills>) : RecyclerView.Adapter<SkillAdapter.ViewHolder>() {

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
}*/
