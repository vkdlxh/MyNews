package com.archive.mynews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.model.Article
import com.archive.mynews.model.Category
import kotlinx.android.synthetic.main.item_top_heading.view.*

class TopHeadingAdapter(val context: Context, private val articleList: List<Article>) : RecyclerView.Adapter<TopHeadingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).
            inflate(R.layout.item_top_heading, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindView(articleList[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageTopHeading = view.image_top_heading
        val content = view.text_top_heading_content
        val sourcemedia = view.text_top_heading_media

        fun bindView(article: Article) {
            //imageTopHeading.imagesour = article.fragment_source
            content.text = article.description
            sourcemedia.text = article.url

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

