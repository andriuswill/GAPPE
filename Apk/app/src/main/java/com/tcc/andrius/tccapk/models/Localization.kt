package com.tcc.andrius.tccapk.models

import com.google.firebase.database.IgnoreExtraProperties
import java.io.Serializable

/**
 * Created by Andrius on 15/04/2018.
 */
@IgnoreExtraProperties
class Localization : Serializable {

    var latitude : Double? = null
    var longitude : Double? = null

    constructor (latitude : Double,  longitude : Double){
        this.latitude = latitude
        this.longitude = longitude
    }

    constructor ()
}