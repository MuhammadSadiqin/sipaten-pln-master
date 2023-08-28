package com.example.sipaten_pln.ui.home.gantimeter

import com.example.sipaten_pln.network.HttpClient
import com.google.api.Endpoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GantiMeterPresenter (private val view:GantiMeterContract.View) : GantiMeterContract.Presenter {

    private val mCompositeDisposable : CompositeDisposable?
    init {
        this.mCompositeDisposable = CompositeDisposable()
    }




    override fun getgantimeter() {
        val disposable = HttpClient.getInstance().getApi()!!.gantimeter()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    if (it.meta?.status.equals("success",true)) {
                        it.data?.let { it1 -> view.onGantiMeterSucces(it1) }
                    }else{
                        it.meta?.message?.let { it1 -> view.onGantiMeterFailed(it1) }
                    }
                },
                {
                    view.dismissLoading()
                    view.onGantiMeterFailed(it.message.toString())
                }
            )
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {
        TODO("Not yet implemented")
    }

    override fun unSubscribe() {
        TODO("Not yet implemented")
    }


}


