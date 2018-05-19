package com.tcc.andrius.tccapk.utils

import android.util.Log
import com.google.gson.reflect.TypeToken
import st.lowlevel.storo.Storo
import st.lowlevel.storo.model.Callback

/**
 * Created by Andrius on 16/04/2018.
 */
class StoroUtils {
    companion object {
        fun putItem(name: String) {
            var itens = retrieve()
            itens.add(name)
            Storo.put("itens",itens).execute()
        }

        fun removeItem(name: String) {
            var itens = retrieve()
            itens.remove(name)
            Storo.put("itens",itens).execute()
        }

        fun retrieve():ArrayList<String>{
            return if(Storo.contains("itens")) {
                val type = object : TypeToken<ArrayList<String>>() {}.type
                Storo.get<ArrayList<String>>("itens", type).execute()
            } else ArrayList()

        }

        fun hasItem(name: String):Boolean{
            var itens = retrieve()
            return (itens.contains(name))
        }

        fun show(){
            if(Storo.contains("itens")) {
                val type = object : TypeToken<ArrayList<String>>() {}.type
                val list = Storo.get<ArrayList<String>>("itens", type).execute()
                Log.d("ninja", list.toString())
            } else  Log.d("ninja","null")
        }
    }
}