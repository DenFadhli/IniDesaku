package com.citiasia.inidesakubeta.data.remote.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class LoginResponse(

	@field:SerializedName("data")
	val data: Data,

	@field:SerializedName("error")
	val error: Boolean,

	@field:SerializedName("message")
	val message: String
) : Parcelable


@Parcelize
data class Data(

	@field:SerializedName("nama_ibu")
	val namaIbu: String,

	@field:SerializedName("nama_provinsi")
	val namaProvinsi: String,

	@field:SerializedName("api_token")
	val apiToken: String,

	@field:SerializedName("kode_referal")
	val kodeReferal: String? = null,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("kartu_nomor")
	val kartuNomor: String,

	@field:SerializedName("cimb_va")
	val cimbVa: String,

	@field:SerializedName("gv_saldo")
	val gvSaldo: Int,

	@field:SerializedName("bca_va")
	val bcaVa: String,

	@field:SerializedName("tempat_lahir")
	val tempatLahir: String,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("kode_kota")
	val kodeKota: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("jenis_kelamin")
	val jenisKelamin: String,

	@field:SerializedName("kode_provinsi")
	val kodeProvinsi: String,

	@field:SerializedName("kartu_tipe")
	val kartuTipe: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("tanggal_lahir")
	val tanggalLahir: String,

	@field:SerializedName("user_level_id")
	val userLevelId: Int,

	@field:SerializedName("nama_kelurahan")
	val namaKelurahan: String,

	@field:SerializedName("is_active")
	val isActive: Int,

	@field:SerializedName("ktp")
	val ktp: String,

	@field:SerializedName("permata_va")
	val permataVa: String,

	@field:SerializedName("kode_kecamatan")
	val kodeKecamatan: String,

	@field:SerializedName("firebase_token")
	val firebaseToken: String? = null,

	@field:SerializedName("created_by")
	val createdBy: String? = null,

	@field:SerializedName("is_verified")
	val isVerified: Int,

	@field:SerializedName("gv_connect_key")
	val gvConnectKey: String,

	@field:SerializedName("alamat")
	val alamat: String,

	@field:SerializedName("nama_kecamatan")
	val namaKecamatan: String,

	@field:SerializedName("warga_negara")
	val wargaNegara: String,

	@field:SerializedName("user_level_name")
	val userLevelName: String,

	@field:SerializedName("nama")
	val nama: String,

	@field:SerializedName("foto")
	val foto: String,

	@field:SerializedName("phone")
	val phone: String,

	@field:SerializedName("bni_va")
	val bniVa: String,

	@field:SerializedName("updated_by")
	val updatedBy: String? = null,

	@field:SerializedName("kode_kelurahan")
	val kodeKelurahan: String,

	@field:SerializedName("bersama_va")
	val bersamaVa: String,

	@field:SerializedName("tanda_tangan")
	val tandaTangan: String,

	@field:SerializedName("pekerjaan_id")
	val pekerjaanId: Int,

	@field:SerializedName("nama_kota")
	val namaKota: String,

	@field:SerializedName("username")
	val username: String
) : Parcelable
