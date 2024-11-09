package com.example.innovation.ui.screen

import android.annotation.SuppressLint
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.innovation.R
import com.example.innovation.ui.state.MainUIState

@Composable
fun MainScreen(modifier: Modifier,viewModel: MainUIState,tabComponent: @Composable (Modifier) -> Unit) {
    val context = LocalContext.current
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
                )
            )
            .fillMaxSize()
        ) {
            var echartView = EchartView(context,"file:///android_asset/demo.html")
            AndroidView(
                factory = { echartView },
                update = { it.updateChart(viewModel.xData) },
                modifier = Modifier.height(400.dp)
                    .width(400.dp)
                    .background(Color.Transparent)
            )
            Button(onClick = { viewModel.xData = "[160, 100, 130, 70, 70,60,40]" }, modifier = Modifier.padding(16.dp)) {
                Text(text = viewModel.xData)
            }
        }
    }
}

@SuppressLint("ViewConstructor", "SetJavaScriptEnabled")
class EchartView(context: android.content.Context,url: String): WebView(context) {
    init {
        settings.javaScriptEnabled = true
        setBackgroundColor(0) // 设置背景色
        background?.alpha = 0; // 设置填充透明度 范围：0-255
        loadUrl(url)
    }

    @JavascriptInterface
    fun updateChart(xData: String) {
        // 通过JavaScript动态更新Echart数据
        post { loadUrl("javascript:update($xData)") }
    }
}


