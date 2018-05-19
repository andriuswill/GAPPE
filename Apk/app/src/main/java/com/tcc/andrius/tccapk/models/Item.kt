package com.tcc.andrius.tccapk.models

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable
import java.util.*

/**
 * Created by Andrius on 15/04/2018.
 */

@IgnoreExtraProperties
class Item : Serializable {

    var id: String? = null
    var name: String? = null
    var date: Date? = null
    var type: String? = null
    var speaker: String? = null
    var description: String? = null

    constructor(id: String,
                    name: String,
                    date: Date,
                    type: String,
                    speaker: String,
                    description: String) {
        this.id = id
        this.name = name
        this.date = date
        this.type = type
        this.speaker = speaker
        this.description = description
    }

    constructor()
}