package com.example.sipaten_pln.ui.home.gantimeter

import com.bagicode.foodmarketkotlin.base.BasePresenter
import com.bagicode.foodmarketkotlin.base.BaseView
import com.example.sipaten_pln.model.response.gantimeter.GantiMeterResponse

interface GantiMeterContract {

    interface View: BaseView{
        fun onGantiMeterSucces(gantiMeterResponse: GantiMeterResponse)
        fun onGantiMeterFailed(message:String)
    }


    interface Presenter : GantiMeterContract, BasePresenter {
        fun getgantimeter()
    }

}