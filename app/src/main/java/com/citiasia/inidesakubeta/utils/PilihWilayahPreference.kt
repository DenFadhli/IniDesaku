package com.citiasia.inidesakubeta.utils

import android.content.Context
import com.citiasia.inidesakubeta.data.remote.model.PilihWilayahModel

class PilihWilayahPreference(context: Context) {

    private val preference = context.getSharedPreferences("pilih_wilayah", Context.MODE_PRIVATE)

    fun saveData(data: PilihWilayahModel) {
        val editor = preference.edit()
        editor.putString("provinsi", data.provinsi)
        editor.putString("kota_kabupaten", data.kotaKabupaten)
        editor.putString("kecamatan", data.kecamatan)
        editor.putString("desa_kelurahan", data.desaKelurahan)
        editor.apply()
    }

    fun getData() : PilihWilayahModel {
        val provinsi = preference.getString("provinsi", "")
        val kotaKabupaten = preference.getString("kota_kabupaten", "")
        val kecamatan = preference.getString("kecamatan", "")
        val desaKelurahan = preference.getString("desa_kelurahan", "")

        val data = PilihWilayahModel(provinsi, kotaKabupaten, kecamatan, desaKelurahan)
        return data
    }

    fun removeData() {
        var editor = preference.edit()
        editor.remove("provinsi")
        editor.remove("kota_kabupaten")
        editor.remove("kecamatan")
        editor.remove("desa_kelurahan")
        editor.apply()
    }

}