package com.tamil.catimagepicker

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImagePicker : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_images)
        findViewById<ImageView>(R.id.back).setOnClickListener {
            finish()
        }
    }

    companion object {
        const val INTENT_PICK_IMAGE = 11
        const val INTENT_PICK_IMAGE_KEY = "ImageUrl"

        fun startPickerActivity(context: Context) {
            val intent = Intent(context, ImagePicker::class.java)
            (context as AppCompatActivity).startActivityForResult(intent, INTENT_PICK_IMAGE)
        }
    }
}