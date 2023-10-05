package com.ezzy.quizzo.navigation.utils

object NavDestinations {

    const val MAIN_APP = "MAIN_APP"

    object TopCollections {
        const val TOP_COLLECTIONS_MAIN = "top_collections_main"
        const val TOP_COLLECTIONS = "top_collections"
        const val TOP_COLLECTION_DETAILS = "top_collection_details/{collection}"

    }

    object Discover {
        const val DISCOVER_MAIN = "discover_main"
        const val DISCOVER = "discover"
    }

    object Settings {
        const val SETTINGS_MAIN = "settings_main"
        const val SETTINGS = "settings"
        const val NOTIFICATION_SETTINGS = "notification_settings"
    }

    object Splash {
        const val SPLASH_MAIN = "splash_main"
        const val SPLASH = "splash"
    }

    object Auth {
        const val ONBOARDING = "onboarding"
        const val SIGN_UP = "sign_up"
        const val AUTH_MAIN = "auth_main"
        const val AUTH = "auth"
        const val AUTHENTICATION = "authentication"
        const val REGISTRATION_MAIN = "registration_main"
        const val REGISTRATION = "registration"
    }

    object FindFriends {
        const val FIND_FRIENDS_MAIN = "find_friends_main"
        const val FIND_FRIENDS = "find_friends"
    }

    object TopAuthors {
        const val TOP_AUTHORS_MAIN = "top_authors_main"
        const val TOP_AUTHORS = "top_authors"
        const val TOP_AUTHORS_DETAILS = "top_authors_details/{author}"
    }

    object Main {
        const val MAIN = "main"
    }

    object SignupSteps {
        const val SIGNUP_STEPS = "signup_steps"
        const val ACCOUNT_TYPE = "account_type"
        const val WORKPLACE = "workplace"
        const val CREATE_ACCOUNT_1 = "create_account_1"
        const val CREATE_ACCOUNT_2 = "create_account_2"
    }

}