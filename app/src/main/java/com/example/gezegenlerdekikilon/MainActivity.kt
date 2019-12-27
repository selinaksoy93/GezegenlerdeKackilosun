package com.example.gezegenlerdekikilon

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val kilo_to_pound = 2.2045
    val pound_to_kilo = 0.4535
    val MARS = 0.38
    val VENUS = 0.91
    val JUPITER = 2.34
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Glide.with(this).load(R.drawable.saturn).into(imageView)
        setContentView(R.layout.activity_main)
        cbMars.setOnClickListener(this)
        cbVenus.setOnClickListener(this)
        cbJupiter.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v as CheckBox
        var secili: Boolean = v.isChecked
        if (!TextUtils.isEmpty(girilenkilo.text.toString())) {
            var kullanicikilo = girilenkilo.text.toString().toDouble()
            var kullancipound = kilotopound(kullanicikilo)
            when (v.id) {
                R.id.cbMars -> if (secili) {
                    cbVenus.isChecked = false
                    cbJupiter.isChecked = false
                    HesaplaAgirlikPound(kullancipound, v)
                }
                R.id.cbVenus -> if (secili) {
                    cbMars.isChecked = false
                    cbJupiter.isChecked = false
                    HesaplaAgirlikPound(kullancipound, v)
                }
                R.id.cbJupiter -> if (secili) {
                    cbMars.isChecked = false
                    cbVenus.isChecked = false
                    HesaplaAgirlikPound(kullancipound, v)
                }
            }

        }
    }


    fun kilotopound(kilo: Double): Double {
        return kilo * kilo_to_pound
    }

    fun HesaplaAgirlikPound(pound: Double, checkBox: CheckBox) {
        var sonuc: Double
        when (checkBox.id) {
            R.id.cbMars -> sonuc = pound * MARS
            R.id.cbVenus -> sonuc = pound * VENUS
            R.id.cbJupiter -> sonuc = pound * JUPITER
            else -> sonuc = 0.0
        }
        var sonhesap = poundtokilo(sonuc)
        sonsonuc.text = sonhesap.toString()
    }

    fun poundtokilo(pound: Double): Double {
        return pound * pound_to_kilo
    }


}
