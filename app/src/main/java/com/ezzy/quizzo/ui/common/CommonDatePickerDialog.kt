package com.ezzy.quizzo.ui.common

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.ezzy.quizzo.R
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import java.time.Instant

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonDatePickerDialog(
    openDialog: Boolean,
    onDismiss: () -> Unit = {},
    title: String,
    onDateSelected: (isDatePickerOpen: Boolean, selectedDate: Long?) -> Unit
) {

    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now().toEpochMilli()
    )

    if (openDialog)
        DatePickerDialog(
            onDismissRequest = onDismiss,
            confirmButton = {
                TextButton(onClick = {
                    onDateSelected(false, datePickerState.selectedDateMillis)

                }) {
                    Text(
                        text = stringResource(R.string.ok),
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            },
            shape = RoundedCornerShape(DpDimensions.Normal),
            modifier = Modifier.fillMaxWidth(),
            colors = DatePickerDefaults.colors(
                containerColor = MaterialTheme.colorScheme.background,
                headlineContentColor = MaterialTheme.colorScheme.inversePrimary,
                titleContentColor = MaterialTheme.colorScheme.inversePrimary,
                selectedDayContainerColor =  MaterialTheme.colorScheme.background
            )
        ) {
            DatePicker(state = datePickerState,
                dateValidator = { timeStamp ->
                    timeStamp > Instant.now().toEpochMilli()
                },
                colors = DatePickerDefaults.colors(
                    containerColor = MaterialTheme.colorScheme.background,
                    headlineContentColor = MaterialTheme.colorScheme.inversePrimary,
                    titleContentColor = MaterialTheme.colorScheme.inversePrimary,
                )
            )
        }

}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun CommonDatePickerDialogPreview() {
    QuizzoTheme {
        CommonDatePickerDialog(title = "Select date", openDialog = true, onDateSelected = {_, _ ->})
    }
}