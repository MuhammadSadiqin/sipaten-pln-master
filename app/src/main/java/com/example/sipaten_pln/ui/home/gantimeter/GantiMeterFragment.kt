    package com.example.sipaten_pln.ui.home.gantimeter

    import android.content.Intent
    import android.os.Bundle
    import androidx.fragment.app.Fragment
    import android.view.LayoutInflater
    import android.view.View
    import android.view.ViewGroup
    import android.widget.Toast
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView
    import com.example.sipaten_pln.databinding.FragmentGantiMeterBinding
    import com.example.sipaten_pln.model.response.gantimeter.Data
    import com.example.sipaten_pln.model.response.gantimeter.GantiMeterResponse
    import com.google.gson.Gson

    class GantiMeterFragment : Fragment(),GantiMeterAdapter.ItemAdapterCallback,GantiMeterContract.View {
        private var gantimeterlist : ArrayList<Data> = ArrayList()
        private lateinit var presenter: GantiMeterPresenter


        private var _binding: FragmentGantiMeterBinding? = null
        private val gantimeterBinding get() = _binding!!

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentGantiMeterBinding.inflate(inflater, container, false)
            val root: View = gantimeterBinding.root
            return root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            presenter = GantiMeterPresenter(this)
            presenter.getgantimeter()


        }

        override fun onGantiMeterSucces(gantiMeterResponse: GantiMeterResponse) {
            val adapter = GantiMeterAdapter(gantiMeterResponse.data,this)
            val layoutManager: RecyclerView.LayoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            gantimeterBinding.rclist.layoutManager = layoutManager
            gantimeterBinding.rclist.adapter = adapter

        }

        override fun onGantiMeterFailed(message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        override fun onResume() {
            super.onResume()

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

            val detail = Intent(activity, DetailGantiMeterActivity::class.java)
            detail.putExtra("data", dataJson)
            startActivity(detail)
        }

    }