package com.example.sipaten_pln.ui.home.detailgantimeter

import com.example.sipaten_pln.model.response.gantimeter.Data
import com.example.sipaten_pln.network.HttpClient
import com.example.sipaten_pln.ui.home.gantimeter.DetailGantiMeterContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class DetailGantiMeterPresenter(private val view: DetailGantiMeterContract.View) : DetailGantiMeterContract.Presenter {
    private val mCompositeDisposable: CompositeDisposable?

    init {
        this.mCompositeDisposable = CompositeDisposable()
    }

    override fun updateGantiMeter(id: Int, data: Data) {
        val disposable = HttpClient.getInstance().getApi()!!.updateGantiMeter(id, data)
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
