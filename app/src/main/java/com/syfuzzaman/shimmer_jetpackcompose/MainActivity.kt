package com.syfuzzaman.shimmer_jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.syfuzzaman.shimmer_jetpackcompose.ui.theme.ScreenBG
import com.syfuzzaman.shimmer_jetpackcompose.ui.theme.ScreenBGNight
import com.syfuzzaman.shimmer_jetpackcompose.ui.theme.ShimmerjetpackcomposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShimmerjetpackcomposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize().background(
                    if (isSystemInDarkTheme()) ScreenBGNight else ScreenBG
                )) { innerPadding ->
                    Contents(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Contents(
    modifier: Modifier = Modifier,
){
    LazyColumn (contentPadding = PaddingValues(top = 16.dp, bottom = 6.dp), modifier = modifier){
        items(3, key = {it.inc()}){
            ItemPlaceholder()
        }
    }
}