package com.tcc.andrius.tccapk.ui.event

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.models.Event
import com.tcc.andrius.tccapk.ui.event.openEvent.*
import kotlinx.android.synthetic.main.activity_event.*


class EventActivity : AppCompatActivity() {

    lateinit var event : Event

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        event = intent.getSerializableExtra("event") as Event
        supportActionBar?.title = event.name

        supportFragmentManager.beginTransaction().replace(R.id.main_container, HomeFragment.newInstance(event)).commit()

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
