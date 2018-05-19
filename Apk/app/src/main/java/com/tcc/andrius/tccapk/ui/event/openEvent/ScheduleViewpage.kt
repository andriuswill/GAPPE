package com.tcc.andrius.tccapk.ui.event.openEvent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.adapters.ItensScheduleAdapter
import com.tcc.andrius.tccapk.models.Item
import kotlinx.android.synthetic.main.viewpage_schedule.view.*

/**
 * Created by Andrius on 08/04/2018.
 */
class ScheduleViewpage : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.viewpage_schedule, container, false)

        val itens = arguments.getSerializable("itens") as ArrayList<Item>

        if (itens.isNotEmpty()) {
            var adapter = ItensScheduleAdapter(context)
            view.recyclerview_itens.setHasFixedSize(true)
            view.recyclerview_itens.layoutManager = LinearLayoutManager(context)
            view.recyclerview_itens.adapter = adapter
            adapter.updateList(itens)
        } else{
            view.text_error.visibility = View.VISIBLE
        }

        return view
    }

    companion object {
        fun newInstance(itens: ArrayList<Item>): ScheduleViewpage {
            val fragment = ScheduleViewpage()
            val args = Bundle()
            args.putSerializable("itens", itens)
            fragment.arguments = args
            return fragment
        }
    }

}