package com.razibkani.footballclub.ui.base

import android.content.Context
import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

/**
 * Created by razibkani on 26/04/18.
 */

abstract class BaseViewHolder<in T>(ctx: Context) : BaseViewProvider, AnkoComponent<Context> {

    abstract override fun createView(ui: AnkoContext<Context>): View

    abstract fun bindData(data: T)

    override val view: View by lazy {
        createView(AnkoContext.Companion.create(ctx))
    }
}