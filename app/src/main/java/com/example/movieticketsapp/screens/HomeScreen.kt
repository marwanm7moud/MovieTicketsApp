package com.example.movieticketsapp.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(){
    Text(text = "Hello Android")
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen()
}