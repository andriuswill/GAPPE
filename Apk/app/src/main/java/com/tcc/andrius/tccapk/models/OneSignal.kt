package com.tcc.andrius.tccapk.models

import android.content.Context
import android.util.Log
import com.onesignal.OSNotification
import com.onesignal.OneSignal
import com.onesignal.NotificationExtenderService
import com.onesignal.OSNotificationReceivedResult
import com.tcc.andrius.tccapk.utils.SharedPreferencesUtils


/**
 * Created by Andrius on 14/05/2018.
 */

data class Notification(var app_id: String, var contents: Content, var included_segments: List<String>, var send_after: String, val data: Data)
data class Content(var en: String)
data class NotificationResponse(var id:String, var recipients:Int )
data class Data(var tag: String)

class NotificationReceivedHandler(val context: Context) : OneSignal.NotificationReceivedHandler {
    override fun notificationReceived(notification: OSNotification?) {

    }
}

class NotificationExtender : NotificationExtenderService() {
     override fun onNotificationProcessing(notification: OSNotificationReceivedResult?): Boolean {
         val data = notification?.payload?.additionalData!!["tag"] as String
         return !SharedPreferencesUtils.hasItem(data, applicationContext)
    }
}
