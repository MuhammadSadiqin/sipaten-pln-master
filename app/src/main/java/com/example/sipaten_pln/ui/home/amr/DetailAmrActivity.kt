package com.example.sipaten_pln.ui.home.amr

import android.Manifest
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.sipaten_pln.R
import com.example.sipaten_pln.model.response.amr.AmrResponse
import com.example.sipaten_pln.model.response.amr.Data
import com.google.gson.Gson
import java.util.*

class DetailAmrActivity : AppCompatActivity(),DetailAmrContract.View {

    private lateinit var presenter: DetailAmrPresenter


    private lateinit var etIDPetugas: EditText
    private lateinit var etULP: EditText
    private lateinit var etKDunit: EditText
    private lateinit var etIdPel: EditText
    private lateinit var etNamaPel: EditText
    private lateinit var etAlamat: EditText
    private lateinit var etTarif: EditText
    private lateinit var etDaya: EditText
    private lateinit var etPeta: EditText
    private lateinit var etTipe: EditText
    private lateinit var etKelainan: EditText
    private lateinit var etPetugas: EditText
    private lateinit var etStatus: EditText
    private lateinit var etAlasanTunda: EditText
    private lateinit var etKetTunda: EditText
    private lateinit var etTanggalTL: EditText // Inisialisasi EditText for etTanggalTL
    private lateinit var etMerekMeterLama: EditText
    private lateinit var etNoMeterLama: EditText
    private lateinit var etSisaTokenLama: EditText
    private lateinit var etMerkMeterBaru: EditText
    private lateinit var etNomorMeterBaru: EditText
    private lateinit var etSisaTokenBaru: EditText
    private lateinit var etNoHpPelanggan: EditText
    private lateinit var etNamaPelanggan: EditText
    private lateinit var etNamaPetugas: EditText
    private lateinit var etBeritaAcara: EditText
    private lateinit var etKeterangan: EditText

    private lateinit var radioGroupStatus: RadioGroup
    private lateinit var rbSudah: RadioButton
    private lateinit var rbBelum: RadioButton
    private lateinit var rbTunda: RadioButton

    private lateinit var imageViewSelectedPhoto: ImageView
    private lateinit var buttonSelectPhoto: AppCompatButton
    private var selectedImageUri: Uri? = null // Menyimpan URI gambar yang dipilih

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_amr)

        // Buat instance presenter
        presenter = DetailAmrPresenter(this)


        // Inisialisasi RadioGroup dan RadioButtons
        radioGroupStatus = findViewById(R.id.radioGroupStatus)
        rbSudah = findViewById(R.id.rbSudah)
        rbBelum = findViewById(R.id.rbBelum)
        rbTunda = findViewById(R.id.rbTunda)

