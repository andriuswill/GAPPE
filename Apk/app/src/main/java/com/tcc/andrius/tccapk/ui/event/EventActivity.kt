package com.tcc.andrius.tccapk.ui.event

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.models.Event
import com.tcc.andrius.tccapk.ui.event.openEvent.*
import kotlinx.android.synthetic.main.activity_event.*
import com.tcc.andrius.tccapk.R.id.*
import kotlinx.android.synthetic.main.showcase_screen.view.*
import me.toptas.fancyshowcase.FancyShowCaseQueue
import me.toptas.fancyshowcase.FancyShowCaseView
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig





class EventActivity : AppCompatActivity() {

    lateinit var event : Event
    private var fancyShowCaseQueue: FancyShowCaseQueue? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        event = intent.getSerializableExtra("event") as Event

        toolbar.title = event.name
        toolbar.navigationIcon = ContextCompat.getDrawable(this, R.drawable.ic_arrow_back)
        toolbar.setNavigationOnClickListener { this.onBackPressed() }
        toolbar.setTitleTextColor(resources.getColor(R.color.white))


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        supportFragmentManager.beginTransaction().replace(R.id.main_container, HomeFragment.newInstance(event)).commit()

        val fancyShowCaseView1 = FancyShowCaseView.Builder(this)
                .title("Third Queue Item")

                .customView(R.layout.showcase_screen) { view ->
                    kotlin.run {
                        view.text_description.text = "Favorite atividades par receber notificações sobre elas."
                        view.btn_close.setOnClickListener(mClickListener)
                    }
                }
                .closeOnTouch(false)
                .build()

        fancyShowCaseQueue = FancyShowCaseQueue().add(fancyShowCaseView1)
        fancyShowCaseQueue!!.show()

    }

    var mClickListener: View.OnClickListener = View.OnClickListener {
        fancyShowCaseQueue?.cancel(true)
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_container, HomeFragment.newInstance(event)).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_schedule -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_container, TypesFragments.newInstance(event)).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_agenda -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_container, AgendaFragment.newInstance(event)).commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_map -> {
                supportFragmentManager.beginTransaction().replace(R.id.main_container, MapFragment.newInstance(event.map)).commit()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

}
