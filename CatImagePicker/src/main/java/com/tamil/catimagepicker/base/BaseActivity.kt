package com.tamil.catimagepicker.base

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.tamil.catimagepicker.ext.gone
import com.tamil.catimagepicker.ext.snackBar
import com.tamil.catimagepicker.ext.visible

internal abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showError(@StringRes errorMessage: Int, rootView: View) = snackBar(errorMessage, rootView)

    fun showError(errorMessage: String?, rootView: View) =
        snackBar(errorMessage ?: EMPTY_STRING, rootView)

    fun showLoading(progressBar: ProgressBar) = progressBar.visible()

    fun hideLoading(progressBar: ProgressBar) = progressBar.gone()


    companion object {
        private const val EMPTY_STRING = ""
    }
}