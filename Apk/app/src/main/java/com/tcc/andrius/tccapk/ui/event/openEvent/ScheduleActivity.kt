package com.tcc.andrius.tccapk.ui.event.openEvent

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.R.color.white
import com.tcc.andrius.tccapk.adapters.ScheduleAdapter
import com.tcc.andrius.tccapk.models.Event
import com.tcc.andrius.tccapk.models.Item
import kotlinx.android.synthetic.main.activity_schedule.*
import android.support.annotation.NonNull
import android.view.View
import android.widget.Button
import me.toptas.fancyshowcase.OnViewInflateListener
import me.toptas.fancyshowcase.FancyShowCaseView




/**
 * Created by Andrius on 08/04/2018.
 */
class ScheduleActivity : AppCompatActivity()  {

    lateinit var fancyShowCaseView: FancyShowCaseView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        val event = intent.getSerializableExtra("event") as Event
        val type = intent.getSerializableExtra("type") as String

        toolbar.title = type
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { this.onBackPressed() }
        toolbar.setTitleTextColor(resources.getColor(white))


        val itens = ArrayList<Item>()
        for (item: Item in event.takeItens()!!) {
            if(item.type.equals(type))
                itens.add(item)
        }

        val mPagerAdapter = ScheduleAdapter(supportFragmentManager, event, itens)
        viewpager_schedule.adapter = mPagerAdapter
        tab_schedule.setupWithViewPager(viewpager_schedule)

        fancyShowCaseView = FancyShowCaseView.Builder(this)
                .customView(R.layout.showcase_screen) {
                    it.findViewById<Button>(R.id.btn_close).setOnClickListener(mClickListener)
                }
                .closeOnTouch(false)
                .showOnce("0003")
                .build()

        fancyShowCaseView.show()
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

    var mClickListener: View.OnClickListener = View.OnClickListener {
        fancyShowCaseView.hide()
    }

}