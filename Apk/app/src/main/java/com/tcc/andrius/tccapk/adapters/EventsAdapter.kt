package com.tcc.andrius.tccapk.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.models.Event
import com.tcc.andrius.tccapk.ui.event.EventActivity
import kotlinx.android.synthetic.main.item_event.view.*
import org.jetbrains.anko.startActivity
import java.lang.Exception

/**
 * Created by Andrius on 08/04/2018.
 */

class EventsAdapter(val context : Context) : RecyclerView.Adapter<EventsAdapter.EventsViewHolder>() {

    var mList = arrayListOf<Event>()

    fun updateList(listEvents : ArrayList<Event>){
        mList = listEvents
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: EventsViewHolder?, position: Int) {
        holder?.bindEvents(mList[position], context, position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EventsViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_event, parent, false)
        return EventsViewHolder(view)
    }

    override fun getItemCount(): Int = mList.size

    class EventsViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindEvents(event : Event, context: Context, position: Int) {
           // val url =  "https://firebasestorage.googleapis.com/v0/b/tcc-ifrs.appspot.com/o/logo.jpg?alt=media&token=74ed1d6f-416f-42e3-b7d2-4d9886934391"
            Picasso.get().load(event.logo).fit()
                    .error(R.drawable.default_image)
                    .into(itemView.img_logo, object : Callback {
                        override fun onSuccess() {
                            itemView.loader.visibility = View.GONE
                        }

                        override fun onError(e: Exception?) {

                        }

                    })

            itemView.card_event.setOnClickListener {
                context.startActivity<EventActivity>("event" to event)
            }
        }
    }
}