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

    private val source_DataArray : ArrayList<Source> = ArrayList()
    lateinit var recyclerView1 : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var rootView = inflater.inflate(R.layout.source, container, false)
        source_DataArray.add(Source("1","1","1","1","1","1"))

        recyclerView1 = rootView.findViewById(R.id.recycler_source)as RecyclerView
        recyclerView1.layoutManager = LinearLayoutManager(requireContext())
        recyclerView1.adapter = SourceAdapter(requireContext(),source_DataArray)

        return rootView
        //return inflater.inflate(R.layout.source, container, false)
    }

}
