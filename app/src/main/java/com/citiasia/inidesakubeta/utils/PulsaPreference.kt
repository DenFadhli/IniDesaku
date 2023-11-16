package com.citiasia.inidesakubeta.utils

import android.content.Context
import com.citiasia.inidesakubeta.model.PulsaDataInput

class PulsaPreference(context: Context) {

    private val preference = context.getSharedPreferences("pulsa_data", Context.MODE_PRIVATE)

    fun saveData(data: PulsaDataInput) {
        val editor = preference.edit()
        editor.putString("number", data.number)
        editor.putString("provider", data.provider)
        editor.apply()
    }

    fun getData() : PulsaDataInput {
        val number = preference.getString("number", "")
        val provider = preference.getString("provider", "")

        val data = PulsaDataInput(number, provider)
        return data
    }

    fun removeData() {
        var editor = preference.edit()
        editor.remove("number")
        editor.remove("provider")
        editor.apply()
    }

}