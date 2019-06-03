package com.tcc.andrius.tccapk.utils

import android.app.PendingIntent.getActivity
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tcc.andrius.tccapk.models.Item
import java.util.*

/**
 * Created by Andrius on 18/04/2018.
 */
class SharedPreferencesUtils {
    companion object {

        fun putItem(name: String,context: Context) {
            var sharedPref = context.getSharedPreferences("agenda", Context.MODE_PRIVATE)
            var editor = sharedPref.edit()
            val turnsType = object : TypeToken<List<String>>() {}.type
            var itens = Gson().fromJson<List<String>>(sharedPref.getString("itens", null), turnsType) as? ArrayList
            if (itens == null) itens = ArrayList()
            itens?.add(name)
            editor.putString("itens", Gson().toJson(itens)).commit()

        }

        fun removeItem(name: String, context: Context) {
            var sharedPref = context.getSharedPreferences("agenda", Context.MODE_PRIVATE)
            var editor = sharedPref.edit()
            val turnsType = object : TypeToken<List<String>>() {}.type
            var itens = Gson().fromJson<List<String>>(sharedPref.getString("itens", null), turnsType) as? ArrayList
            if (itens == null) itens = ArrayList()
            itens?.removeAll(Collections.singleton(name))
            editor.putString("itens", Gson().toJson(itens)).commit()
        }

        fun hasItem(name: String, context: Context):Boolean{
            var sharedPref = context.getSharedPreferences("agenda", Context.MODE_PRIVATE)
            val turnsType = object : TypeToken<List<String>>() {}.type
            var itens = Gson().fromJson<List<String>>(sharedPref.getString("itens", null), turnsType) as? ArrayList
            if (itens == null)
                return false
            else
                return(itens.contains(name))

        }

        fun show(context: Context){
            var sharedPref = context.getSharedPreferences("agenda", Context.MODE_PRIVATE)
            val turnsType = object : TypeToken<List<String>>() {}.type
            var itens = Gson().fromJson<List<String>>(sharedPref.getString("itens", null), turnsType) as? ArrayList
        }

        fun clear(context: Context){
            var sharedPref = context.getSharedPreferences("agenda", Context.MODE_PRIVATE)
            var editor = sharedPref.edit()
            editor.clear().commit()
        }
    }
}