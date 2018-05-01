package com.razibkani.footballclub.ui.list_football_club

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.TypedArray
import android.os.Handler
import com.razibkani.footballclub.R
import com.razibkani.footballclub.data.model.FootballClub
import com.razibkani.footballclub.ui.base.BasePresenter


class ListFootballClubPresenter : BasePresenter<ListFootballClubMvpView>() {

    fun getFootballClubList(context: Context) {
        mvpView?.showLoading()

        val clubName = context.resources.getStringArray(R.array.club_name).toList()
        val clubDescription = context.resources.getStringArray(R.array.club_description).toList()

        val footballClubList: MutableList<FootballClub> = ArrayList()
        Handler().postDelayed({
            for (index in clubName.indices) {
                footballClubList.add(FootballClub(getDrawable(context, index), clubName[index], clubDescription[index]))
            }

            mvpView?.updateData(footballClubList)
            mvpView?.hideLoading()
        }, 1000)
    }

    @SuppressLint("Recycle")
    private fun getDrawable(context: Context, index: Int): Int {
        val images: TypedArray = context.resources.obtainTypedArray(R.array.club_image)
        return images.getResourceId(index, -1)
    }
}