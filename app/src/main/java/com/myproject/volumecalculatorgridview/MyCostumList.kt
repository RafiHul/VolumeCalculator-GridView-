package com.myproject.volumecalculatorgridview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyCostumList(val context:Context,val griditem:List<Shape>) : ArrayAdapter<Shape>(context,0,griditem) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var itemView = convertView
        val holder: ViewHolder

        if (convertView == null){
            itemView = LayoutInflater.from(context)
                .inflate(R.layout.griditem_view,parent,false) //inflate itu intinya merubah layout xml menjadi sebuah object
            holder = ViewHolder()
            holder.imageView = itemView.findViewById(R.id.imageView)
            holder.textView = itemView.findViewById(R.id.textView)

            itemView.tag = holder
        } else {
            holder = itemView?.tag as ViewHolder
        }

        val current = griditem[position]
        holder.imageView.setImageResource(current.image)
        holder.textView.text = current.name

        return itemView!! //!! adalah pernyataan nonnull
    }
    class ViewHolder{
        // ini digunakan untuk improve performa dengan cara caching untuk smooth scrolling
        // reduce 'findviewbyid()'
        lateinit var imageView:ImageView
        lateinit var textView:TextView
    }
}

