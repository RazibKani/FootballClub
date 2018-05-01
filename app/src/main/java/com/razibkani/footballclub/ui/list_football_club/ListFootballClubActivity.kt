package com.razibkani.footballclub.ui.list_football_club

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.razibkani.footballclub.data.model.FootballClub
import com.razibkani.footballclub.ui.base.BaseActivity
import com.razibkani.footballclub.utils.OnItemClickListener
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.indeterminateProgressDialog
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.toast

class ListFootballClubActivity : BaseActivity(), ListFootballClubMvpView {

    lateinit var presenter: ListFootballClubPresenter
    lateinit var footballClubAdapter: ListFootballClubAdapter

    lateinit var footballClubRecyclerView: RecyclerView
    lateinit var progressDialog: ProgressDialog

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
        progressDialog.show()
    }

    override fun hideLoading() {
        progressDialog.dismiss()
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
                toast(item.name)
            }
        }
    }

    private fun buildUI() {
        progressDialog = indeterminateProgressDialog("Loading...")

        frameLayout {
            lparams(width = matchParent, height = matchParent)

            footballClubRecyclerView = recyclerView {
                val orientation = LinearLayoutManager.VERTICAL
                layoutManager = LinearLayoutManager(context, orientation, false)
                adapter = footballClubAdapter

            }.lparams(width = matchParent, height = matchParent)
        }
    }
}