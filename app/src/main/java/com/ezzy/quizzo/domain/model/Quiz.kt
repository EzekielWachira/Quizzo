package com.ezzy.quizzo.domain.model

import androidx.annotation.DrawableRes
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.screens.home.Author

data class Quiz(
    val title: String,
    val date: String,
    val playsCount: String,
    val quizNo: Int,
    @DrawableRes val image: Int = listOf(
        R.drawable.shelf_1,
        R.drawable.earth_1,
        R.drawable.earth_2,
        R.drawable.flowers,
        R.drawable.forest_1,
        R.drawable.gaming_2,
        R.drawable.globe_2,
        R.drawable.ideass,
        R.drawable.play,
        R.drawable.recycle,
        R.drawable.flowers_2,
        R.drawable.calendar_2
    ).random(),
    val author: Author
)



val quizzes = listOf(
    Quiz(
        title = "Get Smarter with Productivity Questions",
        date = "1 week ago",
        playsCount = "2.3K",
        quizNo = 18,
        author = Author(
            name = "Rayford",
            username = "@rayford_eddings",
            isFollowing = false,
            isVerified = true
        )
    ),
    Quiz(
        title = "Great Ideas Come from Greate Minds",
        date = "2 months ago",
        playsCount = "1.2K",
        quizNo = 23,
        author = Author(
            name = "Willard",
            username = "@top_willad",
            isFollowing = true,
            isVerified = false
        )
    ),
    Quiz(
        title = "Test Your Geography Knowledge",
        date = "3 weeks ago",
        playsCount = "4.5K",
        quizNo = 101,
        author = Author(
            name = "Geography Guru",
            username = "@geo_guru",
            isFollowing = true,
            isVerified = true
        )
    ),
    Quiz(
        title = "Movie Buff Challenge",
        date = "2 months ago",
        playsCount = "2.8K",
        quizNo = 102,
        author = Author(
            name = "Cinephile",
            username = "@movie_buff",
            isFollowing = false,
            isVerified = true
        )
    ),
    Quiz(
        title = "History Trivia: Ancient Civilizations",
        date = "1 month ago",
        playsCount = "3.2K",
        quizNo = 103,
        author = Author(
            name = "History Buff",
            username = "@history_lover",
            isFollowing = true,
            isVerified = false
        )
    ),
    Quiz(
        title = "Science Wonders: Space Exploration",
        date = "3 months ago",
        playsCount = "2.1K",
        quizNo = 104,
        author = Author(
            name = "Space Explorer",
            username = "@cosmic_adventurer",
            isFollowing = true,
            isVerified = true
        )
    ),
    Quiz(
        title = "Cooking Masterclass: Italian Cuisine",
        date = "2 weeks ago",
        playsCount = "5.7K",
        quizNo = 105,
        author = Author(
            name = "Chef Italia",
            username = "@italian_cuisine",
            isFollowing = false,
            isVerified = false
        )
    ),
    Quiz(
        title = "Music Mania: Guess the Song Lyrics",
        date = "1 week ago",
        playsCount = "6.4K",
        quizNo = 106,
        author = Author(
            name = "Lyrics Wizard",
            username = "@music_lyrics",
            isFollowing = true,
            isVerified = true
        )
    ),
    Quiz(
        title = "Sports Fanatic: NBA Trivia",
        date = "4 weeks ago",
        playsCount = "3.9K",
        quizNo = 107,
        author = Author(
            name = "Basketball Junkie",
            username = "@nba_trivia",
            isFollowing = false,
            isVerified = true
        )
    ),
    Quiz(
        title = "Mind-bending Riddles",
        date = "5 weeks ago",
        playsCount = "4.2K",
        quizNo = 108,
        author = Author(
            name = "Riddle Master",
            username = "@mind_riddles",
            isFollowing = true,
            isVerified = true
        )
    ),
    Quiz(
        title = "Travel Enthusiast: World Capitals",
        date = "2 months ago",
        playsCount = "3.6K",
        quizNo = 109,
        author = Author(
            name = "Globe Trotter",
            username = "@world_traveler",
            isFollowing = true,
            isVerified = false
        )
    ),
    Quiz(
        title = "Nature Lovers: Wildlife Safari",
        date = "3 months ago",
        playsCount = "2.5K",
        quizNo = 110,
        author = Author(
            name = "Wildlife Explorer",
            username = "@safari_adventures",
            isFollowing = false,
            isVerified = true
        )
    ),
    Quiz(
        title = "Art History: Famous Paintings",
        date = "6 weeks ago",
        playsCount = "3.8K",
        quizNo = 111,
        author = Author(
            name = "Art Connoisseur",
            username = "@art_history",
            isFollowing = true,
            isVerified = false
        )
    ),
    Quiz(
        title = "Tech Trends: Future of AI",
        date = "2 months ago",
        playsCount = "2.9K",
        quizNo = 112,
        author = Author(
            name = "Tech Enthusiast",
            username = "@ai_future",
            isFollowing = false,
            isVerified = true
        )
    ),
    Quiz(
        title = "Literary Classics: Book Quotes",
        date = "4 weeks ago",
        playsCount = "4.1K",
        quizNo = 113,
        author = Author(
            name = "Bookworm",
            username = "@literary_quotes",
            isFollowing = true,
            isVerified = true
        )
    ),
    Quiz(
        title = "Healthy Living: Nutrition Facts",
        date = "3 weeks ago",
        playsCount = "3.7K",
        quizNo = 114,
        author = Author(
            name = "Nutrition Guru",
            username = "@health_nutrition",
            isFollowing = true,
            isVerified = false
        )
    ),
    Quiz(
        title = "Mythology Mysteries: Greek Gods",
        date = "2 months ago",
        playsCount = "3.0K",
        quizNo = 115,
        author = Author(
            name = "Mythology Scholar",
            username = "@greek_myths",
            isFollowing = false,
            isVerified = true
        )
    ),
    Quiz(
        title = "Culinary Adventure: Thai Cuisine",
        date = "5 weeks ago",
        playsCount = "4.6K",
        quizNo = 116,
        author = Author(
            name = "Thai Foodie",
            username = "@thai_cuisine",
            isFollowing = true,
            isVerified = true
        )
    ),
    Quiz(
        title = "Pop Culture Quiz: 80s Nostalgia",
        date = "3 months ago",
        playsCount = "2.4K",
        quizNo = 117,
        author = Author(
            name = "Pop Culture Geek",
            username = "@nostalgia_80s",
            isFollowing = false,
            isVerified = false
        )
    ),
    Quiz(
        title = "Environmental Awareness: Climate Change",
        date = "1 month ago",
        playsCount = "3.4K",
        quizNo = 118,
        author = Author(
            name = "Climate Activist",
            username = "@climate_awareness",
            isFollowing = true,
            isVerified = true
        )
    ),
    Quiz(
        title = "Mindfulness Meditation: Relaxation",
        date = "4 weeks ago",
        playsCount = "4.0K",
        quizNo = 119,
        author = Author(
            name = "Mindful Guru",
            username = "@mindfulness_meditation",
            isFollowing = true,
            isVerified = false
        )
    ),
    Quiz(
        title = "Traveler's Delight: European Cities",
        date = "2 months ago",
        playsCount = "3.3K",
        quizNo = 120,
        author = Author(
            name = "Europhile",
            username = "@european_travel",
            isFollowing = false,
            isVerified = true
        )
    ),
    Quiz(
        title = "Language Lovers: Spanish Vocabulary",
        date = "6 weeks ago",
        playsCount = "3.5K",
        quizNo = 121,
        author = Author(
            name = "Language Enthusiast",
            username = "@spanish_vocab",
            isFollowing = true,
            isVerified = false
        )
    ),
    Quiz(
        title = "Financial Wisdom: Investment Strategies",
        date = "2 months ago",
        playsCount = "2.7K",
        quizNo = 122,
        author = Author(
            name = "Investment Pro",
            username = "@financial_wisdom",
            isFollowing = false,
            isVerified = true
        )
    ),
    Quiz(
        title = "Famous Landmarks: World Tour",
        date = "4 weeks ago",
        playsCount = "4.3K",
        quizNo = 123,
        author = Author(
            name = "Travel Enthusiast",
            username = "@landmark_tour",
            isFollowing = true,
            isVerified = true
        )
    ),
    Quiz(
        title = "Health and Fitness: Yoga Poses",
        date = "3 weeks ago",
        playsCount = "3.9K",
        quizNo = 124,
        author = Author(
            name = "Yoga Guru",
            username = "@yoga_poses",
            isFollowing = true,
            isVerified = false
        )
    ),
    Quiz(
        title = "Tech Talk: Future of Robotics",
        date = "2 months ago",
        playsCount = "3.1K",
        quizNo = 125,
        author = Author(
            name = "Tech Futurist",
            username = "@robotics_future",
            isFollowing = false,
            isVerified = true
        )
    ),
    Quiz(
        title = "Culinary Challenge: Baking Master",
        date = "5 weeks ago",
        playsCount = "4.7K",
        quizNo = 126,
        author = Author(
            name = "Baking Maestro",
            username = "@baking_challenge",
            isFollowing = true,
            isVerified = true
        )
    ),
    Quiz(
        title = "Pop Culture Quiz: Movie Quotes",
        date = "3 months ago",
        playsCount = "2.6K",
        quizNo = 127,
        author = Author(
            name = "Pop Culture Geek",
            username = "@movie_quotes",
            isFollowing = false,
            isVerified = false
        )
    ),
    Quiz(
        title = "Environmental Conservation: Wildlife Protection",
        date = "1 month ago",
        playsCount = "3.3K",
        quizNo = 128,
        author = Author(
            name = "Conservationist",
            username = "@wildlife_protection",
            isFollowing = true,
            isVerified = true
        )
    ),
    Quiz(
        title = "Mindfulness Meditation: Stress Relief",
        date = "4 weeks ago",
        playsCount = "4.2K",
        quizNo = 129,
        author = Author(
            name = "Mindful Guru",
            username = "@mindfulness_stressrelief",
            isFollowing = true,
            isVerified = false
        )
    ),
    Quiz(
        title = "Traveler's Paradise: Asian Destinations",
        date = "2 months ago",
        playsCount = "3.2K",
        quizNo = 130,
        author = Author(
            name = "Asia Explorer",
            username = "@asian_destinations",
            isFollowing = false,
            isVerified = true
        )
    )
)
