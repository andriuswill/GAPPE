package com.tcc.andrius.tccapk.ui.event.openEvent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.adapters.ItensScheduleAdapter
import com.tcc.andrius.tccapk.adapters.TypesAdapters
import com.tcc.andrius.tccapk.models.Event
import com.tcc.andrius.tccapk.models.Item
import kotlinx.android.synthetic.main.fragment_types.view.*
import kotlinx.android.synthetic.main.viewpage_schedule.view.*

/**
 * Created by Andrius on 07/05/2018.
 */
class TypesFragments : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_types, container, false)

        val event = arguments.getSerializable("event") as Event
        var types = ArrayList<String>()

        for (item: Item in event.itens!!) {
            if(!types.contains(item.type))
                item.type?.let { types.add(it) }
        }

        if (types.isNotEmpty()) {
            var adapter = TypesAdapters(event, types, context)
            view.recyclerview_types.setHasFixedSize(true)
            view.recyclerview_types.layoutManager = LinearLayoutManager(context)
            view.recyclerview_types.adapter = adapter
        } else{
            //view.text_error.visibility = View.VISIBLE
        }

        return view
    }

    companion object {
        fun newInstance(event: Event): TypesFragments {
            val fragment = TypesFragments()
            val args = Bundle()
            args.putSerializable("event", event)
            fragment.arguments = args
            return fragment
        }
    }

}