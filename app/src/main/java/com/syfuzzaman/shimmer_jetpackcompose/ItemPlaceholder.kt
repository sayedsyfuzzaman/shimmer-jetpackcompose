package com.syfuzzaman.shimmer_jetpackcompose

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(name = "Dark Mode",  uiMode = UI_MODE_NIGHT_YES)
@Preview(name = "Light Mode", uiMode = UI_MODE_NIGHT_NO)
@Composable
fun ItemPlaceholder() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 24.dp)

    ) {
        Column(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .background(colorResource(id = R.color.cardBgColor), shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.ic_placeholder),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(128.dp),
                    contentScale = ContentScale.Crop
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(128.dp)
                        .clip(RectangleShape)
                        .shimmer(transparentMode = true)
                )
            }
            Spacer(modifier = Modifier.size(10.dp))
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .shimmer()
                )
                Spacer(modifier = Modifier.size(6.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.6F)
                        .height(12.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .shimmer()
                )
            }
            Spacer(modifier = Modifier.size(12.dp))
        }
    }
}