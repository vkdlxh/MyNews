package com.archive.mynews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.api.NewsError
import com.archive.mynews.api.NewsRepository
import com.archive.mynews.api.NewsResponse
import com.archive.mynews.api.Result
import com.archive.mynews.model.Article

/**
 * A simple [Fragment] subclass.
 */
class EverythingFragment : Fragment() {
//
//    private var articleList : List<Article> = ArrayList()
//    lateinit var everythingRecyclerView : RecyclerView
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//
//        var articleView = inflater.inflate(R.layout.fragment_everything, container, false)
//
//        NewsRepository.getKeywordNews ("123", callback = object : Result<NewsResponse> {
//            override fun onSuccess(response: NewsResponse) {
//                articleList = response.articles
//                everythingRecyclerView = articleView.findViewById(R.id.recycler_everything) as RecyclerView
//                everythingRecyclerView.layoutManager = LinearLayoutManager(requireContext())
//                everythingRecyclerView.adapter = EverythingAdapter(requireContext(), articleList)
//            }
//
//            override fun onFailure(error: NewsError) {
//
//            }
//        })
//
//        return articleView
//    }
}