//        //foto
//        imageViewSelectedPhoto = findViewById(R.id.imageViewSelectedPhoto)
//        buttonSelectPhoto = findViewById(R.id.buttonSelectPhoto)
//
//
//        buttonSelectPhoto.setOnClickListener {
//            if (ContextCompat.checkSelfPermission(
//                    this,
//                    Manifest.permission.READ_EXTERNAL_STORAGE
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//                ActivityCompat.requestPermissions(
//                    this,
//                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
//                    DetailAmrActivity.REQUEST_CODE_PERMISSION
//                )
//            } else {
//                openGallery()
//            }
//        }
//
//        if (selectedImageUri != null) {
//            imageViewSelectedPhoto.setImageURI(selectedImageUri)
//        }



        // Inisialisasi semua EditText yang ada di layout
        etIDPetugas = findViewById(R.id.etIDpetugas)
        etULP = findViewById(R.id.etULP)
        etKDunit = findViewById(R.id.etKDunit)
        etIdPel = findViewById(R.id.etIdPel)
        etNamaPel = findViewById(R.id.etNamaPel)
        etAlamat = findViewById(R.id.etAlamat)
        etTarif = findViewById(R.id.etTarif)
        etDaya = findViewById(R.id.etDaya)
        etPeta = findViewById(R.id.etPeta)
        etTipe = findViewById(R.id.etTipe)
        etKelainan = findViewById(R.id.etKelainan)
        etPetugas = findViewById(R.id.etPetugas)
        etAlasanTunda = findViewById(R.id.etAlasanTunda)
        etKetTunda = findViewById(R.id.etKetTunda)
        etTanggalTL = findViewById(R.id.editTextSelectedDate)
        etMerekMeterLama = findViewById(R.id.etMerekMeterLama)
        etNoMeterLama = findViewById(R.id.etNoMeterLama)
        etSisaTokenLama = findViewById(R.id.etSisaTokenLama)
        etMerkMeterBaru = findViewById(R.id.etMerkMeterBaru)
        etNomorMeterBaru = findViewById(R.id.etNomorMeterBaru)
        etSisaTokenBaru = findViewById(R.id.etSisaTokenBaru)
        etNamaPelanggan = findViewById(R.id.etNamaPelanggan)
        etNoHpPelanggan = findViewById(R.id.etNoHpPelanggan)
        etNamaPetugas = findViewById(R.id.etNamaPetugas)
        etBeritaAcara = findViewById(R.id.etBeritaAcara)
        etKeterangan = findViewById(R.id.etKeterangan)




        // Mengambil data JSON yang telah dikirimkan melalui intent
        val dataJson = intent.getStringExtra("data")

        // Parsing data JSON menggunakan Gson
        val gson = Gson()
        val data: Data = gson.fromJson(dataJson, Data::class.java)

        // Mengisi nilai dari objek Data ke dalam EditText
        etIDPetugas.setText(data.id.toString())
        etULP.setText(data.ulp)
        etKDunit.setText(data.kdUnit.toString())
        etIdPel.setText(data.idPel.toString())
        etNamaPel.setText(data.namaPelanggan)
        etAlamat.setText(data.alamat)
        etTarif.setText(data.tarif)
        etDaya.setText(data.daya.toString())
        etPeta.setText(data.peta)
        etTipe.setText(data.tipe)
        etKelainan.setText(data.kelainan)
        etPetugas.setText(data.petugas)
        etAlasanTunda.setText(
            data.alasanTunda ?: ""
        ) // Menggunakan elvis operator untuk handle nullable values
        etKetTunda.setText(data.ketTunda ?: "")
        etMerekMeterLama.setText(data.merkMeterLama ?: "")
        etNoMeterLama.setText(data.noMeterLama ?: "")
        etSisaTokenLama.setText(data.sisaTokenLama?.toDouble()?.toString() ?: "")
        etMerkMeterBaru.setText(data.merkMeterBaru ?: "")
        etNomorMeterBaru.setText(data.noMeterBaru?.toString() ?: "")
        etSisaTokenBaru.setText(data.sisaTokenBaru?.toDouble()?.toString() ?: "")
        etNoHpPelanggan.setText(data.noHpPelanggan?.toString() ?: "")
        etNamaPetugas.setText(data.namaPetugas ?: "")
        etBeritaAcara.setText(data.noBeritaAcara?.toString() ?: "")
        etKeterangan.setText(data.ket ?: "")
        etTanggalTL.setText(data.tglTl ?: "")


        // Mengatur status radio button
        when (data.status) {
            "Sudah" -> rbSudah.isChecked = true
            "Belum" -> rbBelum.isChecked = true
            "Tunda" -> rbTunda.isChecked = true
        }

        etTanggalTL.setOnClickListener {
            val calendar = Calendar.getInstance()
            val tahun = calendar.get(Calendar.YEAR)
            val bulan = calendar.get(Calendar.MONTH)
            val hari = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                this,
                { _, tahun, bulanTahun, hariBulan ->
                    data.tglTl = "$tahun-${bulanTahun + 1}-${hariBulan}"
                    etTanggalTL.setText(data.tglTl) // Tampilkan tanggal pada EditText
                },
                tahun, bulan, hari
            )
            datePickerDialog.show()
        }

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {

            when (radioGroupStatus.checkedRadioButtonId) {
                R.id.rbSudah -> data.status = "Sudah"
                R.id.rbBelum -> data.status = "Belum"
                R.id.rbTunda -> data.status = "Tunda"
            }

            data.alasanTunda = etAlasanTunda.text.toString()
            data.ketTunda = etKetTunda.text.toString()
            data.merkMeterLama = etMerekMeterLama.text.toString()
            data.noMeterLama = etNoMeterLama.text.toString()
            data.sisaTokenLama = etSisaTokenLama.text.toString().toDoubleOrNull() ?: 0.0
            data.merkMeterBaru = etMerkMeterBaru.text.toString()
            data.noMeterBaru = etNomorMeterBaru.text.toString().toIntOrNull() ?: 0
            data.sisaTokenBaru = etSisaTokenBaru.text.toString().toDoubleOrNull() ?: 0.0
            data.noHpPelanggan = etNoHpPelanggan.text.toString().toIntOrNull() ?: 0
            data.namaPetugas = etNamaPetugas.text.toString()
            data.noBeritaAcara = etBeritaAcara.text.toString()
            data.ket = etKeterangan.text.toString()
            data.tglTl = etTanggalTL.text.toString()



            presenter.updateAmr(data.id, data)



        }

    }

    override fun onUpdateSuccess(response: AmrResponse) {
        Toast.makeText(this, "Update successful", Toast.LENGTH_SHORT).show()

        finish()
        val detail = Intent(this, AmrActivity::class.java)
        startActivity(detail)

//        val updatedData = data
//
//        etStatus.setText(updatedData.status)
//        etAlasanTunda.setText(updatedData.alasanTunda ?: "")
//        etKetTunda.setText(updatedData.ketTunda ?: "")
//        etMerekMeterLama.setText(updatedData.merkMeterLama ?: "")
//        etNoMeterLama.setText(updatedData.noMeterLama ?: "")
//        etSisaTokenLama.setText(updatedData.sisaTokenLama?.toDouble()?.toString() ?: "")
//        etMerkMeterBaru.setText(updatedData.merkMeterBaru ?: "")
//        etNomorMeterBaru.setText(updatedData.noMeterBaru?.toString() ?: "")
//        etSisaTokenBaru.setText(updatedData.sisaTokenBaru?.toDouble()?.toString() ?: "")
//        etNoHpPelanggan.setText(updatedData.noHpPelanggan?.toString() ?: "")
//        etNamaPetugas.setText(updatedData.namaPetugas ?: "")
//        etBeritaAcara.setText(updatedData.noBeritaAcara?.toString() ?: "")
//        etKeterangan.setText(updatedData.ket ?: "")


    }

    override fun onUpdateFailed(message: String) {
        Toast.makeText(this, "Update failed: $message", Toast.LENGTH_SHORT).show()


    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun dismissLoading() {
        TODO("Not yet implemented")
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_CODE_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            selectedImageUri = data.data
            imageViewSelectedPhoto.setImageURI(selectedImageUri)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_SELECTED_IMAGE_URI, selectedImageUri)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        selectedImageUri = savedInstanceState.getParcelable(KEY_SELECTED_IMAGE_URI)
        if (selectedImageUri != null) {
            imageViewSelectedPhoto.setImageURI(selectedImageUri)
        }
    }

    // ... (Rest of your code)

    companion object {
        private const val REQUEST_CODE_PERMISSION = 101
        private const val REQUEST_CODE_PICK_IMAGE = 102
        private const val KEY_SELECTED_IMAGE_URI = "selected_image_uri"
    }

}