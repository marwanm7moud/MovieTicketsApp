package com.example.movieticketsapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movieticketsapp.R

@Composable
fun BlurImage(imageId:Int){
    val imageHeight = LocalConfiguration.current.screenHeightDp / 2
    val gradient = Brush.verticalGradient(
        colors = listOf(Color.Transparent, Color.Transparent, Color.White),
        startY = imageHeight.toFloat() / 3,
        endY = imageHeight.toFloat() * 3.5f
    )
    Image(
        painter = painterResource(id = imageId),
        contentDescription = "Image",
        modifier = Modifier
            .blur(radius = 17.dp)
            .fillMaxWidth()
            .height(imageHeight.dp),
        contentScale = ContentScale.Crop,
    )
    Box(modifier = Modifier
        .fillMaxSize()
        .background(gradient))
}