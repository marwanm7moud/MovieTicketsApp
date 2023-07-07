package com.example.movieticketsapp.screens.booking_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.movieticketsapp.R
import com.example.movieticketsapp.composables.CinemaSeat
import com.example.movieticketsapp.composables.CustomButton
import com.example.movieticketsapp.composables.DateChip
import com.example.movieticketsapp.composables.SpacerHorizontal4
import com.example.movieticketsapp.composables.SpacerVertical16
import com.example.movieticketsapp.composables.TimeChip
import com.example.movieticketsapp.ui.theme.AvailableSeatColor
import com.example.movieticketsapp.ui.theme.ItemBackground
import com.example.movieticketsapp.ui.theme.SelectedSeatColor
import com.example.movieticketsapp.ui.theme.TakenSeatColor
import dagger.hilt.EntryPoint

@Composable
fun BookingScreen(bookingViewModel: BookingViewModel = hiltViewModel(), navController: NavHostController) {
    val bookingUiState by bookingViewModel.uiState.collectAsState()
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val (infoCard, backButton, seats, seatsType , checkOut) = createRefs()
        val startGuideline = createGuidelineFromBottom(0.31f)

        Surface(
            color = ItemBackground,
            shape = CircleShape,
            modifier = Modifier
                .wrapContentWidth()
                .padding(top = 24.dp, start = 16.dp)
                .constrainAs(backButton) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }.clickable{
                    navController.popBackStack()
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
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .constrainAs(seats) {
                    top.linkTo(backButton.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                },
            verticalArrangement = Arrangement.spacedBy(10.dp),
            columns = GridCells.Fixed(3)
        ) {
            item(span = { GridItemSpan(3) }) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    painter = painterResource(id = R.drawable.cinema_screen),
                    contentDescription = ""
                )
            }
            items(bookingUiState.seats.size) { index ->
                CinemaSeat(
                    leftSeat = bookingUiState.seats[index].leftSeatData,
                    rightSeatData = bookingUiState.seats[index].rightSeatData,
                    onSeatAvailableClick = { isSelected, id ->
                        bookingViewModel.changeSelectedSeat(isSelected, id)
                        bookingViewModel.incrementSelectedCount()
                    })
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .constrainAs(seatsType) {
                top.linkTo(seats.bottom)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
                bottom.linkTo(infoCard.top)
            }
            .padding(horizontal = 16.dp)) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = AvailableSeatColor,
                    modifier = Modifier.size(13.dp)
                ) {}
                SpacerHorizontal4()
                Text(text = "Available", color = Color.White)
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = TakenSeatColor,
                    modifier = Modifier.size(13.dp)
                ) {}
                SpacerHorizontal4()
                Text(text = "Taken", color = Color.White)
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = CircleShape,
                    color = SelectedSeatColor,
                    modifier = Modifier.size(13.dp)
                ) {}
                SpacerHorizontal4()
                Text(text = "Selected", color = Color.White)
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
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 24.dp),
                horizontalAlignment = Alignment.Start
            ) {
                LazyRow(contentPadding = PaddingValues(horizontal = 16.dp)) {
                    items(31) {index->
                        if (index!=0)
                        DateChip(day = index,
                            selectedDay = bookingUiState.selectedDate,
                            onChecked = { bookingViewModel.changeSelectedDate(it) })
                    }
                    items(25) {index->
                        if (index!=0)
                            TimeChip(time = index.toString(),
                                selectedTime = bookingUiState.selectedTime,
                                onChecked = { bookingViewModel.changeSelectedTime(index.toString()) })
                    }
                }
                SpacerVertical16()
                LazyRow(contentPadding = PaddingValues(horizontal = 16.dp)) {
                    items(25) {index->
                        if (index!=0)
                            TimeChip(time = index.toString(),
                                selectedTime = bookingUiState.selectedTime,
                                onChecked = { bookingViewModel.changeSelectedTime(index.toString()) })
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .constrainAs(checkOut) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
                .fillMaxWidth()
                .padding(bottom = 28.dp, start = 32.dp, end = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column {
                Text(text = "$${bookingUiState.selectedSeatsId.size * 25.00 }" , fontSize = 24.sp)
                Text(text = "${bookingUiState.selectedSeatsId.size} tickets", fontSize = 12.sp , color = Color.LightGray)
            }

            CustomButton("Buy Tickets",iconDrawable = R.drawable.card){

            }
        }


    }
}



data class ItemSeatData(
    val leftSeatData: SeatData,
    val rightSeatData: SeatData
)

data class SeatData(
    val id: Int,
    val isAvailable: Boolean,
    var isSelected: Boolean
)