    package com.example.sipaten_pln.ui.home.amr

    import android.content.Intent
    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.Toast
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.example.sipaten_pln.databinding.FragmentAmrBinding
    import com.example.sipaten_pln.model.response.amr.AmrResponse
    import com.example.sipaten_pln.model.response.amr.Data
    import com.google.gson.Gson

    class AmrFragment : Fragment(),AmrAdapter.ItemAdapterCallback,AmrContract.View {
        private lateinit var presenter: AmrPresenter


        private var _binding: FragmentAmrBinding? = null
        private val amrBinding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentAmrBinding.inflate(inflater, container, false)
            val root: View = amrBinding.root
            return root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            presenter = AmrPresenter(this)
            presenter.getAmr()


        }

        override fun onAmrSucces(amrResponse: AmrResponse) {
            val adapter = AmrAdapter(amrResponse.data,this)
            val layoutManager: RecyclerView.LayoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            amrBinding.rclist.layoutManager = layoutManager
            amrBinding.rclist.adapter = adapter

        }

        override fun onAmrFailed(message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }



        override fun showLoading() {
            TODO("Not yet implemented")
        }

        override fun dismissLoading() {
            TODO("Not yet implemented")
        }

        override fun onClick(v: View, data: Data) {
            val gson = Gson()
            val dataJson = gson.toJson(data)

            val detail = Intent(activity, DetailAmrActivity::class.java)
            detail.putExtra("data", dataJson)
            startActivity(detail)
        }

    }