package com.example.weather.Presentation

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
import androidx.compose.ui.Alignment
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


@Composable
fun WeatherCard(
    state: WeatherState

) {

    state.weatherResponse?.main.let { data ->
        
        
        val icon = state.weatherResponse?.weather?.get(0)?.icon
        val city = state.weatherResponse?.name
        val description = state.weatherResponse?.weather?.get(0)?.description




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
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)

            ) {
                Text(
                    text = "$city",
                    fontSize = 30.sp,
                    style = TextStyle.Default.copy(
                        Color.White,
                    ),
                    fontWeight = FontWeight.Bold,

                    )

                AsyncImage(
                    model = "https://openweathermap.org/img/wn/${icon}@2x.png",
                    contentDescription = null,
                    modifier = Modifier
                        .width(200.dp)
                        .height(100.dp)
                        .clip(CircleShape)
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center

                ) {


                    Text(
                        text = "${data?.temp}".take(2)+"ºC",
                        fontSize = 100.sp,
                        modifier = Modifier,
                        style = TextStyle.Default.copy(
                            Color.White, fontWeight = FontWeight.ExtraBold

                        ),
                    )

                }
                Text(
                    text = "$description".uppercase(),
                    fontSize = 18.sp,
                    style = TextStyle.Default.copy(
                        Color.White,
                    ),
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(modifier = Modifier.padding(bottom = 30.dp))


                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    Text(
                        text = "MIN:",
                        style = TextStyle.Default.copy(
                            Color.White,
                        ),

                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(end = 5.dp),


                        )

                    Text(
                        text = "${data?.temp_min}".take(2)+" ºC",
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier
                    )

                    Text(
                        text = "MAX:",
                        style = TextStyle.Default.copy(
                            Color.White,
                        ),
                        modifier = Modifier.padding(start = 10.dp, end = 2.dp),
                        fontWeight = FontWeight.ExtraBold,


                        )

                    Text(
                        text = "${data?.temp_max}".take(2)+" ºC",
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,

                        )


                    Spacer(modifier = Modifier.width(10.dp))


                    Text(
                        text = "SENSAÇÃO:",
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                    )
                    Text(
                        text = "${data?.feels_like}".take(2)+" ºC",
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
                        text = "${data?.humidity} %",
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
                        text = "${data?.humidity} km",
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.padding(start = 5.dp)
                    )


                }
            }


        }

    }
}


@Preview
@Composable
fun GreatingPreview() {

    WeatherCard(state = WeatherState())

}
