package com.ezzy.quizzo.ui.screens.collection_details.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ezzy.quizzo.R
import com.ezzy.quizzo.domain.model.Quiz
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.utils.showToast

@Composable
fun CollectionDetailsTopBar(
    modifier: Modifier = Modifier,
    menuItems: List<Menu>,
    onShareClick: () -> Unit = {},
    onGeneratePinClick: () -> Unit = {},
    onStarClick: () -> Unit = {},
    onEditClick: () -> Unit = {},
    onCloseClick: () -> Unit = {}
) {

    val context = LocalContext.current

    var expanded by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                start = DpDimensions.Smallest,
                end = DpDimensions.Smallest,
                top = DpDimensions.Small,
                bottom = DpDimensions.Small,
            )
        ) {
            IconButton(onClick = { onCloseClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "pay logo",
                    modifier = Modifier.size(DpDimensions.Dp24),
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Text(
                text = "",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.inversePrimary, modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
            )

            IconButton(onClick = { onEditClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.edit),
                    contentDescription = "pay logo",
                    modifier = Modifier.size(DpDimensions.Dp24),
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            IconButton(onClick = { onStarClick() }) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "pay logo",
                    modifier = Modifier.size(DpDimensions.Dp24),
                    tint = MaterialTheme.colorScheme.inversePrimary
                )
            }

            Box(
                contentAlignment = Alignment.BottomCenter
            ) {


                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        painter = painterResource(id = R.drawable.more),
                        contentDescription = "notification logo",
                        modifier = Modifier.size(DpDimensions.Dp24),
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )
                }

                androidx.compose.animation.AnimatedVisibility(
                    visible = expanded,
                    enter = slideInVertically(animationSpec = tween(2_000), initialOffsetY = { it }),
                    exit = slideOutVertically(animationSpec = tween(2_000), targetOffsetY = { it })
                ) {
                    MaterialTheme(
                        shapes = MaterialTheme.shapes.copy(
                            extraSmall = RoundedCornerShape(
                                DpDimensions.Small
                            )
                        )
                    ) {

                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false },
                            modifier = Modifier
                                .background(
                                    MaterialTheme.colorScheme.background,
                                    RoundedCornerShape(DpDimensions.Small)
                                )
                                .border(
                                    BorderStroke(
                                        width = 1.dp,
                                        color = MaterialTheme.colorScheme.outline,
                                    ),
                                    RoundedCornerShape(DpDimensions.Small)
                                ),

                            ) {

                            menuItems.forEachIndexed { index, menu ->
                                DropdownMenuItem(
                                    text = {
                                        Text(
                                            text = menu.name,
                                            style = MaterialTheme.typography.titleMedium,
                                            color = MaterialTheme.colorScheme.inversePrimary
                                        )
                                    }, onClick = {
                                        if (menu.name == "Share"){
                                            onShareClick()
                                            expanded = false
                                        }
                                        else {
                                            onGeneratePinClick()
                                            expanded = false
                                        }
                                    },
                                    leadingIcon = {
                                        Icon(
                                            painter = painterResource(id = menu.icon),
                                            contentDescription = menu.name,
                                            tint = MaterialTheme.colorScheme.inversePrimary,
                                            modifier = Modifier.size(DpDimensions.Dp20)
                                        )
                                    }
                                )

//                                MenuItem(menu = menu, index = index, size = menuItems.size,
//                                    onClick = {
//                                        if (menu.name == "Share") onShareClick()
//                                        else onGeneratePinClick()
//                                    }
//                                )
                            }

                        }
                    }
                }
            }
        }
    }

}

@Preview
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CollectionDetailsTopBarPreview() {
    QuizzoTheme {
        CollectionDetailsTopBar(menuItems = menuItems)
    }
}

@Composable
fun MenuItem(
    menu: Menu,
    modifier: Modifier = Modifier,
    index: Int,
    size: Int,
    onClick: () -> Unit = {}
) {
    Surface(
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background,
        onClick = onClick,
        modifier = modifier
    ) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(DpDimensions.Small),
            ) {
                Icon(
                    painter = painterResource(id = menu.icon), contentDescription = menu.name,
                    tint = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier.size(DpDimensions.Dp20)
                )
                Text(
                    text = menu.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier.weight(1f)
                )
            }
            if (index + 1 < size) {
                Divider(color = MaterialTheme.colorScheme.outline)
            }
        }
    }
}

data class Menu(
    val name: String,
    @DrawableRes val icon: Int
)

val menuItems = listOf(
    Menu(name = "Share", icon = R.drawable.send),
    Menu(name = "Generate PIN & QR Code", icon = R.drawable.grid)
)