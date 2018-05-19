package com.tcc.andrius.tccapk.ui.event.openEvent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.adapters.ItensAgendaAdapter
import com.tcc.andrius.tccapk.models.Item
import com.tcc.andrius.tccapk.utils.CustomDateUtils
import com.tcc.andrius.tccapk.utils.SharedPreferencesUtils
import kotlinx.android.synthetic.main.viewpage_schedule.view.*

/**
 * Created by Andrius on 18/04/2018.
 */
class AgendaViewpage : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.viewpage_schedule, container, false)

        var itens = arguments.getSerializable("itens") as ArrayList<Item>
        itens = itens.filter { s: Item -> SharedPreferencesUtils.hasItem(s.name + CustomDateUtils.getFormatedDate(s.date, "ddMMyyyyHHmm"), context) } as ArrayList


        if (itens.isNotEmpty()) {
            var adapter = ItensAgendaAdapter(context)
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
        fun newInstance(itens: ArrayList<Item>): AgendaViewpage {
            val fragment = AgendaViewpage()
            val args = Bundle()
            args.putSerializable("itens", itens)
            fragment.arguments = args
            return fragment
        }
    }

}