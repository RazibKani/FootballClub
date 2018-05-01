package com.razibkani.footballclub.ui.list_football_club

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.widget.ProgressBar
import com.razibkani.footballclub.data.model.FootballClub
import com.razibkani.footballclub.ui.base.BaseActivity
import com.razibkani.footballclub.ui.detail_football_club.DetailFootballClubActivity
import com.razibkani.footballclub.utils.OnItemClickListener
import com.razibkani.footballclub.utils.hide
import com.razibkani.footballclub.utils.visible
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.progressBar
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity

class ListFootballClubActivity : BaseActivity(), ListFootballClubMvpView {

    lateinit var presenter: ListFootballClubPresenter
    lateinit var footballClubAdapter: ListFootballClubAdapter

    lateinit var footballClubRecyclerView: RecyclerView
    lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPresenter()
        initAdapter()
        buildUI()
        presenter.getFootballClubList(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    override fun showLoading() {
        progressBar.visible()
    }

    override fun hideLoading() {
        progressBar.hide()
    }

    override fun updateData(footballClubList: List<FootballClub>) {
        footballClubAdapter.updateData(footballClubList)
    }

    private fun initPresenter() {
        presenter = ListFootballClubPresenter()
        presenter.attachView(this)
    }

    private fun initAdapter() {
        footballClubAdapter = ListFootballClubAdapter()
        footballClubAdapter.onItemClickListener = object : OnItemClickListener<FootballClub> {
            override fun onClick(item: FootballClub) {
                startActivity<DetailFootballClubActivity>(DetailFootballClubActivity.ARG_FOOTBALL_CLUB to item)
            }
        }
    }

    private fun buildUI() {
        frameLayout {
            lparams(width = matchParent, height = matchParent)

            progressBar = progressBar {
                isIndeterminate = true
                visibility = View.GONE
            }.lparams {
                gravity = Gravity.CENTER
            }

            footballClubRecyclerView = recyclerView {
                val orientation = LinearLayoutManager.VERTICAL
                layoutManager = LinearLayoutManager(context, orientation, false)
                adapter = footballClubAdapter

            }.lparams(width = matchParent, height = matchParent)
        }
    }
}