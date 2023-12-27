package com.citiasia.inidesakubeta.utils

import android.content.Context
import com.citiasia.inidesakubeta.data.remote.model.DonasiInput

class DonasiPreference(context: Context) {
    private val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun saveData(data: DonasiInput){
        val edit = preference.edit()
        edit.putString(VALUE_TOTAL, data.total)
        edit.apply()
    }

    fun getData() : DonasiInput {
        val total = preference.getString(VALUE_TOTAL, null)
        return DonasiInput(total)
    }

    fun clearData() {
        val edit = preference.edit()
        edit.remove(VALUE_TOTAL)
        edit.apply()
    }

    companion object{
        private const val PREFERENCE_NAME = "DonasiPreference"
        private const val VALUE_TOTAL = "total"
    }
}