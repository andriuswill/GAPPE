package com.tcc.andrius.tccapk.ui.main

import com.tcc.andrius.tccapk.models.Event

/**
 * Created by Andrius on 08/04/2018.
 */
interface MainContract {
    interface View {
        fun showEvents(list : List<Event>)
        fun showErrorMessage(area :String)
    }

    interface Presenter {
        fun getEvents()
    }
}