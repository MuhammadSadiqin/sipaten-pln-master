package com.example.sipaten_pln.ui.home.gantimeter

import com.bagicode.foodmarketkotlin.base.BasePresenter
import com.bagicode.foodmarketkotlin.base.BaseView
import com.example.sipaten_pln.model.response.gantimeter.Data
import com.example.sipaten_pln.model.response.gantimeter.GantiMeterResponse

interface DetailGantiMeterContract {

    interface View : BaseView {
        fun onUpdateSuccess(response: GantiMeterResponse)
        fun onUpdateFailed(message: String)
    }

    interface Presenter : BasePresenter {
        fun updateGantiMeter(id: Int, data: Data)
    }
}