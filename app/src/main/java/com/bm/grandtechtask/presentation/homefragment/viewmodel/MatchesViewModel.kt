package com.bm.grandtechtask.presentation.homefragment.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bm.grandtechtask.data.model.response.MatchesResponse
import com.bm.grandtechtask.data.remote.Resource
import com.bm.grandtechtask.domain.usecase.MatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel@Inject constructor(
    private val mMatchesUseCase: MatchesUseCase,
) : ViewModel() {
    private val matchLiveData: MutableLiveData<Resource<MatchesResponse?>> = MutableLiveData()

    init {
        getHomeData()
    }

    private fun getHomeData() = viewModelScope.launch(Dispatchers.IO) {
        try {
            matchLiveData.postValue(Resource.loading())
            val result = mMatchesUseCase.execute()
            matchLiveData.postValue(result)
        } catch (e: Exception) {
            matchLiveData.postValue(Resource.domainError(e))
        }
    }

    fun getMatchLiveData(): LiveData<Resource<MatchesResponse?>> = matchLiveData
}
