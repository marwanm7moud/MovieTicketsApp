package com.example.movieticketsapp.composables

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieticketsapp.screens.HomeScreen
import com.example.movieticketsapp.ui.theme.PrimaryLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabChip(title:String , selected:Boolean , OnClick:()-> Unit ){
    FilterChip(
        colors = FilterChipDefaults.filterChipColors(selectedContainerColor = PrimaryLight ,
            selectedLabelColor = Color.White ,
            labelColor = Color.White ,
            ),
        shape = CircleShape,
        selected = selected,
        onClick = OnClick,
        label = { Text(title , fontWeight = FontWeight.Normal) },
    )
}