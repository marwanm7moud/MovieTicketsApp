package com.example.movieticketsapp.composables

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movieticketsapp.R
import com.example.movieticketsapp.ui.theme.PrimaryLight
import com.example.movieticketsapp.ui.theme.kumbhSans

@Composable
fun CustomButton(text:String ,color:Color = PrimaryLight , iconDrawable:Int , onclick:()->Unit ){
    Button(
        contentPadding = PaddingValues(vertical = 12.dp , horizontal = 16.dp),
        onClick = onclick ,
        colors = ButtonDefaults.buttonColors(containerColor = color , contentColor = Color.White)
    )
    {
        Icon(painter = painterResource(id = iconDrawable), contentDescription ="" )
        Text(text = text,
            fontSize = 16.sp ,
            modifier = Modifier.padding(start = 8.dp),
            textAlign = TextAlign.Center,
            fontFamily = kumbhSans
        )
    }
}

@Preview
@Composable
fun CustomButtonPreview(){
    CustomButton("Booking",iconDrawable = R.drawable.card){}
}