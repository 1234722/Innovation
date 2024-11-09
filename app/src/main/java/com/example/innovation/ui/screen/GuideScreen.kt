package com.example.innovation.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.colorResource
import androidx.lifecycle.ViewModel
import com.example.innovation.R
import com.example.innovation.ui.state.GuideUIState

@Composable
fun GuideScreen(modifier: Modifier,viewModel: GuideUIState,tabComponent: @Composable (Modifier) -> Unit) {
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