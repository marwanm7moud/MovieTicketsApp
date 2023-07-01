package com.example.movieticketsapp.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieticketsapp.R
import com.example.movieticketsapp.composables.BlurImage
import com.example.movieticketsapp.composables.ImageSlider
import com.example.movieticketsapp.composables.SpacerHorizontal4
import com.example.movieticketsapp.composables.SpacerVertical16
import com.example.movieticketsapp.composables.SpacerVertical32
import com.example.movieticketsapp.composables.Chip
import com.example.movieticketsapp.composables.SpacerVertical8

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val images = listOf(R.drawable.movie1, R.drawable.movie2, R.drawable.movie3)
    val pagerState = rememberPagerState(initialPage = 1) { images.size }

    Box(modifier = Modifier.fillMaxSize()) {
        BlurImage(imageId = images[pagerState.currentPage])
        Column(modifier = Modifier.fillMaxSize()) {
            SpacerVertical32()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Chip(title = "Now Showing", selected = true, OnClick = {} , textColor = Color.White)
                SpacerHorizontal4()
                Chip(title = "Coming Soon", selected = false, OnClick = {} , textColor = Color.White)
            }
            SpacerVertical16()
            ImageSlider(imagesList = images, pagerState = pagerState)
            SpacerVertical16()
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_access_time_24),
                    contentDescription = "Time",
                    tint = Color.Gray
                )
                SpacerHorizontal4()
                Text(text = "2h 23m")

            }
            SpacerVertical16()
            Text(
                text = "Fantastic Beasts: The Secrets of Dumbledore",
                modifier = Modifier.fillMaxWidth().padding(horizontal = 64.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp
            )
            SpacerVertical8()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Chip(title = "Fantasy", selected = false)
                SpacerHorizontal4()
                Chip(title = "Adventure", selected = false)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}