package com.archive.mynews.view

import android.app.PendingIntent.getActivity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.archive.mynews.R
import com.archive.mynews.api.NewsError
import com.archive.mynews.api.NewsRepository
import com.archive.mynews.api.NewsResponse
import com.archive.mynews.api.Result
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), ChangeCountryDialogFragment.ChangeCountryListener {

    //private lateinit var adapter : CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        TopHeadingAdapter.ViewHolder(viewPager)

        // * 사용 예 (실제로 사용하실 땐 액티비티에 코드가 집중되지 MVP 나눠주세요)
        NewsRepository.getTopHeadlines(callback = object : Result<NewsResponse> {
            override fun onSuccess(response: NewsResponse) {
                // 성공처리
            }

            override fun onFailure(error: NewsError) {
                // 실패처리
            }

        })

        val fragmentAdapter = MyNewsPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)

        viewPager?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {


            }
            override fun onPageSelected(position: Int) {
                if (position == 0) {
                    button_change_country.visibility = View.VISIBLE
                } else {
                    button_change_country.visibility = View.GONE
                }
                // 페이지 이동시 hide keyboard
                (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).also {
                    it.hideSoftInputFromWindow(window.currentFocus!!.windowToken, 0)
                }
            }

        })

        // TODO: 국가변경 액티비티 화면 이동용 테스트 버튼입니다.
        //  나중에 화면 디자인에 맞춰서 변경해주세요.
        button_change_country.setOnClickListener {
            ChangeCountryDialogFragment.show(fragmentManager = supportFragmentManager)
        }
    }

    override fun onClickChange() {
        //Toast.makeText(this, "국가변경 완료", Toast.LENGTH_SHORT).show()
        // TODO: 국가변경 완료됐으므로 화면 갱신
        NewsRepository.getTopHeadlines(callback = object : Result<NewsResponse> {
            override fun onSuccess(response: NewsResponse) {
                Toast.makeText(this@MainActivity, "국가변경 완료", Toast.LENGTH_SHORT).show()
                //adapter.addCountryList()

            }

            override fun onFailure(error: NewsError) {
                // 실패처리
            }
        })
    }
}
