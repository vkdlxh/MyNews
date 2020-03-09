package com.archive.mynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentPagerAdapter
import com.archive.mynews.api.NewsError
import com.archive.mynews.api.NewsRepository
import com.archive.mynews.api.NewsResponse
import com.archive.mynews.api.Result
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // * 사용 예 (실제로 사용하실 땐 프레젠터 등 액티비티에 코드가 집중되지 않도록 해주세요)
        NewsRepository.getTopHeadlines(callback = object : Result<NewsResponse> {
            override fun onSuccess(response: NewsResponse) {
                // 성공처리
            }

            override fun onFailure(error: NewsError) {
                // 실패처리
            }

        })

        toolbar.setTitle("Tap Layout")
        setSupportActionBar(toolbar)

        val fragmentAdapter = MyNewsPagerAdapter(supportFragmentManager)
        viewPager.adapter = fragmentAdapter

        tabLayout.setupWithViewPager(viewPager)

    }
}
