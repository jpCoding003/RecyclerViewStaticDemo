package com.tops.recyclerviewstaticdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tops.recyclerviewstaticdemo.databinding.ExamCardBinding


class MyAdapter(private val examList: List<ExamItem>) : RecyclerView.Adapter<MyAdapter.ExamViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExamViewHolder {
       val binding = ExamCardBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return ExamViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ExamViewHolder,
        position: Int
    ) {
        val ExamItem = examList[position]
        holder.binding.name.text = ExamItem.name
        holder.binding.age.text = ExamItem.age.toString()
        holder.binding.imageCard.setImageResource(ExamItem.pic!!)

    }

    override fun getItemCount(): Int {
     return examList.size
    }

    class ExamViewHolder(val binding: ExamCardBinding): RecyclerView.ViewHolder(binding.root) {

    }
}