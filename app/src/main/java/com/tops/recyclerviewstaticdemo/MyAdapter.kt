package com.tops.recyclerviewstaticdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tops.recyclerviewstaticdemo.databinding.ExamCardBinding
import com.tops.recyclerviewstaticdemo.model.Person


class MyAdapter(private val personList: List<Person>) : RecyclerView.Adapter<MyAdapter.ExamViewHolder>(){

    private var onClickListener: OnClickListener? = null


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
        val ExamItem = personList[position]
        holder.binding.cardName.text = ExamItem.name
        holder.binding.cardAge.text = ExamItem.age.toString()
        holder.binding.imageCard.setImageResource(ExamItem.pic!!)


        // Set click listener for the item view
        holder.itemView.setOnClickListener {
            onClickListener?.onClick(position, ExamItem)
        }
    }

    override fun getItemCount(): Int {
     return personList.size
    }

    // Set the click listener for the adapter
    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    // Interface for the click listener
    interface OnClickListener {
        fun onClick(position: Int, model: Person)
    }

    class ExamViewHolder(val binding: ExamCardBinding): RecyclerView.ViewHolder(binding.root) {

    }
}