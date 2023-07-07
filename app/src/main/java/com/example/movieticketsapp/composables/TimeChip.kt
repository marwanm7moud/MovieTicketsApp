package com.example.movieticketsapp.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.Unspecified
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieticketsapp.screens.booking_screen.BookingScreen
import com.example.movieticketsapp.ui.theme.SelectedChip

@Composable
fun TimeChip(
    time: String,
    selectedTime:String,
    onChecked: (String) -> Unit,
    selectedColor: Color = SelectedChip
) {
    val isSelected = time==selectedTime
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                vertical = 2.dp,
                horizontal = 4.dp
            )
            .border(
                width = 1.dp,
                color = if (isSelected) selectedColor else SelectedChip,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = if (isSelected) selectedColor else Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .clip(shape = RoundedCornerShape(16.dp))
            .clickable {
                onChecked(time)
            }
            .padding(horizontal = 12.dp , vertical = 8.dp)
    ) {
        Text(
            text = "$time:00",
            color = if (isSelected) White else Color.Black,
            fontSize = 16.sp
        )
    }
}
@Preview()
@Composable
fun TimePreview() {
    TimeChip("14" , "12" , {})
}
