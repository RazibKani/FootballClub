package com.razibkani.footballclub.ui.list_football_club

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.razibkani.footballclub.data.model.FootballClub
import com.razibkani.footballclub.utils.OnItemClickListener
import org.jetbrains.anko.AnkoContext

/**
 * Created by razibkani on 26/04/18.
 */
class ListFootballClubAdapter : RecyclerView.Adapter<ListFootballClubViewHolder>() {

    private var footballClubList: List<FootballClub> = ArrayList()
    var onItemClickListener: OnItemClickListener<FootballClub>? = null

    fun updateData(newFootballClubList: List<FootballClub>) {
        footballClubList = newFootballClubList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFootballClubViewHolder {
        return ListFootballClubViewHolder.ListFootballClubItemUI()
                .createView(AnkoContext.create(parent.context, parent)).tag as ListFootballClubViewHolder
    }

    override fun getItemCount(): Int {
        return footballClubList.size
    }

    override fun onBindViewHolder(holder: ListFootballClubViewHolder, position: Int) {
        holder.bind(footballClubList[position], onItemClickListener)
    }
}