package com.example.galleryapp.ui.base

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.galleryapp.AppListener

open class BaseFragment : Fragment() {

    private lateinit var listener: AppListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AppListener) {
            listener = context
        } else {
            throw RuntimeException("$context must implement AppListener")
        }
    }

    protected open fun showProgress(show: Boolean) {
        if (show) {
            listener.showProgress()
        } else {
            listener.hideProgress()
        }
    }

    protected fun showMessage(message: String?) {
        listener.showMessage(message)
    }

}