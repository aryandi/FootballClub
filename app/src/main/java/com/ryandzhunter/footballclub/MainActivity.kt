package com.ryandzhunter.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.ryandzhunter.footballclub.R.array.club_image
import com.ryandzhunter.footballclub.R.array.club_name
import com.ryandzhunter.footballclub.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

/**
 * Created by ryandzhunter on 4/16/18.
 */

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items, listener = { position ->
            startActivity<SecondActivity>("position" to position)
        })
    }

    private fun initData(){
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],
                    image.getResourceId(i, 0)))
        }
        image.recycle()
    }
}
