package com.razibkani.footballclub.ui.detail_football_club

import android.os.Bundle
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.razibkani.footballclub.data.model.FootballClub
import com.razibkani.footballclub.ui.base.BaseActivity
import org.jetbrains.anko.*

class DetailFootballClubActivity : BaseActivity(), DetailFootballClubMvpView {

    lateinit var presenter: DetailFootballClubPresenter

    private var footballClub: FootballClub? = null

    lateinit var clubImage: ImageView
    lateinit var clubName: TextView
    lateinit var clubDescription: TextView

    companion object {
        const val ARG_FOOTBALL_CLUB = "arg_football_club"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPresenter()
        buildUI()
        bindData()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    private fun initPresenter() {
        presenter = DetailFootballClubPresenter()
        presenter.attachView(this)
    }

    private fun buildUI() {
        verticalLayout {
            lparams(width = matchParent, height = matchParent)
            gravity = Gravity.CENTER_HORIZONTAL
            padding = dip(16)

            clubImage = imageView().lparams(width = dip(64), height = dip(64))

            clubName = textView {
                textSize = 16f
            }.lparams {
                topMargin = dip(4)
            }

            clubDescription = textView().lparams {
                topMargin = dip(16)
            }
        }
    }

    private fun bindData() {
        footballClub = intent.getParcelableExtra(ARG_FOOTBALL_CLUB)
        footballClub?.let {
            clubImage.imageResource = it.image
            clubName.text = it.name
            clubDescription.text = it.description
        }
    }
}