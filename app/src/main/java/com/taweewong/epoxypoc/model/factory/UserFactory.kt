package com.taweewong.epoxypoc.model.factory

import com.taweewong.epoxypoc.model.UserBase
import com.taweewong.epoxypoc.model.header.UserHeader
import com.taweewong.epoxypoc.model.image.Image
import com.taweewong.epoxypoc.model.user.User
import java.util.*
import kotlin.collections.ArrayList

object UserFactory {
    private val random = Random()
    private val firstNameList = listOf(
        "Mark", "Tony", "Peter", "Satochi", "Ken", "Bruce", "Will", "Lauren"
    )
    private val lastNameList = listOf(
        "Willis", "Parker", "Nami", "BeepBeep", "Kangaroo", "Monitor", "Pikachu", "McDonald"
    )
    private val displayNameList = listOf(
        "lnwza007", "Momo", "Paudkee", "Nachos", "Pizza1112", "Noob2019", "Kenmuay", "SoundKreme"
    )
    private val headerTitleList = listOf(
        "CRUSH on YOU", "BFF", "HATERS", "My future", "Robbers", "Noob guys", "Healer"
    )
    private val imageList = listOf(
        Image(
            id = 0, title = "Yellphone", path = "https://images.unsplash.com/photo-1572289010144-d4031cc0f00b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80"
        ),
        Image(
            id = 1, title = "Brown Fox", path = "https://images.unsplash.com/photo-1563210080-dfe35c83e2eb?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1400&q=80"
        ),
        Image(
            id = 2, title = "Hungry?", path = "https://images.unsplash.com/photo-1568376794508-ae52c6ab3929?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=668&q=80"
        ),
        Image(
            id = 3, title = "Rune Terra", path = "https://images.unsplash.com/photo-1469474968028-56623f02e42e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1506&q=80"
        ),
        Image(
            id = 4, title = "Circle Star", path = "https://images.unsplash.com/photo-1567450121326-28da3797155d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1500&q=80"
        ),
        Image(
            id = 5, title = "Bokeh .", path = "https://images.unsplash.com/photo-1498575207492-cfbed56146c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=802&q=80"
        )
    )

    fun generateUser(): User {
        return User(
            firstName = firstNameList[random.nextInt(8)],
            lastName = lastNameList[random.nextInt(8)],
            displayName = displayNameList[random.nextInt(8)]
        )
    }

    fun generateHeader(): UserHeader {
        return UserHeader(
            title = headerTitleList[random.nextInt(7)]
        )
    }

    fun generateUserList(size: Int): ArrayList<User> {
        val userList = arrayListOf<User>()
        repeat(size) {
            userList.add(generateUser())
        }
        return userList
    }

    fun generateUserListWithHeader(size: Int): ArrayList<UserBase> {
        val userList = arrayListOf<UserBase>()
        repeat(size) { index ->
            when (index) {
                0 -> userList.add(generateHeader())
                else -> if (shouldAddHeader(25)) userList.add(generateHeader())
            }
            userList.add(generateUser())
        }
        return userList
    }

    fun getImageList(): List<Image> = imageList

    private fun shouldAddHeader(chance: Int): Boolean {
        return random.nextInt(100) < chance
    }
}