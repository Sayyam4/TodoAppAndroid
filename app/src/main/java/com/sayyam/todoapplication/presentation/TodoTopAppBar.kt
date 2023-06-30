package com.sayyam.todoapplication.presentation

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.sayyam.todoapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar (
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.displayMedium
            )
        },
        modifier = modifier
    )
}