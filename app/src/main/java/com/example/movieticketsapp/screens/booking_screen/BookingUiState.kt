package com.example.movieticketsapp.screens.booking_screen

data class BookingUiState(
    val seats : MutableList<ItemSeatData> = mutableListOf(),
    val selectedSeatsId:MutableList<Int> = mutableListOf(),
    var selectedSeatsCount:Int = 0,
    val selectedDate:Int = 0,
    val selectedTime:String = ""
)
