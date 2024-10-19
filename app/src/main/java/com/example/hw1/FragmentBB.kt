package com.example.hw1

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlin.random.Random

class FragmentBB : Fragment(R.layout.fragment_b_b) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btnSendColor).setOnClickListener {
            val randomColor = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))

            val bundle = Bundle()
            bundle.putInt("color", randomColor)
            parentFragmentManager.setFragmentResult("requestColor", bundle)
        }
    }
}