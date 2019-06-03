package com.tcc.andrius.tccapk.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.tcc.andrius.tccapk.models.Event
import com.tcc.andrius.tccapk.models.Item
import com.tcc.andrius.tccapk.ui.event.openEvent.AgendaViewpage
import com.tcc.andrius.tccapk.utils.CustomDateUtils
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Andrius on 18/04/2018.
 */
class AgendaAdapter(fm: FragmentManager, val event: Event) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var itens = ArrayList<Item>()

        var eventDate = Calendar.getInstance()
        eventDate.time = event.takeDateInit()
        eventDate.add(Calendar.DATE, position)

        for (item: Item in event.takeItens()) {
            if(CustomDateUtils.isSameDay(eventDate.time,item.takeDate()))
                itens.add(item)
        }

        return AgendaViewpage.newInstance(itens)
    }

    override fun getCount(): Int {
        val diff = event.takeDateEnd()!!.time - event.takeDateInit()!!.time
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS).toInt() + 1
    }

    override fun getPageTitle(position: Int): CharSequence {
        val c = Calendar.getInstance()
        c.time = event.takeDateInit()
        c.add(Calendar.DATE, position)
        val sdf = SimpleDateFormat("dd/MM")
        return CustomDateUtils.getFormatedDate(c.time,"dd/MM")
    }
}