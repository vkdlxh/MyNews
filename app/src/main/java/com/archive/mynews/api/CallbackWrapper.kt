package com.archive.mynews.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CallbackWrapper<T>(
    private val result: Result<T>
) : Callback<T> {

    override fun onResponse(call: Call<T>, response: Response<T>) {
        if (response.isSuccessful) {
            result.onSuccess(response.body()!!)
        } else {
            val errorBodyJson = response.errorBody()?.string()
            val error = Gson().fromJson(errorBodyJson, NewsError::class.java)
            result.onFailure(error)
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        // TODO 에러 처리
        val error = NewsError(
            Status.ERROR, null, t.localizedMessage
        )
        result.onFailure(error)
    }
}