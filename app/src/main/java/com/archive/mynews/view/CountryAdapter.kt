package com.archive.mynews.view

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.archive.mynews.R
import com.archive.mynews.model.Article
import com.archive.mynews.model.Country
import kotlinx.android.synthetic.main.item_county.view.*

class CountryAdapter(
    private val countryList: List<Country>,
    private var selectedCountryCode: String
) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val context = parent.context
        val itemView = if (convertView == null) {
            val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            inflater.inflate(R.layout.item_county, null)
        } else {
            convertView
        }

        val country = countryList[position]
        val countryTextView = itemView.text_county
        val countryImageView = itemView.image_country
        countryTextView.text = country.countryCode.code
        countryImageView.setImageDrawable(context.resources.getDrawable(country.countryImage))
        itemView.setBackgroundColor(if (country.countryCode.code == selectedCountryCode) {
            Color.LTGRAY
        } else {
            Color.TRANSPARENT
        })
        itemView.setOnClickListener{
            selectedCountryCode = country.countryCode.code
            notifyDataSetChanged()
        }
        return itemView
    }

    override fun getItem(position: Int): Any {
        return countryList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return countryList.size
    }

    fun addCountryList(countryList: List<Country>) {
        this.countryList.listIterator()
        notifyDataSetChanged()
    }

    fun getSelectedCountryCode(): String {
        return selectedCountryCode
    }
}