package com.example.mybroadcastapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    lateinit var fragmentA: FragmentA
    lateinit var fragmentB: FragmentB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        showFragments()

        send_broadcast_button.setOnClickListener {

            val intent = Intent()
            intent.action = "106.9"

            val rnds = (0..100).random()

            intent.putExtra("random_number", rnds.toString())

            sendBroadcast(intent)
        }
    }

    private fun showFragments() {

        fragmentA = FragmentA()
        fragmentB = FragmentB()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_layout_a, fragmentA)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_layout_b, fragmentB)
            .commit()

    }


}
