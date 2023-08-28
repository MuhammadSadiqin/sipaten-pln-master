package com.example.sipaten_pln.ui.home.amr

import com.example.sipaten_pln.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AmrPresenter (private val view:AmrContract.View) : AmrContract.Presenter {

    private val mCompositeDisposable : CompositeDisposable?
    init {
        this.mCompositeDisposable = CompositeDisposable()
    }




    override fun getAmr() {
        val disposable = HttpClient.getInstance().getApi()!!.amr()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    if (it.meta?.status.equals("success",true)) {
                        it.data?.let { it1 -> view.onAmrSucces(it1) }
                    }else{
                        it.meta?.message?.let { it1 -> view.onAmrFailed(it1) }
                    }
                },
                {
                    view.dismissLoading()
                    view.onAmrFailed(it.message.toString())
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


