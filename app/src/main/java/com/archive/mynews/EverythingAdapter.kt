package com.archive.mynews

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.model.Article
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_everything.view.*
import kotlinx.android.synthetic.main.item_everything.view.image_source_framework
import kotlinx.android.synthetic.main.item_top_heading.view.*

class EverythingAdapter (val context: Context, private val articleList: List<Article>) : RecyclerView.Adapter<EverythingAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).
            inflate(R.layout.item_everything, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(articleList[position], context)
    }

    class ViewHolder(view: View) :RecyclerView.ViewHolder(view) {
        val layout_top_heading = view.image_source_framework
        val date = view.text_everything_date
        val imageTopHeading = view.image_everything
        val content = view.text_everything_content
        val sourcemedia = view.text_everything_media

        fun bindView(article: Article, context: Context) {
            date.text = article.publishedAt.toString()
            content.text = article.description
            sourcemedia.text = article.url
            Glide.with(context).load(article.urlToImage).into(imageTopHeading)

            layout_top_heading.setOnClickListener(View.OnClickListener {
                Toast.makeText(context, "사이트 연결", Toast.LENGTH_SHORT).show()

                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(article.url))
                context.startActivity(intent)
            })
        }
    }
}