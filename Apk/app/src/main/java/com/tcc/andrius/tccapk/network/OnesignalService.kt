package com.tcc.andrius.tccapk.network

import com.tcc.andrius.tccapk.models.Notification
import com.tcc.andrius.tccapk.models.NotificationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by Andrius on 14/05/2018.
 */
interface OnesignalService {

    @Headers( "Content-Type: application/json", "Authorization: Basic OGE0ZTg2ZDUtMzM2My00OWI2LWJjNTMtNTIzZTQ2NmIyMDA0")
    @POST("notifications/")
    fun createNotification(@Body notification: Notification): Call<NotificationResponse>

}