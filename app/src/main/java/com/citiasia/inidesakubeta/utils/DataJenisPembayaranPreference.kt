package com.citiasia.inidesakubeta.utils

import android.content.Context

class DataJenisPembayaranPreference(context: Context) {

    private val preference = context.getSharedPreferences("pulsa_data", Context.MODE_PRIVATE)

    fun saveData(jenis: String, nominal: String, harga: String) {
        val editor = preference.edit()
        editor.putString("jenis", jenis)
        editor.putString("nominal", nominal)
        editor.putString("harga", harga)
        editor.apply()
    }

    fun getData() : List<String?> {
        val jenis = preference.getString("jenis", "")
        val nominal = preference.getString("nominal", "")
        val harga = preference.getString("harga", "")

        val data = listOf<String?>(jenis, nominal, harga)
        return data
    }

    fun removeData() {
        var editor = preference.edit()
        editor.remove("jenis")
        editor.remove("nominal")
        editor.remove("harga")
        editor.apply()
    }

}