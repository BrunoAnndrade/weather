package com.example.weather

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weather.Data.Forecast.ForecastViewModel
import com.example.weather.ui.theme.WeatherTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                Greeting()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {

    val viewModelWeather by lazy {
        WeatherViewModel.create()

    }
    val viewModelForecast by lazy {
        ForecastViewModel.create()
    }

    val MainState = viewModelWeather.MainLiveData.observeAsState()
    val WeatherState = viewModelWeather.WeatherLiveData.observeAsState()
    val temperatura = MainState.value?.temp
    val iconeTemp = WeatherState.value?.firstOrNull()?.icon
    val descricaoTemp = WeatherState.value?.firstOrNull()?.description

    val CityState = viewModelForecast.CityLiveData.observeAsState()
    val city = CityState.value?.name


    val dataState = viewModelForecast.ListElementLiveData.observeAsState()

    //previsao dia 1
    val tempMinForDayOne = dataState.value?.get(2)?.main?.temp_min
    val tempMaxForDayOne = dataState.value?.get(2)?.main?.temp_max
    val iconTempForDayOne = dataState.value?.get(2)?.weather?.firstOrNull()?.icon
    val dataForDayOne = dataState.value?.get(2)?.dt_txt

    //Previsao Dia 2
    val tempMinForDayTwo = dataState.value?.get(10)?.main?.temp_min
    val tempMaxForDayTwo = dataState.value?.get(10)?.main?.temp_max
    val iconTempForDayTwo = dataState.value?.get(10)?.weather?.firstOrNull()?.icon
    val dataForDayTwo = dataState.value?.get(10)?.dt_txt

    //Previsao Dia 3
    val tempMinForDayThree = dataState.value?.get(18)?.main?.temp_min
    val tempMaxForDayThree = dataState.value?.get(18)?.main?.temp_max
    val iconTempForDayThree = dataState.value?.get(18)?.weather?.firstOrNull()?.icon
    val dataForDayThree = dataState.value?.get(18)?.dt_txt

    //Previsao Dia 4
    val tempMinForDayFour = dataState.value?.get(26)?.main?.temp_min
    val tempMaxForDayFour = dataState.value?.get(26)?.main?.temp_max
    val iconTempForDayFour = dataState.value?.get(26)?.weather?.firstOrNull()?.icon
    val dataForDayFour = dataState.value?.get(26)?.dt_txt

    Scaffold(
        topBar = {
            TopAppBar(

                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Black
                ),
                title = {
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
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center

            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()

                ) {
                    Text(
                        text = city.toString(),
                        fontSize = 50.sp,
                        style = TextStyle.Default.copy(
                            Color.White,
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center

                    ) {

                        if (temperatura != null) {
                            Text(
                                text = temperatura.toInt().toString() + "ºC",
                                fontSize = 100.sp,
                                modifier = Modifier,
                                style = TextStyle.Default.copy(
                                    Color.White,
                                    fontWeight = FontWeight.ExtraBold

                                ),
                            )
                        } else {
                            Text(
                                text = "",
                                fontSize = 100.sp,
                                modifier = Modifier,
                                style = TextStyle.Default.copy(
                                    Color.White,
                                    fontWeight = FontWeight.ExtraBold

                                ),
                            )
                        }
                        Spacer(modifier = Modifier.width(15.dp))

                        AsyncImage(
                            model = "https://openweathermap.org/img/wn/$iconeTemp@2x.png",
                            contentDescription = null,
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .align(alignment = CenterVertically)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)

                        )
                    }
                    Text(
                        text = descricaoTemp.toString(),
                        fontSize = 30.sp,
                        style = TextStyle.Default.copy(
                            Color.White,
                        )
                    )
                }
            }

            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center

            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(40.dp)
                ) {
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Text(
                            text = "Agora",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )

                        Image(
                            painter = painterResource(id = R.drawable.sun),
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)
                        )
                        Text(
                            text = "-27ºC",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Text(
                            text = "Agora",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                        Image(
                            painter = painterResource(id = R.drawable.sun),
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)
                        )
                        Text(
                            text = "-27ºC",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Text(
                            text = "Agora",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                        Image(
                            painter = painterResource(id = R.drawable.sun),
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)
                        )
                        Text(
                            text = "-27ºC",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Text(
                            text = "Agora",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                        Image(
                            painter = painterResource(id = R.drawable.sun),
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)
                        )
                        Text(
                            text = "-27ºC",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {
                        Text(
                            text = "Agora",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                        Image(
                            painter = painterResource(id = R.drawable.sun),
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)
                        )
                        Text(
                            text = "-27ºC",
                            style = TextStyle.Default.copy(
                                Color.White,
                            )
                        )
                    }
                }
            }
            Box(
                modifier = Modifier
                    .background(Color.Yellow)
                    .width(350.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(
                        text = "Previsao para os próximos dias",
                        modifier = Modifier.align(Alignment.CenterHorizontally)

                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(70.dp),
                        verticalAlignment = CenterVertically
                    ) {

                        Text(
                            text = viewModelForecast.getDayOfTheWeek(dataForDayOne.toString()),
                            modifier = Modifier.width(40.dp)
                        )

                        AsyncImage(
                            model =
                            "https://openweathermap.org/img/wn/$iconTempForDayOne@2x.png",
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)
                        )


                        Text(
                            text = tempMinForDayOne.toString().take(2)+"º" ,
                            modifier = Modifier.width(40.dp)
                        )

                        Text(
                            text = tempMaxForDayOne.toString().take(2)+"º",
                            style = TextStyle.Default.copy(
                                Color.Black,
                            )
                        )
                    }
                    Row(

                        horizontalArrangement = Arrangement.spacedBy(70.dp),
                        verticalAlignment = CenterVertically
                    ) {
                        Text(
                            text = viewModelForecast.getDayOfTheWeek(dataForDayTwo.toString()),
                            modifier = Modifier.width(40.dp)
                        )

                        AsyncImage(
                            model =
                            "https://openweathermap.org/img/wn/$iconTempForDayTwo@2x.png",
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)
                        )

                        Text(
                            text = tempMinForDayTwo.toString().take(2)+"º" ,
                            modifier = Modifier.width(40.dp)
                        )
                        Text(
                            text = tempMaxForDayTwo.toString().take(2)+"º",
                            style = TextStyle.Default.copy(
                                Color.Black,
                            )
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(70.dp),
                        verticalAlignment = CenterVertically
                    ) {
                        Text(
                            text = viewModelForecast.getDayOfTheWeek(dataForDayThree.toString()),
                            modifier = Modifier.width(40.dp)
                        )

                        AsyncImage (
                            model =
                            "https://openweathermap.org/img/wn/$iconTempForDayThree@2x.png",
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)
                        )

                        Text(
                            text = tempMinForDayThree.toString().take(2)+"º" ,
                            modifier = Modifier.width(40.dp)
                        )

                        Text(
                            text = tempMaxForDayThree.toString().take(2)+"º",
                            style = TextStyle.Default.copy(
                                Color.Black,
                            )
                        )
                    }

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(70.dp),
                        verticalAlignment = CenterVertically
                    ) {
                        Text(
                            text = viewModelForecast.getDayOfTheWeek(dataForDayFour.toString()),
                            modifier = Modifier.width(40.dp)
                        )

                        AsyncImage(
                            model =
                            "https://openweathermap.org/img/wn/$iconTempForDayFour@2x.png",
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)
                        )


                        Text(
                            text = tempMinForDayFour.toString().take(2)+"º" ,
                            modifier = Modifier.width(40.dp)
                        )

                        Text(
                            text = tempMaxForDayFour.toString().take(2)+"º",
                            style = TextStyle.Default.copy(
                                Color.Black,
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun GreatingPreview() {
    Greeting()
}