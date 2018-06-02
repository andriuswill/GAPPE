package com.tcc.andrius.tccapk.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import com.tcc.andrius.tccapk.R
import com.tcc.andrius.tccapk.adapters.EventsAdapter
import com.tcc.andrius.tccapk.models.Event
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    lateinit var mAdapter : EventsAdapter
    lateinit var mProgressBar : ProgressBar
    lateinit var mRecyclerviewEvents : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = "GAppE"

        mProgressBar = progressbar
        mRecyclerviewEvents = recyclerview_events
        mAdapter = EventsAdapter(this)
        toolbar.setTitleTextColor(resources.getColor(R.color.white))


        mRecyclerviewEvents.setHasFixedSize(true)
        mRecyclerviewEvents.layoutManager = LinearLayoutManager(this)
        mRecyclerviewEvents.adapter = mAdapter


        MainPresenter(this, this).getEvents()


    }


    override fun showEvents(list: List<Event>) {
        mAdapter.updateList(ArrayList(list))
        mProgressBar.visibility = View.GONE
    }

    override fun showErrorMessage(text: String) {
        text_error.text = text
        text_error.visibility = View.GONE
        mProgressBar.visibility = View.GONE
    }

}
