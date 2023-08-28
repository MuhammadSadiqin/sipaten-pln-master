package com.example.sipaten_pln.model.response.gantimeter


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



data class Data(
    @Expose
    @SerializedName("alamat")
    val alamat: String,
    @Expose
    @SerializedName("alasan_tunda")
    var alasanTunda: String,
    @Expose
    @SerializedName("created_at")
    val createdAt: String,
    @Expose
    @SerializedName("daya")
    val daya: Int,
    @Expose
    @SerializedName("foto_app_baru")
    val fotoAppBaru: String,
    @Expose
    @SerializedName("foto_app_lama")
    val fotoAppLama: String,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("id_pel")
    val idPel: Int,
    @Expose
    @SerializedName("kd_unit")
    val kdUnit: Int,
    @Expose
    @SerializedName("kelainan")
    val kelainan: String,
    @Expose
    @SerializedName("ket")
    var ket: String,
    @Expose
    @SerializedName("ket_tunda")
    var ketTunda: String,
    @Expose
    @SerializedName("merk_meter_baru")
    var merkMeterBaru: String,
    @Expose
    @SerializedName("merk_meter_lama")
    var merkMeterLama: String,
    @Expose
    @SerializedName("nama")
    val nama: String,
    @Expose
    @SerializedName("nama_pelanggan")
    val namaPelanggan: String,
    @Expose
    @SerializedName("nama_petugas")
    var namaPetugas: String,
    @Expose
    @SerializedName("no_berita_acara")
    var noBeritaAcara: String,
    @Expose
    @SerializedName("no_hp_pelanggan")
    var noHpPelanggan: Int,
    @Expose
    @SerializedName("no_meter_baru")
    var noMeterBaru: Int,
    @Expose
    @SerializedName("no_meter_lama")
    var noMeterLama: String,
    @Expose
    @SerializedName("peta")
    val peta: String,
    @Expose
    @SerializedName("petugas")
    val petugas: String,
    @Expose
    @SerializedName("sisa_token_baru")
    var sisaTokenBaru: Double,
    @Expose
    @SerializedName("sisa_token_lama")
    var sisaTokenLama: Double,
    @Expose
    @SerializedName("status")
    var status: String,
    @Expose
    @SerializedName("tarif")
    val tarif: String,
    @Expose
    @SerializedName("teken_pelanggan")
    val tekenPelanggan: String,
    @Expose
    @SerializedName("teken_petugas")
    val tekenPetugas: String,
    @Expose
    @SerializedName("tgl_tl")
    var tglTl: String,
    @Expose
    @SerializedName("tipe")
    val tipe: String,
    @Expose
    @SerializedName("ulp")
    val ulp: String,
    @Expose
    @SerializedName("updated_at")
    val updatedAt: String,
    @Expose
    @SerializedName("user_id")
    val userId: Int
)