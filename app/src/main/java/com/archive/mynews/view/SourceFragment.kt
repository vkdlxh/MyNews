package com.archive.mynews.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.R
import com.archive.mynews.api.*
import com.archive.mynews.model.Source
import kotlinx.android.synthetic.main.fragment_source.view.*

/**
 * A simple [Fragment] subclass.
 */
class SourceFragment : Fragment() {

    lateinit var sourceRecyclerView : RecyclerView
    private lateinit var adapter : SourceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var sourceView = inflater.inflate(R.layout.fragment_source, container, false)

        adapter = SourceAdapter(requireContext())
        sourceRecyclerView = sourceView.recycler_source as RecyclerView
        sourceRecyclerView.adapter = adapter
        sourceRecyclerView.layoutManager = LinearLayoutManager(requireContext())


        NewsRepository.getNewsProviders(object : Result<SourceResponse> {
            override fun onSuccess(response: SourceResponse) {
                adapter.addSourceList(response.sources)
            }

            override fun onFailure(error: NewsError) {

            }

        })
        return sourceView
    }

}
