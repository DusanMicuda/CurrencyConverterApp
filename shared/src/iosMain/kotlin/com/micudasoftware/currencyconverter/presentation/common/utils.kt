package com.micudasoftware.currencyconverter.presentation.common

import androidx.compose.runtime.Composable
import dev.icerock.moko.resources.desc.StringDesc

/**
 * Function to get [String] from [StringDesc].
 *
 * @return A [String].
 */
@Composable
actual fun StringDesc.getString() = this.localized()