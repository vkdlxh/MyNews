package com.archive.mynews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.api.*
import com.archive.mynews.model.Source

/**
 * A simple [Fragment] subclass.
 */
class SourceFragment : Fragment() {

    private var sourceList : List<Source> = ArrayList()
    lateinit var sourceRecyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var sourceView = inflater.inflate(R.layout.fragment_source, container, false)

        NewsRepository.getNewsProviders(object : Result<SourceResponse> {
            override fun onSuccess(response: SourceResponse) {
                sourceList = response.sources
                sourceRecyclerView = sourceView.findViewById(R.id.recycler_source)as RecyclerView
                sourceRecyclerView.layoutManager = LinearLayoutManager(requireContext())
                sourceRecyclerView.adapter = SourceAdapter(requireContext(),sourceList)
            }

            override fun onFailure(error: NewsError) {

            }

        })

        return sourceView
    }

}
