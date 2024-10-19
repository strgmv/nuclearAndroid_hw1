package com.example.hw1

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class FragmentBA : Fragment(R.layout.fragment_b_a) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnOpenFragmentBB = view.findViewById<Button>(R.id.btnOpenFragmentBB)

        btnOpenFragmentBB?.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, FragmentBB())
                .addToBackStack(null)
                .commit()
        }

        parentFragmentManager.setFragmentResultListener("requestColor", this) { key, bundle ->
            val color = bundle.getInt("color")
            view.setBackgroundColor(color)
        }
    }

}