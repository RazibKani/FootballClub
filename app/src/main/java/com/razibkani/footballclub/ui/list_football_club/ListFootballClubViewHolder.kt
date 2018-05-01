package com.razibkani.footballclub.ui.list_football_club

import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.razibkani.footballclub.data.model.FootballClub
import com.razibkani.footballclub.utils.OnItemClickListener
import org.jetbrains.anko.*
import kotlin.properties.Delegates

/**
 * Created by razibkani on 26/04/18.
 */
class ListFootballClubViewHolder(itemView: View,
                                 private val clubImage: ImageView,
                                 private val clubName: TextView) : RecyclerView.ViewHolder(itemView) {

    fun bind(footballClub: FootballClub, onClickListener: OnItemClickListener<FootballClub>?) {
        clubImage.imageResource = footballClub.image
        clubName.text = footballClub.name

        onClickListener?.let {
            itemView.setOnClickListener { onClickListener.onClick(footballClub) }
        }
    }

    class ListFootballClubItemUI: AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>): View {
            var clubImage: ImageView by Delegates.notNull()
            var clubName: TextView by Delegates.notNull()

            val itemView = with(ui) {
                linearLayout {
                    orientation = LinearLayout.HORIZONTAL
                    gravity = Gravity.CENTER_VERTICAL
                    lparams(width = matchParent, height = wrapContent) {
                        leftMargin = dip(16)
                        topMargin = dip(8)
                        rightMargin = dip(16)
                        bottomMargin = dip(8)
                    }

                    clubImage = imageView().lparams(
                            width = dip(48),
                            height = dip(48))

                    clubName = textView().lparams(
                            width = wrapContent,
                            height = wrapContent
                    ) {
                        leftMargin = dip(16)
                    }
                }
            }

            itemView.tag = ListFootballClubViewHolder(itemView, clubImage, clubName)
            return itemView
        }
    }
}