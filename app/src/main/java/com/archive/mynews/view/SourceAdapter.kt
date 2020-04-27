package com.archive.mynews.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.R
import com.archive.mynews.model.Article
import com.archive.mynews.model.Source
import kotlinx.android.synthetic.main.item_source.view.*

class SourceAdapter(
    val context: Context,
    private val sourceList: MutableList<Source> = mutableListOf()
) : RecyclerView.Adapter<SourceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_source, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return sourceList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 리사이클러뷰가 불러짐
        holder.bindView(sourceList[position])
    }


    fun addSourceList(sourceList: List<Source>) {
        this.sourceList.addAll(sourceList)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sourcemedia = view.text_source_media
        val content = view.text_source_content
        val language = view.text_source_language
        val country = view.text_source_country

        fun bindView(source: Source) {
            sourcemedia.text = source.name
            content.text = source.description
            language.text = source.language
            country.text = source.country
        }
    }
}