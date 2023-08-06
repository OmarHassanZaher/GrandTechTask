package com.bm.grandtechtask.presentation.homefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bm.grandtechtask.R
import com.bm.grandtechtask.data.model.response.MatchesResponse
import com.bm.grandtechtask.data.remote.Resource
import com.bm.grandtechtask.databinding.FragmentHomeBinding
import com.bm.grandtechtask.presentation.basefragment.BaseFragment
import com.bm.grandtechtask.presentation.homefragment.adapter.MatchesAdapter
import com.bm.grandtechtask.presentation.homefragment.viewmodel.MatchesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment() {
    private var binding: FragmentHomeBinding? = null
    private lateinit var viewModel : MatchesViewModel
    @Inject
    lateinit var adapter: MatchesAdapter

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialization()
    }


    private fun initialization() {
        initViewModel()
        initRV()
    }

    private fun initRV() {
       binding!!.matchList.adapter =adapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this)[MatchesViewModel::class.java]
        viewModel.getMatchLiveData().observe(viewLifecycleOwner, matchObserver)
    }
    private var matchObserver: Observer<Resource<MatchesResponse?>> = Observer {
        when (it.status) {
            Resource.Status.LOADING -> {
                showLoading()
            }
            Resource.Status.SUCCESS -> {
                adapter.setData(it.data?.matches as List<MatchesResponse.Matche?>)
                hideLoading()
            }
            Resource.Status.API_ERROR -> {
                handleError(it.error_msg.toString())
                hideLoading()
            }
            Resource.Status.DOMAIN_ERROR -> {
                handleError(it.throwable.toString())
                hideLoading()
            }
        }
    }
    private fun showLoading() {
        binding!!.loadingIndicator.loadingIndicatorLayout.visibility = View.VISIBLE

    }
    private fun hideLoading() {
        binding!!.loadingIndicator.loadingIndicatorLayout.visibility = View.INVISIBLE

    }
}