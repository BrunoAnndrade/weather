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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weather.ui.theme.WeatherTheme
import kotlin.math.round

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

    val viewModel by lazy {
        WeatherViewModel.create()
    }
    val weatherData = viewModel.weatherLiveData.observeAsState()

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
                        text = "Brasil",
                        fontSize = 50.sp,
                        style = TextStyle.Default.copy(
                            Color.White,
                        )
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center

                    ) {

                        Text(
                            text = weatherData.value.toString(),
                            fontSize = 100.sp,
                            modifier = Modifier,
                            style = TextStyle.Default.copy(
                                Color.White,
                                fontWeight = FontWeight.ExtraBold

                            ),
                        )
                        Spacer(modifier = Modifier.width(15.dp))
                        Image(
                            painter = painterResource(id = R.drawable.sun),
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp)
                                .align(alignment = CenterVertically)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)
                        )
                    }
                    Text(
                        text = "Ensolarado",
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
                        text = "Previsao para 10 dias"
                    )

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(70.dp),
                        verticalAlignment = CenterVertically
                    ) {
                        Text(
                            text = "Sab.",
                            modifier = Modifier.width(40.dp)
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
                                Color.Black,
                            )
                        )
                        Text(
                            text = "-19ºC",
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
                            text = "Dom.",
                            modifier = Modifier.width(40.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.sun),
                            contentDescription = "sol",
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape),

                        )
                        Text(
                            text = "-27ºC",
                            style = TextStyle.Default.copy(
                                Color.Black,
                            )
                        )
                        Text(
                            text = "-19ºC",
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
                            text = "Seg.",
                            modifier = Modifier.width(40.dp)
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
                                Color.Black,
                            )
                        )
                        Text(
                            text = "-19ºC",
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
                            text = "Seg.",
                            modifier = Modifier.width(40.dp)
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
                                Color.Black,
                            )
                        )
                        Text(
                            text = "-19ºC",
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
                            text = "Ter.",
                            modifier = Modifier.width(40.dp)
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
                                Color.Black,
                            )
                        )
                        Text(
                            text = "-19ºC",
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