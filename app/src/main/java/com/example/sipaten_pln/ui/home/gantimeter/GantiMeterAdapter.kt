package com.example.sipaten_pln.ui.home.gantimeter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sipaten_pln.databinding.ItemVerticalBinding
import com.example.sipaten_pln.model.response.gantimeter.Data

class GantiMeterAdapter(
    private val listData: List<Data>,
    private val itemAdapterCallback: ItemAdapterCallback,
) : RecyclerView.Adapter<GantiMeterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listData[position], itemAdapterCallback)
    }

    override fun getItemCount(): Int {
        return listData.size
    }


    class ViewHolder(private val binding: ItemVerticalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Data, itemAdapterCallback: ItemAdapterCallback) {
            binding.apply {
                textViewIdPelanggan.text = "ID Pelanggan           : ${data.idPel}"
                textViewNamaPelanggan.text = "Nama Pelanggan       : ${data.nama}"
                textViewTarif.text = "Tarif                                  : ${data.tarif}"
                textViewDaya.text = "Daya                                : ${data.daya}"
                textViewStatus.text = "Status                              : ${data.status}"

//                Glide.with(itemView.context)

                root.setOnClickListener { itemAdapterCallback.onClick(it, data) }
            }
        }
    }



    interface ItemAdapterCallback {
        fun onClick(v: View, data:Data)
    }


}
