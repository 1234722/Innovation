package com.example.innovation.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainUIState: ViewModel() {
    var xData by mutableStateOf("[120, 200, 150, 80, 70,30,40]") // demo y轴数据
}