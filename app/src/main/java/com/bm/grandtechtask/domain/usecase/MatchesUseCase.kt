package com.bm.grandtechtask.domain.usecase

import com.bm.grandtechtask.data.model.response.MatchesResponse
import com.bm.grandtechtask.data.remote.ApiServices
import com.bm.grandtechtask.data.remote.Resource
import com.bm.grandtechtask.data.remote.ResourceMapper
import javax.inject.Inject

class MatchesUseCase @Inject constructor(
    private val apiServices: ApiServices,
    private val mapper: ResourceMapper<MatchesResponse?>
){
    suspend fun execute(): Resource<MatchesResponse?> = mapper.map(apiServices.getMatches())
}