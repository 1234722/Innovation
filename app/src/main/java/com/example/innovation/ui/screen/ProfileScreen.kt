package com.example.innovation.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.innovation.R
import com.example.innovation.ui.state.ProfileUIState


@Composable
fun ProfileScreen(modifier: Modifier,viewModel: ProfileUIState,tabComponent: @Composable (Modifier) -> Unit) {
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
            .fillMaxSize(),
        ) {
            Row(modifier = Modifier.padding(horizontal = 50.dp, vertical = 35.dp)) {
                Image(
                    bitmap = /*viewModel.avatar ?:*/ ImageBitmap.imageResource(id = R.drawable.logo),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                        .border(2.dp, colorResource(id = R.color.image_border_color), CircleShape)
                        .clickable { /*TODO*/ }
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = "高永进 19岁0个月",
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = stringResource(R.string.profile_image_show_text),
                        fontSize = 14.sp,
                    )
                }
            }
            Surface(
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 5.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(15.dp),
                color = colorResource(id = R.color.box_in_screen)
            ){
                val labels = listOf("宝宝档案袋", "宝宝美照", "宝宝的健康记录","使用教程")
                val labelIcons = listOf(
                    R.drawable.file,
                    R.drawable.image,
                    R.drawable.doctor,
                    R.drawable.help
                )
                Column(){
                    labels.forEachIndexed { index, label ->
                        if (index != 0) {
                            HorizontalDivider(
                                color = colorResource(id = R.color.line_color),
                                thickness = 1.dp,
                            )
                        }
                        Row(
                            modifier = Modifier
                                .padding(horizontal = 10.dp, vertical = 15.dp)
                                .fillMaxWidth()
                                .clickable { /*TODO*/ },
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = label,
                                modifier = Modifier.padding(start = 5.dp),
                                fontSize = 14.sp,
                            )
                            Icon(
                                painter = painterResource(id = labelIcons[index]),
                                contentDescription = null,
                            )
                        }
                    }
                }
            }
        }
    }
}