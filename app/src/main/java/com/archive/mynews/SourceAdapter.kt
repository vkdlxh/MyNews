package com.archive.mynews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.model.Category
import com.archive.mynews.model.Source
import kotlinx.android.synthetic.main.item_source.view.*

class SourceAdapter(val context: Context, private val sourceList: List<Source>) : RecyclerView.Adapter<SourceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).
            inflate(R.layout.item_source,parent,false))
    }

    override fun getItemCount(): Int {
        return sourceList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 리사이클러뷰가 불러짐
        holder.bindView(sourceList[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val sourcemedia = view.text_source_media
        val content = view.text_source_content
        val language = view.text_source_language
        val country = view.text_source_country

        fun bindView(source: Source) {
            //itemView.text_source_content.text = ""
            sourcemedia.text = source.name
            content.text = source.description
            language.text = source.language
            country.text = source.country

//            when (fragment_source.category) {
//               Category.GENERAL -> {
//
//               }
//
//            }

//            if (fragment_source.category == Category.GENERAL){
//
//            } else if (fragment_source.category == "culture") {
//
//            } else {
//
//            }
        }
    }

}