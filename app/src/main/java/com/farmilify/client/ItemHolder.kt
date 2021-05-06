package com.farmilify.client

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*
import kotlinx.android.synthetic.main.activity_cuaca.*
import kotlinx.android.synthetic.main.activity_cuaca.view.*

class ItemHolder(view: View) : RecyclerView.ViewHolder(view){
    private val dateTime = itemView.day
    private val cuaca = itemView.desc
    private val temperatur = itemView.temp
    private val tempbatas = itemView.temp_range
    private val imageIcon = itemView.icon

    fun binditem(item: ListItem) {
        dateTime.text = item.dt?.let { Util.getDay(it) }
        cuaca.text = item.weather?.get(0)?.description
        temperatur.text = item.main?.temp?.let { Util.setformattemp(it) }
        tempbatas.text = item?.main?.tempMin.toString() + " - " + item?.main?.tempMax.toString()
        item?.weather?.get(0)?.id?.let { Util.getartcuaca(it) }?.let { imageIcon.setImageResource(it) }

    }
}