package com.example.sipaten_pln.ui.auth.signin

import com.bagicode.foodmarketkotlin.base.BasePresenter
import com.bagicode.foodmarketkotlin.base.BaseView
import com.example.sipaten_pln.model.response.login.LoginResponse

interface SigninContract {

    interface View: BaseView {
        fun onLoginSuccess(loginResponse: LoginResponse)
        fun onLoginFailed(massage:String)
    }

    interface Presenter : SigninContract, BasePresenter {
        fun submitLogin(email:String,password:String)
    }

}