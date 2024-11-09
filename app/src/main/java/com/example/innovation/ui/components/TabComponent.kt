package com.example.innovation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.innovation.NavDestination
import com.example.innovation.R

@Composable
fun TabComponent(
    modifier: Modifier,
    destinations: List<NavDestination>,
    labels: List<String>,
    labelIcons: List<Int>,
    select: NavDestination,
    onItemClick: (NavDestination) -> Unit
) {
    Surface(
        modifier = modifier
            .padding(
                bottom = WindowInsets.navigationBars
                    .asPaddingValues()
                    .calculateBottomPadding()
            )
            .fillMaxWidth()
            .height(50.dp),
        color = colorResource(id = R.color.background_color)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            labels.forEachIndexed { index, label ->
                Column(
                    Modifier
                        .padding(16.dp, 0.dp)
                        .width(IntrinsicSize.Max)
                        .clickable(onClick = { onItemClick(destinations[index]) },indication = null, interactionSource = remember { MutableInteractionSource() }),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        painter = painterResource(id = labelIcons[index]),
                        contentDescription = null,
                        tint = if (select == destinations[index]) colorResource(id = R.color.selected_color) else colorResource(id = R.color.color_unselected)
                    )
                    Text(
                        text = label,
                        fontSize = 17.sp,
                        fontWeight = if (select == destinations[index]) FontWeight.ExtraBold else FontWeight.Bold,
                        color = if (select == destinations[index]) colorResource(id = R.color.selected_color) else colorResource(id = R.color.color_unselected)
                    )
                }
            }
        }
    }
}
