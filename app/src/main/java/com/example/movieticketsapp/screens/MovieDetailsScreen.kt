package com.example.movieticketsapp.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.movieticketsapp.R
import com.example.movieticketsapp.composables.MovieTime
import com.example.movieticketsapp.ui.theme.ItemBackground
import com.example.movieticketsapp.ui.theme.PrimaryLight


@Composable
fun MovieDetailsScreen() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (image, playButton, movieTime, backButton , infoCard) = createRefs()
        val startGuideline = createGuidelineFromTop(0.45f)

        Image(
            painter = painterResource(id = R.drawable.poster),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            contentDescription = "Poster",
            contentScale = ContentScale.Crop
        )
        Surface(
            color = PrimaryLight,
            shape = CircleShape,
            modifier = Modifier
                .size(53.dp)
                .constrainAs(playButton) {
                    top.linkTo(image.top)
                    start.linkTo(image.start)
                    end.linkTo(image.end)
                    bottom.linkTo(image.bottom)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.play_button),
                contentDescription = "Home",
                tint = Color.White,
                modifier = Modifier.padding(15.dp)

            )
        }

        Surface(
            color = ItemBackground,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 32.dp, end = 16.dp)
                .constrainAs(movieTime) {
                    top.linkTo(parent.top)
                    end.linkTo(image.end)
                }

        ) {
            MovieTime(
                time = "2h 23m",
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
                iconColor = Color.White,
                textColor = Color.White
            )
        }
        Surface(
            color = ItemBackground,
            shape = CircleShape,
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 24.dp, start = 16.dp)
                .constrainAs(backButton) {
                    top.linkTo(parent.top)
                    start.linkTo(image.start)
                }

        ) {
            Icon(
                painter = painterResource(id = R.drawable.close_circle),
                contentDescription = "Home",
                tint = Color.White,
                modifier = Modifier.padding(8.dp)

            )
        }

        Surface(
            shape = RoundedCornerShape(topStart = 32.dp , topEnd = 32.dp),
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(infoCard){
                    top.linkTo(startGuideline)
                }
        ) {

        }


    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}