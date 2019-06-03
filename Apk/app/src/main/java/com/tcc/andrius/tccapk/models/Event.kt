package com.tcc.andrius.tccapk.models

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Andrius on 15/04/2018.
 */
@IgnoreExtraProperties
class Event : Serializable {

    var name: String? = null
    var dateInit: String? = null
    var dateEnd: String? = null
    var description: String? = null
    var logo: String? = null
    var map: String? = null
    var adress: String? = null
    var localization: Localization? = null
    var activities: HashMap<String, Item>? = null
    var category: Boolean? = null
    var published: Boolean? = null

    constructor(
                name: String,
                dateInit: String,
                dateEnd: String,
                description: String,
                logo: String,
                map: String,
                adress: String,
                localization: Localization,
                activities:HashMap<String, Item>?,
                category: Boolean,
                published: Boolean) {

        this.name = name
        this.dateInit = dateInit
        this.dateEnd = dateEnd
        this.description = description
        this.logo = logo
        this.map = map
        this.adress = adress
        this.localization = localization
        this.activities = activities
        this.activities = activities
        this.category = category
        this.published = published
    }

    fun takeDateInit():Date{
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        return simpleDateFormat.parse(this.dateInit)
    }



    fun takeDateEnd():Date{
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        return simpleDateFormat.parse(this.dateEnd)
    }

    fun takeItens():ArrayList<Item>{
        var itens = ArrayList<Item>()
        if(this.activities != null)
            itens.addAll(this.activities!!.values)
        return itens
    }

    constructor()
}