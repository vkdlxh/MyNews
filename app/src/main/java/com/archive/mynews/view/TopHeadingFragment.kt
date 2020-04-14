package com.archive.mynews.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.R
import com.archive.mynews.api.NewsError
import com.archive.mynews.api.NewsRepository
import com.archive.mynews.api.NewsResponse
import com.archive.mynews.api.Result
import com.archive.mynews.model.Article
import kotlinx.android.synthetic.main.fragment_top_heading.*

/**
 * A simple [Fragment] subclass.
 */
class TopHeadingFragment : Fragment() {

    private var articleList : List<Article> = ArrayList()
    lateinit var topHeadingRecyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var articleView = inflater.inflate(R.layout.fragment_top_heading, container, false)

        NewsRepository.getTopHeadlines(callback = object : Result<NewsResponse> {
            override fun onSuccess(response: NewsResponse) {
                articleList = response.articles
                topHeadingRecyclerView = articleView.findViewById(R.id.recycler_top_heading)as RecyclerView
                topHeadingRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                topHeadingRecyclerView.adapter =
                    TopHeadingAdapter(requireContext(), articleList)
            }

            override fun onFailure(error: NewsError) {

            }
        })
        return articleView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        if (recycler_top_heading.canScrollVertically(-1)) {
//            Toast.makeText(context, "리스트", Toast.LENGTH_SHORT).show()
//        }
    }
}
