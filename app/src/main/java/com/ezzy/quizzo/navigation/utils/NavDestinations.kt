package com.ezzy.quizzo.navigation.utils

object NavDestinations {



    object TopCollections {
        const val TOP_COLLECTIONS_MAIN = "top_collections_main"
        const val TOP_COLLECTIONS = "top_collections"
        const val TOP_COLLECTION_DETAILS = "top_collection_details/{collection}"

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