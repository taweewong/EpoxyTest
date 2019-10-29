package com.taweewong.epoxypoc.model.image

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.facebook.drawee.view.SimpleDraweeView
import com.taweewong.epoxypoc.R
import kotlinx.android.synthetic.main.image_item_layout.view.*

@EpoxyModelClass
abstract class ImageEpoxyModel : EpoxyModelWithHolder<ImageEpoxyModel.UserViewHolder>() {
    @EpoxyAttribute
    var title: String = ""

    @EpoxyAttribute
    var path: String = ""

    @EpoxyAttribute
    var onClickListener: View.OnClickListener? = null

    override fun getDefaultLayout(): Int = R.layout.image_item_layout

    override fun createNewHolder(): UserViewHolder = UserViewHolder()

    override fun bind(holder: UserViewHolder) {
        holder.imageView.setImageURI(path)
        holder.container.setOnClickListener(onClickListener)
    }

    inner class UserViewHolder : EpoxyHolder() {
        lateinit var imageView: SimpleDraweeView
        lateinit var container: View

        override fun bindView(itemView: View) {
            imageView = itemView.image_item_display_name_text_view
            container = itemView.image_item_container
        }
    }
}