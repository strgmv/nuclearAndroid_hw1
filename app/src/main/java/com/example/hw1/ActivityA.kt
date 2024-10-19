package com.example.hw1

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_a)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnOpenActivityB = findViewById<Button>(R.id.btnOpenActivityB)
        val btnOpenFragmentB = findViewById<Button>(R.id.btnOpenFragmentB)

        btnOpenActivityB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }

        btnOpenFragmentB.setOnClickListener {
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                val fragmentContainer = findViewById<FrameLayout>(R.id.fragmentContainer)
                fragmentContainer.visibility = View.VISIBLE

                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, FragmentBA())
                    .addToBackStack(null)
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerA, FragmentBA())
                    .replace(R.id.fragmentContainerB, FragmentBB())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }
}