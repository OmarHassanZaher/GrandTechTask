package com.bm.grandtechtask.presentation.homefragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bm.grandtechtask.R
import com.bm.grandtechtask.data.model.response.MatchesResponse
import com.bm.grandtechtask.databinding.CardLayoutBinding
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MatchesAdapter @Inject constructor(@ApplicationContext val context: Context):
    RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {
    private lateinit var binding : CardLayoutBinding
    private var cardList:ArrayList<MatchesResponse.Matche?> = ArrayList()
    inner class ViewHolder (binding: CardLayoutBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MatchesResponse.Matche?) {
            binding.apply {
                homeTeamName.text = item?.homeTeam?.name
                awayTeamName.text =item?.awayTeam?.name
                resultTx.text = item?.score?.fullTime?.homeTeam.toString()
                dayTx.text = item?.matchday.toString()
                startMatchTx.text= item?.utcDate
                liveTx.text=item?.season?.startDate
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = CardLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cardList[position])
        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return cardList.size
    }
    fun setData(list: List<MatchesResponse.Matche?>) {
        if (this.cardList.isNotEmpty())
            this.cardList.clear()
        this.cardList.addAll(list)
        notifyDataSetChanged()

    }
}