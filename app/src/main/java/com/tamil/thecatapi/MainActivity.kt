package com.tamil.thecatapi

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.tamil.catimagepicker.ImagePicker
import com.tamil.catimagepicker.ImagePicker.Companion.INTENT_PICK_IMAGE_KEY
import com.tamil.catimagepicker.ImagePicker.Companion.startPickerActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textview)
        textView.setOnClickListener {
            startPickerActivity(this)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK && requestCode == ImagePicker.INTENT_PICK_IMAGE) {
            Glide.with(this).load(data?.getStringExtra(INTENT_PICK_IMAGE_KEY))
                .into(findViewById(R.id.image))
        }
    }
}