package com.ezzy.quizzo.ui.screens.home

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.Coral70
import com.ezzy.quizzo.ui.theme.Orange53
import com.ezzy.quizzo.ui.theme.Turquoise48

data class Discover(
    val title: String,
    @DrawableRes val image: Int,
    val user: String,
    @DrawableRes val userImage: Int,
    val backgroundColor: Color
)

val discovers = listOf(
    Discover(
        title = "Get Smarter with Productivity Quizzes",
        image = R.drawable.calendar_2,
        user = "John Doe",
        userImage = R.drawable.person_1,
        backgroundColor = Turquoise48
    ),
    Discover(
        title = "Great ideas come from Brilliant Minds",
        image = R.drawable.ideass,
        user = "Jane Doe",
        userImage = R.drawable.person_1,
        backgroundColor = Orange53
    ),
    Discover(
        title = "Great ideas come from Brilliant Minds",
        image = R.drawable.plant,
        user = "Jane Doe",
        userImage = R.drawable.person_1,
        backgroundColor = Coral70
    )
)



val trending = listOf(
    Discover(
        title = "Let's Memorize the Names of the Flowers",
        image = R.drawable.flowers_5,
        user = "John Doe",
        userImage = R.drawable.person_1,
        backgroundColor = Turquoise48
    ),
    Discover(
        title = "Earth is Our Home and Will Always Be",
        image = R.drawable.flowers_4,
        user = "Jane Doe",
        userImage = R.drawable.person_1,
        backgroundColor = Orange53
    ),
    Discover(
        title = "Recycle to Keep our World Clean as Always",
        image = R.drawable.forest_1,
        user = "Jane Doe",
        userImage = R.drawable.person_1,
        backgroundColor = Coral70
    )
)

val topPics = listOf(
    Discover(
        title = "Save Life Around, Green Our Earth!",
        image = R.drawable.earth_1,
        user = "John Doe",
        userImage = R.drawable.person_1,
        backgroundColor = Turquoise48
    ),
    Discover(
        title = "Earth is Our Home and Will Always Be",
        image = R.drawable.flowers_3,
        user = "Jane Doe",
        userImage = R.drawable.person_1,
        backgroundColor = Orange53
    ),
    Discover(
        title = "Recycle to Keep our World Clean as Always",
        image = R.drawable.globe_1,
        user = "Jane Doe",
        userImage = R.drawable.person_1,
        backgroundColor = Coral70
    )
)

