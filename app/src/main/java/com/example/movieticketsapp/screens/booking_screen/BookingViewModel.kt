package com.example.movieticketsapp.screens.booking_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor() : ViewModel() {
    private val _uiState: MutableStateFlow<BookingUiState> = MutableStateFlow(BookingUiState())
    val uiState: StateFlow<BookingUiState> get() = _uiState

    init {
        getData()
    }

    private fun getData() {
        val seatsData = mutableListOf(
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 1),
                SeatData(isAvailable = true, isSelected = false, id = 2),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 2),
                SeatData(isAvailable = true, isSelected = false, id = 4),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 5),
                SeatData(isAvailable = true, isSelected = false, id = 6),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 7),
                SeatData(isAvailable = true, isSelected = false, id = 8),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 9),
                SeatData(isAvailable = true, isSelected = false, id = 10),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 11),
                SeatData(isAvailable = true, isSelected = false, id = 12),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 13),
                SeatData(isAvailable = true, isSelected = false, id = 14),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 15),
                SeatData(isAvailable = true, isSelected = false, id = 16),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 17),
                SeatData(isAvailable = false, isSelected = false, id = 18),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 19),
                SeatData(isAvailable = true, isSelected = false, id = 20),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 21),
                SeatData(isAvailable = false, isSelected = false, id = 22),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 23),
                SeatData(isAvailable = true, isSelected = false, id = 24),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 25),
                SeatData(isAvailable = false, isSelected = false, id = 26),
            ),
            ItemSeatData(
                SeatData(isAvailable = false, isSelected = false, id = 27),
                SeatData(isAvailable = false, isSelected = false, id = 28),
            ),
            ItemSeatData(
                SeatData(isAvailable = true, isSelected = false, id = 29),
                SeatData(isAvailable = true, isSelected = false, id = 30),
            )

            )

        _uiState.update {
            BookingUiState(
                seats = seatsData
            )
        }
    }

    fun changeSelectedSeat(selected: Boolean, id: Int) {
        val list = uiState.value.selectedSeatsId
        if (selected) list.add(id) else list.remove(id)
        _uiState.update { state ->
            state.copy(
                selectedSeatsId = list
            )
        }
    }

}