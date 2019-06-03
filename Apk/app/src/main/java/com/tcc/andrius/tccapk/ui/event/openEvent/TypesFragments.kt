package com.tcc.andrius.tccapk.ui.event.openEvent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.adapters.ScheduleAdapter
import com.tcc.andrius.tccapk.adapters.TypesAdapters
import com.tcc.andrius.tccapk.models.Event
import com.tcc.andrius.tccapk.models.Item
import kotlinx.android.synthetic.main.fragment_types.view.*
import me.toptas.fancyshowcase.FancyShowCaseView

/**
 * Created by Andrius on 07/05/2018.
 */
class TypesFragments : Fragment() {

    lateinit var fancyShowCaseView: FancyShowCaseView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_types, container, false)

        val event = arguments.getSerializable("event") as Event
        var types = ArrayList<String>()

        for (item: Item in event.takeItens()!!) {
            if(!types.contains(item.type))
                item.type?.let { types.add(it) }
        }

        if (event.category!!) {
            if(event.takeItens().isEmpty()){
                view.text_error.visibility = View.VISIBLE
            } else {
                view.recyclerview_types.visibility = View.VISIBLE
                var adapter = TypesAdapters(event, types, context)
                view.recyclerview_types.setHasFixedSize(true)
                view.recyclerview_types.layoutManager = LinearLayoutManager(context)
                view.recyclerview_types.adapter = adapter
            }

        } else {
            view.tab_schedule.visibility = View.VISIBLE
            view.viewpager_schedule.visibility = View.VISIBLE
            val mPagerAdapter = ScheduleAdapter(fragmentManager, event, event.takeItens())
            view.viewpager_schedule.adapter = mPagerAdapter
            view.tab_schedule.setupWithViewPager(view.viewpager_schedule)

            fancyShowCaseView = FancyShowCaseView.Builder(activity)
                    .customView(R.layout.showcase_screen) {
                        it.findViewById<Button>(R.id.btn_close).setOnClickListener(mClickListener)
                    }
                    .closeOnTouch(false)
                    .showOnce("0006")
                    .build()

            fancyShowCaseView.show()
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

    var mClickListener: View.OnClickListener = View.OnClickListener {
        fancyShowCaseView.hide()
    }

}