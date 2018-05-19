package com.tcc.andrius.tccapk.models

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable
import java.util.*

/**
 * Created by Andrius on 15/04/2018.
 */
@IgnoreExtraProperties
class Event : Serializable {

    var id: String? = null
    var name: String? = null
    var dateInit: Date? = null
    var dateEnd: Date? = null
    var description: String? = null
    var map: String? = null
    var adress: String? = null
    var localization: Localization? = null
    var itens: ArrayList<Item>? = null

    constructor(id: String,
                name: String,
                dateInit: Date,
                dateEnd: Date,
                description: String,
                map: String,
                adress: String,
                localization: Localization,
                itens: ArrayList<Item>) {
        this.id = id
        this.name = name
        this.dateInit = dateInit
        this.dateEnd = dateEnd
        this.description = description
        this.map = map
        this.adress = adress
        this.localization = localization
        this.itens = itens
    }

    constructor()
}