package com.example.pocofdigivalapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class FlowsAct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flows)
        val tvCount = findViewById<TextView>(R.id.tvCount)
        val myFlows = flow<Int> {
            for (i in 1..100) {
                emit(i)
                delay(1000L)
            }
        }

        CoroutineScope(Dispatchers.Main).launch {
            myFlows.collect {
                tvCount.text = "Current index is : $it"
            }
        }
    }
}
