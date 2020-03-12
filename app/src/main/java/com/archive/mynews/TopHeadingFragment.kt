package com.archive.mynews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.archive.mynews.model.Article

/**
 * A simple [Fragment] subclass.
 */
class TopHeadingFragment : Fragment() {

    private val newsList : ArrayList<Article> = ArrayList()
    lateinit var recyclerMainNewsAdapterOne : TopHeadingAdapter

    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?): View? {
//
//        var recyclerMainNewsAdapter = inflater.inflate(R.layout.item_top_heading, container, false)
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
        return inflater.inflate(R.layout.top_heading, container, false)
    }

}
