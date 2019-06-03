package com.tcc.andrius.tccapk.models

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Andrius on 15/04/2018.
 */

@IgnoreExtraProperties
class Item : Serializable {
    var name: String? = null
    var date: String? = null
    var time: String? = null
    var type: String? = null
    var local: String? = null
    var speaker: String? = null
    var description: String? = null

    constructor(
                    name: String,
                    date: String,
                    time: String,
                    type: String,
                    local: String,
                    speaker: String,
                    description: String) {

        this.name = name
        this.date = date
        this.time = time
        this.type = type
        this.local = local
        this.speaker = speaker
        this.description = description
    }

    fun takeDate():Date{
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")
        return simpleDateFormat.parse(this.date + " " + this.time)
    }

    constructor()
}