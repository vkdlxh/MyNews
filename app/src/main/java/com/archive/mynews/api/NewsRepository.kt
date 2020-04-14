package com.archive.mynews.api

import com.archive.mynews.model.Category
import com.archive.mynews.model.CountryCode

// TODO: 클래스로 바꿔 서비스를 인자로 받아야 하는가?
object NewsRepository {
    private val apiService = NewsService.create()
    // TODO: 국가코드 관리
    private var countryCode: CountryCode = CountryCode.SOUTH_KOREA

    /**
     * 헤드라인 뉴스 취득
     * @param category 카테고리
     * @param pageSize 페이지당 표시하는 기사 수
     * @param page 페이지
     * @param callback 결과 콜백
     */
    fun getTopHeadlines(category: Category = Category.GENERAL,
                        pageSize: Int = 20,
                        page: Int = 1,
                        callback: Result<NewsResponse>) {
        apiService.getInternationalHeadlines(
            countryCode.code, category.toLowerCase(), pageSize, page)
            .enqueue(CallbackWrapper(callback))
    }

    /**
     * 특정 단어 뉴스 취득
     * @param keyword 검색어
     * @param pageSize 페이지당 표시하는 기사 수
     * @param page 페이지
     * @param callback 결과 콜백
     */
    fun getKeywordNews(keyword: String,
                       pageSize: Int = 20,
                       page: Int = 1,
                       callback: Result<NewsResponse>) {
        apiService.getKeywordNews(keyword, pageSize, page).enqueue(CallbackWrapper(callback))
    }

    /**
     * 뉴스 제공자(신문사) 정보 취득
     * @param callback 결과 콜백
     */
    fun getNewsProviders(callback: Result<SourceResponse>) {
        apiService.getNewsProviders().enqueue(CallbackWrapper(callback))
    }

    // TODO: 국가코드 관리
    fun setCountryCode(countryCode: CountryCode) {
        this.countryCode = countryCode
    }

}