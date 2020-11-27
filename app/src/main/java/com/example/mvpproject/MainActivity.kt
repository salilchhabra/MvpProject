package com.example.mvpproject

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), IView {
    private var presenter: MyPresenter? = null
    private var mProgressDialog: CustomProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MyPresenter()
        mProgressDialog = CustomProgressDialog(this)
        attachPresenter()
        btn_click.setOnClickListener {
            mProgressDialog?.show("please wait")
            Handler(Looper.getMainLooper()).postDelayed({
                run {
                    presenter?.displayText()
                }
            }, 5000)
        }
    }

    private fun attachPresenter() {
        presenter?.attachView(this)

    }

    override fun displaytext(data: DataModel) {
        mProgressDialog?.hide()
        tv_display.text = String.format(data.name + data.age)
    }

    override fun onDestroy() {
        presenter?.detachView()
        super.onDestroy()
    }
}