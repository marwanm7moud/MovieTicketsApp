package com.example.movieticketsapp.composables

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState


import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.util.lerp
import com.example.movieticketsapp.R
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImageSlider(imagesList:List<Int> , pagerState:PagerState , onMovieClick:(index:Int)->Unit) {
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 50.dp)
    ) {index->
        Box(
            modifier = Modifier.fillMaxWidth().wrapContentHeight().clickable{
                onMovieClick.invoke(index)
            }, contentAlignment = Alignment.Center,
        ) {
            val padding: Dp by animateDpAsState(
                if (pagerState.currentPage != index) 15.dp else 0.dp
            )
            Image(
                painter = painterResource(id = imagesList[index]),
                contentDescription = "Image",
                alignment = Alignment.Center,
                modifier = Modifier
                    .padding(horizontal = padding)
                    .aspectRatio(263  / 398f)
                    .clip(RoundedCornerShape(16.dp))
                    .graphicsLayer {

                        val pageOffset = (
                                (pagerState.currentPage - index) + pagerState
                                    .currentPageOffsetFraction
                                ).absoluteValue
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    },
                contentScale = ContentScale.Crop,
            )
        }
    }
}
