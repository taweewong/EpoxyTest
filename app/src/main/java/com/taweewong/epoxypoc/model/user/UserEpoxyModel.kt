package com.taweewong.epoxypoc.model.user

import android.view.View
import android.widget.TextView
import com.airbnb.epoxy.*
import com.taweewong.epoxypoc.R
import kotlinx.android.synthetic.main.user_item_layout.view.*

@EpoxyModelClass
abstract class UserEpoxyModel : EpoxyModelWithHolder<UserEpoxyModel.UserViewHolder>() {
    @EpoxyAttribute
    var displayName: String = ""

    @EpoxyAttribute
    var name: String = ""

    @EpoxyAttribute
    var onClickListener: View.OnClickListener? = null

    override fun getDefaultLayout(): Int = R.layout.user_item_layout

    override fun createNewHolder(): UserViewHolder = UserViewHolder()

    override fun bind(holder: UserViewHolder) {
        holder.textViewDisplayName.text = displayName
        holder.textViewName.text = name
        holder.container.setOnClickListener(onClickListener)
    }

    inner class UserViewHolder : EpoxyHolder() {
        lateinit var textViewDisplayName: TextView
        lateinit var textViewName: TextView
        lateinit var container: View

        override fun bindView(itemView: View) {
            textViewDisplayName = itemView.user_item_display_name_text_view
            textViewName = itemView.user_item_name_text_view
            container = itemView.user_item_container
        }
    }
}