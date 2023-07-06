package com.example.movieticketsapp.screens.booking_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.movieticketsapp.R
import com.example.movieticketsapp.composables.CinemaSeat
import com.example.movieticketsapp.ui.theme.ItemBackground

@Composable
fun BookingScreen(bookingViewModel: BookingViewModel = viewModel()) {
    val bookingUiState by bookingViewModel.uiState.collectAsState()
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val (infoCard, backButton, seats) = createRefs()
        val startGuideline = createGuidelineFromBottom(0.3f)

        Surface(
            color = ItemBackground,
            shape = CircleShape,
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 24.dp, start = 16.dp)
                .constrainAs(backButton) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.close_circle),
                contentDescription = "Home",
                tint = Color.White,
                modifier = Modifier.padding(8.dp)

            )
        }
        LazyVerticalGrid(
            modifier = Modifier.constrainAs(seats) {
                top.linkTo(backButton.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                bottom.linkTo(infoCard.top)
            },
            columns = GridCells.Fixed(3)
        ) {
            items(bookingUiState.seats.size) {index->
                CinemaSeat(
                    leftSeat = bookingUiState.seats[index].leftSeatData,
                    rightSeatData = bookingUiState.seats[index].rightSeatData,
                    onSeatAvailableClick = {isSelected, id ->
                        bookingViewModel.changeSelectedSeat(isSelected, id)
                        Log.e("TAG", "BookingScreen: ${id}  $isSelected", )
                    })
            }
        }

        Surface(
            shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(infoCard) {
                    top.linkTo(startGuideline)
                }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

            }
        }


    }
}

@Preview(showSystemUi = true)
@Composable
fun BookingScreenPreview() {
    BookingScreen()
}

data class ItemSeatData(
    val leftSeatData: SeatData,
    val rightSeatData: SeatData
)

data class SeatData(
    val id:Int,
    val isAvailable: Boolean,
    var isSelected: Boolean
)