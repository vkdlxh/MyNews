package com.archive.mynews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.model.Article
import kotlinx.android.synthetic.main.item_news_page_one.*

/**
 * A simple [Fragment] subclass.
 */
class NewsPageOne : Fragment() {

    private val newsList : ArrayList<Article> = ArrayList()
    lateinit var recyclerMainNewsAdapter : RecyclerMainNewsAdapter

    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?): View? {
//
//        var recyclerMainNewsAdapter = inflater.inflate(R.layout.item_news_page_one, container, false)
//        newsList.add(Article("","","","", "",""))
//
//        recyclerMainNewsAdapter = mainNewsItem.findViewById(R.id.image!!)as RecyclerView
//        recyclerMainNewsAdapter.layoutManager = LinearLayoutManager(requireContext())
//        recyclerMainNewsAdapter.adapter = RecyclerMainNewsAdapter(requireContext(),newsList)

//        return mainNewsItem
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.news_page_one, container, false)
    }

}
