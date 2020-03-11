package com.archive.mynews.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentPagerAdapter
import com.archive.mynews.MyNewsPagerAdapter
import com.archive.mynews.R
import com.archive.mynews.api.NewsError
import com.archive.mynews.api.NewsRepository
import com.archive.mynews.api.NewsResponse
import com.archive.mynews.api.Result
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // * 사용 예 (실제로 사용하실 땐 액티비티에 코드가 집중되지 MVP 나눠주세요)
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

        // TODO: 국가변경 액티비티 화면 이동용 테스트 버튼입니다.
        //  나중에 화면 디자인에 맞춰서 변경해주세요.
        button_change_country.setOnClickListener {
            val intent = Intent(this, ChangeCountyActivity::class.java)
            startActivity(intent)
        }
    }
}
