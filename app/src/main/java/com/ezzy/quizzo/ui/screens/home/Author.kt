package com.ezzy.quizzo.ui.screens.home

import androidx.annotation.DrawableRes
import com.ezzy.quizzo.R

data class Author(
    @DrawableRes val avatar: Int = listOf(
        R.drawable.person_1,
        R.drawable.person_2,
        R.drawable.person_3,
        R.drawable.person_4,
        R.drawable.person_5,
    ).random(),
    val name: String,
    val username: String,
    val isFollowing: Boolean = false,
    val isVerified: Boolean = false
)

val authors = listOf(
    Author(name = "Rayford", username = "@rayford_eddings", isFollowing = false, isVerified = true),
    Author(name = "Willard", username = "@top_willad", isFollowing = true, isVerified = false),
    Author(name = "Hannah", username = "@hannah_elards", isFollowing = false, isVerified = false),
    Author(name = "Geoffrey", username = "@jeff", isFollowing = true, isVerified = true),
    Author(name = "Justin", username = "@justin_clinton", isFollowing = true, isVerified = false),
)

val authors2 = listOf(
    Author(name = "Rayford", username = "@rayford_eddings", isFollowing = false, isVerified = true),
    Author(name = "Willard", username = "@top_willad", isFollowing = true, isVerified = false),
    Author(name = "Hannah", username = "@hannah_elards", isFollowing = false, isVerified = false),
    Author(name = "Geoffrey", username = "@jeff", isFollowing = true, isVerified = true),
    Author(name = "Justin", username = "@justin_clinton", isFollowing = true, isVerified = false),
    Author(name = "Alice", username = "@alice_smith", isFollowing = true, isVerified = true),
    Author(name = "Evelyn", username = "@evelyn_jones", isFollowing = false, isVerified = false),
    Author(name = "Michael", username = "@michael_davis", isFollowing = true, isVerified = false),
    Author(name = "Olivia", username = "@olivia_brown", isFollowing = false, isVerified = true),
    Author(name = "Henry", username = "@henry_jackson", isFollowing = true, isVerified = true),
    Author(name = "Sophia", username = "@sophia_robinson", isFollowing = false, isVerified = true),
    Author(name = "William", username = "@william_martin", isFollowing = false, isVerified = false),
    Author(name = "Charlotte", username = "@charlotte_anderson", isFollowing = true, isVerified = false),
    Author(name = "James", username = "@james_smith", isFollowing = false, isVerified = true),
    Author(name = "Emily", username = "@emily_johnson", isFollowing = true, isVerified = true),
    Author(name = "Daniel", username = "@daniel_clark", isFollowing = false, isVerified = false),
    Author(name = "Ava", username = "@ava_wilson", isFollowing = true, isVerified = false),
    Author(name = "Alexander", username = "@alexander_harris", isFollowing = true, isVerified = false),
    Author(name = "Mia", username = "@mia_miller", isFollowing = false, isVerified = true),
    Author(name = "Benjamin", username = "@benjamin_wright", isFollowing = true, isVerified = true)
)
