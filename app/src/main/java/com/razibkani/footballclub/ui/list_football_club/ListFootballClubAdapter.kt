package com.razibkani.footballclub.ui.list_football_club

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.razibkani.footballclub.data.model.FootballClub

/**
 * Created by razibkani on 26/04/18.
 */
class ListFootballClubAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val footballClubList: List<FootballClub> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return footballClubList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}