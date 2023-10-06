package com.ezzy.quizzo.ui.screens.stats.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.carlosgub.kotlinm.charts.ChartAnimation
import com.carlosgub.kotlinm.charts.line.LineChart
import com.carlosgub.kotlinm.charts.line.LineChartData
import com.carlosgub.kotlinm.charts.line.LineChartPoint
import com.carlosgub.kotlinm.charts.line.LineChartSeries
import com.ezzy.quizzo.ui.theme.DpDimensions
import com.ezzy.quizzo.ui.theme.QuizzoTheme
import com.ezzy.quizzo.ui.theme.RoyalBlue65

@Composable
fun GraphComponent(
    modifier: Modifier = Modifier,
    lineColor: Color,
) {

    val context = LocalContext.current

    val lineData = remember {
        LineChartData(
            series = listOf(
                LineChartSeries(
                    dataName = "data ",
                    lineColor = lineColor,
                    lineWidth = 3.dp,
                    listOfPoints = (1..10).map { point ->
                        LineChartPoint(
                            x = point.toLong(),
                            y = (1..15).random().toFloat(),
                        )
                    }
                )
            ),
        )
    }

    Surface(
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline,
        ),
        modifier = modifier,
        shape = RoundedCornerShape(DpDimensions.Small),
        color = MaterialTheme.colorScheme.background
    ) {

        Column(modifier = Modifier.padding(horizontal = DpDimensions.Small, vertical = DpDimensions.Normal),) {


            Spacer(modifier = Modifier.height(DpDimensions.Small))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Your Point this Week",
                    style = MaterialTheme.typography.headlineMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = "787 pt",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                )
            }

            Spacer(modifier = Modifier.height(DpDimensions.Small))
            Divider(color = MaterialTheme.colorScheme.outline)
            Spacer(modifier = Modifier.height(DpDimensions.Small))

            LineChart(
                lineChartData = lineData,
                modifier = Modifier
                    .height(200.dp)
                    .padding(start = 0.dp),
                xAxisLabel = {
                    Text(
                        text = (it as Long).toString(),
                        color = MaterialTheme.colorScheme.inversePrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                },

                animation = ChartAnimation.Sequenced(),
                yAxisLabel = {
                    Text(
                        text = (it as Float).toString(),
                        color = MaterialTheme.colorScheme.inversePrimary,
                        style = MaterialTheme.typography.bodySmall
                    )
                },
                overlayDataEntryLabel = { xAxisLabel, value ->

                },
                overlayHeaderLabel = {}
            )
        }

    }

}

@Preview
@Composable
fun GraphComponentPreview() {
    QuizzoTheme {
        GraphComponent(modifier = Modifier.fillMaxWidth(), lineColor = RoyalBlue65)
    }
}