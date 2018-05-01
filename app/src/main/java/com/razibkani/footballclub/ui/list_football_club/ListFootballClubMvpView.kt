package com.razibkani.footballclub.ui.list_football_club

import com.razibkani.footballclub.data.model.FootballClub
import com.razibkani.footballclub.ui.base.MvpView

interface ListFootballClubMvpView : MvpView {

    fun showLoading()

    fun hideLoading()

    fun updateData(footballClubList: List<FootballClub>)

}