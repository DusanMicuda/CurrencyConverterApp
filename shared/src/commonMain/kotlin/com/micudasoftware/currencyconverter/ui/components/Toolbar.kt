package com.micudasoftware.currencyconverter.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.micudasoftware.currencyconverter.SharedRes
import com.micudasoftware.currencyconverter.ui.theme.CurrencyConverterTheme
import dev.icerock.moko.resources.compose.painterResource

/**
 * Top app toolbar.
 *
 * @param title Title to be displayed at the center of toolbar.
 * @param showBackButton Flag that indicates whether back button should be displayed or not.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    title: String,
    showBackButton: Boolean = false
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                color = Color.White
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(0x00000000)
        ),
        navigationIcon = {
            if (showBackButton) {
                IconButton(
                    onClick = {}
                ) {
                    Icon(
                        painterResource(SharedRes.images.ic_arrow_back),
                        tint = CurrencyConverterTheme.colors.primary,
                        contentDescription = null
                    )
                }
            }
        },
        actions = {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    painterResource(SharedRes.images.ic_info),
                    tint = CurrencyConverterTheme.colors.primary,
                    contentDescription = null
                )
            }
        }
    )
}