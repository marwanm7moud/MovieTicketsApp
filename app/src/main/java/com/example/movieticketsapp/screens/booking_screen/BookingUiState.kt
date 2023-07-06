package com.example.movieticketsapp.screens.booking_screen

data class BookingUiState(
    val seats : MutableList<ItemSeatData> = mutableListOf(),
    val selectedSeatsId:MutableList<Int> = mutableListOf()
)
