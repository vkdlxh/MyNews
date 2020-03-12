package com.archive.mynews

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.archive.mynews.model.Source

class SourceAdapter  (val context: Context, val sourceList: ArrayList<Source>) : RecyclerView.Adapter<mViewH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): mViewH {

          val view = LayoutInflater.from(context).inflate(R.layout.item_source, parent, false)
          return mViewH(view)

        //return mViewH(LayoutInflater.from(context).inflate(R.layout.item_source,parent,false))
    }

    override fun getItemCount(): Int {
        return sourceList.size
    }

    override fun onBindViewHolder(holder: mViewH, position: Int) {
        // 리사이클러뷰가 불려짐
    }
}

class mViewH(view: View) : RecyclerView.ViewHolder(view!!) {
//    var recycler_source = view.friend_List_circle_Profile
//    var friend_Name = view.friend_List_friendName
//    var friend_Status = view.friend_List_friendStatus
}