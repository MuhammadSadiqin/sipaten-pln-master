package com.example.sipaten_pln.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment

import com.example.sipaten_pln.databinding.FragmentHomeBinding
import com.example.sipaten_pln.ui.home.amr.AmrActivity
import com.example.sipaten_pln.ui.home.gantimeter.GantiMeterActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val homeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeBinding.ivGantimeter.setOnClickListener{
            val gantimeter = Intent(activity, GantiMeterActivity::class.java)
            startActivity(gantimeter)
        }
        homeBinding.ivAmr.setOnClickListener{
            val Amr = Intent(activity, AmrActivity::class.java)
            startActivity(Amr)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}