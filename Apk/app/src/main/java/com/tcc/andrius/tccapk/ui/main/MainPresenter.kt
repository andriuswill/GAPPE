package com.tcc.andrius.tccapk.ui.main

import android.content.Context
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.tcc.andrius.tccapk.models.*
import com.tcc.andrius.tccapk.network.OnesignalService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Andrius on 08/04/2018.
 */
class MainPresenter(private val mContext: Context, val mView: MainContract.View) : MainContract.Presenter {

    override fun getEvents() {
        /*val type = object : TypeToken<ArrayList<Event>>() {}.type
        val events = Storo.get<ArrayList<Event>>("events", type).execute()*/

        var events = ArrayList<Event>()

        var database = FirebaseDatabase.getInstance()
        var myRef = database.getReference("events")

        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                events.clear()
                if (dataSnapshot.exists()) {
                    for (postSnapshot in dataSnapshot.children) {
                        val event = postSnapshot.getValue<Event>(Event::class.java)
                        if (event != null) {
                            events.add(event)
                        }
                    }
                    if(events.isNotEmpty())
                        mView.showEvents(events)
                    else
                        mView.showErrorMessage("Nenhum evento encontrado")
                } else {
                    mView.showErrorMessage("Nenhum evento encontrado")
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                mView.showErrorMessage("Falha ao se comunicar com servidor.")
            }
        })

    }

    override fun createNotification(time: String){
        val retrofit = Retrofit.Builder()
                .baseUrl("https://onesignal.com/api/v1/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        var included_segments = ArrayList<String>()
        included_segments.add("All")
        var notification = Notification("d74d5747-1648-4918-b00b-2a108cc9a7fc", Content("Notificação teste"), included_segments,  time , Data("teste"))

        val service = retrofit.create(OnesignalService::class.java)
        val serviceCall = service.createNotification(notification)

        serviceCall.enqueue(object : Callback<NotificationResponse>{
            override fun onResponse(call: Call<NotificationResponse>?, response: Response<NotificationResponse>?) {
               Log.d("ninja","onResponse")
            }

            override fun onFailure(call: Call<NotificationResponse>?, t: Throwable?) {
                Log.d("ninja","onFailure")
            }
        })

    }

}