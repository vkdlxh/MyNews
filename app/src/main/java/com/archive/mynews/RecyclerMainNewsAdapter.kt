package com.archive.mynews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.model.Article
import kotlinx.android.synthetic.main.news_page_one.view.*

class RecyclerMainNewsAdapter (val context : Context, val friend_DataArray: ArrayList<Article>) : RecyclerView.Adapter<mViewH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewH {
        return mViewH(LayoutInflater.from(context).inflate(R.layout.item_news_page_one,parent,false))
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: mViewH, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class mViewH(view: View) : RecyclerView.ViewHolder(view!!) {
    var image = view.recyclerNewsMain
    var content = view.recyclerNewsMain
    var company = view.recyclerNewsMain
}

