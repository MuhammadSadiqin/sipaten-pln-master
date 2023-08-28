package com.example.sipaten_pln.ui.home.amr

import com.bagicode.foodmarketkotlin.base.BasePresenter
import com.bagicode.foodmarketkotlin.base.BaseView
import com.example.sipaten_pln.model.response.amr.AmrResponse
import com.example.sipaten_pln.model.response.gantimeter.GantiMeterResponse

interface AmrContract {

    interface View: BaseView{
        fun onAmrSucces(amrResponse: AmrResponse)
        fun onAmrFailed(message:String)
    }


    interface Presenter : AmrContract, BasePresenter {
        fun getAmr()
    }

}