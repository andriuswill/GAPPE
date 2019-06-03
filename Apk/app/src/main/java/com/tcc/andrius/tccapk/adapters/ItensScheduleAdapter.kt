package com.tcc.andrius.tccapk.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.models.Item
import com.tcc.andrius.tccapk.ui.event.openEvent.ItemActivity
import com.tcc.andrius.tccapk.utils.CustomDateUtils
import com.tcc.andrius.tccapk.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.item_schedule.view.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


/**
 * Created by Andrius on 15/04/2018.
 */
class ItensScheduleAdapter(val context : Context, val mList :ArrayList<Item>) : RecyclerView.Adapter<ItensScheduleAdapter.ItensViewHolder>() {

    /*var mList = arrayListOf<Item>()

    fun updateList(listItens : ArrayList<Item>){
        listItens.sortBy { it.date }
        mList = listItens
        notifyDataSetChanged()
    }*/

    override fun onBindViewHolder(holder: ItensViewHolder?, position: Int) {
        holder?.bindItens(mList[position], context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItensViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_schedule, parent, false)
        return ItensViewHolder(view)
    }

    override fun getItemCount(): Int = mList.size

    class ItensViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindItens(item : Item, context: Context) {

            var textDate = CustomDateUtils.getFormatedDate(item.takeDate(), "ddMMyyyyHHmm")
            itemView.text_name.text = item.name
            itemView.text_local.text = "Local: " + item.speaker
            itemView.text_time.text = CustomDateUtils.getFormatedDate(item.takeDate(), "HH:mm")
            itemView.toggleButton.isChecked = SharedPreferencesUtils.hasItem(item.name + textDate, context)
            itemView.toggleButton.setOnClickListener {
                if(itemView.toggleButton.isChecked){
                    context.toast("Atividade adicionada aos favoritos")
                    SharedPreferencesUtils.putItem(item.name + textDate, context)
                    SharedPreferencesUtils.show(context)
                } else {
                    context.toast("Atividade removida aos favoritos")
                    SharedPreferencesUtils.removeItem(item.name + textDate, context)
                    SharedPreferencesUtils.show(context)
                }
            }

            /*itemView.card_item.setOnClickListener {
                context.startActivity<ItemActivity>("item" to item)
            }*/

        }
    }
}

