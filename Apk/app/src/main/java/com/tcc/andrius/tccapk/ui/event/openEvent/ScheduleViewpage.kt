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
import me.toptas.fancyshowcase.FancyShowCaseView
import android.util.Log
import kotlinx.android.synthetic.main.showcase_screen.view.*
import me.toptas.fancyshowcase.FancyShowCaseQueue


/**
 * Created by Andrius on 08/04/2018.
 */
class ScheduleViewpage : Fragment() {

    private var fancyShowCaseQueue: FancyShowCaseQueue? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.viewpage_schedule, container, false)

        val itens = arguments.getSerializable("itens") as ArrayList<Item>

        if (itens.isNotEmpty()) {
            val sortedItens = ArrayList<Item>(itens.sortedWith(compareBy({ it.time }, { it.name })))
            var adapter = ItensScheduleAdapter(context,sortedItens)
            view.recyclerview_itens.setHasFixedSize(true)
            view.recyclerview_itens.layoutManager = LinearLayoutManager(context)
            view.recyclerview_itens.adapter = adapter


        } else {
            view.text_error.visibility = View.VISIBLE
        }

        return view
    }

    var mClickListener: View.OnClickListener = View.OnClickListener {
        fancyShowCaseQueue?.cancel(true)
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