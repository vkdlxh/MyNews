package com.archive.mynews

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.model.Article
import com.archive.mynews.model.Category
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_top_heading.view.*
import java.util.logging.Logger

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
        val date = view.text_top_heading_date
        val imageTopHeading = view.image_top_heading
        val content = view.text_top_heading_content
        val sourcemedia = view.text_top_heading_media

        fun bindView(article: Article) {
            date.text = article.publishedAt.toString()
            content.text = article.description
            sourcemedia.text = article.url
        }

        fun setBitmap(view: ImageView,bitmap:Bitmap?, article: Article){
            bitmap?.let {
                Glide.with(view.context).load(article.urlToImage).into(imageTopHeading)
            }
        }
    }
}

