package com.tcc.andrius.tccapk.ui.event.openEvent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.adapters.ScheduleAdapter
import com.tcc.andrius.tccapk.models.Event
import com.tcc.andrius.tccapk.models.Item
import kotlinx.android.synthetic.main.activity_schedule.*


/**
 * Created by Andrius on 08/04/2018.
 */
class ScheduleActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        var event = intent.getSerializableExtra("event") as Event
        val type = intent.getSerializableExtra("type") as String

        supportActionBar?.title = type


        var itens = ArrayList<Item>()
        for (item: Item in event.itens!!) {
            if(item.type.equals(type))
                itens.add(item)
        }

        event.itens = itens

        val mPagerAdapter = ScheduleAdapter(supportFragmentManager, event)
        viewpager_schedule.adapter = mPagerAdapter
        tab_schedule.setupWithViewPager(viewpager_schedule)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}