package com.example.mvpproject

import android.app.Dialog
import android.content.Context

class CustomProgressDialog(
    context: Context?
) : Dialog(context!!) {

    fun show(message: String?) {
        try {
            if (!isShowing) {
                super.show()
            }
        } catch (e: Exception) {
            super.dismiss()
        }
    }

    override fun hide() {
        try {
            if (isShowing) {
                super.dismiss()
            }
        } catch (e: Exception) {
            super.dismiss()
        }
    }


    init {
        setContentView(R.layout.layout_loader)
    }
}