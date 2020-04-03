package com.example.alternativelayoutfiles

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        Toast.makeText(this, "This is details activity", Toast.LENGTH_LONG)
            .show()

    }
}