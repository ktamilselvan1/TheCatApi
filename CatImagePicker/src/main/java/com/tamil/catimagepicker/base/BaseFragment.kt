package com.tamil.catimagepicker.base

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

internal abstract class BaseFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    open fun showError(@StringRes errorMessage: Int, rootView: View) {
        (activity as BaseActivity).showError(errorMessage, rootView)
    }

    open fun showError(errorMessage: String?, rootView: View) {
        (activity as BaseActivity).showError(errorMessage, rootView)
    }

    open fun showLoading(progressBar: ProgressBar) {
        (activity as BaseActivity).showLoading(progressBar)
    }

    open fun hideLoading(progressBar: ProgressBar) {
        (activity as BaseActivity).hideLoading(progressBar)
    }
}