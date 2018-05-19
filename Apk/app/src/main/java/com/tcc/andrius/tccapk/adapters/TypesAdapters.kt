package com.tcc.andrius.tccapk.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.models.Event
import com.tcc.andrius.tccapk.ui.event.openEvent.ScheduleActivity
import kotlinx.android.synthetic.main.item_type.view.*
import org.jetbrains.anko.startActivity

/**
 * Created by Andrius on 07/05/2018.
 */
class TypesAdapters(val event: Event, val types: ArrayList<String>, val context: Context) : RecyclerView.Adapter<TypesAdapters.TypesViewHolder>() {

    override fun onBindViewHolder(holder: TypesViewHolder?, position: Int) {
        holder?.bindItens(types[position], event, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TypesViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_type, parent, false)
        return TypesViewHolder(view)
    }

    override fun getItemCount(): Int = types.size

    class TypesViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindItens(type : String, event: Event, context: Context) {
            itemView.text_type.text = type
            itemView.cart_type.setOnClickListener {
                context.startActivity<ScheduleActivity>("event" to event, "type" to type)
            }
        }
    }
}