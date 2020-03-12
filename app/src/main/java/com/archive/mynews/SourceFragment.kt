package com.archive.mynews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.model.Source

/**
 * A simple [Fragment] subclass.
 */
class SourceFragment : Fragment() {

    private val sourceList : ArrayList<Source> = ArrayList()
    lateinit var sourceRecyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var sourceView = inflater.inflate(R.layout.source, container, false)
        sourceList.add(Source("abc-news","ABC News","Your trusted source for breaking news, analysis, exclusive interviews, headlines, and videos at ABCNews.com.",
            "https://abcnews.go.com","general","en", "us"))

        sourceRecyclerView = sourceView.findViewById(R.id.recycler_source)as RecyclerView
        sourceRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        sourceRecyclerView.adapter = SourceAdapter(requireContext(),sourceList)

        return sourceView
    }

}
