package com.archive.mynews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.archive.mynews.R
import com.archive.mynews.common.PreferenceHelper
import com.archive.mynews.model.Country
import com.archive.mynews.model.CountryCode
import kotlinx.android.synthetic.main.activity_change_county.*

class ChangeCountyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_county)

        val testData = arrayListOf<Country>()
        testData.add(Country(CountryCode.REPUBLIC_OF_KOREA, "한국", R.drawable.south_korea))
        testData.add(Country(CountryCode.JAPAN, "日本", R.drawable.japan))
        testData.add(Country(CountryCode.UNITED_STATES, "United States", R.drawable.united_states))
        testData.add(Country(CountryCode.CHINA, "China", R.drawable.china))
        val selectedCountryCode = PreferenceHelper.countryCode
        val adapter = CountryAdapter(testData, selectedCountryCode)
        grid_view.adapter = adapter

        button_change.setOnClickListener {
            PreferenceHelper.countryCode = adapter.getSelectedCountryCode()
            finish()
        }
    }
}
