package com.ezzy.quizzo.ui.screens.premium

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.ezzy.quizzo.ui.screens.premium.components.FreeVsPremiumItem
import com.ezzy.quizzo.ui.screens.premium.model.differences
import com.ezzy.quizzo.ui.theme.DpDimensions

@Composable
fun FreeVsPremium(
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(DpDimensions.Normal),
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        horizontal = DpDimensions.Normal,
                        vertical = DpDimensions.Small
                    ),
                verticalArrangement = Arrangement.spacedBy(DpDimensions.Smallest)
            ) {
                item {
                    Column(
                        horizontalAlignment = Alignment.End
                    ) {
                        Spacer(modifier = Modifier.height(DpDimensions.Small))
                        Row(horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small)) {
                            Text(
                                text = "FREE",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.inversePrimary
                            )
                            Text(
                                text = "PREMIUM",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.inversePrimary
                            )
                        }
                        Spacer(modifier = Modifier.height(DpDimensions.Small))
                        Divider(color = MaterialTheme.colorScheme.outline)
                        Spacer(modifier = Modifier.height(DpDimensions.Small))
                    }
                }
                items(differences) {
                    FreeVsPremiumItem(freeVsPremium = it, modifier = Modifier.fillMaxWidth())
                }
            }

        }
    }

}