package com.ezzy.quizzo.ui.screens.top_authors_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.screens.home.collections
import com.ezzy.quizzo.ui.screens.home.components.CollectionItem
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun CollectionsTabScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    onSortClick: () -> Unit = {}
) {

    Column(
        modifier = modifier
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = "49 Collections",
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.inversePrimary,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "Newest",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(horizontal = DpDimensions.Smallest)
            )

            IconButton(onClick = { onSortClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.sort),
                    contentDescription = "Sort icon",
                    modifier = Modifier.size(DpDimensions.Dp20),
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }

        }

        Spacer(modifier = Modifier.height(DpDimensions.Small))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small),
            verticalArrangement = Arrangement.spacedBy(DpDimensions.Small)
        ) {


            items(collections) { collection ->
                CollectionItem(collection = collection,
                    onClick = {
//                        navController.navigate("top_collection_details/${it.title}")
                    })
            }

        }

    }

}

@Preview
@Composable
fun CollectionsTabScreenPreview() {
    QuizzoTheme {
        CollectionsTabScreen(navController = rememberNavController())
    }
}