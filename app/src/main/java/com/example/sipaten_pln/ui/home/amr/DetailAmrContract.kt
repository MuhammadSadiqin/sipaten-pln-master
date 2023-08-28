package com.example.sipaten_pln.ui.home.amr

import com.bagicode.foodmarketkotlin.base.BasePresenter
import com.bagicode.foodmarketkotlin.base.BaseView
import com.example.sipaten_pln.model.response.amr.AmrResponse
import com.example.sipaten_pln.model.response.amr.Data


interface DetailAmrContract {

    interface View : BaseView {
        fun onUpdateSuccess(response: AmrResponse)
        fun onUpdateFailed(message: String)
    }

    interface Presenter : BasePresenter {
        fun updateAmr(id: Int, data: Data)
    }
}