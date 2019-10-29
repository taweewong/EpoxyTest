package com.taweewong.epoxypoc.controller

import android.util.Log
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.taweewong.epoxypoc.model.factory.UserFactory
import com.taweewong.epoxypoc.model.header.UserHeader
import com.taweewong.epoxypoc.model.header.UserHeaderEpoxyModel_
import com.taweewong.epoxypoc.model.image.ImageEpoxyModel_
import com.taweewong.epoxypoc.model.user.User
import com.taweewong.epoxypoc.model.user.UserEpoxyModel_

class UserEpoxyController : EpoxyController() {
    var userList = UserFactory.generateUserListWithHeader(10)

    init {
        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }

    override fun buildModels() {
        userList.forEachIndexed { index, user ->
            when (user) {
                is User -> {
                    UserEpoxyModel_()
                        .id(index.toLong())
                        .displayName(user.displayName)
                        .name("${user.firstName} ${user.lastName}")
                        .onClickListener { model, parentView, clickedView, position ->
                            Log.d("DEBUG_CLICK", model.displayName())
                        }
                        .addTo(this)
                }
                is UserHeader -> {
                    UserHeaderEpoxyModel_()
                        .id(index.toLong())
                        .title(user.title)
                        .addTo(this)
                    addImageEpoxyModelList()
                }
            }
        }
    }

    private fun addImageEpoxyModelList() {
        val imageEpoxyList = UserFactory.getImageList().map { image ->
            ImageEpoxyModel_()
                .id(image.id)
                .title(image.title)
                .path(image.path)
        }
        CarouselModel_()
            .id("IMAGE_LIST")
            .models(imageEpoxyList)
            .addTo(this)
    }
}