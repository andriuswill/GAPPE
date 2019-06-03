package com.tcc.andrius.tccapk.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Andrius on 15/04/2018.
 */
class CustomDateUtils{
    companion object {
        fun getDateTimeFromString(text: String):Date{
            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm")
            return simpleDateFormat.parse(text)
        }

        fun getFormatedDate(date: Date?, format: String): String {
            val simpleDateFormat = SimpleDateFormat(format)
            return simpleDateFormat.format(date)
        }

        fun isSameDay(date1: Date?, date2: Date?): Boolean {
            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
            return simpleDateFormat.format(date1) == simpleDateFormat.format(date2)
        }
    }
}