package com.taweewong.epoxypoc.model.header

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.taweewong.epoxypoc.R
import kotlinx.android.synthetic.main.user_header_item_layout.view.*

@EpoxyModelClass
abstract class UserHeaderEpoxyModel : EpoxyModelWithHolder<UserHeaderEpoxyModel.UserHeaderViewHolder>() {
    @EpoxyAttribute
    var title: String = ""

    override fun getDefaultLayout(): Int = R.layout.user_header_item_layout

    override fun createNewHolder(): UserHeaderViewHolder = UserHeaderViewHolder()

    override fun bind(holder: UserHeaderViewHolder) {
        holder.textViewTitle.text = title
    }

    inner class UserHeaderViewHolder : EpoxyHolder() {
        lateinit var textViewTitle: TextView

        override fun bindView(itemView: View) {
            textViewTitle = itemView.user_header_item_title_text_view
        }
    }
}