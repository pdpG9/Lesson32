package com.example.lesson32.adapters

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson32.R
import com.example.lesson32.models.GroupData
import kotlinx.android.synthetic.main.item_group.view.*

class DeleteDialogAdapter(val data:ArrayList<GroupData>):
    RecyclerView.Adapter<DeleteDialogAdapter.DeleteViewHolder>(){

    private var listener:ItemClick<Int>? = null

    fun setOnItemClickListener(f:ItemClick<Int>?){
        Log.d("TTT", "listener = f")
        listener = f
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DeleteViewHolder(parent.inflater(R.layout.item_group))

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: DeleteViewHolder, position: Int)  = holder.bind()


    inner class DeleteViewHolder(view: View):RecyclerView.ViewHolder(view){

        init {
            Log.d("TTT", "setOnItemClickListener { listener?.invoke(adapterPosition)")
           view.setOnClickListener {
               setOnItemClickListener { listener?.invoke(adapterPosition) }
           }
        }
        fun bind(){
            val d = data[adapterPosition]
            itemView.apply {

              DeleteGroupTitle.text = d.title
            }

        }
    }
}