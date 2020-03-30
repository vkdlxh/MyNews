package com.archive.mynews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.api.NewsError
import com.archive.mynews.api.NewsRepository
import com.archive.mynews.api.NewsResponse
import com.archive.mynews.api.Result
import com.archive.mynews.model.Article
import kotlinx.android.synthetic.main.fragment_everything.*

/**
 * A simple [Fragment] subclass.
 */
class EverythingFragment : Fragment() {

    private var articleList : List<Article> = ArrayList()
    lateinit var everythingRecyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var articleView = inflater.inflate(R.layout.fragment_everything, container, false)

        NewsRepository.getKeywordNews ("korea", callback = object : Result<NewsResponse> {
            override fun onSuccess(response: NewsResponse) {
                articleList = response.articles
                everythingRecyclerView = articleView.findViewById(R.id.recycler_everything) as RecyclerView
                everythingRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                everythingRecyclerView.adapter = EverythingAdapter(requireContext(), articleList)
            }

            override fun onFailure(error: NewsError) {

            }
        })

        if (newsSearch != null) {
            newsSearch.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
                when (actionId) {
                    EditorInfo.IME_ACTION_SEARCH -> {
                        Toast.makeText(context, "검색성공", Toast.LENGTH_SHORT).show()

                    }

                    else -> {
                        Toast.makeText(context, "검색실패", Toast.LENGTH_SHORT).show()
                        return@OnEditorActionListener false
                    }
                }
                true
            })
        }

        return articleView
    }
}
