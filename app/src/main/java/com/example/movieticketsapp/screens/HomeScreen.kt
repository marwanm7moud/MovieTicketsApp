package com.example.movieticketsapp.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.example.movieticketsapp.R
import com.example.movieticketsapp.composables.BlurImage
import com.example.movieticketsapp.composables.ImageSlider
import com.example.movieticketsapp.composables.SpacerHorizontal4
import com.example.movieticketsapp.composables.SpacerVertical16
import com.example.movieticketsapp.composables.SpacerVertical32
import com.example.movieticketsapp.composables.CustomChip
import com.example.movieticketsapp.composables.MovieTime
import com.example.movieticketsapp.composables.SpacerVertical8
import com.example.movieticketsapp.ui.theme.PrimaryLight

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val images = listOf(R.drawable.movie1, R.drawable.movie2, R.drawable.movie3)
    val pagerState = rememberPagerState(initialPage = 1) { images.size }

    Scaffold(bottomBar = {
            BottomAppBar(containerColor = Color.Transparent) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.vector_1),
                        contentDescription = "Home",
                        tint = Color.White,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(PrimaryLight)
                            .padding(10.dp)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.search_icon),
                        tint = Color.Black,
                        contentDescription = "search"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ticket_1),
                        tint = Color.Black,
                        contentDescription = "ticket"
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.user_icon),
                        contentDescription = "person",
                        tint = Color.Black
                    )
                }
            }
        }
    ) { padding ->
        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (info, playButton) = createRefs()
                BlurImage(imageId = images[pagerState.currentPage])
                Column(modifier = Modifier.fillMaxSize()) {
                    SpacerVertical32()
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CustomChip(
                            title = "Now Showing",
                            selected = true,
                            OnClick = {},
                            textColor = Color.White
                        )
                        SpacerHorizontal4()
                        CustomChip(
                            title = "Coming Soon",
                            selected = false,
                            OnClick = {},
                            textColor = Color.White
                        )
                    }
                    SpacerVertical16()
                    ImageSlider(imagesList = images, pagerState = pagerState){
                        if (it==1)
                            navController.navigate("movieDetails")
                    }
                    SpacerVertical16()

                }
            Column(modifier = Modifier.constrainAs(info){
                bottom.linkTo(parent.bottom)
            }.padding(padding)) {
                MovieTime(time = "2h 23m" , Modifier.fillMaxWidth())
                SpacerVertical16()
                Text(
                    text = "Fantastic Beasts: The Secrets of Dumbledore",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 64.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    fontSize = 24.sp
                )
                SpacerVertical8()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CustomChip(title = "Fantasy", selected = false)
                    SpacerHorizontal4()
                    CustomChip(title = "Adventure", selected = false)
                }
            }

        }

    }


}