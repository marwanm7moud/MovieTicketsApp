package com.example.movieticketsapp.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.movieticketsapp.R
import com.example.movieticketsapp.composables.CustomChip
import com.example.movieticketsapp.composables.MovieTime
import com.example.movieticketsapp.composables.SpacerHorizontal4
import com.example.movieticketsapp.composables.SpacerVertical14
import com.example.movieticketsapp.composables.SpacerVertical16
import com.example.movieticketsapp.composables.SpacerVertical24
import com.example.movieticketsapp.composables.SpacerVertical4
import com.example.movieticketsapp.composables.SpacerVertical8
import com.example.movieticketsapp.ui.theme.ItemBackground
import com.example.movieticketsapp.ui.theme.PrimaryLight
import com.example.movieticketsapp.ui.theme.kumbhSans
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


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
                .constrainAs(infoCard) {
                    top.linkTo(startGuideline)
                }
        ){
            Column(modifier = Modifier.fillMaxSize() , horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 38.dp, start = 50.dp, end = 50.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row() {
                            Text(text ="6" , fontSize = 16.sp )
                            Text(text ="/10" , color = Color.Gray, fontSize = 16.sp )

                        }
                        SpacerVertical4()
                        Text(text = "IMDB", color = Color.Gray, fontSize = 12.sp )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(text ="63%" , fontSize = 16.sp )
                        SpacerVertical4()
                        Text(text = "Rotten Tomatoes", color = Color.Gray, fontSize = 12.sp )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Row() {
                            Text(text ="4" , fontSize = 16.sp )
                            Text(text ="/10" , color = Color.Gray, fontSize = 16.sp )

                        }
                        SpacerVertical4()
                        Text(text = "IGN" , color = Color.Gray, fontSize = 12.sp )
                    }
                }
                SpacerVertical14()
                Text(text = "Fantastic Beasts: The Secrets of Dumbledore",
                    fontSize = 24.sp ,
                    modifier = Modifier.padding(horizontal = 48.dp),
                    textAlign = TextAlign.Center,
                    fontFamily = kumbhSans
                )
                SpacerVertical16()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CustomChip(title = "Fantasy", selected = false)
                    SpacerHorizontal4()
                    CustomChip(title = "Adventure", selected = false)
                }
                SpacerVertical16()
                LazyRow(
                    contentPadding = PaddingValues(start = 24.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ){
                    for (i in 1..10){
                        item {
                            Image(
                                painter = painterResource(id = R.drawable.people),
                                contentDescription ="",
                                modifier = Modifier.size(60.dp)

                            )
                        }
                    }
                }
                SpacerVertical16()
                Text(text = "Professor Albus Dumbledore knows the powerful, dark wizard Gellert Grindelwald is moving to seize control of the wizarding world. Unable to stop him alone, he entrusts magizoologist Newt Scamander to lead an intrepid team of wizards and witches. They soon encounter an array of old and new beasts as they clash with Grindelwald's growing legion of followers.",
                    fontSize = 12.sp ,
                    modifier = Modifier.padding(horizontal = 30.dp),
                    maxLines = 3,
                    textAlign = TextAlign.Center,
                    fontFamily = kumbhSans
                )
                SpacerVertical16()
                Button(onClick = { } , colors = ButtonDefaults.buttonColors(containerColor = PrimaryLight , contentColor = Color.White)) {
                    Icon(painter = painterResource(id = R.drawable.ticket_1), contentDescription ="" )
                    Text(text = "Booking",
                        fontSize = 16.sp ,
                        modifier = Modifier.padding(start = 8.dp),
                        textAlign = TextAlign.Center,
                        fontFamily = kumbhSans
                    )
                }
            }
        }


    }
}

@Preview(showSystemUi = true)
@Composable
fun MovieDetailsScreenPreview() {
    MovieDetailsScreen()
}