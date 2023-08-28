package com.example.sipaten_pln.model.dummy

data class GantiMeterModel(
    val idPelanggan: String,
    val namaPelanggan: String,
    val tarif: String,
    val daya: String,
    val status: String
)

object DummyData {
    fun generateDummyData(): List<GantiMeterModel> {
        val dataList = mutableListOf<GantiMeterModel>()

        dataList.add(GantiMeterModel("ID001", "John Doe", "Tarif A", "4500 VA", "Aktif"))
        dataList.add(GantiMeterModel("ID002", "Jane Smith", "Tarif B", "3500 VA", "Tidak Aktif"))
        dataList.add(GantiMeterModel("ID003", "Michael Johnson", "Tarif C", "2200 VA", "Aktif"))
        dataList.add(GantiMeterModel("ID004", "Emily Williams", "Tarif A", "900 VA", "Tidak Aktif"))
        dataList.add(GantiMeterModel("ID005", "Robert Brown", "Tarif B", "1300 VA", "Aktif"))

        return dataList
    }
}

