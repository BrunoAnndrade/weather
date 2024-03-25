package com.example.weather.Presentation


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weather.R
import com.example.weather.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {

                WeatherScreen()


            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeatherScreen() {


    val viewModelWeather by lazy {
        WeatherViewModel.create()
    }

    val viewModelForecast by lazy {
        ForecastViewModel.create()
    }


    val mainState = viewModelWeather.mainLiveData.observeAsState()
    val weatherState = viewModelWeather.weatherLiveData.observeAsState()
    val windState = viewModelWeather.windSpeedLiveData.observeAsState()
    val mainTemp = mainState.value?.temp
    val iconTemp = weatherState.value?.icon
    val descriptionTemp = weatherState.value?.description
    val mainTempMin = mainState.value?.temp_min
    val mainTempMax = mainState.value?.temp_max
    val feelsLike = mainState.value?.feels_like
    val humidity = mainState.value?.humidity
    val windSpeed = windState.value?.speed

    val cityState = viewModelForecast.cityLiveData.observeAsState()
    val city = cityState.value?.name


    val forecastForDayState = viewModelForecast.listElementLiveData.observeAsState()


    // each array has 3 hours of differences in API
    // 1 day later
    val oneDayLater = 2
    val tempMinForDayOne = forecastForDayState.value?.get(oneDayLater)?.main?.temp_min
    val tempMaxForDayOne = forecastForDayState.value?.get(oneDayLater)?.main?.temp_max
    val iconTempForDayOne = forecastForDayState.value?.get(oneDayLater)?.weather?.firstOrNull()?.icon
    val dataForDayOne = forecastForDayState.value?.get(oneDayLater)?.dt_txt

    // 2 days later
    val twoDayLater = 10
    val tempMinForDayTwo = forecastForDayState.value?.get(twoDayLater)?.main?.temp_min
    val tempMaxForDayTwo = forecastForDayState.value?.get(twoDayLater)?.main?.temp_max
    val iconTempForDayTwo = forecastForDayState.value?.get(twoDayLater)?.weather?.firstOrNull()?.icon
    val dataForDayTwo = forecastForDayState.value?.get(twoDayLater)?.dt_txt

    // 3 days later
    val threeDayLater = 18
    val tempMinForDayThree = forecastForDayState.value?.get(threeDayLater)?.main?.temp_min
    val tempMaxForDayThree = forecastForDayState.value?.get(threeDayLater)?.main?.temp_max
    val iconTempForDayThree = forecastForDayState.value?.get(threeDayLater)?.weather?.firstOrNull()?.icon
    val dataForDayThree = forecastForDayState.value?.get(threeDayLater)?.dt_txt

    // 4 days later
    val fourDayLater = 26
    val tempMinForDayFour = forecastForDayState.value?.get(fourDayLater)?.main?.temp_min
    val tempMaxForDayFour = forecastForDayState.value?.get(fourDayLater)?.main?.temp_max
    val iconTempForDayFour = forecastForDayState.value?.get(fourDayLater)?.weather?.firstOrNull()?.icon
    val dataForDayFour = forecastForDayState.value?.get(fourDayLater)?.dt_txt

    Scaffold(
        topBar = {
            TopAppBar(

                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Black
                ), title = {
                    Text(
                        text = "Weather",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.White,
                    )
                })
        },

        ) { innerPadding ->

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White),

            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(1.dp))



            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Blue.copy(0.7f, 0.3f, 0.7f), Color.Blue.copy(0.6f)
                            )
                        ),
                        shape = RoundedCornerShape(10.dp),

                        )
                    .width(360.dp), contentAlignment = Alignment.Center

            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()

                ) {
                    Text(
                        text = city.toString(),
                        fontSize = 30.sp,
                        style = TextStyle.Default.copy(
                            Color.White,
                        ),
                        fontWeight = FontWeight.Bold,

                        )

                    AsyncImage(
                        model = "https://openweathermap.org/img/wn/$iconTemp@2x.png",
                        contentDescription = null,
                        modifier = Modifier
                            .width(200.dp)
                            .height(120.dp)
                            .clip(CircleShape)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center

                    ) {

                        if (mainTemp != null) {
                            Text(
                                text = mainTemp.toInt().toString() + "ºC",
                                fontSize = 80.sp,
                                modifier = Modifier,
                                style = TextStyle.Default.copy(
                                    Color.White, fontWeight = FontWeight.ExtraBold

                                ),
                            )
                        } else {
                            Text(
                                text = "",
                                fontSize = 100.sp,
                                modifier = Modifier,
                                style = TextStyle.Default.copy(
                                    Color.White, fontWeight = FontWeight.ExtraBold

                                ),
                            )
                        }
                    }
                    Text(
                        text = descriptionTemp.toString().uppercase(),
                        fontSize = 18.sp,
                        style = TextStyle.Default.copy(
                            Color.White,
                        ),
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(5.dp))


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                           ,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically

                    ) {

                        Text(
                            text = "Min:",
                            style = TextStyle.Default.copy(
                                Color.White,
                            ),

                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(end = 5.dp),


                            )
                        if (mainTempMin != null) {
                            Text(
                                text = mainTempMin.toInt().toString() + "ºC",
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier


                            )
                        }

                        Text(
                            text = "Max:",
                            style = TextStyle.Default.copy(
                                Color.White,
                            ),
                            modifier = Modifier.padding(start = 10.dp, end = 2.dp),
                            fontWeight = FontWeight.ExtraBold,


                            )
                        if (mainTempMax != null) {
                            Text(
                                text = mainTempMax.toInt().toString() + "ºC",
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold,

                                )
                        }

                        Spacer(modifier = Modifier.width(10.dp))


                        Text(
                            text = "Sensação:",
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                        )
                        Text(
                            text = feelsLike.toString().take(2)+"ºC",
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(start = 5.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))


                    Row(
                        modifier = Modifier.padding(bottom = 10.dp)
                    ) {

                        Image(
                            painter = painterResource(id = R.drawable.humidity_icon),
                            contentDescription = "humidity",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = humidity.toString()+"%",
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(start = 5.dp)
                        )

                        Spacer(modifier = Modifier.width(10.dp))

                        Image(
                            painter = painterResource(id = R.drawable.wind_icon),
                            contentDescription = "umidity",
                            modifier = Modifier.size(20.dp)
                        )
                        Text(
                            text = windSpeed.toString()+" km",
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.padding(start = 5.dp)
                        )


                    }
                }
            }

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
                        verticalAlignment = CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    ) {

                        Text(
                            text = viewModelForecast.getDayOfTheWeek(dataForDayOne.toString()),
                            modifier = Modifier.width(40.dp),
                            color = Color.White,
                        )

                        AsyncImage(
                            model = "https://openweathermap.org/img/wn/$iconTempForDayOne@2x.png",
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                        )


                        Text(
                            text = tempMinForDayOne.toString().take(2) + "º",
                            modifier = Modifier.width(40.dp),
                            color = Color.White,
                        )

                        Text(
                            text = tempMaxForDayOne.toString().take(2) + "º",
                            style = TextStyle.Default.copy(
                                color = Color.White,
                            )
                        )
                    }
                    Row(

                        horizontalArrangement = Arrangement.spacedBy(45.dp),
                        verticalAlignment = CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    ) {
                        Text(
                            text = viewModelForecast.getDayOfTheWeek(dataForDayTwo.toString()),
                            modifier = Modifier.width(40.dp),
                            color = Color.White,
                        )

                        AsyncImage(
                            model = "https://openweathermap.org/img/wn/$iconTempForDayTwo@2x.png",
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                        )

                        Text(
                            text = tempMinForDayTwo.toString().take(2) + "º",
                            modifier = Modifier.width(40.dp),
                            color = Color.White,
                        )
                        Text(
                            text = tempMaxForDayTwo.toString().take(2) + "º",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(45.dp),
                        verticalAlignment = CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    ) {
                        Text(
                            text = viewModelForecast.getDayOfTheWeek(dataForDayThree.toString()),
                            modifier = Modifier.width(40.dp),
                            color = Color.White,
                        )

                        AsyncImage(
                            model = "https://openweathermap.org/img/wn/$iconTempForDayThree@2x.png",
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)

                        )

                        Text(
                            text = tempMinForDayThree.toString().take(2) + "º",
                            modifier = Modifier.width(40.dp),
                            color = Color.White,
                        )

                        Text(
                            text = tempMaxForDayThree.toString().take(2) + "º",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(45.dp),
                        verticalAlignment = CenterVertically,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    ) {
                        Text(
                            text = viewModelForecast.getDayOfTheWeek(dataForDayFour.toString()),
                            modifier = Modifier.width(40.dp),
                            color = Color.White,
                        )

                        AsyncImage(
                            model = "https://openweathermap.org/img/wn/$iconTempForDayFour@2x.png",
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                        )


                        Text(
                            text = tempMinForDayFour.toString().take(2) + "º",
                            modifier = Modifier.width(40.dp),
                            color = Color.White,
                        )

                        Text(
                            text = tempMaxForDayFour.toString().take(2) + "º",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun GreatingPreview() {
    WeatherScreen()
}