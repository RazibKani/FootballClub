package com.razibkani.footballclub.ui.list_football_club

import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.razibkani.footballclub.data.model.FootballClub
import com.razibkani.footballclub.ui.base.BaseViewHolder
import org.jetbrains.anko.*
import kotlin.properties.Delegates

/**
 * Created by razibkani on 26/04/18.
 */
class ListFootballClubViewHolder(context: Context) : BaseViewHolder<FootballClub>(context) {

    private var clubImage: ImageView by Delegates.notNull()
    private var clubName: TextView by Delegates.notNull()

    override fun bindData(data: FootballClub) {
        clubImage.setImageResource(data.image)
        clubName.text = data.name
    }

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        return linearLayout {
            orientation = LinearLayout.HORIZONTAL
            gravity = Gravity.CENTER_VERTICAL
            lparams(width = matchParent, height = wrapContent) {
                margin = dip(8)
            }

            clubImage = imageView().lparams(
                    width = dip(48),
                    height = dip(48))

            clubName = textView().lparams(
                    width = wrapContent,
                    height = wrapContent
            )
        }
    }
}