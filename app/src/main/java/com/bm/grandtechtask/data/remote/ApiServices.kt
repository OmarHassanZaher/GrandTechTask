package com.bm.grandtechtask.data.remote

import com.bm.grandtechtask.data.model.response.MatchesResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET("competitions/2021/matches")
    suspend fun getMatches() :Response<MatchesResponse?>
}