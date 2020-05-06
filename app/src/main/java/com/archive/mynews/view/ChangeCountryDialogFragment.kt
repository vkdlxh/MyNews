package com.archive.mynews.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.archive.mynews.R
import com.archive.mynews.common.PreferenceHelper
import com.archive.mynews.model.Country
import com.archive.mynews.model.CountryCode
import java.lang.ClassCastException

class ChangeCountryDialogFragment : DialogFragment() {

    var clickListener: ChangeCountryListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            clickListener = context as ChangeCountryListener
        } catch (e: ClassCastException) {
            Log.e(FRAGMENT_TAG,  "리스너를 상속해주세요")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.fragment_change_contry, null)
        val gridView: GridView = view.findViewById(R.id.grid_view)
        val changeButton: Button = view.findViewById(R.id.button_change)
        val cancelButton: Button = view.findViewById(R.id.button_cancel)

        val selectedCountryCode = PreferenceHelper.countryCode
        val adapter = CountryAdapter(countryList, selectedCountryCode)
        gridView.adapter = adapter
        changeButton.setOnClickListener {
            PreferenceHelper.countryCode = adapter.getSelectedCountryCode()
            clickListener?.onClickChange()
            dismiss()
        }
        cancelButton.setOnClickListener {
            dismiss()
        }
        return view
    }

    private val countryList = listOf (
        Country(CountryCode.UNITED_ARAB_EMIRATES, R.drawable.united_arab_emirates),
        Country(CountryCode.ARGENTINA, R.drawable.argentina),
        Country(CountryCode.AUSTRALIA, R.drawable.australia),
        Country(CountryCode.BRAZIL, R.drawable.brazil),
        Country(CountryCode.BULGARIA, R.drawable.bulgaria),
        Country(CountryCode.CANADA, R.drawable.canada),
        Country(CountryCode.CHINA, R.drawable.china),
        Country(CountryCode.FRANCE, R.drawable.france),
        Country(CountryCode.ITALY, R.drawable.italy),
        Country(CountryCode.JAPAN, R.drawable.japan),
        Country(CountryCode.RUSSIA, R.drawable.russia),
        Country(CountryCode.SINGAPORE, R.drawable.singapore),
        Country(CountryCode.SOUTH_KOREA, R.drawable.south_korea),
        Country(CountryCode.SWEDEN, R.drawable.sweden),
        Country(CountryCode.SWITZERLAND, R.drawable.switzerland),
        Country(CountryCode.THAILAND, R.drawable.thailand),
        Country(CountryCode.TURKEY, R.drawable.turkey),
        Country(CountryCode.UNITED_KINGDOM, R.drawable.united_kingdom),
        Country(CountryCode.UNITED_STATES_OF_STATE, R.drawable.united_states_of_america)
    )

    companion object {
        private const val FRAGMENT_TAG = "custom_dialog"

        fun newInstance() = ChangeCountryDialogFragment()

        fun show(fragmentManager: FragmentManager): ChangeCountryDialogFragment {
            val dialog = newInstance()
            dialog.show(fragmentManager, FRAGMENT_TAG)
            return dialog
        }
    }

    interface ChangeCountryListener {
        fun onClickChange()
    }
}