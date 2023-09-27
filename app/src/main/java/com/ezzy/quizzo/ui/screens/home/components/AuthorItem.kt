package com.ezzy.quizzo.ui.screens.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.ui.screens.home.Author
import com.ezzy.quizzo.ui.screens.home.authors
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme

@Composable
fun AuthorItem(modifier: Modifier = Modifier, author: Author) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = DpDimensions.Small)
    ) {

        Image(
            painter = painterResource(id = author.avatar), contentDescription = null,
            modifier = Modifier.size(70.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(DpDimensions.Small))

        Text(
            text = author.name,
            style = MaterialTheme.typography.titleSmall,
            color = MaterialTheme.colorScheme.inversePrimary
        )

    }
}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AuthorItemPreview() {
    QuizzoTheme {
        AuthorItem(author = authors[0])
    }
}