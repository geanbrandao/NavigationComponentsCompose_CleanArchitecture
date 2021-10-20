package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.ui.components.common

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToolbarCustom(
    @StringRes toolbarTitleId: Int,
    onArrowBackClickListener: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(color = MaterialTheme.colors.secondary)
            .padding(all = 16.dp)
            .fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack, contentDescription = "Arrow back icon",
            modifier = Modifier
                .align(alignment = Alignment.CenterStart)
                .clickable {
                    onArrowBackClickListener()
                }
        )
        Text(
            text = stringResource(id = toolbarTitleId),
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            modifier = Modifier
                .align(alignment = Alignment.Center)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }
}