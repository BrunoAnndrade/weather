package com.example.weather.Presentation

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun ForecastCard(
    state: ForecastState,
) {

    state.forecastResponse?.list.let { data ->

        println("Tamanho da lista de previsão meteorológica: ${state.forecastResponse}")


        fun getDayOfTheWeek(dtTxt: String): String {
            try {
                val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
                val date = sdf.parse(dtTxt)

                if (date != null) {
                    val calendar = Calendar.getInstance()
                    calendar.time = date
                    return when (calendar.get(Calendar.DAY_OF_WEEK)) {
                        1 -> "Dom"
                        2 -> "Seg"
                        3 -> "Ter"
                        4 -> "Qua"
                        5 -> "Qui"
                        6 -> "Sex"
                        7 -> "Sáb"
                        else -> "Dia inválido"
                    }
                } else {
                    return "Formato de data inválido"
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                return "Erro"
            }
        }

        // each array has 3 hours of differences in API
        // 1 day later
        val oneDayLater = 2

        val tempMinForDayOne = data?.get(oneDayLater)?.main?.temp_min ?: 0.0
        val tempMaxForDayOne = data?.get(oneDayLater)?.main?.temp_max
        val iconTempForDayOne = data?.get(oneDayLater)?.weather?.get(0)?.icon
        val dataForDayOne = data?.get(oneDayLater)?.dt_txt


        // 2 days later
        val twoDayLater = 10
        val tempMinForDayTwo = data?.get(twoDayLater)?.main?.temp_min
        val tempMaxForDayTwo = data?.get(twoDayLater)?.main?.temp_max
        val iconTempForDayTwo = data?.get(twoDayLater)?.weather?.get(0)?.icon
        val dataForDayTwo = data?.get(twoDayLater)?.dt_txt

        // 3 days later
        val threeDayLater = 18
        val tempMinForDayThree = data?.get(threeDayLater)?.main?.temp_min
        val tempMaxForDayThree = data?.get(threeDayLater)?.main?.temp_max
        val iconTempForDayThree = data?.get(threeDayLater)?.weather?.get(0)?.icon
        val dataForDayThree = data?.get(threeDayLater)?.dt_txt

        // 4 days later
        val fourDayLater = 26
        val tempMinForDayFour = data?.get(fourDayLater)?.main?.temp_min
        val tempMaxForDayFour = data?.get(fourDayLater)?.main?.temp_max
        val iconTempForDayFour = data?.get(fourDayLater)?.weather?.get(0)?.icon
        val dataForDayFour = data?.get(fourDayLater)?.dt_txt

        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Blue.copy(0.9f, 0.4f, 0.6f), Color.Blue.copy(0.6f)
                        )
                    ),
                    shape = RoundedCornerShape(10.dp),

                    )
                .width(360.dp), contentAlignment = Alignment.Center

        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                modifier = Modifier.padding(top = 10.dp)

            ) {


                Text(
                    text = "Previsao para os próximos dias",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.CenterHorizontally)

                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(45.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {

                    Text(
                        text = getDayOfTheWeek(dataForDayOne.toString()),
                        modifier = Modifier.width(40.dp),
                        color = Color.White,
                    )

                    AsyncImage(
                        model = "https://openweathermap.org/img/wn/${iconTempForDayOne}@2x.png",
                        contentDescription = "sol",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .clip(CircleShape)
                    )


                    Text(
                        text = "$tempMinForDayOne ºC",
                        modifier = Modifier.width(40.dp),
                        color = Color.White,
                    )

                    Text(
                        text = "$tempMaxForDayOne ºC",
                        style = TextStyle.Default.copy(
                            color = Color.White,
                        )
                    )
                }
                Row(

                    horizontalArrangement = Arrangement.spacedBy(45.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    Text(
                        text = getDayOfTheWeek(dataForDayTwo.toString()),
                        modifier = Modifier.width(40.dp),
                        color = Color.White,
                    )

                    AsyncImage(
                        model = "https://openweathermap.org/img/wn/${iconTempForDayTwo}@2x.png",
                        contentDescription = "sol",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .clip(CircleShape)
                    )

                    Text(
                        text = "$tempMinForDayTwo ºC",
                        modifier = Modifier.width(40.dp),
                        color = Color.White,
                    )
                    Text(
                        text = "$tempMaxForDayTwo ºC",
                        style = TextStyle.Default.copy(
                            Color.White,
                        )
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(45.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    Text(
                        text = getDayOfTheWeek(dataForDayThree.toString()),
                        modifier = Modifier.width(40.dp),
                        color = Color.White,
                    )

                    AsyncImage(
                        model = "https://openweathermap.org/img/wn/${iconTempForDayThree}@2x.png",
                        contentDescription = "sol",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .clip(CircleShape)

                    )

                    Text(
                        text = "$tempMinForDayThree ºC",
                        modifier = Modifier.width(40.dp),
                        color = Color.White,
                    )

                    Text(
                        text = "$tempMaxForDayThree ºC",
                        style = TextStyle.Default.copy(
                            Color.White,
                        )
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.spacedBy(45.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    Text(
                        text = getDayOfTheWeek(dataForDayFour.toString()),
                        modifier = Modifier.width(40.dp),
                        color = Color.White,
                    )

                    AsyncImage(
                        model = "https://openweathermap.org/img/wn/${iconTempForDayFour}@2x.png",
                        contentDescription = "sol",
                        modifier = Modifier
                            .width(30.dp)
                            .height(30.dp)
                            .clip(CircleShape)
                    )


                    Text(
                        text = "$tempMinForDayFour ºC",
                        modifier = Modifier.width(40.dp),
                        color = Color.White,
                    )

                    Text(
                        text = "$tempMaxForDayFour ºC",
                        style = TextStyle.Default.copy(
                            Color.White,
                        )
                    )
                }


            }
        }

    }

}

@Preview
@Composable
fun ForecastPreview() {

    ForecastCard(state = ForecastState())

}






