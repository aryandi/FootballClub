package com.ryandzhunter.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.*

class SecondActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var nameTextView: TextView
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)
            imageView = imageView() {
                padding = dip(10)
            }.lparams {
                width = dip(100)
                height = dip(100)
                gravity = Gravity.CENTER
            }
            nameTextView = textView() {
                padding = dip(10)
            }.lparams {
                gravity = Gravity.CENTER
            }
            infoTextView = textView() {
                padding = dip(10)
            }.lparams {
                gravity = Gravity.CENTER
            }
        }

        val intent = intent
        val position = intent.getIntExtra("position", 0)
        val image = resources.obtainTypedArray(R.array.club_image).getResourceId(position, 0)
        val name = resources.getStringArray(R.array.club_name)[position]
        val info = resources.getStringArray(R.array.club_info)[position]

        Glide.with(this).load(image).into(imageView)
        nameTextView.text = name
        infoTextView.text = info


    }
}