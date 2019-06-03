package com.tcc.andrius.tccapk.ui.event.openEvent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.adapters.AgendaAdapter
import com.tcc.andrius.tccapk.models.Event
import kotlinx.android.synthetic.main.fragment_agenda.view.*

/**
 * Created by Andrius on 08/04/2018.
 */
class AgendaFragment : Fragment()  {

    lateinit var mPagerAdapter: AgendaAdapter


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_agenda, container, false)

        val event = arguments.getSerializable("event") as Event

        mPagerAdapter = AgendaAdapter(fragmentManager, event)
        view.viewpager_agenda.adapter = mPagerAdapter
        view.tab_agenda.setupWithViewPager(view.viewpager_agenda)

        return  view
    }

    companion object {
        fun newInstance(event: Event): AgendaFragment {
            val fragment = AgendaFragment()
            val args = Bundle()
            args.putSerializable("event", event)
            fragment.arguments = args
            return fragment
        }
    }
}