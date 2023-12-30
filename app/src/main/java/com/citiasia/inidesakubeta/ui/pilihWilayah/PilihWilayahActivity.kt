package com.citiasia.inidesakubeta.ui.pilihWilayah

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.citiasia.inidesakubeta.R
import com.citiasia.inidesakubeta.data.remote.model.PilihWilayahModel
import com.citiasia.inidesakubeta.databinding.ActivityPilihWilayahBinding
import com.citiasia.inidesakubeta.ui.HomeActivity
import com.citiasia.inidesakubeta.utils.PilihWilayahPreference

class PilihWilayahActivity : AppCompatActivity() {

    private var _binding: ActivityPilihWilayahBinding? = null
    private val binding get() = _binding!!

    private lateinit var pref: PilihWilayahPreference
    private var selectedProvinsi: String = ""
    private var selectedKota: String = ""
    private var selectedKecamatan: String = ""
    private var selectedKelurahan: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPilihWilayahBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        pref = PilihWilayahPreference(this)

        val provinsiItems = resources.getStringArray(R.array.provinsi_items)
        val kotaMap = mapOf(
            "DKI Jakarta" to resources.getStringArray(R.array.kota_kabupaten_jakarta_items),
            "Jawa Barat" to resources.getStringArray(R.array.kota_kabupaten_jawabarat_items),
            "Jawa Tengah" to resources.getStringArray(R.array.kota_kabupaten_jawatengah_items),
            "Jawa Timur" to resources.getStringArray(R.array.kota_kabupaten_jawatimur_items),
        )
        val kecamatanMap = mapOf(
            "Kabupaten Administrasi Kepulauan Seribu" to resources.getStringArray(R.array.kecamatan_kepulauan_seribu_items),
            "Kota Administrasi Jakarta Barat" to resources.getStringArray(R.array.kecamatan_jakarta_barat_items),
            "Kota Administrasi Jakarta Pusat" to resources.getStringArray(R.array.kecamatan_jakarta_pusat_items),
            "Kota Administrasi Jakarta Selatan" to resources.getStringArray(R.array.kecamatan_jakarta_selatan_items),
            "Kota Administrasi Jakarta Timur" to resources.getStringArray(R.array.kecamatan_jakarta_timur_items),
            "Kota Administrasi Jakarta Utara" to resources.getStringArray(R.array.kecamatan_jakarta_utara_items),
            "Kota Bandung" to resources.getStringArray(R.array.kecamatan_jawabarat_kota_bandung_items),
            "Kota Bekasi" to resources.getStringArray(R.array.kecamatan_jawabarat_kota_bekasi_items),
            "Kabupaten Bogor" to resources.getStringArray(R.array.kecamatan_jawabarat_kab_bogor_items),
            "Kabupaten Ciamis" to resources.getStringArray(R.array.kecamatan_jawabarat_kab_ciamis_items),
            "Kota Magelang" to resources.getStringArray(R.array.kecamatan_jawatengah_magelang_items),
            "Kota Pekalongan" to resources.getStringArray(R.array.kecamatan_jawatengah_pekalongan_items),
            "Kabupaten Banjarnegara" to resources.getStringArray(R.array.kecamatan_jawatengah_banjarnegara_items),
            "Kabupaten Banyumas" to resources.getStringArray(R.array.kecamatan_jawatengah_banyumas_items),
            "Kota Kediri" to resources.getStringArray(R.array.kecamatan_jawatimur_kediri_items),
            "Kota Malang" to resources.getStringArray(R.array.kecamatan_jawatimur_malang_items),
            "Kota Surabaya" to resources.getStringArray(R.array.kecamatan_jawatimur_surabaya_items),
            "Kabupaten Banyuwangi" to resources.getStringArray(R.array.kecamatan_jawatimur_kab_banyuwangi_items),
        )
        val kelurahanMap = mapOf(
            "Kepulauan Seribu Utara" to resources.getStringArray(R.array.desa_kelurahan_kepulauan_seribu_utara_items),
            "Kepulauan Seribu Selatan" to resources.getStringArray(R.array.desa_kelurahan_kepulauan_seribu_selatan_items),
            "Kelapa Gading" to resources.getStringArray(R.array.desa_kelurahan_jakarta_utara_kelapagading_items),
            "Penjaringan" to resources.getStringArray(R.array.desa_kelurahan_jakarta_utara_penjaringan_items),
            "Tanjung Priok" to resources.getStringArray(R.array.desa_kelurahan_jakarta_utara_tanjungpriok_items),
            "Cakung" to resources.getStringArray(R.array.desa_kelurahan_jakarta_timur_cakung_items),
            "Cipayung" to resources.getStringArray(R.array.desa_kelurahan_jakarta_timur_cipayung_items),
            "Ciracas" to resources.getStringArray(R.array.desa_kelurahan_jakarta_timur_ciracas_items),
            "Cakung" to resources.getStringArray(R.array.desa_kelurahan_jakarta_timur_cakung_items),
            "Cilandak" to resources.getStringArray(R.array.desa_kelurahan_jakarta_selatan_cilandak_items),
            "Kebayoran Baru" to resources.getStringArray(R.array.desa_kelurahan_jakarta_selatan_kebayoranbaru_items),
            "Kebayoran Lama" to resources.getStringArray(R.array.desa_kelurahan_jakarta_selatan_kebayoranlama_items),
            "Kemayoran" to resources.getStringArray(R.array.desa_kelurahan_jakarta_pusat_kemayoran_items),
            "Senen" to resources.getStringArray(R.array.desa_kelurahan_jakarta_pusat_senen_items),
            "Tanah Abang" to resources.getStringArray(R.array.desa_kelurahan_jakarta_pusat_tanahabang_items),
            "Cengkareng" to resources.getStringArray(R.array.desa_kelurahan_jakarta_barat_cengkareng_items),
            "Kebon Jeruk" to resources.getStringArray(R.array.desa_kelurahan_jakarta_barat_kebonjeruk_items),
            "Palmerah" to resources.getStringArray(R.array.desa_kelurahan_jakarta_barat_palmerah_items),
            "Banjaranyar" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_ciamis_banjaranyar_items),
            "Ciamis" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_ciamis_ciamis_items),
            "Panawangan" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_ciamis_panawangan_items),
            "Babakan Madang" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_bogor_babakan_items),
            "Bojonggede" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_bogor_bojonggede_items),
            "Caringin" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_bogor_caringin_items),
            "Bekasi Barat" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_bekasi_barat_items),
            "Bekasi Selatan" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_bekasi_selatan_items),
            "Bekasi Timur" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_bekasi_timur_items),
            "Bekasi Utara" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_bekasi_utara_items),
            "Andir" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_bandung_andir_items),
            "Astana Anyar" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_bandung_astana_anyar_items),
            "Antapani" to resources.getStringArray(R.array.desa_kelurahan_jawabarat_bandung_antapani_items),
            "Magelang Selatan" to resources.getStringArray(R.array.desa_kelurahan_jawatengah_magelang_selatan_items),
            "Magelang Tengah" to resources.getStringArray(R.array.desa_kelurahan_jawatengah_magelang_tengah_items),
            "Magelang Utara" to resources.getStringArray(R.array.desa_kelurahan_jawatengah_magelang_utara_items),
            "Pekalongan Barat" to resources.getStringArray(R.array.desa_kelurahan_jawatengah_pekalongan_barat_items),
            "Pekalongan Selatan" to resources.getStringArray(R.array.desa_kelurahan_jawatengah_pekalongan_selatan_items),
            "Pekalongan Timur" to resources.getStringArray(R.array.desa_kelurahan_jawatengah_pekalongan_timur_items),
            "Pekalongan Utara" to resources.getStringArray(R.array.desa_kelurahan_jawatengah_pekalongan_utara_items),
            "Banjarmangu" to resources.getStringArray(R.array.desa_kelurahan_jawatengah_kab_banjarnegara_banjarmangu_items),
            "Banjarnegara" to resources.getStringArray(R.array.desa_kelurahan_jawatengah_kab_banjarnegara_banjarnegara_items),
            "Ajibarang" to resources.getStringArray(R.array.ddesa_kelurahan_jawatengah_kab_banyumas_ajibarang_items),
            "Banyumas" to resources.getStringArray(R.array.desa_kelurahan_jawatengah_kab_banyumas_banyumas_items),
            "Pesanggaran" to resources.getStringArray(R.array.desa_kelurahan_jawatimur_kab_banyuwangi_pesanggaran_items),
            "Bangorejo" to resources.getStringArray(R.array.desa_kelurahan_jawatimur_kab_banyuwangi_bangorejo_items),
            "Asemrowo" to resources.getStringArray(R.array.desa_kelurahan_jawatimur_surabaya_asemrowo_items),
            "Benowo" to resources.getStringArray(R.array.desa_kelurahan_jawatimur_surabaya_benowo_items),
            "Pare" to resources.getStringArray(R.array.desa_kelurahan_jawatimur_kediri_pare_items),
            "Wates" to resources.getStringArray(R.array.desa_kelurahan_jawatimur_kediri_wates_items),
            "Blimbing" to resources.getStringArray(R.array.desa_kelurahan_jawatimur_malang_blimbing_items),
            "Kedungkandang" to resources.getStringArray(R.array.desa_kelurahan_jawatimur_malang_kedungkandang_items),
            "Banjarnegara" to resources.getStringArray(R.array.desa_kelurahan_jawatengah_kab_banjarnegara_banjarnegara_items),
        )


        val adapterProvinsi = ArrayAdapter(this, android.R.layout.simple_list_item_1, provinsiItems)
        binding.spinProvinsi.setAdapter(adapterProvinsi)

        binding.spinProvinsi.setOnItemClickListener { _, _, position, _ ->
            selectedProvinsi = provinsiItems[position]
            val kotaItems = kotaMap[selectedProvinsi]

             if (kotaItems != null) {
                val adapterKota = ArrayAdapter(this, android.R.layout.simple_list_item_1, kotaItems)
                binding.spinKota.setAdapter(adapterKota)
                if (!kotaItems.contains(selectedKota)) {
                    selectedKota = ""
                    binding.spinKota.setText("")
                    selectedKecamatan= ""
                    binding.spinKecamatan.setText("")
                    selectedKelurahan = ""
                    binding.spinDesa.setText("")
                }
                binding.spinKecamatan.setAdapter(null)
                binding.spinDesa.setAdapter(null)
            } else {
                selectedProvinsi = ""
                selectedKota = ""
                 selectedKelurahan = ""
                binding.spinKota.setText("")
                binding.spinKota.setAdapter(null)
                binding.spinKecamatan.setAdapter(null)
                binding.spinDesa.setAdapter(null)
            }
        }

        binding.spinKota.setOnItemClickListener { _, _, position, _ ->
            selectedKota = binding.spinKota.adapter.getItem(position) as String
            val kecamatanItems = kecamatanMap[selectedKota]

            if (kecamatanItems != null) {
                val adapterKecamatan = ArrayAdapter(this, android.R.layout.simple_list_item_1, kecamatanItems)
                binding.spinKecamatan.setAdapter(adapterKecamatan)
                if (!kecamatanItems.contains(selectedKecamatan)) {
                    selectedKecamatan = ""
                    binding.spinKecamatan.setText("")
                    selectedKelurahan= ""
                    binding.spinDesa.setText("")
                }
                binding.spinDesa.setAdapter(null)
            } else {
                selectedKota = ""
                selectedKecamatan = ""
                binding.spinKecamatan.setText("")
                binding.spinKecamatan.setAdapter(null)
                binding.spinDesa.setAdapter(null)
            }
        }

        binding.spinKecamatan.setOnItemClickListener { _, _, position, _ ->
            selectedKecamatan = binding.spinKecamatan.adapter.getItem(position) as String
            val kelurahanItems = kelurahanMap[selectedKecamatan]

            if (kelurahanItems != null) {
                val adapterKelurahan = ArrayAdapter(this, android.R.layout.simple_list_item_1, kelurahanItems)
                binding.spinDesa.setAdapter(adapterKelurahan)
                if (!kelurahanItems.contains(selectedKelurahan)) {
                    selectedKelurahan = ""
                    binding.spinDesa.setText("")
                }
            } else {
                selectedKelurahan = ""
                binding.spinDesa.setText("")
                binding.spinDesa.setAdapter(null)
            }
        }

        val data = PilihWilayahModel(
            selectedProvinsi,
            selectedKota,
            selectedKecamatan,
            selectedKelurahan
        )

        pref.saveData(data)

        binding.btnNext.setOnClickListener {
            val intent = Intent(this@PilihWilayahActivity, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}