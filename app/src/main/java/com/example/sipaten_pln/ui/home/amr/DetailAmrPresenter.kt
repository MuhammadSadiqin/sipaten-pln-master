package com.example.sipaten_pln.ui.home.amr

import com.example.sipaten_pln.model.response.amr.Data
import com.example.sipaten_pln.network.HttpClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailAmrPresenter(private val view: DetailAmrContract.View) : DetailAmrContract.Presenter {
    private val mCompositeDisposable: CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }


    override fun updateAmr(id: Int, data: Data) {
        val disposable = HttpClient.getInstance().getApi()!!.updateamr(id,data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    if (it.meta?.status.equals("success",true)) {
                        it.data?.let { it1 -> view.onUpdateSuccess(it1) }
                    }else{
                        it.meta?.message?.let { it1 -> view.onUpdateFailed(it1) }
                    }
                },
                {
                    view.onUpdateFailed(it.message.toString())
                }
            )
        mCompositeDisposable!!.add(disposable)
    }

    override fun subscribe() {
        // Tidak ada operasi khusus yang perlu dilakukan saat subscribe
    }

    override fun unSubscribe() {
        mCompositeDisposable?.clear()
    }
}
