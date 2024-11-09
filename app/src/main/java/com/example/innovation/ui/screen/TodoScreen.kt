package com.example.innovation.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import com.example.innovation.R
import com.example.innovation.ui.state.TodoUIState
import kotlinx.datetime.LocalDate

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TodoScreen(modifier: Modifier,viewModel: TodoUIState,tabComponent: @Composable (Modifier) -> Unit) {
    Scaffold(
        topBar = {  },
        bottomBar = { tabComponent(Modifier) },
    ) { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .background(
                Brush.verticalGradient(
                    listOf(
                        colorResource(id = R.color.background_color_up),
                        colorResource(id = R.color.background_color),
                    ), endY = 2000.0f
                ))
            .fillMaxSize()
        ) {

        }
    }
}



