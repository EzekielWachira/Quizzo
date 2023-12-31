package com.ezzy.quizzo.ui.screens.find_friends

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.common.CategoryHeader
import com.ezzy.quizzo.ui.common.CommonAppBarWithTitle
import com.ezzy.quizzo.ui.common.SearchBar
import com.ezzy.quizzo.ui.common.state.SearchState
import com.ezzy.quizzo.ui.screens.find_friends.components.FriendItem
import com.ezzy.quizzo.ui.screens.find_friends.components.FriendsConnectTop
import com.ezzy.quizzo.ui.screens.find_friends.components.friendList
import com.ezzy.quizzo.ui.screens.settings.SettingsViewModel
import com.ezzy.quizzo.ui.theme.DarkGrey11
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun FindFriendsScreen(navController: NavController) {

    val systemUiController = rememberSystemUiController()
    val settingsViewModel: SettingsViewModel = hiltViewModel()
    val isDarkModeEnabled by settingsViewModel.isDarkModeEnabled.collectAsStateWithLifecycle(initialValue = false)
    val useDarkIcons = !isDarkModeEnabled

    var state by remember {
        mutableStateOf(SearchState())
    }

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = if (useDarkIcons)
                Color.White else DarkGrey11,
            darkIcons = useDarkIcons
        )
    }

    Scaffold(topBar = {
        CommonAppBarWithTitle(
            title = "Find friends", backIcon = Icons.AutoMirrored.Outlined.ArrowBack,
            modifier = Modifier.fillMaxWidth(),
        ) { navController.popBackStack() }
    }
    ) { paddingValues ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small),
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = DpDimensions.Normal)
        ) {

            item {
                Column(modifier = Modifier.fillMaxWidth()) {

                    Spacer(modifier = Modifier.height(DpDimensions.Small))
                    SearchBar(
                        placeholder = stringResource(R.string.search_email_name_),
                        state = state,
                        modifier = Modifier.fillMaxWidth(),
                        onSearch = {
                            state = state.copy(query = it)
                        }
                    )
                    Spacer(modifier = Modifier.height(DpDimensions.Normal))
                    FriendsConnectTop(modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(DpDimensions.Small))
                    CategoryHeader(categoryTitle = "People you may know", onClick = { })
                }
            }

            items(friendList) { friend ->
                FriendItem(friend = friend, modifier = Modifier.fillMaxWidth())
            }

        }
    }

}


@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun FindFriendsScreenPreview() {
    QuizzoTheme {
        FindFriendsScreen(rememberNavController())
    }
}